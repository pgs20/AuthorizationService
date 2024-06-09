package ru.netology.authorizationservice.repository;

import ru.netology.authorizationservice.authorities.Authorities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class UserRepository {
    private final ConcurrentMap<String, String> personalData = new ConcurrentHashMap<String, String>();

    public List<Authorities> getUserAuthorities(User user) {
        if (personalData.containsKey(user.getUser())) {
            return new ArrayList<>(List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
        } else {
            return List.of();
        }
    }
}
