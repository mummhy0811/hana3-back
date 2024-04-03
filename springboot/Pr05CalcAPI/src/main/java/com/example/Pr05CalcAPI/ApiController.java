package com.example.Pr05CalcAPI;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiController {
    final Calculator calculator;

    @PostMapping("/calc")
    public ResDto calc(@RequestBody ReqDto reqDto){

        double result = calculator.calc( reqDto );
        ResDto resDto = new ResDto();
        resDto.setStatus("ok");
        resDto.setResult( result );

        return resDto;
    }
}
