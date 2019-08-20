package com.example.fordlabs.myroomapp;

import android.arch.persistence.room.Room;
import android.content.Context;

public class DatabaseClient {

    private Context mCtx;
    private static DatabaseClient mInstance;

    //our app database object
    private TaskDatabase appDatabase;

    private DatabaseClient(Context mCtx) {
        this.mCtx = mCtx;

        //creating the app database with Room database builder
        //MyToDos is the name of the database
        appDatabase = Room.databaseBuilder(mCtx, TaskDatabase.class, "MyToDos").build();
    }

    public static synchronized DatabaseClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new DatabaseClient(mCtx);
        }
        return mInstance;
    }

    public TaskDatabase getAppDatabase() {
        return appDatabase;
    }
}
