import java.util.*;

//TODO methods for later to make code cleaner
private double ConvertToBinary(){



    //this return will be the double for the code.
    return 0.0;
}

private void waiting(){
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}



private double ConvertToNumerical(String binaryNumber){

    double answer = 0;
    int twoToTheN = 0;
    double subtracting;


    //this for loop starts at the end of the number and then decrement towards the front.
    for(int i = binaryNumber.length()-1; i > -1; i--){

        //here is the 2^n that we are adding
        subtracting = Math.pow(2.0, twoToTheN);

        // we are checking if the spot in the number is 1

        if(binaryNumber.charAt(i) == '1'){

            //running total or adding
            answer = answer + subtracting;
        }else if(binaryNumber.charAt(i) != '0' && binaryNumber.charAt(i) != '1'){
            answer = -1;
        }

        twoToTheN++;
    }

            return answer;
        }

void main() {

    //scanner
    Scanner scan = new Scanner(System.in);



    boolean check = true;
    String reply;
    while (check) {
    System.out.print("Type 1 if you want to convert from binary to numerical. Type 2 if you want to convert from numerical to binary:");

    int reCheck = 0;
    boolean c1 = true;

        while(c1) {

            try {

                reCheck = scan.nextInt();

                if(reCheck == 1 || reCheck == 2){
                    c1 = false;

                } else{
                    System.out.print("Bad input type 1 for numerical to binary. 2 for binary to numerical:");
                }
            } catch (Exception e) {
                System.out.print("Bad input type 1 for numerical to binary. 2 for binary to numerical:");
                //to remove the bad input
                scan.nextLine();
            }
    }




    if(reCheck == 1){

        scan.nextLine();

        System.out.print("Type in your number in binary, and I'll convert it to numerical: 0b");

        waiting();
        boolean c2 = true;
        String binaryNumber = "";
        while(c2) {

            try {
                //Take the user input as a string so we can iterate through it as an array
                binaryNumber = scan.nextLine();

                c2 = false;

            }
            catch(Exception e){

                System.out.println("Bad input, type in your number in binary: 0b");
            }
        }

        double convertedBinaryNumber = -1;

        while(convertedBinaryNumber == -1) {

            convertedBinaryNumber = ConvertToNumerical(binaryNumber);


            if(convertedBinaryNumber == -1) {

                System.out.print("Bad input try again, type in your number in binary: 0b");


                binaryNumber = scan.nextLine();
            }

        }

        System.out.println("The binary number you have chosen is 0b" + binaryNumber);

        waiting();




        System.out.println("Here is your number answer: " + convertedBinaryNumber);

        waiting();

    }
    else if (reCheck == 2) {





            System.out.print("Type in the number you want to convert to binary: ");




            double userInput = 0.0;
            boolean negNum = false;
            boolean c3 = true;
            while(c3) {
                try {
                    // get user input as double for Math.pow
                    userInput = scan.nextDouble();

                        c3 = false;

                        negNum = true;
                        userInput = userInput * -1;

                } catch (Exception e) {
                    System.out.print("Bad input type type the number you want to convert to binary:");
                    scan.nextLine();
                }
            }

        System.out.println();

            //clearing the scanner
            scan.nextLine();

            //this is our incrementor for the while loop as a double for Math.pow
            double i = 0.0;

            //this is our 2^n where n is subTractor
            double subTractor = 0.0;

            //this loop checks the user input and find outs which 2^n we have to subtract by for the binary.
            while (userInput > Math.pow(2.0, i)) {

                //increment before we check
                i++;

                //this is to set the 2^n to a var to use only when the 2^n+1 is bigger than user input.
                if (Math.pow(2.0, i) <= userInput) {
                    subTractor = Math.pow(2.0, i);
                }

            }

            //this is just nice words
        if(!negNum) {
            System.out.println("This is the user input: " + userInput + ". ");
        }else{
            System.out.println("This is the user input: -" + userInput + ". ");
        }
            waiting();

            System.out.println("This should be the 2^n that we are using by: " + subTractor + ". ");

            //this is the array for our binary calculation, the size is our 2^n(subTractor) + 1 b/c we need to do one more calculation at 2^0 or sum like that
            int[] arr = new int[((int) i) + 1];

            //this is the copy we are modifying
            double userInputCopy = userInput;

            //this is the for loop for calculation. we make a new var j, and we decrement b/c j is some 2^n, we also run until j is less than 0. that is denoted by j>=0
            for (double j = i; j >= 0; j--) {

                //b/c j is some 2^n in order to add it to the first position we need to subtract by the length of our array to flip the indexing
                int posJ = arr.length - ((int) j) - 1;

                //this is to check whether the value of userInput - 2^j is <0 or >= 0
                double calculation;

                calculation = userInputCopy - Math.pow(2, j);

                if ((calculation < 0)) {
                    arr[posJ] = 0;
                } else {
                    userInputCopy = calculation;
                    arr[posJ] = 1;
                }
            }

            waiting();

        if(!negNum) {
            System.out.println("Your original number was: " + userInput + ".");
        }else{
            System.out.println("Your original number was: -" + userInput + ".");
        }

            waiting();




            if(!negNum){
                System.out.print("Your number in binary is :0b");
            }else{
                System.out.print("Your number in binary is :-0b");
            }

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
            waiting();




        }

        System.out.println();
        System.out.print("Do you want to do another conversion? (Y/N): ");


        reply = scan.nextLine();


        if (Objects.equals(reply, "Y") || Objects.equals(reply, "y")) {

        } else {

            //check being false ends the while loop
            check = false;

        }

    }
    System.out.println("Thank you for using my program");
}
