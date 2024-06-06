package ru.netology.authorizationservice.repository;

import ru.netology.authorizationservice.authorities.Authorities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class UserRepository {
    private final ConcurrentMap<String, String> personalData = new ConcurrentHashMap<String, String>();

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (personalData.containsKey(user)) {
            return new ArrayList<Authorities>(List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
        } else {
            return List.of();
        }
    }
}
