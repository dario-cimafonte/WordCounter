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
        String trimmedWord = word == null ? "" : word.trim();
        if (trimmedWord.length() == 0) {
            throw new IllegalArgumentException("a word is required");
        }
        boolean isAlpha = isAlpha(trimmedWord);
        if (!isAlpha) {
            throw new IllegalArgumentException("illegal non-alphabetic characters");
        }
        wordStore.save(translator.translate(word));
    }

    private boolean isAlpha(String s) {
        return s.chars().allMatch(Character::isAlphabetic);
    }

    public int count(String word) {
        return -1;
    }
}
