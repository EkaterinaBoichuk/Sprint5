package com.example;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ParameterizedTests {

    @Mock
    Predator predator;

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 5, 10})
    void getKittensWithCountReturnsSameCount(int kittensCount) {
        Feline feline = new Feline();
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void constructorSetsCorrectHasMane(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(sex, predator);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "самец", "Мужской", "unknown"})
    void constructorThrowsExceptionForInvalidSex(String invalidSex) {
        assertThrows(Exception.class, () -> new Lion(invalidSex, predator));
    }
}