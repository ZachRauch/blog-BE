package controllers;

import org.example.models.AppUser;
import org.example.services.AppUserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class AppUserController {
    AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }
    @PostMapping
    public AppUser addUser(@RequestBody AppUser appUser) {
        try {
            return this.appUserService.addUser(appUser);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id, @RequestParam String email, @RequestParam String password) {
        try {
            this.appUserService.deleteUser(id, email, password);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public AppUser modifyAppUser (@PathVariable Long id, @RequestBody AppUser appUser, @RequestParam String email, @RequestParam String password) {
        try {
            return appUserService.modifyAppUser(id, appUser, email, password);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
