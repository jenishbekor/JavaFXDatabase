package com.example.demo1gui;

import java.util.Date;

public class TaskService {

    TaskDAO taskDAO;

    public TaskService(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    public int insertTask(Task task){
        int id = 0;

        if( task.getDeadline().after(new Date())) {
            id = taskDAO.insert(task);
        }
        return id;
    }
}