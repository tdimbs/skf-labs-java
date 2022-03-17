package com.skf.labs.desyaml;

import java.io.InputStream;
import java.util.Base64;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DesYamlController {

  @GetMapping("/")
  public String index(Model model) {
    return "redirect:/information/eWFtbDogVGhlIGluZm9ybWF0aW9uIHBhZ2UgaXMgc3RpbGwgdW5kZXIgY29uc3RydWN0aW9uLCB1cGRhdGVzIGNvbWluZyBzb29uIQ==";
  }

  @GetMapping("/information/{input}")
  public String information(@PathVariable(value = "input", required = false) String input, Model model) {
    System.out.println(input);
    if (input != null) {
      String yaml_file = new String(Base64.getDecoder().decode(input));
      System.out.println(yaml_file);
      // yaml.load(yaml_file);

    }
    return "index";
  }
}
