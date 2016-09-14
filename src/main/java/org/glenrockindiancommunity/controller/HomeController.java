package org.glenrockindiancommunity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  /**
   * Redirect user to index.jsp by default. Lazy fix... 
   * 
   * @param model
   * @return
   */
  @RequestMapping(path = "/")
  public String redirectToIndex(Model model) {
    return "redirect:/index.jsp";
  }

}
