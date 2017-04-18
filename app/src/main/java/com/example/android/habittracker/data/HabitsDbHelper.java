package com.example.android.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.habittracker.data.HabitsContract.HabitsEntry;

/**
 * Helper class for the database of the Habit Tracker App.
 * Manages database creation, connection and versioning.
 *
 * Created by Christi on 18.04.2017.
 */
public class HabitsDbHelper extends SQLiteOpenHelper {

    // Name of the database file
    private static final String DATABASE_NAME = "habittracker.db";

    /**
     * Database version of the habits database. On any changes of the
     * database schema, the version will be incremented
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructor of the HabitsDbHelper.
     *
     * @param context from which the object is created
     */
    public HabitsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Method executed on creation of the database.
     *
     * @param db is the SQLiteDatabase object referencing the database
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL Statement for creation of the database
        String SQL_CREATE_HABITS_TABLE = "CREATE TABLE " + HabitsEntry.TABLE_NAME + " ("
                + HabitsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitsEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL, "
                + HabitsEntry.COLUMN_HABIT_DESCRIPTION + " TEXT, "
                + HabitsEntry.COLUMN_HABIT_FREQUENCY + " INTEGER NOT NULL DEFAULT 0, "
                + HabitsEntry.COLUMN_HABIT_ESTEEM + " INTEGER, "
                + HabitsEntry.COLUMN_HABIT_IS_HEALTHY + " INTEGER DEFAULT 0);";

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This is the initial database version, so no action is needed here
    }
}
