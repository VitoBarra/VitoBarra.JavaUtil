package IO;

import java.io.*;

public class ConsoleInput
{
    public static String Prompt(String Prompt)
    {
        try (var br = new BufferedReader(new InputStreamReader(System.in)))
        {
            return Prompt(br, System.out, Prompt);

        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static String Prompt(BufferedReader reader, PrintStream printer, String prompt)
    {
        return Prompt(reader, new PrintWriter(printer), prompt, "");
    }

    public static String Prompt(BufferedReader reader, PrintWriter printer, String prompt)
    {
        return Prompt(reader, printer, prompt, "");
    }

    public static String Prompt(BufferedReader reader, PrintWriter printer, String prompt, String Extra)
    {
        printer.print(prompt + ">" + Extra);
        printer.flush();
        return ReadString(reader);
    }


    private static String ReadString(BufferedReader reader)
    {
        try
        {
            return reader.readLine();
        } catch (java.net.SocketException e)
        {
            System.out.println("Connesine Chiusa");
            return null;
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
