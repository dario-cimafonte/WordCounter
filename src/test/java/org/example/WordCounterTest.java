package org.example;

import org.example.storage.WordStore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class WordCounterTest {

    @Mock
    Translator translator;
    @Mock
    WordStore wordStore;

    @InjectMocks
    WordCounter wordCounter;

    @Test
    void aLegalWordIsAdded() {
        wordCounter.add("flower");
        verify(wordStore).save("flower");
    }
}