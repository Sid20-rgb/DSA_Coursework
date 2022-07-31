package Week5;
public class Week5
{
    public static void checkSubset(String target, String[] set) 
    {
        String visited = ""; //initializing the visited string

        int ans = 0;

        for (int i = 0; i < target.length(); i++) //loop through the target string
        {
            for (int j = 0; j < set.length; j++) //loop through the set string
            {
                for (int k = 0; k < set[j].length(); k++) //loop through the set string again
                {
                    if (target.toUpperCase().charAt(i) == set[j].toUpperCase().charAt(k) //if the target string and set string are the same, then increment the ans
                            && !visited.contains(target.charAt(i) + "")) 
                            {
                            visited += target.charAt(i); //add the character to the visited string

                        if (ans <= j + 1) //if the ans is less than or equal to the set string, then increment the ans
                        {
                            ans++;
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) //main method
    {
        String target = "frog"; //initializing the target string
        String[] set = { "programming", "For", "developers" }; //initializing the set string
        checkSubset(target, set); //calling the checkSubset method
    }
}