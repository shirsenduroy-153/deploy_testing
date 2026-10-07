package com.example.deploytesting.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> root() {
        return getHelloResponse("Deployment Test User");
    }

    @GetMapping("/api/helloo")
    public ResponseEntity<Map<String, Object>> hello(
            @RequestParam(value = "name", defaultValue = "World") String name) {
        return getHelloResponse(name);
    }

    @GetMapping("/api/health")
    public ResponseEntity<Map<String, Object>> health() {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", "UP");
        response.put("timestamp", Instant.now().toString());
        return ResponseEntity.ok(response);
    }

    private ResponseEntity<Map<String, Object>> getHelloResponse(String name) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", "SUCCESS");
        response.put("message", "Hello " + name + "! Spring Boot application is successfully deployed and running!");
        response.put("timestamp", Instant.now().toString());

        try {
            response.put("hostname", InetAddress.getLocalHost().getHostName());
            response.put("hostAddress", InetAddress.getLocalHost().getHostAddress());
        } catch (Exception e) {
            response.put("hostname", "unknown");
        }

        return ResponseEntity.ok(response);
    }
}
