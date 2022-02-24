package com.skf.labs.xxe;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class XxeController {
    @PostMapping("/home")
	public String home(@RequestParam(name="xxe", required=true, defaultValue="xxe") String xxe, Model model) {

		model.addAttribute("xss", xxe);
		return "index";
	}
    
}