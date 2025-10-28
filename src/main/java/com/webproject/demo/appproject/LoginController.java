package com.webproject.demo.appproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("/login_basic")
    //@ResponseBody
    public String goToLoginPage() {
        return "login";
    }

}
