# transaction-stats
Basic REST API to calculate real time statistics from 'event's a.k.a `Transaction`s.

## Development

This is a Work In Progress project based on the [Spring boot framework](https://projects.spring.io/spring-boot/).

 The basic configuration includes:
 
 - Maven
 - H2
 - JPA

## POST /transactions

Think about these `transactions` as *events* that happen in a specific **timestamp**

- This API persists the data in a H2 (in-memory) table
- Analyses the received **timestamp** to calculate statistics in the last minute.

### Request

`POST /transactions`

#### Parameters

Both *amount* and *timestamp* are required

```
{
    amount: 3.50,
    timestamp: 1519589581
}
```

### Response

HTTP Status: `201. Created`

## GET /statistics

The goal of this endpoint is to provide basic stats based on the previous *transactions* in the last minute (60 seconds).

It's worth to notice that you as the API client can expect to have consistent response times pretty close to the order of O(1). 

### Request

`GET /statistics`

### Response
```
{
    "min": 1.2,
    "avg": 2,
    "max": 3.6,
    "count": 3,
    "sum": 6
}
```

----

## Things to improve in a future

- Do some house cleaning with the current *Cache* process. 
  - If we only care about the last 60 minutes. It would be nice to remove every minute the past statistics.
  - Currently I'm inserting in the `ConcurrentHashMap` transactions in future timestamps, I made it because we could have scheduled *transactions* that we need to take in consideration in the stats.
   - It's worth to notice that these future/scheduled *transactions* are being stored in the correct `DateTime`. 
  - Maybe a Redis could help to deal with these key-value storage in the future.
- Probably YAGNI (for now). But I would propose Cassandra for this use-case. Basically we have a Time-Series case here and Cassandra provides good tooling for these problems. 
  - Cassandra is easy to scale (It can handle up to 1 million requests per second).
   - Fast writes and relativity fast reads with compounded indexes.
