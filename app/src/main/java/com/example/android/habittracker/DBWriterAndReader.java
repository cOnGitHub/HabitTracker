package com.example.android.habittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.habittracker.data.HabitsContract.HabitsEntry;
import com.example.android.habittracker.data.HabitsDbHelper;

/**
 * Created by Christi on 18.04.2017.
 */

public final class DBWriterAndReader {

    // Private and empty constructor
    private DBWriterAndReader() {

    }

    public static void insertPet(Context context) {

        // Database helper
        HabitsDbHelper mDbHelper = new HabitsDbHelper(context);

        // Get the database repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(HabitsEntry.COLUMN_HABIT_NAME, "Jogging");
        values.put(HabitsEntry.COLUMN_HABIT_DESCRIPTION, "Jogging through nearby nature sites");
        values.put(HabitsEntry.COLUMN_HABIT_FREQUENCY, 2);
        values.put(HabitsEntry.COLUMN_HABIT_ESTEEM, 3);
        values.put(HabitsEntry.COLUMN_HABIT_IS_HEALTHY, 1);

        // Insert the new row,returning primary kay value of the new row
        long newRowId = db.insert(HabitsEntry.TABLE_NAME, null, values);
    }
}
