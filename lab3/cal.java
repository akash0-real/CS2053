import java.util.Scanner;
public class cal{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int select;
        Calculator one = new Calculator(scanner);
        System.out.println("This is a calculator!");
        System.out.print("Enter a opreation to perform(+,-,*,./): ");
        System.out.print("1. for +, 2. for -, 3 for *, 4 for /");
        select = scanner.nextInt();
        switch (select){
            case 1:
                System.out.println("the sum is : " + one.add());
                break;
            case 2:
                System.out.println("The subtractiion is : " + one.sub());
                break;
            case 3:
                System.out.println("The multiplication is: " + one.mult());
                break;
            case 4:
                System.out.println("The divion is: " + one.divide());
                break;
        }
        scanner.close();
    }
}

class Calculator{
    int num1;
    int num2;

    Calculator(Scanner scanner) {
        System.out.println("enter num1: ");
        num1 = scanner.nextInt();
        System.out.println("enter second number: ");
        num2 = scanner.nextInt();
    }
    int add(){
        return num1+num2;
    }
    int sub(){
        return num1-num2;
    }
    int mult(){
         return num1*num2;
    }
    int divide(){
         return num1/num2;
    }
    


}
