package com.example.fordlabs.myroomapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saveTask();
        printTaskInfo();
    }


    private void saveTask() {

        class SaveTask extends AsyncTask<Void,Void,Void>{

            @Override
            protected Void doInBackground(Void... voids) {
                Task task = new Task();
                task.setDesc("TSK 1");
                task.setId(001);

                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase().taskDao().insertTask(task);
                SaveTask st = new SaveTask();
                st.execute();

                return null;
            }
        }
    }

    private void printTaskInfo() {

        class GetTasks extends AsyncTask<Void,Void,List<Task>>{
            @Override
            protected List<Task> doInBackground(Void... voids) {

                List<Task> tasksList = new ArrayList<Task>();

                tasksList =   DatabaseClient.getInstance(getApplicationContext()).getAppDatabase().taskDao().getAllTasks();

                Log.i("****************", "doInBackground: "+tasksList.get(0).getId());

                return tasksList;
            }
        }
    }

}
