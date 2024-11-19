package com.example.demo1gui;

import java.sql.*;
import java.util.List;

public class TaskDAO implements DAOInterface<Task>{

    private Connection conn;

    public TaskDAO(){
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

    @Override
    public int insert(Task entity) {
        int newid = 0;

        try {
            String sql = "INSERT INTO tasks (taskname, description, deadline, priority)" +
                    " VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, entity.getTaskname());
            preparedStatement.setString(2, entity.getDescription());
            preparedStatement.setDate(3, new Date(entity.getDeadline().getTime()));
            preparedStatement.setString(4, entity.getPriority());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating task failed.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {

                if (generatedKeys.next()) {
                    newid = generatedKeys.getInt(1);
                }
            }

            System.out.println("New record is added with id: " + newid);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }


        return newid;
    }

    @Override
    public Task read(int id) {
        return null;
    }

    @Override
    public void update(Task entity) {

    }

    @Override
    public void delete(Task entity) {

    }

    @Override
    public List<Task> findAll() {
        return null;
    }
}
