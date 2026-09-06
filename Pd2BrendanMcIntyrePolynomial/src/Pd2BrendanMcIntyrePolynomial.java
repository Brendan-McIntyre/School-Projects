/***
 Name:Brendan McIntyre
 Period:2
 Name of the Program:Interface lab: Polynomial
 Purpose of Program: To better understand how to use interface by using it in a different way.

 What I Learned/Reflection:
 I learned you could have parameters in methods defined in an interface.
 ***/
public class Pd2BrendanMcIntyrePolynomial {
    public static void main(String[] args) {
        double [] c = {1, 0, 3, 4};
        double [] c1 = {-2, -5};

        Polynomial p1 = new ArrayBasedPolynomial(c);             // 4x^3 + 3x^2 + 1
        System.out.println("p1(x) =     " + p1);

        Polynomial p2 = new ArrayBasedPolynomial(c1);            // -5x – 2
        System.out.println("p2(x) =     " + p2);

        Polynomial p3   = new ArrayBasedPolynomial (-4, 1);      // coeff = -4, exp = 1
        System.out.println("p3(x) =     " + p3);

        Polynomial p    = p1.plus(p2).plus(p2);                  // 4x^3 + 3x^2 - 10x – 3
        System.out.println("p(x) =     " + p);

        Polynomial p4   = p.minus(p3);                           // 4x^3 + 3x^2 - 6x – 3
        System.out.println("p4(x) =     " + p4);

        Polynomial p5   = p4.differentiate();                    // 12x^2 + 6x - 6
        System.out.println("p5(x) =     " + p5);

        Polynomial clone = new ArrayBasedPolynomial (p5);        // copy constructor
        System.out.println("clone(x) =     " + clone);

        System.out.println ("p5(0) = " + p5.evaluate(0));
        System.out.println ("p5(1) = " + p5.evaluate(1));
    }
}

interface Polynomial{
    // Precondition: input polynomial is valid
    // Postcondition: returns this polynomial minus the given polynomial
    Polynomial minus(Polynomial array);

    // Precondition: input polynomial is valid
    // Postcondition: returns this polynomial plus the given polynomial
    Polynomial plus(Polynomial array);

    // Precondition: x is a real number
    // Postcondition: returns the value of the polynomial at x
    double evaluate(double x);

    // Precondition: polynomial exists
    // Postcondition: returns the derivative polynomial
    Polynomial differentiate();

    // Precondition: polynomial exists
    // Postcondition: returns coefficient array representation of the polynomial
    double [] getPoly();
}

class ArrayBasedPolynomial implements Polynomial{
    private double [] poly;

    // Precondition: array is not null
    // Postcondition: creates a polynomial with given coefficient array
    public ArrayBasedPolynomial(double [] array){
        poly = new double [array.length];
        for(int i = 0; i < array.length; i++){
            poly[i] = array[i];
        }
    }

    // Precondition: array is a valid Polynomial
    // Postcondition: creates a deep copy of the polynomial
    public ArrayBasedPolynomial(Polynomial array){
        poly = new double [array.getPoly().length];
        for(int i = 0; i < array.getPoly().length; i++){
            poly[i] = array.getPoly()[i];
        }
    }

    // Precondition: none
    // Postcondition: returns internal coefficient array
    public double [] getPoly(){
        return poly;
    }

    // Precondition: exponent >= 0
    // Postcondition: creates a polynomial with given coefficient at given exponent
    public ArrayBasedPolynomial(double coefficient , int exponent){
        poly = new double [exponent + 1];
        poly[exponent] = coefficient;
    }

    // Precondition: input polynomial is valid
    // Postcondition: returns a new polynomial that is the sum
    public Polynomial plus(Polynomial array) {
        double [] addition;
        if (array.getPoly().length >= poly.length)
            addition = new double[array.getPoly().length];
        else
            addition = new double [poly.length];

        for(int i = 0; i < array.getPoly().length;i++){
            addition[i] = array.getPoly()[i];
        }
        for(int i = 0; i < poly.length;i++){
            addition[i] += poly[i];
        }
        Polynomial sum = new ArrayBasedPolynomial(addition);
        return sum;
    }

    // Precondition: input polynomial is valid
    // Postcondition: returns a new polynomial that is the difference
    public Polynomial minus(Polynomial array) {
        double [] subtract;
        if (array.getPoly().length >= poly.length)
            subtract = new double[array.getPoly().length];
        else
            subtract = new double [poly.length];

        for(int i = 0; i < poly.length;i++){
            subtract[i] = poly[i];
        }
        for(int i = 0; i < array.getPoly().length;i++){
            subtract[i] -= array.getPoly()[i];
        }
        Polynomial sub = new ArrayBasedPolynomial(subtract);
        return sub;
    }

    // Precondition: polynomial has at least one term
    // Postcondition: returns the derivative polynomial
    public Polynomial differentiate(){
        double [] derivitive = new double[poly.length-1];
        derivitive[0] = poly[0];
        for(int i = 2; i < poly.length;i++){
            derivitive[i-1] = poly[i] * i;
        }
        Polynomial d = new ArrayBasedPolynomial(derivitive);
        return d;
    }

    // Precondition: x is a real number
    // Postcondition: returns polynomial value at given x
    public double evaluate(double x){
        double sum = poly[0];
        for(int i = 1; i < poly.length;i++){
            sum += poly[i] * Math.pow(x, i);
        }
        return sum;
    }

    // Precondition: polynomial exists
    // Postcondition: returns string representation of polynomial
    public String toString(){
        String polyString = "";
        for(int i = poly.length - 1; i > 0;i--){
            if(poly[i] == 0){
                if(poly[i-1] > 0) {
                    polyString = polyString + " + ";
                }
                else{
                    polyString = polyString + " - ";
                }
            }
            else if(poly[i-1] > 0) {
                polyString = polyString + Math.abs(poly[i]) + "x^" + i + " + ";
            }
            else if(poly[i-1] == 0) {
                polyString = polyString + Math.abs(poly[i]) + "x^" + i + " ";
            }
            else{
                polyString = polyString + Math.abs(poly[i]) + "x^" + i + " - ";
            }
        }
        polyString = polyString + Math.abs(poly[0]);

        String copy = polyString;
        int counter = 0;
        for(int i = 0; i < copy.length(); i++) {
            if (copy.indexOf(" 0") > 0){
                counter++;
                copy = copy.substring(copy.indexOf(" 0"));
            }
        }
        if(counter == poly.length)
            return "0";
        if(counter == poly.length - 1){
            for(int i = poly.length - 1; i >= 0;i--){
                if(poly[i] != 0){
                    return "coeff = " + poly[i] + ", exp = " + i;
                }
            }
        }
        return polyString;
    }
}
/********* PROGRAM OUTPUTS ******
 p1(x) =     4.0x^3 + 3.0x^2  + 1.0
 p2(x) =     5.0x^1 - 2.0
 p3(x) =     coeff = -4.0, exp = 1
 p(x) =     4.0x^3 + 3.0x^2 - 10.0x^1 - 3.0
 p4(x) =     4.0x^3 + 3.0x^2 - 6.0x^1 - 3.0
 p5(x) =     12.0x^2 + 6.0x^1 - 3.0
 clone(x) =     12.0x^2 + 6.0x^1 - 3.0
 p5(0) = -3.0
 p5(1) = 15.0
 **********************************/