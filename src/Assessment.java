import java.util.HashMap;

public class Assessment {
    public static Integer stringToInteger(String input) throws Exception {
        // for storing the output
        int output = 0, i=0;
        boolean positive = true;

        // if the number is negative start from the next index and make the flag false
        if(input.charAt(0) == '-'){
            i = 1;
            positive = false;
        }

        // loop though the string and create the integer
        for(; i<input.length(); i++){
            int temp =  input.charAt(i) - '0';
            if(temp < 0 || temp > 9){
                throw new Exception("The input string should only contain digits");
            }

            output = (10 * output) + temp;
        }

        // check if the number is negative if so multiply the output with -1
        return positive ? output : output * -1;
    }

    public static boolean hasInteger(String input){
        // loop through the string and check if the character is a digit
        for(int i=0; i<input.length(); i++){
            if(Character.isDigit(input.charAt(i))) return true;
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        String[] string_to_integer_inputs = new String[] {"1230", "-123", "666", "9999"};
        String[] has_integer_inputs = new String[] {"123", "-123", "66B", "999A", "Hi", "IAMGOOD"};

        System.out.println("******** String to Integer *********");
        for(String input: string_to_integer_inputs){
            System.out.println(input + " --> " + stringToInteger(input));
        }

        System.out.println("\n" + "******** Has Integer *********");
        for(String input: has_integer_inputs){
            System.out.println(input + " --> " + hasInteger(input));
        }

    }
}
