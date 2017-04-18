package com.example.android.habittracker.data;

import android.provider.BaseColumns;

/**
 * API Contract for the habit tracker app.
 * Created by Christi on 18.04.2017.
 */

public final class HabitsContract {

    // Private and empty constructor. This will prevent the class from
    // being instantiated.
    private HabitsContract() {

    }

    /**
     * Inner class containing constant values used for interaction with the database
     * table.
     */
    public static final class HabitsEntry implements BaseColumns {

        // Name of the database table used for the habit tracking
        public static final String TABLE_NAME = "habits";

        /**
         * Unique ID number for the habits within the database.
         *
         * Type: INTEGER
         */
        public static final String _ID = BaseColumns._ID;

        /**
         * Name of the habit.
         *
         * Type: TEXT
         */
        public static final String COLUMN_HABIT_NAME = "name";

        /**
         * Description of the habit.
         *
         * Type: TEXT
         */
        public static final String COLUMN_HABIT_DESCRIPTION = "description";

        /**
         * Frequency of the habit.
         *
         * Type: INTEGER
         */
        public static final String COLUMN_HABIT_FREQUENCY = "frequency";

        /**
         * Esteem against the habit.
         *
         * Type: INTEGER
         */
        public static final String COLUMN_HABIT_ESTEEM = "esteem";

        /**
         * Healthyness of the habit.
         *
         * Type: INTEGER
         */
        public static final String COLUMN_HABIT_IS_HEALTHY = "is_healthy";

        /**
         * Possible values for the frequency of the habit.
         */
        public static final int FREQUENCY_UNKNOWN = 0;
        public static final int FREQUENCY_DAILY = 1;
        public static final int FREQUENCY_WEEKLY = 2;
        public static final int FREQUENCY_MONTHLY = 3;
        public static final int FREQUENCY_YEARLY = 4;

        /**
         * Possible values for the esteem against the habit.
         */
        public static final int ESTEEM_UNDEFINED = 0;
        public static final int ESTEEM_LOW = 1;
        public static final int ESTEEM_MEDIUM = 2;
        public static final int ESTEEM_HIGH = 3;

        /**
         * Possible values for the healthyness of the habit.
         */
        public static final int IS_NOT_RELATED_TO_HEALTH = 0;
        public static final int IS_HEALTHY = 1;
        public static final int IS_NOT_HEALTHY = 2;



    }
}
