package org.glenrockindiancommunity.controller;

import org.glenrockindiancommunity.integrate.AdminApproval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminUserController {

  @Autowired
  private AdminApproval approval;

  @PostMapping(path = "/admin/approve/{adminId}")
  public void acceptRegistration(@PathVariable String adminId) {
    approval.approveAdmin(adminId);
  }

}
