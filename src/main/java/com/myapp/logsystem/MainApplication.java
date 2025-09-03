package com.myapp.logsystem;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

public class MainApplication {

    public static void main(String[] args) {

        SpringApplication.run(MainApplication.class, args);

    }

}

@RestController

class LogController {

    @GetMapping("/logs")

    public String showLogs() {

        // For demo: later we can read from your log files

        return "Log monitoring system is running!";

    }

}
 
