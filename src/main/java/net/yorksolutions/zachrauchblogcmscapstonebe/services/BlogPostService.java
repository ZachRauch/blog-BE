package net.yorksolutions.zachrauchblogcmscapstonebe.services;

import net.yorksolutions.zachrauchblogcmscapstonebe.models.BlogPost;
import net.yorksolutions.zachrauchblogcmscapstonebe.repositories.BlogPostRepository;
import org.springframework.stereotype.Service;


@Service
public class BlogPostService {
    final BlogPostRepository blogPostRepository;

    public BlogPostService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    public BlogPost addBlogPost(BlogPost blogPost) {
        return this.blogPostRepository.save(blogPost);
    }

    public void deletePost(Long id) {
        this.blogPostRepository.deleteById(id);
    }

    public BlogPost updatePost(Long id, BlogPost blogPost) throws Exception {
        if (blogPostRepository.findById(id).isPresent()) {
            return blogPostRepository.save(blogPost);
        } else throw new Exception("Invalid post");
    }

    public Iterable<BlogPost> getAllPosts() {
        return blogPostRepository.findAll();
    }

    public Iterable<BlogPost> getPostByEmail(String email) {
        return blogPostRepository.findByEmail(email);
    }
}
