package com.example.demo1gui;

import java.sql.*;
// CRUD operations with database
public class TaskData {

    private Connection conn;

    public TaskData(){
        String url = "jdbc:postgresql:testdb"; // testdb is a name of localhost database
        String username = "postgres";
        String password = "postgres";

        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Database is successfully connected...");
        }
        catch(SQLException e){
            System.out.println(e.toString());
        }

    }

    public Task insertTask(Task task) {
        int newid = 0;

        try {
            String sql = "INSERT INTO tasks (taskname, description, deadline, priority)" +
                    " VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, task.getTaskname());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setDate(3, new Date(task.getDeadline().getTime()));
            preparedStatement.setString(4, task.getPriority());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating task failed.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {

                if (generatedKeys.next()) {
                    newid = generatedKeys.getInt(1);
                    task.setId(newid);
                }
            }

            System.out.println("New record is added with id: " + newid);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }


        return task;
    }
}
