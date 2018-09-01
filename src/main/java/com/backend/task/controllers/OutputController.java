package com.backend.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.task.services.CountersService;

@RestController("OutputController")
public class OutputController {
	@Autowired
	CountersService countService;
	
	@GetMapping("/test")
	public String test() {
		return "<body><p><b>Test</body>";
	}
	
	@GetMapping("/countTypes")
    public String countTypes(){
        return countService.printTypes();
    }

    @GetMapping("/countWords")
    public String countWords(){
        return countService.printWords();
    }
}
