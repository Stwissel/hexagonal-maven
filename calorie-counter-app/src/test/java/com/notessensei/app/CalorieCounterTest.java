/*
 *     Copyright 2024 NotesSensei @ http://notessensei.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.notessensei.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.notessensei.adapters.CalorieJouleAdapter;
import com.notessensei.primaryports.ForCalculatingCalorieAllowance;
import com.notessensei.secondaryports.ForGettingFoodCalories;
import com.notessensei.secondaryports.ForGettingUserCalories;

/**
 * Unit test for CalorieCounter
 */
class CalorieCounterTest {

    private ForCalculatingCalorieAllowance calorieCounter;

    @BeforeEach
    void setUp() {
        // Initialize the CalorieCounter instance with mock dependencies
        ForGettingUserCalories mockUserCalories = new MockForGettingUserCalories();
        ForGettingFoodCalories mockFoodCalories = new MockForGettingFoodCalories();
        calorieCounter = new CalorieCounter(mockUserCalories, mockFoodCalories);
    }

    @Test
    void remainingCalories_ShouldReturnCorrectValue_WhenUserAndFoodExist() {
        // Arrange
        String username = "John";
        String foodName = "Apple";
        int quantity = 2;
        int expectedRemainingCalories = 100; // Assuming 50 calories per apple and user has 200
                                             // calories

        // Act
        int actualRemainingCalories =
                calorieCounter.remainingCalories(username, foodName, quantity);

        // Assert
        assertEquals(expectedRemainingCalories, actualRemainingCalories);
    }

    @Test
    void remainingCalories_ShouldReturnZero_WhenUserHasNoCalories() {
        // Arrange
        String username = "Jane";
        String foodName = "Banana";
        int quantity = 1;
        int expectedRemainingCalories = 0; // User has no calories

        // Act
        int actualRemainingCalories =
                calorieCounter.remainingCalories(username, foodName, quantity);

        // Assert
        assertEquals(expectedRemainingCalories, actualRemainingCalories);
    }

    @Test
    void remainingCalories_ShouldReturnNegativeValue_WhenFoodHasMoreCaloriesThanUserAllowance() {
        // Arrange
        String username = "Mike";
        String foodName = "Apple";
        int quantity = 1;
        int expectedRemainingJoules = 1882;
        // Act
        int actualRemainingJoules = CalorieJouleAdapter.caloriesToJoules(
                calorieCounter.remainingCalories(username, foodName, quantity));

        // Assert
        assertEquals(expectedRemainingJoules, actualRemainingJoules);
    }

    @Test
    void computation_should_work_with_joul_adapter() {
        // Arrange
        String username = "Mike";
        String foodName = "Pizza";
        int quantity = 1;
        int expectedRemainingCalories = -500; // Assuming pizza has 1000 calories and user allowance
                                              // is 500

        // Act
        int actualRemainingCalories =
                calorieCounter.remainingCalories(username, foodName, quantity);

        // Assert
        assertEquals(expectedRemainingCalories, actualRemainingCalories);
    }

    // Add more tests as needed

}
