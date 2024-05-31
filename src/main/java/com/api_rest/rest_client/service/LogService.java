package com.api_rest.rest_client.service;

import com.api_rest.rest_client.entity.Log;
import com.api_rest.rest_client.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    private LogRepository logRepository;
    @Autowired
    LogService(LogRepository logRepository){
        this.logRepository = logRepository;
    }

    public Log saveLog(Log log) {
        return this.logRepository.save(log);
    }

    public List<Log> findAllLogs(String filter) {
        return this.logRepository.findAll();
    }
}
