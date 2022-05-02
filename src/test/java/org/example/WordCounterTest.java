package org.example;

import org.example.storage.WordStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WordCounterTest {

    @Mock(lenient = true)
    Translator translator;
    @Mock
    WordStore wordStore;

    @InjectMocks
    WordCounter wordCounter;

    @BeforeEach
    void setUp() {
        doAnswer(i -> i.getArgument(0)).when(translator).translate(any());
    }

    @Test
    void aLegalWordIsAdded() {
        wordCounter.add("flower");
        verify(wordStore).save("flower");
    }

    @Test
    void aWordIsTranslated() {
        doReturn("flower").when(translator).translate("blume");
        wordCounter.add("blume");
        verify(wordStore).save("flower");
    }
}