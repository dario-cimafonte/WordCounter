package org.example.storage;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordStoreTest {

    @Test
    void storeAWord() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("word", 3);

        WordStoreImpl wordStore = new WordStoreImpl(expected);
        wordStore.save("word");

        assertEquals(4, wordStore.getWordCount().get("word"));
    }

    @Test
    void storeAWordForTheFirstTime() {
        Map<String, Integer> expected = new HashMap<>();

        WordStoreImpl wordStore = new WordStoreImpl(expected);
        wordStore.save("word");

        assertEquals(1, wordStore.getWordCount().get("word"));
    }

    @Test
    void retrieveWordCount() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("word", 3);

        WordStoreImpl wordStore = new WordStoreImpl(expected);
        assertEquals(3, wordStore.count("word"));
    }
}