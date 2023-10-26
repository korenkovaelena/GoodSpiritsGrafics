package com.example.calculatorfx;

public class Triangle {
    double x;
    double y;
    double z;

    public Triangle(double x, double y, double z) throws NotNaturalNumberException, ImpossibleTriangleException {
        this.x = x;
        this.y = y;
        this.z = z;
        if (x<=0 || y<=0 ||z<=0)
            throw new NotNaturalNumberException("Можно вводить только положительные числа");
        isTrianglePossible();
    }
    public void isTrianglePossible() throws ImpossibleTriangleException {
        double max; double min1; double min2;
        if(x>y) {
            max = x;
            min1 = y;
        }
        else {
            max = y;
            min1 =x;
        }
        if (max<z) {
            max = z;
            min2 = max;
        }
        else
            min2 = z;
        if (max>=(min1+min2))
            throw  new ImpossibleTriangleException("Невозможно создать треугольник с такими длинами");

    }

    public double perimetr() {
        double perimetr = x+y+z;
        return perimetr;
    }

    public double  area(){
        double hp = (x+y+z)/2;
        double area = Math.sqrt(hp*(hp-x)*(hp-y)*(hp-z));
        System.out.println("площадь треугольника = "+area);
        return area;
    }
}
