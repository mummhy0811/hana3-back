package com.study.Ex22TD;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@WebMvcTest: @Controller, @RestController가 설정된 컨트롤 클래스를 테스트
//             @Service, @Repository에는 사용 불가
@WebMvcTest(MainController.class)
class MainControllerTest {
    @Autowired
    private MockMvc mockMvc; //웹 API를 테스트 할 때 가상의 HTTP 요청을 만들어주는 클래스

    @Test
    @DisplayName("main() 테스트")
    void main() throws Exception {

        Member member = new Member("hong", "1234");

        mockMvc.perform(get("/"))
                .andExpect(status().isOk()) //상태 확인(응답 코드 200 확인)
                .andExpect(view().name("index")) //뷰 이름 확인
                .andExpect(model().attributeExists("member")) //객체 이름 확인
                .andExpect(model().attribute("list", Matchers.contains("hong", "lee")))
                .andDo(print());
    }
}