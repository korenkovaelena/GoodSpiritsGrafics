package com.example.calculatorfx;

public class Trapezoid {
    double upperBase;
    double lowerBase;
    double rightLeg;
    double leftLeg;

    public Trapezoid(double upperBase, double lowerBase, double rightLeg, double leftLeg) throws NotNaturalNumberException, ImpossibleTriangleException {
        this.upperBase = upperBase;
        this.lowerBase = lowerBase;
        this.rightLeg = rightLeg;
        this.leftLeg = leftLeg;
        if (upperBase<=0 || lowerBase<=0 || rightLeg<=0 || leftLeg<=0)
            throw new NotNaturalNumberException("Можно вводить только положительные числа");
        isTrapezoidPossible();
    }
    public double area(){
        double a;
        double b;
        if (upperBase>lowerBase){
            b = upperBase;
            a = lowerBase;
        }
        else
        {
            a = upperBase;
            b = lowerBase;
        }
        double c = rightLeg;
        double d = leftLeg;
        double p = (a+b+c+d)/2;
        double m = Math.abs(a-b);
       // double bb =(p-a)*(p-b)*(p-a-c)*(p-a-d);///
        double sq = Math.sqrt((p-a)*(p-b)*(p-a-c)*(p-a-d));
        double area = (a+b)/m*(sq);
        return area;
    }
    public void isTrapezoidPossibleCalc(double x, double y, double z) throws ImpossibleTriangleException {
        double max; double min1; double min2; double tmp;
        if(x>y) {
            max = x;
            min1 = y;
        }
        else {
            max = y;
            min1 =x;
        }
        if (max<z) {
            tmp=max;
            max = z;
            min2 = tmp;
        }
        else
            min2 = z;
        if (max>=(min1+min2))
            throw  new ImpossibleTriangleException("Невозможно создать трапецию с такими длинами");

    }
    public void isTrianglePossible2() throws ImpossibleTriangleException {
    double x = Math.abs(upperBase-lowerBase);
    double y; double z;
    if (rightLeg<leftLeg) {
        y = rightLeg;
        z = leftLeg;
    }
    else {
        y = leftLeg;
        z = rightLeg;
    }
        isTrapezoidPossibleCalc(x,y,z);
    }


    public void isTrapezoidPossible() throws ImpossibleTriangleException {
        isTrapezoidPossibleCalc(upperBase, rightLeg, lowerBase);
        isTrapezoidPossibleCalc(rightLeg, lowerBase, leftLeg);
        isTrapezoidPossibleCalc(lowerBase, leftLeg, upperBase);
        isTrapezoidPossibleCalc(leftLeg, upperBase, rightLeg);
        isTrianglePossible2();
    }

}
