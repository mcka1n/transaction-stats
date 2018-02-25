package com.hacknplay.transactionstats.transaction.service;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class StatisticService {

    private ConcurrentMap<String, ConcurrentHashMap<String, Double>> timeMap;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public StatisticService() {
        timeMap = new ConcurrentHashMap<String, ConcurrentHashMap<String, Double>>();
    }

    public void addTransaction(final Double amount, final Long timestamp) {
        String time = dateFormat.format(new Date());
        ConcurrentHashMap<String, Double> statisticMap = timeMap.get(time);
        if (statisticMap == null) {
            statisticMap = new ConcurrentHashMap<String, Double>();
        }

        Double sum = statisticMap.get("sum");
        Double max = statisticMap.get("max");
        Double min = statisticMap.get("min");
        Double count = statisticMap.get("count");

        if (sum == null) {
            sum = amount;
        } else {
            sum = sum + amount;
        }

        // Max
        if ((max == null) || (amount > max)) {
            max = amount;
        }

        // Min
        if ((min == null) || (amount < min)) {
            min = amount;
        }

        // Keep count
        if (count == null) {
            count = (double) 1;
        } else {
            count++;
        }

        statisticMap.put("sum", sum);
        statisticMap.put("max", max);
        statisticMap.put("min", min);
        statisticMap.put("count", count);
        timeMap.put(time, statisticMap);
    }

    public ConcurrentHashMap<String, Double> getCurrentStatistics() {
        String time = dateFormat.format(new Date());
        return timeMap.get(time);
    }
}
