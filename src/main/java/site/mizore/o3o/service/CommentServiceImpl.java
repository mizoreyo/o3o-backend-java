package site.mizore.o3o.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.mizore.o3o.bean.Comment;
import site.mizore.o3o.dao.CommentDao;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentDao commentDao;

    @Override
    public int add(Comment comment) {
        return commentDao.add(comment);
    }

    @Override
    public List<Comment> getCommentTree(String pageId) {
        List<Comment> firstPlaceComments=commentDao.getFirstPlaceListByPageId(pageId);
        for(Comment comment:firstPlaceComments) {
            buildCommentTree(comment);
        }
        return firstPlaceComments;
    }

    private void buildCommentTree(Comment comment) {
        List<Comment> comments=commentDao.getListByReplyTo(comment.getId());
        if(comments==null) {
            return;
        }
        comment.setReplys(comments);
        for(Comment comment1:comments) {
            buildCommentTree(comment1);
        }
    }
}
