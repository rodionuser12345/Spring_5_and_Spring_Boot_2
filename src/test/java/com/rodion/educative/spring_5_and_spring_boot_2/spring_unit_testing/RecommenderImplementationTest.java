package com.rodion.educative.spring_5_and_spring_boot_2.spring_unit_testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RecommenderImplementationTest {

    @Mock
    private Filter mockFilter;

    @InjectMocks
    private RecommenderImplementation recommenderImpl;

    @Test
    void testRecommendMovies_withCollaborativeFilter() {
        when(mockFilter.getRecommendations("Finding Dory")).
                thenReturn(new String[]{"Happy Feet", "Ice Age", "Shark Tale"});
        assertArrayEquals(new String[]{"Happy Feet", "Ice Age", "Shark Tale"},
                recommenderImpl.recommendMovies("Finding Dory"));
    }

    @Test
    void testRecommendMovies_withContentBasedFilter() {
        when(mockFilter.getRecommendations("Finding Dory")).
                thenReturn(new String[]{"Finding Nemo", "Ice Age", "Toy Story"});
        assertArrayEquals(new String[]{"Finding Nemo", "Ice Age", "Toy Story"},
                recommenderImpl.recommendMovies("Finding Dory"));
    }

}