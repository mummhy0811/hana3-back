package com.study.springboot.domain.reply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

    //게시글 인덱스로 댓글 목록 찾기
    List<Reply> findAllByReplyBoardIdx(Long replyBoardIdx);
}
