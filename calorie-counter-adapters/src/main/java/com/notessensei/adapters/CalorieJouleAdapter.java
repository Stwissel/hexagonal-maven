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

/**
 * The adapter class for converting calories to joules.
 * and vice versa
 *
 * @author NotesSensei
 * @since 1.0
 */
public class CalorieJouleAdapter {

    private CalorieJouleAdapter() {
        // static utility class
    }

    private static final double JOULES_PER_CALORIE = 4.184;

    /**
     * Converts calories to joules.
     *
     * @param calories the number of calories
     * @return the number of joules
     */
    public static int caloriesToJoules(final int calories) {
        return (int) (calories * JOULES_PER_CALORIE);
    }

    /**
     * Converts joules to calories.
     *
     * @param joules the number of joules
     * @return the number of calories
     */
    public static int joulesToCalories(final int joules) {
        return (int) (joules / JOULES_PER_CALORIE);
    }
}
