package com.study.springboot.dto;

import com.study.springboot.domain.reply.Reply;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReplyResponseDto {
    private Long replyIdx;
    private String replyName; //작성자
    private String replyContent; //내용
    private LocalDateTime replyDate;

    public ReplyResponseDto(Reply reply) {
        this.replyIdx = reply.getReplyIdx();
        this.replyName = reply.getReplyName();
        this.replyContent = reply.getReplyContent();
        this.replyDate = reply.getReplyDate();
    }
}
