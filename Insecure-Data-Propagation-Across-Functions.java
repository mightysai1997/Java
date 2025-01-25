public class CrossFunctionVulnerability {
    private String sensitiveData;

    public void setSensitiveData(String data) {
        // Missing input validation, sensitive data could be easily injected
        this.sensitiveData = data;
    }

    public void processData() {
        // Data is used without proper checks
        System.out.println("Processing sensitive data: " + sensitiveData);
    }

    public static void main(String[] args) {
        CrossFunctionVulnerability obj = new CrossFunctionVulnerability();
        obj.setSensitiveData("malicious_data"); // Malicious input, no validation
        obj.processData(); // Sensitive data is exposed without checks
    }
}
