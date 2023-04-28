package willydekeyser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class homeController {

	@GetMapping("/")
	public String home(Model model, RestTemplate restTemplate) {
		String quote1 = restTemplate.getForObject(
				"http://localhost:8090/resource1/", String.class);
		String quote2 = restTemplate.getForObject(
				"http://localhost:8090/resource2/", String.class);
		model.addAttribute("text", "Spring Client");
		model.addAttribute("quote1", quote1);
		model.addAttribute("quote2", quote2);
		return "index";
	}
}
