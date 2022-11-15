package com.equilibrium.controller;

import com.equilibrium.dao.ProcessoDao;
import com.equilibrium.dao.TipoProcessoDao;
import com.equilibrium.model.TipoProcesso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TipoProcessoController {
    @Autowired
    TipoProcessoDao dao;//will inject dao from XML file
    @Autowired
    ProcessoDao processoDao;

    /*It displays a form to input data, here "command" is a reserved request attribute
     *which is used to display object data into form
     */
    @RequestMapping("/tipoProcessoForm")
    public String tipoProcessoForm(Model m){
        m.addAttribute("command", new TipoProcesso());
        return "tipoProcessoForm";
    }
    /*It saves object into database. The @ModelAttribute puts request data
     *  into model object. You need to mention RequestMethod.POST method
     *  because default request is GET*/
    @RequestMapping(value="/tipoProcessoSave",method = RequestMethod.POST)
    public String tipoProcessoSave(@ModelAttribute("tipoProcesso") TipoProcesso tp){
        dao.save(tp);
        return "redirect:/viewTipoProcesso";//will redirect to viewemp request mapping
    }
    /* It provides list of employees in model object */
    @RequestMapping("/viewTipoProcesso")
    public String viewTipoProcesso (Model m){
        List<TipoProcesso> list=dao.getTipoProcesso();
        m.addAttribute("list",list);
        return "viewTipoProcesso";
    }
    /* It displays object data into form for the given id.
     * The @PathVariable puts URL data into variable.*/
    @RequestMapping(value="/tipoProcessoEditForm/{id}")
    public String tipoProcessoEditForm(@PathVariable int id, Model m){
        TipoProcesso tp=dao.getTipoProcessoById(id);
        m.addAttribute("command",tp);
        return "tipoProcessoEditForm";
    }
    /* It updates model object. */
    @RequestMapping(value="/editTipoProcessoSave",method = RequestMethod.POST)
    public String editTipoProcessoSave(@ModelAttribute("tipoProcesso") TipoProcesso tp){
        dao.update(tp);
        return "redirect:/viewTipoProcesso";
    }
    /* It deletes record for the given id in URL and redirects to /viewemp */
    @RequestMapping(value="/deleteTipoProcesso/{id}",method = RequestMethod.GET)
    public String deleteTipoProcesso(@PathVariable int id){
        if (processoDao.existsProcessoByTipoProcesso(id)){
            return "viewTipoProcessoHasChild";
        }
        dao.delete(id);
        return "redirect:/viewTipoProcesso";
    }
}