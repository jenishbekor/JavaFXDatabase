package com.example.demo1gui;

import java.util.Date;

public class Task{

        private int id;
        private String taskname;
        private String description;

        private Date deadline;

        private String priority;

    public Task() {
    }

    public Task(int id, String taskname, String description, Date deadline, String priority) {
            this.id = id;
            this.taskname = taskname;
            this.description = description;
            this.deadline = deadline;
            this.priority = priority;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTaskname() {
            return taskname;
        }

        public void setTaskname(String taskname) {
            this.taskname = taskname;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Date getDeadline() {
            return deadline;
        }

        public void setDeadline(Date deadline) {
            this.deadline = deadline;
        }

        public String getPriority() {
            return priority;
        }

        public void setPriority(String priority) {
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "id=" + id +
                    ", taskname='" + taskname + '\'' +
                    ", description='" + description + '\'' +
                    ", deadline=" + deadline +
                    ", priority='" + priority + '\'' +
                    '}';
        }
}
