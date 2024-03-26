package com.study.Ex03Autowired;

import org.springframework.stereotype.Component;

//원리 빈의 이름 -> bcCard
@Component("cardBC") //빈의 이름 직접 설정
public class BCCard implements ICard{

    @Override
    public void buy(String itemName) {
        System.out.println("BC카드로 "+itemName+"구매");
    }

}
