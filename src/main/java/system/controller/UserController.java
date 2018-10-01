package system.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import system.model.User;
import system.service.DateValidator;
import system.service.UserService;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


@Controller
@RequestMapping("/")
public class UserController {


    @Autowired
    private UserService userService;


    @Value("${build.version}")
    private String buildVersion;

    @RequestMapping("/")
    public String execute(@RequestParam(value = "birthday", required = false) String enteredDate, Model model){
        StringBuffer msg = new StringBuffer(200 );

        if (DateValidator.isDateValid(enteredDate,"dd.MM.yyyy")) {
            msg.append("You are " + DateValidator.getAge(enteredDate,"dd.MM.yyyy") + "years old.");
        }
        else if (DateValidator.isDateValid(enteredDate,"yyyy-MM-dd")) {
            msg.append("You are " + DateValidator.getAge(enteredDate,"yyyy-MM-dd") + " years old.");
        }
        else {
            msg.append("Valid formats is: dd.MM.yyyy or yyyy-MM-dd!");
        }

        model.addAttribute("message", msg.toString());
        model.addAttribute("versionText", "Version: " + buildVersion );
        model.addAttribute("namePr", "Korobkin_SD" );
        return "index";
    }


    @RequestMapping(value = "/index/list", method = RequestMethod.GET)
    public @ResponseBody
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView validateUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userForm", new User());
        modelAndView.setViewName("index");
        return modelAndView;
    }


    @RequestMapping(value = "/index/check", method = RequestMethod.POST)
    public @ResponseBody
    String checkUser(@ModelAttribute("userForm") User user) {
        if ("admin".equals(user.getName())) {
            return "valid";
        }
        return "invalid";
    }


    private void populateDefaultModel(Model model) {

        Map<String, String> country = new LinkedHashMap<String, String>();
        country.put("EN", "English");
        country.put("AZ", "Azer");
        country.put("RU", "Русский");
        model.addAttribute("countryList", country);

    }





}
