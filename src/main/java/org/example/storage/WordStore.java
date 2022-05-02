package org.example.storage;

public interface WordStore {

    void save(String word);

    int count(String word);
}
