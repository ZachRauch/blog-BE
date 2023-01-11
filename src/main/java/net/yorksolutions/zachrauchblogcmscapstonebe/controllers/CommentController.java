package net.yorksolutions.zachrauchblogcmscapstonebe.controllers;

import net.yorksolutions.zachrauchblogcmscapstonebe.models.Comment;
import net.yorksolutions.zachrauchblogcmscapstonebe.services.CommentService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/comments")
public class CommentController {
    CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public Comment addComment(@RequestBody Comment comment) {
        return this.commentService.addComment(comment);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        this.commentService.deleteComment(id);
    }

//    @GetMapping(params = {"postId"})
//    public Iterable<Comment> getComments(@RequestParam Long postId) {
//        return commentService.getCommentByPostId(postId);
//    }

    @GetMapping
    public Iterable<Comment> getComments() {
        return commentService.getAllComment();
    }
}
