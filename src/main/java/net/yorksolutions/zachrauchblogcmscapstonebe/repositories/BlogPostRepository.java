package net.yorksolutions.zachrauchblogcmscapstonebe.repositories;

import net.yorksolutions.zachrauchblogcmscapstonebe.models.BlogPost;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BlogPostRepository extends CrudRepository<BlogPost, Long> {
    @Query(value = "SELECT * FROM BlogPost where email=:email order by date", nativeQuery = true)
    Iterable<BlogPost> findByEmail(@Param("email") String email);
}
