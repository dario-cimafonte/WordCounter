package org.example;

import org.example.storage.WordStore;

public class WordCounter {

    private final Translator translator;
    private final WordStore wordStore;

    public WordCounter(Translator translator, WordStore wordStore) {
        this.translator = translator;
        this.wordStore = wordStore;
    }

    public void add(String word) {
        if (word == null || word.trim().length() == 0) {
            throw new IllegalArgumentException("a word is required");
        }
        wordStore.save(translator.translate(word));
    }

    public int count(String word) {
        return -1;
    }
}
