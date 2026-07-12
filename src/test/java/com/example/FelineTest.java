package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FelineTest {
    private final Feline feline = new Feline();

    @Test
    void eatMeatReturnsCorrectFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat());
    }

    @Test
    void getFamilyReturnsCorrectFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittensDefaultReturnsOne() {
        assertEquals(1, feline.getKittens());
    }
}
