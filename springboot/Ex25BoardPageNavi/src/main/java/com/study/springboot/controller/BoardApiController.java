package com.study.springboot.controller;

import com.study.springboot.dto.BoardResponseDto;
import com.study.springboot.dto.BoardSaveRequestDto;
import com.study.springboot.dto.ReplyResponseDto;
import com.study.springboot.service.BoardService;
import com.study.springboot.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardApiController {
    final private BoardService boardService;
    final private ReplyService replyService;

    //전체조회
    @GetMapping("/boards")
    public List<BoardResponseDto> findAll(){
        return boardService.findAll();
    }

    //단건조회
    @GetMapping("/boards/{id}")
    public BoardResponseDto save(@PathVariable final Long id){
        return boardService.findById(id);
    }

    //게시글 댓글 조회
    @GetMapping("/boards/{id}/replys")
    public List<ReplyResponseDto> replys(@PathVariable final Long id){
        return replyService.findAllByReplyBoardIdx(id);
    }

    //게시글 작성
    @PostMapping("/boards")
    public BoardResponseDto save(@RequestBody final BoardSaveRequestDto dto) {
        return boardService.saveToDto(dto);
    }
    //게시글 수정
    @PutMapping("/boards/{id}")
    public BoardResponseDto update(@PathVariable final Long id, @RequestBody final BoardSaveRequestDto dto) {
        return boardService.updateToDto(id, dto);
    }
    //게시글 삭제
    @DeleteMapping("/boards/{id}")
    public Long delete(@PathVariable final Long id){
        return boardService.deleteToLong( id );
    }
}
