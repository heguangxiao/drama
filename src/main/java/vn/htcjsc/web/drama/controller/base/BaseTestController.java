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
@Controller
@RequestMapping("/base/test")
public class BaseTestController {
    
    @RequestMapping(value = { "/hello-angularjs" }, method = RequestMethod.GET)
    public String home(Model model) {
        return "hello-angularjs";
    }
}
