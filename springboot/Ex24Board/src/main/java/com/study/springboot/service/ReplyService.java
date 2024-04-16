package com.study.springboot.service;

import com.study.springboot.domain.reply.Reply;
import com.study.springboot.domain.reply.ReplyRepository;
import com.study.springboot.dto.ReplyResponseDto;
import com.study.springboot.dto.ReplySaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyService {
    final ReplyRepository replyRepository;
    @Transactional
    public Long save(final ReplySaveRequestDto dto){
        Reply entity = replyRepository.save( dto.toEntity() );
        return entity.getReplyIdx();
    }

    @Transactional(readOnly = true)
    public boolean existsById(Long replyIdx){
        return replyRepository.existsById(replyIdx);
    }

    public List<ReplyResponseDto> findById(Long boardIdx){
        List<Reply> list = replyRepository.findAllByReplyBoardIdx(boardIdx);
        return list.stream().map(ReplyResponseDto::new).collect(Collectors.toList());
    }

    public void delete(Long idx){
        replyRepository.deleteById(idx);
    }

}
