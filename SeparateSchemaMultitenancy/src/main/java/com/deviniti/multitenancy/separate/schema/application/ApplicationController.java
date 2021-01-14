package com.deviniti.multitenancy.separate.schema.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/application")
public class ApplicationController {

	@Value("${application.version}")
	private String applicationVersion;
	
	@GetMapping("version")
	public ResponseEntity<String> getVersion(){
		return ResponseEntity.ok(applicationVersion);
	}
}
