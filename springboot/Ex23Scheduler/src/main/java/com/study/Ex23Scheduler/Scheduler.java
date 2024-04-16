package com.study.Ex23Scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@EnableAsync //비동기적으로 처리하도록 제공하는 스프링 어노테이션
public class Scheduler {
    @Scheduled(fixedRate = 1000)
    public void task1()throws InterruptedException{
        log.info("FixedRate task - {}", System.currentTimeMillis()/1000);
        Thread.sleep(5000);
    }
    @Scheduled(fixedRate = 1000)
    public void task2()throws InterruptedException{
        log.info("FixedRate task - {}", System.currentTimeMillis()/1000);
        Thread.sleep(5000);
    }

    //이전 작업이 완료될 때까지 실행되지 않음
    @Async //해당 메소드 로직이 시작되는 시간을 기준으로 ms 간격으로 실행
    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() throws InterruptedException{
        log.info("Fixed rate task = {}", System.currentTimeMillis());
        Thread.sleep(5000);
        log.info("dead");
    }


}
