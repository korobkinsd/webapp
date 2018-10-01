package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import system.model.User;
import system.service.LangValidator;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/header")
public class LangController {

    @Autowired
    private LangValidator langValidator;

    @RequestMapping(method=RequestMethod.GET)
    public String initializeForm(ModelMap model) {
        // Perform and Model / Form initialization
        Map<Integer, String> priority = new LinkedHashMap<Integer, String>();
        priority.put(1, "Low");
        priority.put(2, "Normal");
        priority.put(3, "High");

        model.addAttribute("priorityList", priority);

        return "WEB-INF/pages/header.jsp";
    }


    @RequestMapping(value = "/index/validate", method = RequestMethod.GET)
    public ModelAndView validateUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userForm", new User());
        modelAndView.setViewName("WEB-INF/pages/index.jsp");
        return modelAndView;
    }
}

