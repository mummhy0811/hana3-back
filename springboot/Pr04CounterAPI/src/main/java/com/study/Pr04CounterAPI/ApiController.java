package com.study.Pr04CounterAPI;

import org.springframework.web.bind.annotation.*;


@RestController
public class ApiController {
    public static Counter counter ;

    @GetMapping("/plus")
    public ResDto plus(){
        counter.plus();
        ResDto resDto = new ResDto();
        resDto.setCnt(counter.getCount());
        return resDto;
    }
    @GetMapping("/minus")
    public ResDto minus(){
        counter.minus();
        ResDto resDto = new ResDto();
        resDto.setCnt(counter.getCount());
        return resDto;
    }

}
