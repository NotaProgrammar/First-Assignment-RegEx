import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercises {

    /*
        complete the method below, so it will validate an email address
     */
    public boolean validateEmail(String email) {
        String regex = "\\b[A-Za-z0-9._]+@[^ _-*<>,][A-Za-z0-9.-]+\\b"; // todo
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    /*
        this method should find a date in string
        note that it should be in british or american format
        if there's no match for a date, return null
     */
    public String findDate(String string) {
        String regex = "\\b([0-9]{4}[/-][01][0-9][/-][0-3][0-9])|([0-3][0-9][/-][01][0-9][/-][0-9]{4})\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        if(matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    /*
        given a string, implement the method to detect all valid passwords
        then, it should return the count of them

        a valid password has the following properties:
        - at least 8 characters
        - has to include at least one uppercase letter, and at least a lowercase
        - at least one number and at least a special char "!@#$%^&*"
        - has no white-space in it
     */
    public int findValidPasswords(String string) {
        int counter=0;
        String regex = "\\b(?=.*[A-Za-z][^ ])(?=.*\\d[^ ])(?=.*[@$!%*#?&][^ ])[A-Za-z\\d@$!%*#?&]{8,}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        while(matcher.find()) {
            counter++;
        }
        return counter;
    }

    /*
        you should return a list of *words* which are palindromic
        by word we mean at least 3 letters with no whitespace in it

        note: your implementation should be case-insensitive, e.g. Aba -> is palindrome
     */
    public List<String> findPalindromes(String string) {
        List<String> list = new ArrayList<>();
        String regex = "\\b(?i)(\\w?)(\\w?)(\\w?)(\\w?)(\\w?)(\\w)\\S?\\6\\5\\4\\3\\2\\1\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        while(matcher.find())
        {
            list.add(matcher.group());
        }
        return list;
    }

    public static void main(String[] args) {
        String email = "john.doe@example.com";
        Exercises ex = new Exercises();
        ex.validateEmail(email);
    }
}
