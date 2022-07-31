package Week6;

import java.util.HashMap;

class Week6 {

    String[] leftSide; //initializing the left side array
    String rightSide; //initializing the right side string
    HashMap<String, String> mapper = new HashMap<String, String>(); //initializing the hashmap

    Week6(String[] leftSide, String rightSide) //initializing the left side array and right side string
    {

        this.leftSide = leftSide; //assigning the left side array to the leftSide array
        this.rightSide = rightSide;//assigning the right side string to the rightSide string
    }

    boolean processor() //method to process the left side array and right side string
    {

        String checkval1 = String.join("", leftSide); //converting the left side array to a string
        String checkvalFinal = checkval1 + rightSide; //concatenating the left side array and right side string

        String uniqueCheck = uniqueFinder(checkvalFinal, checkval1.charAt(checkval1.length() - 1)); //calling the uniqueFinder method to find the unique characters

        int leftSum = leftItterSum(); //calling the leftItterSum method to find the sum of the left side array

        String rightSum = ""; //initializing the right side string

        for (int i = 0; i < rightSide.length(); i++) //loop through the right side string
        {
            rightSum += mapper.get("" + rightSide.charAt(i));
        }

        if (leftSum == Integer.parseInt(rightSum)) //if the left side sum is equal to the right side sum, then return true
        {
            return true;
        }

        return false;

    }

    int leftItterSum() //method to find the sum of the left side array
    {
        int unitsItter = 0; //initializing the units itter
        String[] units = new String[leftSide.length]; //initializing the units array
        int leftTotal = 0; //initializing the left total

        for (int i = 0; i < leftSide.length; i++) //loop through the left side array
        {

            units[unitsItter] = ""; //initializing the units array

            for (int j = 0; j < leftSide[i].length(); j++) //loop through the left side string
            {

                units[unitsItter] += mapper.get("" + leftSide[i].charAt(j)); //assigning the units array to the units itter

            }
            leftTotal += Integer.parseInt(units[unitsItter]); //adding the units itter to the left total
            unitsItter++; //incrementing the units itter

        }

        return leftTotal; //returning the left total
    }

    String uniqueFinder(String a, char leftend) //method to find the unique characters in the string
    {

        int len = 0; //initializing the length
        char[] passer = new char[a.length()]; //initializing the passer array

        for (int i = 0; i < a.length(); i++)  //loop through the string
        {
            boolean push = false; //initializing the push boolean
            for (int j = 0; j < a.length(); j++) //loop through the string again to check if the element is already in the array
            {
                if (i >= j) //if the element is already in the array, then don't push it into the new array
                {
                    if (i == a.length() - 1) //if the element is the last element, then push it into the new array
                    {
                        push = true;
                        break;
                    }
                    continue; //if the element is not in the array, then push it into the new array
                }

                if (a.charAt(i) == a.charAt(j)) //if the element is not in the array, then push it into the new array
                {
                    push = false;
                    break;
                } else if (a.charAt(i) != a.charAt(j)) //if the element is in the array, then don't push it into the new array
                {
                    push = true;
                }
            }
            if (push) //if the push boolean is true, then add the element to the new array
            {
                passer[len] = a.charAt(i); //adding the element to the new array
                push = false;
                len++; //incrementing the length
            }
        }

        String combined = ""; //initializing the combined string
        int itter = 0;

        String[] leftRightSum = new String[2]; //initializing the left right sum array

        for (int i = 0; i < len; i++) 
        {
            combined += passer[i]; //adding the element to the combined string
            mapper.put("" + passer[i], "" + i); //adding the element to the hashmap

        }


        return combined; //returning the combined string

    }

    public static void main(String[] args) //main method
    {

        String[] leftInput = { "THIS", "IS", "TOO" }; //initializing the left input array

        System.out.println(new Week6(leftInput, "FUNNY").processor()); //calling the processor method to process the left input array and right input string
    }

}
