package net.yorksolutions.zachrauchblogcmscapstonebe.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long postId;

    public Long userId;

    public String titleText;

    public String bodyText;

//    @OneToMany
//    public List<Comment> comments;

//    public String like;

    public Date date;

    public Date updateDate;

}
