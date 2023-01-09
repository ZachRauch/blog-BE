package net.yorksolutions.zachrauchblogcmscapstonebe.repositories;

import net.yorksolutions.zachrauchblogcmscapstonebe.models.BlogPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BlogPostRepository extends CrudRepository<BlogPost, Long> {
    Iterable<BlogPost> findAllByEmail(String email);
}
