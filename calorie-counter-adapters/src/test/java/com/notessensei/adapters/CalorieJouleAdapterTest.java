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
package com.notessensei.adapters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Unit test for CalorieJouleAdapter
 */
class CalorieJouleAdapterTest {

    @Test
    void testConvertCaloriesToJoules() {
        // 1 calorie is approximately 4.184 joules
        int calories = 1000;
        int expectedJoules = 4184;
        int result = CalorieJouleAdapter.caloriesToJoules(calories);
        assertEquals(expectedJoules, result,
                "1000 calorie should convert to 4184 joules");
    }

    @Test
    void testConvertJoulesToCalories() {
        // 1 joule is approximately 0.239005736 calories
        int joules = 1000;
        int expectedCalories = 239;
        int result = CalorieJouleAdapter.joulesToCalories(joules);
        assertEquals(expectedCalories, result,
                "1000 joule should convert to approximately 239 calories");
    }

}
