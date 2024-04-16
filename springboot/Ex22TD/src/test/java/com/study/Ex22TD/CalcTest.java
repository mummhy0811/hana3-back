package com.study.Ex22TD;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    static Calc calc = null;

    @BeforeAll
    static void init(){
        if(calc == null){
            calc=new Calc();
        }
    }

    @Test
    @DisplayName("add 테스트")
    void add() {
        assertEquals(12, calc.add(10, 2));
    }

    @Test
    void sub() {
        assertEquals(8, calc.sub(10, 2));
    }

    @Test
    void mul() {
        assertEquals(20, calc.mul(10, 2));
    }

    @Test
    void div() {
        assertEquals(5, calc.div(10, 2));
    }
}