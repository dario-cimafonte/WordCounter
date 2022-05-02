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
}