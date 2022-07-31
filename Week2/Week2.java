package Week2;

class Week2 
{
    
    int LenArr; //initializing the len arr integer
    int[] a; //initializing the a integer array

    Week2(int LenArr, int[] a) //constructor
    {

        this.LenArr = LenArr; // assigning the length of array to LenArr
        int len = 0;
        int[] joiner = new int[a.length]; // creating a new array with the length of the array passed in the parameter

        for (int i = 0; i < a.length; i++) //loop through the array 
        {
            boolean push = false;
            for (int j = 0; j < a.length; j++)  //loop through the array again to check if the element is already in the array

            {
                if (i >= j) //if the element is already in the array, then don't push it into the new array
                {
                    if (i == a.length - 1) {
                        push = true;
                        break;
                    }
                    continue;
                }

                if (a[i] == a[j]) //if the element is not in the array, then push it into the new array
                 {
                    push = false;
                    break;
                } else if (a[i] != a[j]) {
                    push = true;
                }
            }
            if (push) //if the element is not in the array, then push it into the new array

            {
                joiner[len] = a[i];
                push = false;
                len++;
            }
        }

        int[] originaljoiner = new int[len];

        for (int i = 0; i < len; i++) //loop through the new array to assign the elements to the original array
        {
            originaljoiner[i] = joiner[i];
            
        }

        this.a = originaljoiner;

    }

    void Findresult() //method to find the result of the array

    {

        // Compilation of whole required functions or steps

        int[][] outputResult = findPrime(a); //calling the function to find the prime numbers in the array
        int[] mainResult = outputResult[0]; //assigning the prime numbers to the mainResult array
        int mainloop = outputResult[1][0]; //assigning the length of the prime numbers to the mainloop variable
        if (mainloop == LenArr) //if the length of the prime numbers is equal to the length of the array, then print the prime numbers
        {
            for (int i = 0; i < mainloop; i++) 
            {
                System.out.println(mainResult[i]);
            }
        } 
        else 
        {
            int[] more = moreSearch(mainResult, mainloop); //calling the function to find the more prime numbers in the array
            for (int i = 0; i < LenArr; i++)
            {
                if (i >= mainloop) //if the element is greater than the length of the prime numbers, then print the more prime numbers
                {
                    int num = i - mainloop;
                    System.out.println(more[num]);
                } 
                else //if the element is less than the length of the prime numbers, then print the prime numbers
                {
                    System.out.println(mainResult[i]);
                }

            }
        }

    }

    int[] moreSearch(int[] primes, int mainloop)  //function to find the more prime numbers in the array
    {

        int[] mores = new int[LenArr]; //creating a new array with the length of the array
        int moresin = 0;
        boolean skip = false;
        for (int i = 0; i < a.length; i++) //loop through the array
        {
            for (int ext = 0; ext < primes.length; ext++)  //loop through the prime numbers array
            {
                if (a[i] == primes[ext]) //if the element is equal to the prime numbers array, then skip it
                {
                    skip = true;
                    break;
                }
            }
            if (skip) //if the element is equal to the prime numbers array, then skip it
            {
                skip = false;
                continue;
            }

            boolean push = true;

            for (int j = 0; j < mainloop; j++) //loop through the prime numbers array again to check if the element is already in the array
            {

                if (primes[j] == 1) //if the element is equal to the prime numbers array, then skip it
                {
                    continue;
                } 
                else //if the element is not equal to the prime numbers array, then push it into the new array
                {
                    
                    float checkval = (float) a[i] / (float) primes[j]; //checking if the element is a multiple of the prime numbers array
                    if (checkval == Math.floorDiv(a[i], primes[j])) //if the element is a multiple of the prime numbers array, then skip it
                    {
                        push = false;
                    }
                }
            }

            if (push) //if the element is not equal to the prime numbers array, then push it into the new array
            {
                mores[moresin] = a[i];
                moresin++;
            }

        }

        return mores;

    }

    int[][] findPrime(int[] arr) //function to find the prime numbers in the array
    {
        // Findout Prime numbers among element of given array arr

        int[] ourPrimeElements = new int[LenArr]; //creating a new array with the length of the array
        int mainloop = 0;

        for (int i = 0; i < arr.length; i++) //loop through the array
        {

            if (arr[i] == 0) //if the element is equal to 0, then skip it
            {
                continue;
            } 
            else if (arr[i] == 1) //if the element is equal to 1, then push it into the new array
            {
                ourPrimeElements[mainloop] = 1;
                mainloop++;

            } else if (arr[i] == 2) //if the element is equal to 2, then push it into the new array
            {
                ourPrimeElements[mainloop] = 2;
                mainloop++;
            } 
            else if (arr[i] == 3) //if the element is equal to 2, then push it into the new array
            {
                ourPrimeElements[mainloop] = 3;
                mainloop++;
            }

            else //if the element is not equal to 0, 1, 2, or 3 then check if it is a prime number
            {

                boolean prime = true;
               
                int divideLimit = Math.floorDiv(arr[i], 2); //checking if the element is a multiple of 2
                for (int j = 2; j <= divideLimit; j++) //loop through the array to check if the element is a multiple of 2
                {

                    float check = (float) a[i] / j;

                    if (check == Math.floorDiv(a[i], j)) //if the element is a multiple of 2, then skip it
                    {

                        prime = false;

                    }
                }

                if (prime == true) //if the element is not a multiple of 2, then push it into the new array
                {

                    ourPrimeElements[mainloop] = a[i];
                    mainloop++;
                }

            }

        }

        int[][] returner = { ourPrimeElements, { mainloop } }; //assigning the prime numbers to the mainResult array

        return returner;

    }


    public static void main(String[] args) //main method
    {

        int[] input = { 10, 10, 5, 0, 2, 1, 2, 5 }; //creating an array with the elements 10, 10, 5, 0, 2, 1, 2, 5

        Week2 sub = new Week2(3, input); //creating a new object of the class Week2 with the length of the array and the array elements
        sub.Findresult(); //calling the function to find the result of the array
    }

}