package net.yorksolutions.zachrauchblogcmscapstonebe.services;

import net.yorksolutions.zachrauchblogcmscapstonebe.models.AppUser;
import org.springframework.stereotype.Service;
import net.yorksolutions.zachrauchblogcmscapstonebe.repositories.AppUserRepository;

@Service
public class AppUserService {
    final AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public AppUser addUser(AppUser appUser) throws Exception {
        if (appUserRepository.findByEmail(appUser.email).isPresent()) {
            throw new Exception("The email you entered is already associated with an existing account");
        }
        return this.appUserRepository.save(appUser);
    }

    public void deleteUser(Long id, String email, String password) throws Exception {
        if (appUserRepository.findAppUserByEmailAndPassword(email, password).orElseThrow().userId.equals(id)) {
            appUserRepository.findById(id).orElseThrow();
            appUserRepository.deleteById(id);
        } else throw new Exception("Cannot delete other Users");
    }

    public AppUser modifyAppUser(Long id, AppUser appUser, String email, String password) throws Exception {
        if (appUserRepository.findAppUserByEmailAndPassword(email, password).orElseThrow().userId.equals(id)
        && appUserRepository.findByEmail(appUser.email).isEmpty()) {
            return appUserRepository.save(appUser);
        } else throw new Exception("Cannot update User, the email you entered is already associated with an existing account");
    }

    public AppUser checkCredentials(String email, String password) {
        return appUserRepository.findAppUserByEmailAndPassword(email, password).orElseThrow();
    }
}
