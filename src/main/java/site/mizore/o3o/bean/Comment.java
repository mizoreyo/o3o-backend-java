package site.mizore.o3o.bean;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Comment {

    private Long id;
    private Long replyTo;
    private String pageId;
    private String guestName;
    private String guestEmail;
    private String guestSite;
    private String comment;
    private Long date;
    private List<Comment> replys;

}
