package com.xp.dao;

import com.xp.vo.Comment;

import java.util.List;

public interface CommentMapper {

    int deleteByPrimaryKey(Integer cId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> getComments();

    void insertComment(Comment comment);
}