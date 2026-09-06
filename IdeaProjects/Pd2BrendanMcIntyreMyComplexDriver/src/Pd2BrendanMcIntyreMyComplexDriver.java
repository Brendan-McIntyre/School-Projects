/****************************************************

 Name (Full Name): Brendan McIntyre   Period: 2
 Name of the Lab/Assignment: U5: MyComplex program
 Purpose: Break apart and modify complex numbers

 How I feel about this programming experience:


 What I Learned:


 ****************************************************/

public class Pd2BrendanMcIntyreMyComplexDriver
{
    public static void main(String [] args)
    {
        MyComplex zero = new MyComplex();
        MyComplex c1 = new MyComplex(1,2);  // c1 is 1 + 2i
        MyComplex real = new MyComplex(4,0); // real is 4
        MyComplex imaginary = new MyComplex(0,7); // imaginary is 0 + 7i

    } // main

} // Pd2BrendanMcIntyreMyComplexDriver

class MyComplex
{
    private double real;
    private double imaginary;

    // default and nondefault constructors
    public MyComplex (){
        real = 0;
        imaginary = 0;
    }

    public MyComplex (double r, double i) {
        real = r;
        imaginary = i;
    }

    // accessors
    public double getReal(){
        return real;
    }

    public double getImaginary(){
        return imaginary;
    }

    // modifiers
    public void setReal(double r) {
        real = r;
    }

    public void setImaginary(double i) {
        imaginary = i;
    }

    // toString method
    public String toString(){
        if imaginary == 0 && real != 0 {
            return MyComplex " is " real;
        }
        if imaginary < 0 {
            return MyComplex + " - " + imaginary + "i";
            return MyComplex + " + " + imaginary + "i";
        }

    // all other required methods
        public Boolean isReal(MyComplex c){
            if c.getImaginary() == 0{
                return true;
            }
            else if (c.getImaginary() != 0) && (c.getReal() != 0){
                return false
            }
        }

        public Boolean isImaginary(MyComplex c){
            if c.getReal() == 0{
                return true;
            }
        else if (c.getImaginary() != 0) && (c.getReal() != 0) {
                return false
            }
        }

        public static MyComplex addNew(MyComplex a, MyComplex b) {
            return a + b;
        }

        public static MyComplex multiplyNew(MyComplex a, MyComplex b) {
            return a * b;
        }


        public void conjugate() {
        imaginary *= -1;
    }

} // MyComplex