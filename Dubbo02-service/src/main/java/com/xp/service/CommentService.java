package com.xp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xp.api.IComment;
import com.xp.common.JSON;
import com.xp.dao.CommentMapper;
import com.xp.vo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author xp
 * @create 2018/11/30  9:45
 * @function 评论接口实现类
 */
@Service
public class CommentService implements IComment {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public JSON selectComments(Map<String, Integer> map) {
        PageHelper.startPage(map.get("pageNumber"), map.get("pageSize"), "c_id desc");
        List<Comment> comments=commentMapper.getComments();
        PageInfo<Comment> pageInfo=new PageInfo<>(comments);
        JSON json=new JSON(200,"1" ,pageInfo );
        return json;
    }

    @Override
    public Integer deleteComment(Integer id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insertComment(Comment comment) {
        commentMapper.insertComment(comment);
    }

    @Override
    public int updateComment(Comment comment) {
        return commentMapper.updateByPrimaryKeySelective(comment);
    }
}
