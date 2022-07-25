package site.mizore.o3o.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import site.mizore.o3o.bean.Comment;

import java.util.Date;
import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Comment comment) {
        String sql="insert into t_comment (replyTo,pageId,guestName,guestEmail,guestSite,comment,date) values (?,?,?,?,?,?,?)";
        Date date=new Date();
        return jdbcTemplate.update(sql,comment.getReplyTo(),comment.getPageId(),comment.getGuestName(),comment.getGuestEmail(),comment.getGuestSite(),comment.getComment(),date.getTime());
    }

    @Override
    public List<Comment> getFirstPlaceListByPageId(String pageId) {
        String sql="select * from t_comment where pageId=? and replyTo is null ";
        List<Comment> comments=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Comment.class),pageId);
        return comments;
    }

    @Override
    public List<Comment> getListByReplyTo(Long replyTo) {
        String sql="select * from t_comment where replyTo=?";
        List<Comment> comments=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Comment.class),replyTo);
        return comments;
    }
}
