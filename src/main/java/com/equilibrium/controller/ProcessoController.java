package com.equilibrium.controller;

import com.equilibrium.dao.ProcessoDao;
import com.equilibrium.dao.TipoProcessoDao;
import com.equilibrium.model.Processo;
import com.equilibrium.model.TipoProcesso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class ProcessoController {
    @Autowired
    ProcessoDao dao;
    @Autowired
    TipoProcessoDao daoTipoProcesso;


    @RequestMapping("/processoForm")
    public String processoForm(Model m){
        List<TipoProcesso> listTipoProcesso = daoTipoProcesso.getTipoProcesso();
        m.addAttribute("command", new Processo());
        m.addAttribute("listTipoProcesso",listTipoProcesso);
        return "processoForm";
    }

    @RequestMapping(value="/processoSave",method = RequestMethod.POST)
    public String processoSave(@ModelAttribute("processo") Processo tp){
        if (dao.existsProcessoByNumero(tp.getNumero())){
            return "viewProcessoAlreadyExists";
        };
        dao.save(tp);
        return "redirect:/viewProcesso";
    }

    @RequestMapping("/viewProcesso")
    public String viewProcesso (Model m){
        List<Processo> list=dao.getProcesso();
        m.addAttribute("list",list);
        return "viewProcesso";
    }

    @RequestMapping("/viewProcessoByNumero")
    public String viewProcessoByNumero (@RequestParam("numero") String numero, Model m){
        List<Processo> list=dao.getProcessoByNumero(numero);
        List<TipoProcesso> listTipoProcesso=daoTipoProcesso.getTipoProcesso();
        m.addAttribute("list",list);
        m.addAttribute("listTipoProcesso",listTipoProcesso);
        return "viewProcessoFiltered";
    }


    @RequestMapping(value="/processoEditForm/{id}")
    public String processoEditForm(@PathVariable int id, Model m){
        Processo tp=dao.getProcessoById(id);
        List<TipoProcesso> listTipoProcesso=daoTipoProcesso.getTipoProcesso();
        m.addAttribute("listTipoProcesso",listTipoProcesso);
        m.addAttribute("command",tp);
        return "processoEditForm";
    }


    @RequestMapping(value="/editProcessoSave",method = RequestMethod.POST)
    public String editProcessoSave(@ModelAttribute("processo") Processo p){
        dao.update(p);
        return "redirect:/viewProcesso";
    }


    @RequestMapping(value="/deleteProcesso/{id}",method = RequestMethod.GET)
    public String deleteProcesso(@PathVariable int id){
        dao.delete(id);
        return "redirect:/viewProcesso";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,true));
    }
}