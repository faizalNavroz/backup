package com.example.fordlabs.myroomapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    void insertTask(Task task);

    @Query("select * from Task")
    List<Task> getAllTasks();
}
