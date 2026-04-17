import java.util.*;

//this method waiting is used multiple to have waits in the program in order to have output readability
private void waiting(){
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}

//this method ConvertToNumerical takes in the String binaryNumber and outputs the regular number.
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

        //This is to see if the thing at i is not 1 or 0 if it isn't we set answer to -1
        }else if(binaryNumber.charAt(i) != '0' && binaryNumber.charAt(i) != '1'){
            answer = -1;
        }

        twoToTheN++;
    }

    return answer;
}

//this method Calculating takes in userInput and outputs an array that has our two useful numbers
private double[] Calculating(double userInput){

    double subTractor = 0;

    //this is our incrementor for the while loop as a double for Math.pow
    double counter = 0.0;


    //this loop checks the user input and find outs which 2^n we have to subtract by for the binary.
    while (userInput > Math.pow(2.0, counter)) {

        //increment before we check
        counter++;

        //this is to set the 2^n to a var to use only when the 2^n+1 is bigger than user input.
        if (Math.pow(2.0, counter) <= userInput) {
            subTractor = Math.pow(2.0, counter);
        }
    }
    //subTractor is in the first spot and counter is in the second spot
    return new double[]{subTractor,counter};
}

//This method ConvertToBinary takes in userInput and counter and uses that to calculate in our arr of binary.
private int[] ConvertToBinary(double userInput, double counter){

//this is the array for our binary calculation, the size is our 2^n(subTractor) + 1 b/c we need to do one more calculation at 2^0 or sum like that
    int[] arr = new int[((int) counter) + 1];

    //this is the copy we are modifying
    double userInputCopy = userInput;

    //this is the for loop for calculation. we make a new var j, and we decrement b/c j is some 2^n, we also run until j is less than 0. that is denoted by j>=0
    for (double j = counter; j >= 0; j--) {

        //b/c j is some 2^n in order to add it to the first position we need to subtract by the length of our array to flip the indexing
        int posJ = arr.length - ((int) j) - 1;

        //this is to check whether the value of userInput - 2^j is <0 or >= 0
        double calculation;

        //we calculate what the answer is and use it and check if its negative or positive
        calculation = userInputCopy - Math.pow(2, j);

        //this if else checks is this calculation negative or positive
        if ((calculation < 0)) {

            //if calculation is negative just forget the calculation and set that position to 0
            arr[posJ] = 0;
        } else {

            //if calculation is positive keep calculation to reuse and set that position to 1
            userInputCopy = calculation;
            arr[posJ] = 1;
        }
    }

    return arr;
}

void main() {

    //scanner
    Scanner scan = new Scanner(System.in);


    boolean programRunning = true;

    String reply;

    while (programRunning) {

    System.out.print("Type 1 if you want to convert from binary to numerical. Type 2 if you want to convert from numerical to binary:");

    int reCheck = 0;

    boolean menuInputLoop = true;

        while(menuInputLoop) {

            try {

                reCheck = scan.nextInt();

                if(reCheck == 1 || reCheck == 2){

                    menuInputLoop = false;

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

        boolean run = true;

        boolean negNum1 = false;

        while(run) {

            System.out.print("Is your binary number negative? (Y/N): ");

            String negReply = scan.nextLine();

            if (Objects.equals(negReply, "Y") || Objects.equals(negReply, "y")) {

                System.out.print("Type in your number in binary, and I'll convert it to numerical: -0b");
                negNum1 = true;
                run = false;

            } else if (Objects.equals(negReply, "N") || Objects.equals(negReply, "n")) {

                System.out.print("Type in your number in binary, and I'll convert it to numerical: 0b");
                run = false;
            } else {
                System.out.println("Bad Input try again.");
            }
        }



        boolean binaryInputLoop = true;

        String binaryNumber = "";

        while(binaryInputLoop) {

            try {
                //Take the user input as a string so we can iterate through it as an array
                binaryNumber = scan.nextLine();

                if(!binaryNumber.isEmpty()){
                    binaryInputLoop = false;
                }else{
                    System.out.print("Bad input, type in your number in binary: 0b");
                }

            }
            catch(Exception e){

                System.out.print("Bad input, type in your number in binary: 0b");
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
        if(!negNum1) {
            System.out.println("The binary number you have chosen is 0b" + binaryNumber);
        }else{
            System.out.println("The binary number you have chosen is -0b" + binaryNumber);
        }

        waiting();



        if(!negNum1) {
            System.out.println("Here is your number answer: " + convertedBinaryNumber);
        }else{
            System.out.println("Here is your number answer: -" + convertedBinaryNumber);
        }

        waiting();

    }
    else if (reCheck == 2) {





            System.out.print("Type in the number you want to convert to binary: ");




            double userInput = 0.0;

            boolean negNum = false;

            boolean decimalInputLoop = true;

            while(decimalInputLoop) {

                try {
                    // get user input as double for Math.pow
                    userInput = scan.nextDouble();

                        decimalInputLoop = false;

                        if(userInput < 0 ) {
                            negNum = true;
                            userInput = userInput * -1;
                        }

                } catch (Exception e) {
                    System.out.print("Bad input type the number you want to convert to binary:");
                    scan.nextLine();
                }
            }


            System.out.println();

            //clearing the scanner
            scan.nextLine();

            double counter;
            double subTractor;
            double[] arr1;

            //this is our 2^n where n is subTractor
              arr1 = Calculating(userInput);

              subTractor = arr1[0];
              counter = arr1[1];

            //this is just nice words
        if(!negNum) {
            System.out.println("This is the user input: " + userInput + ". ");
        }
        else{
            System.out.println("This is the user input: -" + userInput + ". ");
        }
            waiting();

            System.out.println("The highest power of 2 we are working with is: " + subTractor + ". ");

            int[] arr = ConvertToBinary(userInput,counter);



            waiting();

        if(!negNum) {
            System.out.println("Your original number was: " + userInput + ".");
        }
        else{
            System.out.println("Your original number was: -" + userInput + ".");
        }

            waiting();

            if(!negNum){System.out.print("Your number in binary is :0b");}
            else{System.out.print("Your number in binary is :-0b");}

                //loop for printing binary number from arr

                boolean checking = true;

                for (int k = 0; k < arr.length; k++) {

                    if (arr[0] == 0 && checking) {
                        checking = false;
                    }
                    else {
                        System.out.print(arr[k]);
                    }
                }
            waiting();
        }

        System.out.println();

        boolean continuePromptLoop = true;

        while(continuePromptLoop) {

            System.out.println("Do you want to do another conversion? (Y/N): ");

            reply = scan.nextLine();

            if (Objects.equals(reply, "Y") || Objects.equals(reply, "y")) {

                continuePromptLoop = false;

            }
            else if (Objects.equals(reply, "N") || Objects.equals(reply, "n")) {

                continuePromptLoop = programRunning = false;
            }
            else {
                System.out.println("Bad Input try again.");
            }
        }
    }
    System.out.println("Thank you for using my program");
}