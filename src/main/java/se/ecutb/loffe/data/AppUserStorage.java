package se.ecutb.loffe.data;

import se.ecutb.loffe.model.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserStorage {
    Optional<AppUser> findById(int appUserId); // Bra med optional då EN ska hittas. Undviker null!
    List<AppUser> findAll();
    List<AppUser> findByFirstName(String firstName);
    List<AppUser> findByLastName(String lastName);
    Optional<AppUser> findByEmail(String email);
    AppUser createAppUser(String firstName, String lastName, String email);
    boolean deleteAppUser(int appUserId);

}
