import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a, b, c; //numbers
        char op1, op2; //operators

        a = input.nextInt(); //first number
        op1 = input.next().charAt(0); //first operator
        b = input.nextInt(); //second number

        if (input.hasNext()) { //if there is more
            op2 = input.next().charAt(0); //then it's the third number
            c = input.nextInt(); //and this is the seconf operator
        } else { //if there is none
            op2 = ' ';
            c = 0;
        }

        int result = calculate(a, b, c, op1, op2);
        System.out.println(result);
    }

    private static int calculate(int a, int b, int c, char op1, char op2) {
        int result = 0;

        if (op2 == ' ') {
            result = evaluate(a, b, op1);
        } else {
            if (op2 == '*' || op2 == '/') { //prioritizing multiplication and division
                b = evaluate(b, c, op2); //b will be equal operation with b and c
                result = evaluate(a, b, op1);
            } else {
                int temp = evaluate(b, c, op2);
                result = evaluate(a, temp, op1);
            }
        }

        return result;
    }

    private static int evaluate(int a, int b, char op) {
        int result = switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> 0;
        };

        return result;
    }
}
