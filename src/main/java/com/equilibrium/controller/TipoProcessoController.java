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
    TipoProcessoDao dao;
    @Autowired
    ProcessoDao processoDao;


    @RequestMapping("/tipoProcessoForm")
    public String tipoProcessoForm(Model m){
        m.addAttribute("command", new TipoProcesso());
        return "tipoProcessoForm";
    }

    @RequestMapping(value="/tipoProcessoSave",method = RequestMethod.POST)
    public String tipoProcessoSave(@ModelAttribute("tipoProcesso") TipoProcesso tp){
        dao.save(tp);
        return "redirect:/viewTipoProcesso";
    }

    @RequestMapping("/viewTipoProcesso")
    public String viewTipoProcesso (Model m){
        List<TipoProcesso> list=dao.getTipoProcesso();
        m.addAttribute("list",list);
        return "viewTipoProcesso";
    }

    @RequestMapping(value="/tipoProcessoEditForm/{id}")
    public String tipoProcessoEditForm(@PathVariable int id, Model m){
        TipoProcesso tp=dao.getTipoProcessoById(id);
        m.addAttribute("command",tp);
        return "tipoProcessoEditForm";
    }

    @RequestMapping(value="/editTipoProcessoSave",method = RequestMethod.POST)
    public String editTipoProcessoSave(@ModelAttribute("tipoProcesso") TipoProcesso tp){
        dao.update(tp);
        return "redirect:/viewTipoProcesso";
    }

    @RequestMapping(value="/deleteTipoProcesso/{id}",method = RequestMethod.GET)
    public String deleteTipoProcesso(@PathVariable int id){
        if (processoDao.existsProcessoByTipoProcesso(id)){
            return "viewTipoProcessoHasChild";
        }
        dao.delete(id);
        return "redirect:/viewTipoProcesso";
    }
}