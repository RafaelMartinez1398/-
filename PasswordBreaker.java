import java.util.Arrays;
import java.util.Scanner;

public class PasswordBreaker {
    public static void passwordBreaker(String password) {
        char[] charToPswd = password.toCharArray(); //returns a password.length char array ex .['l','i','n','e']
        char[] comparator = new char[password.length()];
        int counter = 0;
        int lastItemInChar = password.length() - 1;
        char c1 = charToPswd[lastItemInChar]; //compare last item of password
        char c2 = comparator[lastItemInChar]; // compare last item of comparator to see if there is a match
        while (password.length() - 1 >= counter) {
            if (c1 == c2 || c2 == '~') {
                //System.out.println(c2); //This is the main reason why this method takes time to run if you delete this it takes way less time
                if (lastItemInChar == 0){
                    counter += 1;
                } else {
                    lastItemInChar -= 1;
                    c1 = charToPswd[lastItemInChar]; //move on to the previous ith place of the char array from last item in array
                    c2 = comparator[lastItemInChar]; //to second to last item in array for both
                    counter += 1;
                }

            } else {
                //increase char character by one until the right one is found
                c2++;
            }
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter password: ");
        String m = s.nextLine();
        long startTime = System.nanoTime();
        passwordBreaker(m);
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("That took: " + elapsedTime/1000000 + " milliseconds");
        System.out.println("Password has been found");

    }
}
