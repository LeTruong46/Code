package Week1;

public class ChangeBaseNumber {

    private int inputBase;   
    private int outputBase;  
    private String inputValue;

    public ChangeBaseNumber(int inputBase, int outputBase, String inputValue) {
        this.inputBase = inputBase;
        this.outputBase = outputBase;
        this.inputValue = inputValue;
    }

    public int convertToDecimal(String input, int base) {
        int value = 0;
        int n = 0;
        for (int i = input.length() - 1; i >= 0; i--) {
            char digitChar = input.charAt(i);
            int digitValue;
            if (digitChar >= '0' && digitChar <= '9') {
                digitValue = digitChar - '0';
            } else if (digitChar >= 'A' && digitChar <= 'F') {
                digitValue = 10 + (digitChar - 'A');
            } else if (digitChar >= 'a' && digitChar <= 'f') {
                digitValue = 10 + (digitChar - 'a');
            } else {
                System.out.println("Error: Invalid character...");
                return -1;
            }

            value += digitValue * Math.pow(base, n); 
            n++;
        }
        return value;
    }

    public String convertToBinary(int decimal) {
        if (decimal == 0) return "0";
        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            int reminder = decimal % 2;
            binary.insert(0, reminder);
            decimal = decimal / 2;
        }
        return binary.toString();
    }

    public String convertToHexadecimal(int decimal) {
        if (decimal == 0) return "0";
        StringBuilder hex = new StringBuilder();
        char[] hexCharacters = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (decimal > 0) {
            int remainder = decimal % 16;
            hex.insert(0, hexCharacters[remainder]);
            decimal = decimal / 16;
        }
        return hex.toString();
    }
}
