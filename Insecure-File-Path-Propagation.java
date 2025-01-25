import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CrossFunctionFileVulnerability {
    private String filePath;

    // Function that sets the file path
    public void setFilePath(String path) {
        this.filePath = path;  // No validation of file path
    }

    // Function that attempts to read the file
    public void readFile() {
        try {
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);  // Output file content
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CrossFunctionFileVulnerability obj = new CrossFunctionFileVulnerability();
        obj.setFilePath("/etc/passwd");  // Malicious file path
        obj.readFile();  // This could read sensitive system files
    }
}
