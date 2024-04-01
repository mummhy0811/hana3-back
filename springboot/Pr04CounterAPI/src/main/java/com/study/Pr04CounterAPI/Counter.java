package com.example.Pr01Counter;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Counter {
    private int count;
    void plus(){
        count++;
    }
    void minus(){
        count--;
    }
}
