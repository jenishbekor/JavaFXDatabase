package com.example.demo1gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class HelloController {

    @FXML
    private TextField deadlinefield;

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

    TaskDAO taskDAO = new TaskDAO();

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

        int newid = taskDAO.insert(newTask);
        newTask.setId(newid);
        taskidlabel.setText( "" + newTask.getId());

    }

}
