package net.yorksolutions.zachrauchblogcmscapstonebe.models;

import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    public Long postId;

    public Long userId;

    public String comment;
}
