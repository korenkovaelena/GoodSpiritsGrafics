package com.example.calculatorfx;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HelloController {
    @FXML
    private TextArea result;

    @FXML
    private TextField side1;

    @FXML
    private TextField side2;

    @FXML
    private TextField side3;
    @FXML
    private TextField side5;

    @FXML
    private TextField side4;


    @FXML
    private ToggleGroup switchFigure;

    @FXML
    private RadioButton rectangle;
    @FXML
    private RadioButton trapezoid;

    @FXML
    private RadioButton triangle;

    @FXML
    private Label sideFieldName;

    @FXML
    private Label sideFieldNameTrapezoid;
    @FXML
    private Button countAreaButton;
    @FXML
    void switchToRectangle(ActionEvent event) {
        side3.setVisible(false);
        sideFieldNameTrapezoid.setVisible(false);
        sideFieldName.setText("Введите стороны прямоугольника:");
        side5.setVisible(false);
        side4.setVisible(false);
    }

    @FXML
    void switchToTrapezoid(ActionEvent event) {
        sideFieldName.setText("Введите длины оснований трапеции:");
        sideFieldNameTrapezoid.setVisible(true);
        side5.setVisible(true);
        side4.setVisible(true);
        side3.setVisible(false);
    }

    @FXML
    void switchToTriangle(ActionEvent event) {
        sideFieldName.setText("Введите стороны треугольника:");
        sideFieldNameTrapezoid.setVisible(false);
        side5.setVisible(false);
        side4.setVisible(false);
        side3.setVisible(true);
        //countAreaButton.setOnAction();
    }

    @FXML
    void countArea(ActionEvent event) throws ImpossibleTriangleException, NotNaturalNumberException {
        if (switchFigure.getSelectedToggle()==triangle){
            calculateTriangle();
        }
        if (switchFigure.getSelectedToggle()==rectangle){
            calculateRectangle();
        }
        if (switchFigure.getSelectedToggle()==trapezoid){
            calculateTrapezoid();
        }

    }
    void calculateTriangle(){
            try {
                double x = Double.parseDouble(side1.getText());
                double y = Double.parseDouble(side2.getText());
                double z = Double.parseDouble(side3.getText());
                Triangle tr = new Triangle(x, y, z);
                double area = tr.area();
                result.setText(String.valueOf(area));
            }
            catch (ImpossibleTriangleException | NotNaturalNumberException ex){
                result.setText(ex.getMessage());
            }
            catch (InputMismatchException ex){
                System.out.println("Нужны целые числа");
            }
            catch (java.lang.RuntimeException ex){
                result.setText("Можно вводить только числа");
            }

    }
    void calculateRectangle() {
        try {
            double x = Double.parseDouble(side1.getText());
            double y = Double.parseDouble(side2.getText());
            Rectangle rect = new Rectangle(x,y);
            double area = rect.rectangleArea();
            result.setText(String.valueOf(area));
        }
        catch (NotNaturalNumberException ex){
            result.setText(ex.getMessage());
        }
        catch (InputMismatchException ex){
            System.out.println("Нужны целые числа");
        }
        catch (java.lang.RuntimeException ex){
            result.setText("Можно вводить только числа");
        }
    }
    void calculateTrapezoid() {
        try {
            double a = Double.parseDouble(side1.getText());
            double b = Double.parseDouble(side2.getText());
            double c = Double.parseDouble(side4.getText());
            double d = Double.parseDouble(side5.getText());

            Trapezoid trap = new Trapezoid(a,b,c,d);
            double area = trap.area();
            result.setText(String.valueOf(area));
        }
        catch (NotNaturalNumberException | ImpossibleTriangleException ex){
            result.setText(ex.getMessage());
        }
        catch (InputMismatchException ex){
            System.out.println("Нужны целые числа");
        }
        catch (java.lang.RuntimeException ex){
            result.setText("Можно вводить только числа");
        }
    }
}