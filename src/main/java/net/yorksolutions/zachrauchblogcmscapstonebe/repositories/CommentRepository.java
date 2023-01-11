package net.yorksolutions.zachrauchblogcmscapstonebe.repositories;

import net.yorksolutions.zachrauchblogcmscapstonebe.models.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    Iterable<Comment> findByPostId(Long postId);

    Iterable<Comment> findAll();

}
