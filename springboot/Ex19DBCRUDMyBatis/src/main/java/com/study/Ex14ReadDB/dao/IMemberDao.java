package com.study.Ex14ReadDB.dao;


import com.study.Ex14ReadDB.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Mapper //인터페이스 DAO와 마이바티스xml과 연결하는 용도
public interface IMemberDao {
    public List<MemberDto> list();

    public int count();

    public int insert(MemberDto dto);
    public int insertMap(Map map);

    public Optional<MemberDto> findById(long id);

    public int update(MemberDto dto);

    public void delete(int id);

}

