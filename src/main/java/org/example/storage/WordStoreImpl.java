package org.example.storage;

import java.util.HashMap;
import java.util.Map;

public class WordStoreImpl implements WordStore {
    private final Map<String, Integer> wordCount;

    public WordStoreImpl() {
        this(new HashMap<>());
    }

    public WordStoreImpl(Map<String, Integer> wordCount) {
        this.wordCount = wordCount;
    }

    @Override
    public synchronized void save(String word) {
        int count = wordCount.getOrDefault(word, 0);
        wordCount.put(word, count+1);
    }

    @Override
    public int count(String word) {
        return wordCount.getOrDefault(word, 0);
    }

    Map<String, Integer> getWordCount() {
        return wordCount;
    }
}
