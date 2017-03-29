package org.glenrockindiancommunity.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.glenrockindiancommunity.model.GricEvent;
import org.glenrockindiancommunity.respository.EventRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  private EventRepository eventRepository;

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

  @GetMapping("/upcoming")
  public List<GricEvent> futureEvents() {
    // Allow the event to be shown a day after the event has happened.
    LocalDateTime today = LocalDateTime.now().plusDays(1L);
    return eventRepository.findByEndDateTimeGreaterThanEqual(today);
  }

}
