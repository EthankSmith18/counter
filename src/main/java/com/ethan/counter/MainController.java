package com.ethan.counter;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class MainController {
  
  @RequestMapping("/")
  public String index(HttpSession Session){
    if (Session.getAttribute("count") == null){
      Session.setAttribute("count", 0);
    }
    else {
      Integer currentCount = (Integer) Session.getAttribute("count") + 1;
      Session.setAttribute("count", currentCount);
    }
    return "index.jsp";
  }

  @RequestMapping("/counter")
  public String counter(HttpSession session){
    return "counter.jsp";
  }

  @RequestMapping("/reset")
  public String reset(HttpSession Session){
    Session.invalidate();
    return "redirect:/";
  }

  
}
