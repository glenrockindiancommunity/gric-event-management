package org.glenrockindiancommunity.integrate;

import org.glenrockindiancommunity.model.security.Admin;
import org.glenrockindiancommunity.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AdminApproval {

  @Autowired
  private AdminRepository adminRepository;

  /**
   * Simple service call to mark a user as approved admin.
   * 
   * @param adminId
   * @return
   */
  @PreAuthorize("isFullyAuthenticated()")
  public boolean approveAdmin(String adminId) {
    Admin admin = adminRepository.findOne(adminId);
    admin.setApproved(true);
    adminRepository.save(admin);

    // all in good faith
    return true;
  }

}
