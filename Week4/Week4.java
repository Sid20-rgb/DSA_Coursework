package Week4;

public class Week4 {
    // sorting array
    private static void sortArray(int array[]) {
        // sorting the provided by the user in the parameter
        for (int i = 1; i < array.length; i++) {
            int j = i; //initilize j to i
            int a = array[i]; //initilize a to the value of the current index of the array
            while ((j > 0) && (array[j - 1] > a)) //return true when both conditions are true
            {
                array[j] = array[j - 1]; //move the value of the current index of the array to the next index
                j--;//decrement j
            }
            array[j] = a; //assign the value of a to the current index of the array
        }
    }

    public static void TotalContainer(int array[]){
        int i; 
        int totalContainers = 0; //initialize the total containers to 0

        // sorted the number of villages in grades
        sortArray(array);

        int prevValue = 0; //initialize the previous value to 0
        int containerForCurrentVillage = 0; //initialize the container for current village to 0

        // looping through the sorted array to find the number of containers needed for each village
        for (i = 0; i < array.length; i++) {
            // if the grades of the current village is not equals to the grades of previous village, then add 1 to the containerforcurrentvillage and add the containerforcurrentvillage to the totalcontainers
            if (array[i] != prevValue) {
                prevValue = array[i];
                containerForCurrentVillage += 1;
                totalContainers += containerForCurrentVillage;
            }
            // if the grade of current village is equals to the grade of the previous village, then add containerforcurrentvillage to the totalcontainer for the current village
             else {
                prevValue = array[i];
                totalContainers += containerForCurrentVillage;
            }
        }

        //printing the number of containers needed for each village
        System.out.println(totalContainers);
    }
    // main function to implement the program
    public static void main(String[] args) {
        // initializing an array as the number of villages in grades
        int array[] = { 5, 2, 2, 2, 4, 6 };

        TotalContainer(array);//calling the function to find the number of containers needed for each village
    }   
}