package sample;

public class Operazion {

    public double add(double a, double b){
        double result = a + b;
        return result;
    }

    public double sous(double a, double b){
        double result = a - b;
        return result;
    }

    public double mult(double a, double b){
        double result = a * b;
        return result;
    }

    public double div(double a, double b){
        double result = a / b;
        return result;
    }

    public double expo(double a, double b){
        double result = Math.pow(a, b);
        return result;
    }

    public double rac(String a){
        double stocka = Double.parseDouble(a);
        double result = Math.sqrt(stocka);
        return result;
    }

    public double log(String a){
        double stocka = Double.parseDouble(a);
        double result = Math.log(stocka);
        return result;
    }

    public double exp(String a){
        double stocka = Double.parseDouble(a);
        double result = Math.exp(stocka);
        return result;
    }
}
