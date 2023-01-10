package net.yorksolutions.zachrauchblogcmscapstonebe.repositories;

import net.yorksolutions.zachrauchblogcmscapstonebe.models.Likes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends CrudRepository<Likes, Long> {
    Iterable<Likes> findByPostId(Long postId);
}
