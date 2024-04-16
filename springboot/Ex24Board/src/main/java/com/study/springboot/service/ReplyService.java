package com.study.springboot.service;

import com.study.springboot.domain.reply.Reply;
import com.study.springboot.domain.reply.ReplyRepository;
import com.study.springboot.dto.ReplySaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
