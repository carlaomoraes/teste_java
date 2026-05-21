package br.com.taskboard.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskboardContoller {
    @GetMapping("/taskboard")
    public String taskboard() {
        return "taskboard";
    }
}
