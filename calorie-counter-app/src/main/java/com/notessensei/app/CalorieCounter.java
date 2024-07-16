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

import com.notessensei.primaryports.ForCalculatingCalorieAllowance;
import com.notessensei.secondaryports.ForGettingFoodCalories;
import com.notessensei.secondaryports.ForGettingUserCalories;

public class CalorieCounter implements ForCalculatingCalorieAllowance {

    private final ForGettingUserCalories forGettingUserCalories;
    private final ForGettingFoodCalories forGettingFoodCalories;

    public CalorieCounter(ForGettingUserCalories forGettingUserCalories,
            ForGettingFoodCalories forGettingFoodCalories) {
        this.forGettingUserCalories = forGettingUserCalories;
        this.forGettingFoodCalories = forGettingFoodCalories;
    }

    public int remainingCalories(String username, String foodName, int quantity) {
        int userCalorieBudget = forGettingUserCalories.getUserCalorieBudget(username);

        if (userCalorieBudget == 0) {
            return 0;
        }
        int foodCalories = forGettingFoodCalories.getFoodCalories(foodName);
        int userCaloriesConsumed = forGettingUserCalories.getUserCaloriesConsumed(username);
        int totalCaloriesConsumed = userCaloriesConsumed + (foodCalories * quantity);
        forGettingUserCalories.setUserCaloriesConsumed(username, totalCaloriesConsumed);
        return userCalorieBudget - totalCaloriesConsumed;
    }

}
