package com.example.demo4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class ControllerForm {
    @FXML
    private Text output;
    private double num1 = 0;
    private double num2 = 0;

    private boolean start = true;

    private String operator = "";
    private Model model = new Model();

    @FXML
    private void processNum(ActionEvent event) {
        if (start) {
            output.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText()+value);
    }
    @FXML
    private void proOperator(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        if(!"=".equals(value)){
            if(!operator.isEmpty())return;
            operator = value;
            num1 = Long.parseLong(output.getText());
            output.setText("");
        }
        else {
            if(operator.isEmpty()) return;
            output.setText(String.valueOf(model.calculation(num1,Long.parseLong(output.getText()),operator)));
            operator = "";
            start = true;
        }
    }
}

