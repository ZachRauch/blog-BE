package net.yorksolutions.zachrauchblogcmscapstonebe.services;

import net.yorksolutions.zachrauchblogcmscapstonebe.models.Comment;
import net.yorksolutions.zachrauchblogcmscapstonebe.repositories.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment addComment(Comment comment) {
        return this.commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    public Iterable<Comment> getCommentByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    public Iterable<Comment> getAllComment() {
        return commentRepository.findAll();
    }
}
