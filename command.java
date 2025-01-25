import java.io.*;

public class CommandInjectionExample {
    public void runCommand(String userInput) {
        try {
            String command = "ls " + userInput;  // Command is built using user input
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CommandInjectionExample obj = new CommandInjectionExample();
        obj.runCommand("-la");  // Safe input
        obj.runCommand("; rm -rf /");  // Command injection attempt (destructive)
    }
}
