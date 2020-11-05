package util;

public class FnStorer {
    private double number1;
    private Math.OPERATOR operator;
    private double number2;

    public int order;

   private double calculatedAnswer;

    public double setNumber1(double number) {
        this.number1 = number;
        return  number1;
    }

    public double setNumber2(double number) {
        this.number2 = number;
        return number2;
    }

    public Math.OPERATOR setOperator(Math.OPERATOR op) {
        this.operator = op;
        return operator;
    }

    public void replaceN2(double calcNumber) {
        this.number2 = calcNumber;
    }


   public void setcalculatedAnswer(double answer) {
        this.calculatedAnswer = answer;
   }


    public double getNumber1() {
        return number1;
    }

    public double getNumber2() {
        return number2;
    }

    public Math.OPERATOR getOperator() {
        return operator;
    }

    public double getAnswer() {
        return calculatedAnswer;
    }


    public FnStorer(double firstnber, Math.OPERATOR op, double secondnber) {
        setNumber1(firstnber);
        setNumber2(secondnber);
        setOperator(op);
        setOrder(op);
    }




    public FnStorer(double answer) {
        setcalculatedAnswer(answer);
    }

    public void setOrder(Math.OPERATOR op) {
        switch (op) {
            case MULTIPLY: this.order = 1;
            break;

            case DIVIDE: this.order = 1;
            break;

            case PLUS: this.order = 2;
            break;

            case MINUS: this.order = 2;
                break;
        }
    }


}
