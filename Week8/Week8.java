package Week8;

class Week8 {

    String[] input; //initializing the input string array
    int rows; //initializing the rows integer
    int columns; //initializing the columns integer

    Week8(String[] input)  //constructor
    {
        this.input = input; //setting the input string array
        this.rows = input.length; //setting the rows integer
        this.columns = input[0].length(); //setting the columns integer
    }

    int processor() //processor method
    {

        int keys = keysNumberFinder(); //calling the keysNumberFinder method to find the number of keys

        int totalTravelled = 0; //
        int keysFound = 0;
        boolean run = true;
        int x = 0;
        int travelledRow = 0;
        int adder = 1;
        char[] foundK = new char[2]; //initializing the found k array

        while (run) //while the run boolean is true
        {
            if (input[travelledRow].charAt(x + adder) != '#') //if the element is not a #
            {

                if (input[travelledRow].charAt(x + adder) == '*') //if the element is a *
                {
                    x += adder; //increment the x integer
                    totalTravelled++; //increment the total travelled integer
                    continue; //continue the loop
                } 
                else //if the element is not a *
                {
                    if (input[travelledRow].charAt(x + adder) != input[travelledRow].toUpperCase().charAt(x + adder)) //if the element is not an uppercase letter
                    {
                        totalTravelled++; //increment the total travelled integer   
                        foundK[keysFound] = input[travelledRow].charAt(x + adder); //add the element to the found k array
                        x += adder; //increment the x integer
                        keysFound++; //increment the keys found integer

                        if (keysFound == keys) //if the keys found integer is equal to the number of keys
                        {
                            run = false; //set the run boolean to false
                            break; //break the loop
                        } else //if the keys found integer is not equal to the number of keys
                        {
                            continue; //continue the loop
                        }

                    } 
                    else //if the element is an uppercase letter
                    {

                        boolean yes = false; //initializing the yes boolean

                        for (int l = 0; l < foundK.length; l++) //loop through the found k array
                        {
                            if (foundK[l] == input[travelledRow].toLowerCase().charAt(x + adder)) //if the element is in the found k array
                            {

                                yes = true; //set the yes boolean to true
                            }
                        }

                        if (yes) //if the yes boolean is true
                        {
                            totalTravelled++; //increment the total travelled integer
                            x += adder; //increment the x integer
                            continue; //continue the loop
                        }
                        else //if the yes boolean is false
                        {
                            adder *= -1; //set the adder integer to negative
                            continue; //continue the loop
                        }

                    }
                }

            }

            if (input[travelledRow + 1].charAt(x) != '#') //if the element is not a #
            {

                if (input[travelledRow + 1].charAt(x) == '*') //if the element is a *
                {

                    travelledRow += 1; //increment the travelled row integer
                    totalTravelled++; //increment the total travelled integer
                    continue; //continue the loop
                } 
                else //if the element is not a *
                {
                    if (input[travelledRow + 1].charAt(x) != input[travelledRow + 1].toUpperCase().charAt(x)) //if the element is not an uppercase letter
                    {
                        totalTravelled++; //increment the total travelled integer
                        foundK[keysFound] = input[travelledRow + 1].charAt(x); //add the element to the found k array
                        travelledRow += 1; //increment the travelled row integer
                        keysFound++; //increment the keys found integer

                        if (keysFound == keys) //if the keys found integer is equal to the number of keys
                        {
                            run = false; //set the run boolean to false
                            break; //break the loop
                        } 
                        else //if the keys found integer is not equal to the number of keys
                        {
                            continue; //continue the loop
                        }

                    } 
                    else //if the element is an uppercase letter
                    {

                        boolean yes = false; //initializing the yes boolean

                        for (int l = 0; l < foundK.length; l++) //loop through the found k array
                        {
                            if (foundK[l] == input[travelledRow + 1].toLowerCase().charAt(x)) //if the element is in the found k array
                            {

                                yes = true; //set the yes boolean to true
                            }
                        }

                        if (yes) //if the yes boolean is true
                        {
                            totalTravelled++; //increment the total travelled integer
                            travelledRow++; //increment the travelled row integer
                            continue; //continue the loop
                        }

                    }
                }

            }
        }

        return totalTravelled; //return the total travelled integer
    }

    int keysNumberFinder() //keysNumberFinder method
    {

        int alphabets = 0; //initializing the alphabets integer

        for (int i = 0; i < rows; i++) //loop through the input string array
        {
            for (int j = 0; j < columns; j++) //loop through the input string array
            {
                if (input[i].charAt(j) == '@' || input[i].charAt(j) == '#' //if the element is an @ or a #
                        || input[i].charAt(j) == '*') //if the element is a *
                        {
                    continue; //continue the loop
                } else //if the element is not an @ or a # or a *
                {
                    alphabets++; //increment the alphabets integer
                }
            }
        }

        int keys = alphabets / 2; //set the keys integer to the alphabets integer divided by 2

        return keys; //return the keys integer
    }

    public static void main(String[] args) //main method
    {

        String[] value = { "@*a*#", "###*#", "b*A*B" }; //initializing the value string array

        Week8 pth = new Week8(value); //initializing the pth object
        System.out.println(pth.processor()); //printing the processor method
    }

}