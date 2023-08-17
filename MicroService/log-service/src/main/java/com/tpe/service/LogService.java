package com.tpe.service;

import com.tpe.domain.AppLog;
import com.tpe.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class LogService {


    private final LogRepository logRepository;


    //NOT: createLog()***************************************
    public void saveLog(AppLog appLog) {
        logRepository.save(appLog);
    }





}
