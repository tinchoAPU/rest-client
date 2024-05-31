package com.api_rest.rest_client.controller;

import com.api_rest.rest_client.entity.Log;
import com.api_rest.rest_client.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/logs")
public class LogController {

    LogService logService;

    @Autowired
    public LogController(LogService logService){
        this.logService = logService;
    }

    @GetMapping
    public List<Log> findAllLogs(){
        return this.logService.findAllLogs(null);
    }

    @PostMapping
    public Log saveLog(Log log){
        return this.logService.saveLog(log);
    }


}
