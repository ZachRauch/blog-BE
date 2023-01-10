package net.yorksolutions.zachrauchblogcmscapstonebe.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Formula;
import org.springframework.data.jpa.repository.Query;

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

//    @ManyToMany
//    public List<Comment> comments;

//    public String like;

    public Date datePosted;

    public Date updateDate;

//    @Formula("(select count(*) from likes where likes.postId = postId)")
//    public Long totalLikes;

}
