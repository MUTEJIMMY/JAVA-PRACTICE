import java.util.*;

//TODO methods for later to make code cleaner
public double ConvertToBinary(){



    //this return will be the double for the code.
    return 0.0;
}


void main() {

    //scanner
    Scanner scan = new Scanner(System.in);



    boolean check = true;
    String reply = "";

    System.out.println("Type 1 if you want to convert from binary to numerical. Type 2 if you want to convert from numerical to binary.");
    System.out.print(": ");
    int reCheck = scan.nextInt();

    if(reCheck == 1){

        System.out.print("Type in your number in binary, and I'll convert it to numerical: 0b");

        int binaryNumber = scan.nextInt();

        System.out.println("The binary number you have choosen is 0b" + binaryNumber);




    } else if (reCheck == 2) {


        while (check) {


            System.out.print("Type in the number you want to convert to binary: ");

            // get user input as double for Math.pow
            double userInput = scan.nextDouble();

            //clearing the scanner
            scan.nextLine();

            //this is our incrementor for the while loop as a double for Math.pow
            double i = 0.0;

            //this is our 2^n where n is subTractor
            double subTractor = 0.0;

            //this loop checks the user input and find outs which 2^n we have to subtract by for the binary.
            while (userInput > Math.pow(2.0, i)) {

                //increment before we check b/c its works for some reason
                i++;

                //this is to set the 2^n to a var to use only when the 2^n+1 is bigger than user input.
                if (Math.pow(2.0, i) <= userInput) {
                    subTractor = Math.pow(2.0, i);
                }

            }

            //this is just nice words
            System.out.println("This is the user input: " + userInput + ". ");
            System.out.println("This should be the 2^n that we are subtracting by: " + subTractor + ". ");

            //this is the array for our binary calculation, the size is our 2^n(subTractor) + 1 b/c we need to do one more calcuation at 2^0 or sum like that
            int[] arr = new int[((int) i) + 1];

            //this is the copy we are modifying
            double userInputCopy = userInput;

            //this is the for loop for calculation. we make a new var j and we decerement b/c j is some 2^n, we also run until j is less than 0. that is denoted by j>=0
            for (double j = i; j >= 0; j--) {

                //b/c j is some 2^n in order to add it to the first postion we need to subtract by the length of our array to flip the indexing
                int posJ = arr.length - ((int) j) - 1;

                //this is to check wether the value of userInput - 2^j is <0 or >= 0
                double calculation = 0;

                calculation = userInputCopy - Math.pow(2, j);

                if ((calculation < 0)) {
                    arr[posJ] = 0;
                } else {
                    userInputCopy = calculation;
                    arr[posJ] = 1;
                }
            }

            System.out.println("Your orginal number was: " + userInput + ".");

            System.out.print("Your number in binary is : 0b");

            //loop for printing binary number from arr


            //
            if ((arr.length > 1) && arr[0] == 0) {


                for (int k = 1; k < arr.length; k++) {


                    System.out.print(arr[k]);

                }

            } else {
                for (int l = 1; l < arr.length; l++) {


                    System.out.print(arr[l]);

                }
            }
            System.out.println();
            System.out.println("Do you want to convert another number to binary? (Y/N): ");

            reply = scan.nextLine();

            if (Objects.equals(reply, "Y") || Objects.equals(reply, "y")) {

            } else {

                //check being false ends the while loop
                check = false;

            }

        }
    } else{

    }
    System.out.println("Thank you for using my program");
}
