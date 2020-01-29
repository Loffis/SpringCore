package se.ecutb.loffe.data;

import se.ecutb.loffe.model.AppUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AppUserStorageListImpl implements AppUserStorage{

    private List<AppUser> appUsers;

    public AppUserStorageListImpl() {
        this.appUsers = new ArrayList<>();
    }

    @Override
    public Optional<AppUser> findById(int appUserId) {
        return appUsers.stream()
                .filter(appUser -> appUser.getAppUserId() == appUserId)
                .findFirst();
    }

    @Override
    public List<AppUser> findAll() {
        return appUsers;
    }

    @Override
    public List<AppUser> findByFirstName(String firstName) {
        return appUsers.stream()
                .filter(appUser -> appUser.getFirstName().equalsIgnoreCase(firstName))
                .collect(Collectors.toList());
    }

    @Override
    public List<AppUser> findByLastName(String lastName) {
        return appUsers.stream()
                .filter(appUser -> appUser.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AppUser> findByEmail(String email) {
        return appUsers.stream()
                .filter(appUser -> appUser.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    @Override
    public AppUser createAppUser(String firstName, String lastName, String email) {
        if (findByEmail(email).isPresent()){
            throw new IllegalArgumentException("Email " + email + " already exists!");
        }
        AppUser newUser = new AppUser(firstName, lastName, email);
        appUsers.add(newUser);
        return newUser;
    }

    @Override
    public boolean deleteAppUser(int appUserId) {
        return appUsers.remove(findById(appUserId).orElseThrow(IllegalAccessError::new));
    }
}
