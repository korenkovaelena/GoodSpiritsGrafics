package com.example.calculatorfx;

import java.util.Scanner;

public class Rectangle {
    double length;
    double width;

    public Rectangle(double length, double width) throws NotNaturalNumberException {
        this.length = length;
        this.width = width;
        if (length<=0 || width<=0)
            throw new NotNaturalNumberException("Можно вводить только положительные числа");
    }

    public double setWidth() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("введите ширину");
             width = sc.nextInt();}
        while (length<0 || width<0);
        return width;
    }
    public double setLength() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("введите длину");
         length = sc.nextInt();}
        while (length<0 || width<0);
        return length;
    }
    public double rectanglePerimeter(){
        return length*2 + width*2;
    }
    public double rectangleArea(){
        return length* width;
    }
    static Rectangle inputRectangle(){
        Rectangle r1 = new Rectangle();
        r1.length = r1.setLength();
        r1.width = r1.setWidth();
        return r1;
    }
    public static void main(String[] args){
       // Rectangle r1 = inputRectangle();
        Rectangle r1 = new Rectangle();
        System.out.println("Периметр = "+r1.rectanglePerimeter());
        System.out.println("Периметр = "+r1.rectangleArea());
    }
    public Rectangle(){
            System.out.println("введите данные прямоугольника");
            length = setLength();
            width = setWidth();
    }
}
