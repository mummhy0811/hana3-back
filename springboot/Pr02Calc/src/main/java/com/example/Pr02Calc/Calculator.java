package com.example.Pr02Calc;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Calculator {
    private int A;
    private int B;
    private int answer;
    private double divAnswer;

    public void add(int a, int b) {
        A = a;
        B = b;
        answer = a + b;
    }

    public void sub(int a, int b) {
        A = a;
        B = b;
        answer = a - b;
    }

    public void mul(int a, int b) {
        A = a;
        B = b;
        answer = a * b;
    }

    public void div(int a, int b) {
        A = a;
        B = b;
        divAnswer = (double) a / (double) b;
    }
}