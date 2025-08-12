import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num1;
        System.out.print("Enter the number: ");
        num1 = scanner.nextInt();
        if (num1%2==0){
            System.out.println("the number " + num1 + " is even.");
            
            
        }
        else{
            System.out.println("The number " + num1 + " is odd.");
        }
        
        scanner.close();
        
        
    }
    
    
    
}
