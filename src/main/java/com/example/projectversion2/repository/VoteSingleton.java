package com.example.projectversion2.repository;

import java.util.ArrayList;
import java.util.List;

public class VoteSingleton {
    private static VoteSingleton instance = new VoteSingleton();
    private List<String> users = new ArrayList<>();

    private VoteSingleton() {
    }

    public static VoteSingleton getVoteSingleton() {
        return instance;
    }

    public void registerVote(String id) {
        users.add(id);
    }

    public boolean isVoting(String id) {
        for (String s : users) {
            if (s.equals(id)) {
                return true;
            }
        }
        return false;
    }
}
