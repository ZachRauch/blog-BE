package net.yorksolutions.zachrauchblogcmscapstonebe.services;

import net.yorksolutions.zachrauchblogcmscapstonebe.models.Likes;
import net.yorksolutions.zachrauchblogcmscapstonebe.repositories.LikesRepository;
import org.springframework.stereotype.Service;

@Service
public class LikesService {
    final LikesRepository likesRepository;

    public LikesService(LikesRepository likesRepository) {
        this.likesRepository = likesRepository;
    }

    public Likes addLike(Likes like) {
        return this.likesRepository.save(like);
    }

    public void deleteLike(Long id) {
        this.likesRepository.deleteById(id);
    }

    public Iterable<Likes> getLikes(Long postId) {
        return likesRepository.findByPostId(postId);
    }
}
