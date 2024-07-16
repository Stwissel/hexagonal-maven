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

import java.util.HashMap;
import java.util.Map;
import com.notessensei.secondaryports.ForGettingUserCalories;

class MockForGettingUserCalories implements ForGettingUserCalories {

    Map<String, MockUser> userCalories = new HashMap<>();

    public MockForGettingUserCalories() {
        userCalories.put("John", new MockUser(200));
        userCalories.put("Jane", new MockUser(0));
        userCalories.put("Mike", new MockUser(500));
    }

    @Override
    public int getUserCalorieBudget(String username) {
        return userCalories.getOrDefault(username, new MockUser(0)).caloryBudget;
    }

    @Override
    public int getUserCaloriesConsumed(String username) {
        return userCalories.getOrDefault(username, new MockUser(0)).caloryConsumed;
    }

    @Override
    public void setUserCaloriesConsumed(String username, int calories) {
        userCalories.getOrDefault(username, new MockUser(0)).caloryConsumed = calories;
    }

}
