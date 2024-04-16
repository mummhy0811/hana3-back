package com.study.Ex22TD;

import org.junit.jupiter.api.*;


public class LifeCycleTest {
    @Test
    @DisplayName("테스트 코드 1")
    void testMethod01(){
        System.out.println("테스트 코드 1");
    }

    @Test
    @DisplayName("테스트 코드 2")
    @Disabled // 비활성화
    void testMethod02(){
        System.out.println("테스트 코드 2");
    }

    @BeforeAll
    static void beforeAll(){
        System.out.println("before All");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("after All");
    }

    @BeforeEach //각각 테스트 메소드가 실행되기 전 매번 실행
    void beforeEach(){
        System.out.println("beforeEach");
    }

    @AfterEach//각각 테스트 메소드가 실행된 후 매번 실행
    void afterEach(){
        System.out.println("afterEach");
    }
}
