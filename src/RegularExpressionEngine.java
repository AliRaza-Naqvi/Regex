import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionEngine
{
    public static String readFileAsString(String fileName)throws Exception
    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static void main(String[] args) throws Exception
    {
        String data = readFileAsString("C:\\Users\\Ali\\IdeaProjects\\JavaRegex\\Ali Raza.txt");

        //for URL
        Matcher u = Pattern.compile(
                "(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)"
                        + "([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
                        + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*").matcher(data);
        //For email
        Matcher e = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(data);
        // FOr Date
        Matcher d = Pattern.compile("[A-Z0-9]+/[A-Z0-9]+/[A-Z0-9]+").matcher(data);
        //For Time
        Matcher t = Pattern.compile("(?=(?:\\D*\\d\\D*){6})(?:[01]\\d|2[0-3]):(?:[0-5]\\d):(?:[0-5]\\d)").matcher(data);


        //for URL
        System.out.println("\nURL is:");
        while (u.find())
        {
            System.out.println(u.group());
        }

        //for email
        System.out.println("\nEmail Address is:");
        while (e.find())
        {
            System.out.println(e.group());
        }

        //for date
        System.out.println("\nDate is:");
        while (d.find())
        {
            System.out.println(d.group());
        }

        //for time
        System.out.println("\nTime is:");
        while (t.find())
        {
            System.out.println(t.group());
        }

    }
}