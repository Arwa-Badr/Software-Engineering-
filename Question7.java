
package Lab2;

import java.util.Scanner;
public class Question7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the position of the friend's house (x): ");
        int x = scanner.nextInt();
        
        int steps = calculateSteps(x);
        System.out.println("Minimum number of steps required: " + steps);
    }
    
    private static int calculateSteps(int x) {
        return (x + 4) / 5;
    }
    
}
