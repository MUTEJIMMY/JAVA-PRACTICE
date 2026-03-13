import java.util.*;

void main() {

    Scanner scan = new Scanner(System.in);

    System.out.print("Type in the number you want to convert to binary: ");
    double userInput = scan.nextDouble();

    double i = 0.0;

    double subTractor = 0.0;

    while(userInput > Math.pow(2.0, i)){

        i++;
        if(Math.pow(2.0,i) <= userInput){
            subTractor = Math.pow(2.0,i);
            System.out.println("We have enter the if the statement");
        }

    }

    System.out.println("This is the user input: " + userInput + ". ") ;
    System.out.println("This should be the 2^n that we are subtracting by: " + subTractor + ". ");
}
