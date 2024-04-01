package com.study.Pr04CounterAPI;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Builder
public class Counter {
    private int count;
    void plus(){
        count++;
    }
    void minus(){
        count--;
    }
}
