package jiliang.chen.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		System.out.println("-----xxx----");
		return "Greetings from Spring Boot! updated by argocd";
	}

    @RequestMapping("/hello")
	public String hello() {
		System.out.println("-----xxx----");
		return "hello for eks cicd";
	}

}