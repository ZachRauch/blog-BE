package net.yorksolutions.zachrauchblogcmscapstonebe.controllers;

import net.yorksolutions.zachrauchblogcmscapstonebe.models.Likes;
import net.yorksolutions.zachrauchblogcmscapstonebe.services.LikesService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/likes")
public class LikesController {

    LikesService likesService;

    public LikesController(LikesService likesService) {
        this.likesService = likesService;
    }

    @PostMapping
    public Likes addLike(@RequestBody Likes like) {
        return this.likesService.addLike(like);
    }

    @DeleteMapping("/{id}")
    public void deleteLike(@PathVariable Long id) {
        this.likesService.deleteLike(id);
    }

//    @GetMapping(params = {"postId"})
//    public Iterable<Likes> getLikes(@RequestParam Long postId) {
//        return this.likesService.getLikes(postId);
//    }
@GetMapping
public Iterable<Likes> getLikes() {
    return this.likesService.getAllLikes();
}
}
