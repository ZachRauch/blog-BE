package net.yorksolutions.zachrauchblogcmscapstonebe.controllers;

import net.yorksolutions.zachrauchblogcmscapstonebe.models.BlogPost;
import net.yorksolutions.zachrauchblogcmscapstonebe.services.BlogPostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@CrossOrigin
@RestController
@RequestMapping("/blogposts")
public class BlogPostController {

    BlogPostService blogPostService;

    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @GetMapping
    public Iterable<BlogPost> getAllPosts() {
            return blogPostService.getAllPosts();
    }

    @GetMapping
    public Iterable<BlogPost> getPosts(@RequestParam String email) {
            return blogPostService.getPostByEmail(email);
    }

    @PostMapping
    public BlogPost addBlogPost(@RequestBody BlogPost blogPost) {
        return this.blogPostService.addBlogPost(blogPost);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        this.blogPostService.deletePost(id);
    }

    @PutMapping("/{id}")
    public BlogPost updatePost(@PathVariable Long id, @RequestBody BlogPost blogPost) {
        try {
            return this.blogPostService.updatePost(id, blogPost);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
