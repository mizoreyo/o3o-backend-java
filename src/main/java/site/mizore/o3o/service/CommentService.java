package site.mizore.o3o.service;

import site.mizore.o3o.bean.Comment;

import java.util.List;

public interface CommentService {

    int add(Comment comment);

    List<Comment> getCommentTree(String pageId);

}
