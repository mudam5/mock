package com.myapp.logsystem;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import java.nio.file.Files;

import java.nio.file.Paths;

import java.util.List;

@SpringBootApplication

@RestController

public class MainApplication {

    public static void main(String[] args) {

        SpringApplication.run(MainApplication.class, args);

    }

    // Endpoint to read logs from logs/app.log

    @GetMapping("/logs")

    public String getLogs() {

        String logFile = "logs/app.log"; // relative to project root

        try {

            List<String> lines = Files.readAllLines(Paths.get(logFile));

            return String.join("<br/>", lines); // return logs with line breaks

        } catch (IOException e) {

            return "Error reading log file: " + e.getMessage();

        }

    }

}
 
