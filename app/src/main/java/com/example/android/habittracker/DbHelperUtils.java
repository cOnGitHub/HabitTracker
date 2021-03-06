package com.example.android.habittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.habittracker.data.HabitsContract.HabitsEntry;
import com.example.android.habittracker.data.HabitsDbHelper;

/**
 * Class containing methods for writing to and reading from the database.
 * <p>
 * Created by Christi on 18.04.2017.
 */

public final class DbHelperUtils {

    // Private and empty constructor
    private DbHelperUtils() {

    }

    public static void insertHabit(Context context) {

        // Database helper
        HabitsDbHelper mDbHelper = new HabitsDbHelper(context);

        // Get the database repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(HabitsEntry.COLUMN_HABIT_NAME, "Jogging");
        values.put(HabitsEntry.COLUMN_HABIT_DESCRIPTION, "Jogging through nearby nature sites for about 1 hour");
        values.put(HabitsEntry.COLUMN_HABIT_FREQUENCY, HabitsEntry.FREQUENCY_WEEKLY);
        values.put(HabitsEntry.COLUMN_HABIT_ESTEEM, HabitsEntry.ESTEEM_HIGH);
        values.put(HabitsEntry.COLUMN_HABIT_IS_HEALTHY, HabitsEntry.IS_HEALTHY);

        // Insert the new row,returning primary kay value of the new row
        long newRowId = db.insert(HabitsEntry.TABLE_NAME, null, values);

        // Create a new map of values, where column names are the keys
        ContentValues valuesSet2 = new ContentValues();
        valuesSet2.put(HabitsEntry.COLUMN_HABIT_NAME, "Smoking");
        valuesSet2.put(HabitsEntry.COLUMN_HABIT_DESCRIPTION, "Smoking cigarettes over the day");
        valuesSet2.put(HabitsEntry.COLUMN_HABIT_FREQUENCY, HabitsEntry.FREQUENCY_DAILY);
        valuesSet2.put(HabitsEntry.COLUMN_HABIT_ESTEEM, HabitsEntry.ESTEEM_HIGH);
        valuesSet2.put(HabitsEntry.COLUMN_HABIT_IS_HEALTHY, HabitsEntry.IS_NOT_HEALTHY);

        // Insert the new row,returning primary kay value of the new row
        long newRowIdSet2 = db.insert(HabitsEntry.TABLE_NAME, null, valuesSet2);

        // Create a new map of values, where column names are the keys
        ContentValues valuesSet3 = new ContentValues();
        valuesSet3.put(HabitsEntry.COLUMN_HABIT_NAME, "Drinking wine");
        valuesSet3.put(HabitsEntry.COLUMN_HABIT_DESCRIPTION, "Drinking one glass wine in the evening");
        valuesSet3.put(HabitsEntry.COLUMN_HABIT_FREQUENCY, HabitsEntry.FREQUENCY_DAILY);
        valuesSet3.put(HabitsEntry.COLUMN_HABIT_ESTEEM, HabitsEntry.ESTEEM_MEDIUM);
        valuesSet3.put(HabitsEntry.COLUMN_HABIT_IS_HEALTHY, HabitsEntry.IS_HEALTHY);

        // Insert the new row,returning primary kay value of the new row
        long newRowIdSet3 = db.insert(HabitsEntry.TABLE_NAME, null, valuesSet3);
    }

    public static String displayDatabaseInfo(Context context) {

        // Return string to be displayed in activity_main.xml
        String output = "";

        // Get cursor from read method
        Cursor cursor = readHabits(context);

        try {
            // Display the number of rows in the Cursor (which reflects the number of rows in the
            // table in the database).

            output += "Number of habits which are healthy ( 1 ): " + cursor.getCount() + "\n\n";

            output += HabitsEntry.COLUMN_HABIT_NAME + " - "
                    + HabitsEntry.COLUMN_HABIT_FREQUENCY + " - "
                    + HabitsEntry.COLUMN_HABIT_IS_HEALTHY + "\n";

            int nameColumnIndex = cursor.getColumnIndex(HabitsEntry.COLUMN_HABIT_NAME);
            int frequencyColumnIndex = cursor.getColumnIndex(HabitsEntry.COLUMN_HABIT_FREQUENCY);
            int healthyColumnIndex = cursor.getColumnIndex(HabitsEntry.COLUMN_HABIT_IS_HEALTHY);

            while (cursor.moveToNext()) {
                String currentName = cursor.getString(nameColumnIndex);
                int currentFrequency = cursor.getInt(frequencyColumnIndex);
                int currentHealthiness = cursor.getInt(healthyColumnIndex);

                output += "\n" + currentName + " - " + currentFrequency + " - " + currentHealthiness;
            }
        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }

        return output;
    }

    /**
     * Method for reading data and returning it as a Cursor.
     */
    private static Cursor readHabits(Context context) {
        // Database helper
        HabitsDbHelper mDbHelper = new HabitsDbHelper(context);

        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Projection of the columns to be read off the table
        String[] projection = {
                HabitsEntry.COLUMN_HABIT_NAME,
                HabitsEntry.COLUMN_HABIT_FREQUENCY,
                HabitsEntry.COLUMN_HABIT_IS_HEALTHY};

        // Selection of the SQL WHERE clause
        String selection = HabitsEntry.COLUMN_HABIT_IS_HEALTHY + "=?";
        String[] selectionArgs = new String[]{String.valueOf(HabitsEntry.IS_HEALTHY)};

        Cursor cursor = db.query(HabitsEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null);

        return cursor;
    }
}
