package org.glenrockindiancommunity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

	@RequestMapping(path = "/")
	public String registerFamily() {
		return "Hello";
	}

}
