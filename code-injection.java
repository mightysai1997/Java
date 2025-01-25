import javax.script.*;

public class CodeInjectionExample {
    public void executeScript(String userInput) {
        try {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
            engine.eval(userInput);  // Dangerous: executes any user input as code
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CodeInjectionExample obj = new CodeInjectionExample();
        obj.executeScript("print('Hello World');");  // Safe input
        obj.executeScript("var exec = new java.lang.ProcessBuilder('ls', '-la').start();");  // Code injection attempt
    }
}
