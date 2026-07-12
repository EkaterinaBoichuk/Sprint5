package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    Predator predator;

    @Test
    void getKittensReturnsKittensFromPredator() throws Exception {
        when(predator.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", predator);

        assertEquals(3, lion.getKittens());
    }

    @Test
    void getFoodReturnsFoodFromPredator() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(predator.eatMeat()).thenReturn(expected);

        Lion lion = new Lion("Самец", predator);

        assertEquals(expected, lion.getFood());
    }
}