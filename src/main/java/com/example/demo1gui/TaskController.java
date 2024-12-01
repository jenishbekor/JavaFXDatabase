package com.example.demo1gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class TaskController {

    @FXML
    private TextField descfield;

    @FXML
    private TextField namefield;

    @FXML
    private TextField prifield;

    @FXML
    private Label taskidlabel;

    @FXML
    private DatePicker datepicker;

    TaskService taskService;

    public void setTaskDAO(TaskService taskService) {
        this.taskService = taskService;
    }

    @FXML
    void onCreate(ActionEvent event) {
        Task newTask = new Task();

        newTask.setTaskname( namefield.getText() );
        newTask.setDescription(  descfield.getText() );

        LocalDate date = datepicker.getValue();
        Instant i = date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        newTask.setDeadline( Date.from(i));

        newTask.setId(0);
        newTask.setPriority( prifield.getText());

        int newid = taskService.insertTask(newTask);
        if(newid == 0 ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Deadline must be later than now.");
            alert.show();
        }

        newTask.setId(newid);
        taskidlabel.setText( "" + newTask.getId());

    }

}
