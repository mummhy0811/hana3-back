package com.study.Ex23Scheduler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {
    @GetMapping("/api/batch-job")
    public String batchJson(){

        return "batch-job";
    }
}
