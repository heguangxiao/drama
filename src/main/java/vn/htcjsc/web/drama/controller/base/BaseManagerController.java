/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.htcjsc.web.drama.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author HTC-PC
 */
@Controller("hieuBaseManagerController")
@RequestMapping("/base/manager")
public class BaseManagerController {
  
    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String home(Model model) {
        return "home";
    }
    
    @RequestMapping(value = { "/charts" }, method = RequestMethod.GET)
    public String charts(Model model) {
        return "charts";
    }
    
    @RequestMapping(value = { "/widgets" }, method = RequestMethod.GET)
    public String widgets(Model model) {
        return "widgets";
    }
    
    @RequestMapping(value = { "/tables" }, method = RequestMethod.GET)
    public String tables(Model model) {
        return "tables";
    }
    
    @RequestMapping(value = { "/grid" }, method = RequestMethod.GET)
    public String grid(Model model) {
        return "grid";
    }
    
    @RequestMapping(value = { "/form-common" }, method = RequestMethod.GET)
    public String formCommon(Model model) {
        return "form-common";
    }
    
    @RequestMapping(value = { "/form-validation" }, method = RequestMethod.GET)
    public String formValidation(Model model) {
        return "form-validation";
    }
    
    @RequestMapping(value = { "/form-wizard" })
    public String formWizard(Model model) {
        return "form-wizard";
    }
    
    @RequestMapping(value = { "/buttons" }, method = RequestMethod.GET)
    public String buttons(Model model) {
        return "buttons";
    }
    
    @RequestMapping(value = { "/interface" }, method = RequestMethod.GET)
    public String interfacePage(Model model) {
        return "interface";
    }
    
    @RequestMapping(value = { "/gallery" }, method = RequestMethod.GET)
    public String gallery(Model model) {
        return "gallery";
    }
    
    @RequestMapping(value = { "/calendar" }, method = RequestMethod.GET)
    public String calendar(Model model) {
        return "calendar";
    }
    
    @RequestMapping(value = { "/chat" }, method = RequestMethod.GET)
    public String chat(Model model) {
        return "chat";
    }
    
    @RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
    public String logout(Model model) {
        return "redirect:/base/manager/login";
    }
    
    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }
}