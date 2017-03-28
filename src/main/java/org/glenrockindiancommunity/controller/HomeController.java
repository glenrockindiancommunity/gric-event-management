package org.glenrockindiancommunity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

  @RequestMapping(value = "/login")
  public String loginPage() {
    return "redirect:/login.jsp";
  }

  @RequestMapping(value = "/logout")
  public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null) {
      new SecurityContextLogoutHandler().logout(request, response, auth);
    }
    return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good idea to show login screen again.
  }

  @RequestMapping(value = "/admin", method = RequestMethod.GET)
  public String adminPage(ModelMap model) {
    model.addAttribute("user", getPrincipal());
    return "redirect:/admin.jsp";
  }

  private String getPrincipal() {
    String userName = null;
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    if (principal instanceof UserDetails) {
      userName = ((UserDetails) principal).getUsername();
    } else {
      userName = principal.toString();
    }
    return userName;
  }

}
