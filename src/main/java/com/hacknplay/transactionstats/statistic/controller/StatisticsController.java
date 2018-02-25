package com.hacknplay.transactionstats.statistic.controller;

import com.hacknplay.transactionstats.transaction.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;

@RestController
public class StatisticsController {

    @Autowired
    private StatisticService statisticService;

    @RequestMapping(method = RequestMethod.GET, value = "/statistics")
    public ConcurrentHashMap<String, Double> index(){
        return statisticService.getCurrentStatistics();
    }
}
