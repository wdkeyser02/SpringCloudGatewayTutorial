package willydekeyser.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/gateway")
	public String home() {
		return "Spring Cloud Gateway";
	}
}
