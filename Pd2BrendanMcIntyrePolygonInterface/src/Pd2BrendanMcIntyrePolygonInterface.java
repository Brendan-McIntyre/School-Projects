/****************************************************
 Name (Full Name): Brendan McIntyre   Period: 2
 Name of the Lab/Assignment: Polygon Interface Program
 Purpose: Hands on understanding of Interface

 How I feel about this programming experience:
 I think that this was good because even if it was inefficient to create the subclasses of Triangles
 it was still good to have a better understanding of using subclasses of abstract classes.


 What I Learned:
 I learned how to integrate interface with the inheritance that I already knew.

 ****************************************************/

interface Polygon {
    // Pre: Polygon is valid.
    // Post: Returns the area as a positive double.
    public double area();

    // Pre: Polygon is valid.
    // Post: Returns the perimeter as a positive double.
    public double perimeter();
}

class RegularPolygon implements Polygon {
    protected double numSides;
    protected double sideLength;

    // Pre: numSides >= 3, sideLength > 0.
    // Post: Constructs a RegularPolygon object.
    public RegularPolygon(int numSides, double sideLength) {
        this.numSides = numSides;
        this.sideLength = sideLength;
    }

    // Pre: numSides >= 3, sideLength > 0.
    // Post: Returns area using the regular polygon formula.
    public double area() {
        return (Math.pow(sideLength, 2) * numSides) / (4 * Math.tan(Math.PI / numSides));
    }

    // Pre: numSides >= 3, sideLength > 0.
    // Post: Returns perimeter = numSides * sideLength.
    public double perimeter() {
        return sideLength * numSides;
    }
}

abstract class Quadrilateral implements Polygon {
    protected double length;
    protected double width;

    // Pre: length > 0, width > 0.
    // Post: Constructs a Quadrilateral object.
    public Quadrilateral(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Pre: length > 0, width > 0.
    // Post: Returns area = length * width.
    public double area() {
        return length * width;
    }
}

class Square extends Quadrilateral {
    // Pre: length > 0, width > 0, and length == width.
    // Post: Constructs a Square object.
    public Square(double length, double width) {
        super(length, width);
    }

    // Pre: side length > 0.
    // Post: Returns perimeter = 4 * side length.
    public double perimeter() {
        return length * 4;
    }
}

class Rectangle extends Quadrilateral {
    // Pre: length > 0, width > 0.
    // Post: Constructs a Rectangle object.
    public Rectangle(double length, double width) {
        super(length, width);
    }

    // Pre: length > 0, width > 0.
    // Post: Returns perimeter = 2 * (length + width).
    public double perimeter() {
        return 2 * length + width * 2;
    }
}

abstract class Triangle implements Polygon {
    protected double side1;
    protected double side2;
    protected double side3;

    // Pre: side1, side2, side3 > 0 and satisfy triangle inequality.
    // Post: Constructs a Triangle object.
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Pre: side1, side2, side3 > 0 and satisfy triangle inequality.
    // Post: Returns perimeter = side1 + side2 + side3.
    public double perimeter() {
        return side1 + side2 + side3;
    }
}

class IsoscelesTriangle extends Triangle {
    // Pre: side1, side2, side3 > 0 and satisfy triangle inequality.
    // Post: Constructs an IsoscelesTriangle object.
    public IsoscelesTriangle(double side1, double side2, double side3) {
        super(side1, side2, side3);
    }

    // Pre: side1, side2, side3 > 0 and satisfy triangle inequality.
    // Post: Returns area using Heron’s formula.
    public double area() {
        double semiPerim = (side1 + side2 + side3) / 2;
        return Math.sqrt(semiPerim * (semiPerim - side1) * (semiPerim - side2) * (semiPerim - side3));
    }
}

class ScaleneTriangle extends Triangle {
    // Pre: side1, side2, side3 > 0 and satisfy triangle inequality.
    // Post: Constructs a ScaleneTriangle object.
    public ScaleneTriangle(double side1, double side2, double side3) {
        super(side1, side2, side3);
    }

    // Pre: side1, side2, side3 > 0 and satisfy triangle inequality.
    // Post: Returns area using Heron’s formula.
    public double area() {
        double semiPerim = (side1 + side2 + side3) / 2;
        return Math.sqrt(semiPerim * (semiPerim - side1) * (semiPerim - side2) * (semiPerim - side3));
    }
}

class EquilateralTriangle extends Triangle {
    // Pre: side1, side2, side3 > 0, all sides equal, satisfy triangle inequality.
    // Post: Constructs an EquilateralTriangle object.
    public EquilateralTriangle(double side1, double side2, double side3) {
        super(side1, side2, side3);
    }

    // Pre: side1, side2, side3 > 0, all sides equal, satisfy triangle inequality.
    // Post: Returns area using Heron’s formula.
    public double area() {
        double semiPerim = (side1 + side2 + side3) / 2;
        return Math.sqrt(semiPerim * (semiPerim - side1) * (semiPerim - side2) * (semiPerim - side3));
    }
}
/********* PROGRAM OUTPUTS ******
 Perimeter: 9.0 Area: 2.9047375096555625
 Perimeter: 14.0 Area: 9.16515138991168
 Perimeter: 24.0 Area: 27.712812921102035
 Perimeter: 14.0 Area: 12.0
 Perimeter: 24.0 Area: 36.0
 Perimeter: 45.0 Area: 139.35866944770635
 Perimeter: 12.0 Area: 10.392304845413264
 Perimeter: 91.0 Area: 614.1312030362686
 Perimeter: 56.0 Area: 236.59292911256333
 **********************************/