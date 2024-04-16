package com.study.springboot.controller;

import com.study.springboot.dto.ReplyResponseDto;
import com.study.springboot.dto.ReplySaveRequestDto;
import com.study.springboot.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {
    final private ReplyService replyService;

    @PostMapping("/writeReplyAction")
    @ResponseBody
    public String writeReplyAction(@ModelAttribute ReplySaveRequestDto dto, @RequestParam Long replyBoardIdx) {
        Long newReplyIdx = replyService.save(dto);

        boolean isFound = replyService.existsById(newReplyIdx);
        if (isFound) {
            return "<script>alert('댓글쓰기 성공'); location.href='/board/contentForm?boardIdx="+ replyBoardIdx +"';</script>";
        } else {
            return "<script>alert('댓글쓰기 실패'); history.back();</script>";
        }
    }

    @GetMapping("/deleteReplyAction")
    @ResponseBody
    public String deleteReplyAction(@RequestParam Long boardIdx, @RequestParam Long replyIdx){
        replyService.delete(replyIdx);
        boolean isFound = replyService.existsById(replyIdx);
        if (!isFound) {
            return "<script>alert('댓글삭제 성공'); location.href='/board/contentForm?boardIdx="+ boardIdx +"';</script>";
        } else {
            return "<script>alert('댓글삭제 실패'); history.back();</script>";
        }
    }

}
