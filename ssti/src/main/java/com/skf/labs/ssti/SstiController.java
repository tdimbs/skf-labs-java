package com.skf.labs.ssti;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SstiController {
	@GetMapping("/{path}")
	public String home(@PathVariable String path, Model model) {
		model.addAttribute("title", "test");
		return "index";
	}
}
