
package Week5;

import java.math.BigInteger;

public class Short64_LargeNumber {
    private String value;
    
    public String getValue(){
        return value;
    }
    
    public Short64_LargeNumber(String value){
        this.value = value;
    }
    
    public Short64_LargeNumber addTwoNum(Short64_LargeNumber other){
        return new Short64_LargeNumber(addLargeNumber(this.value, other.value));
    }
    
    public Short64_LargeNumber mutiplyTwoNumber(Short64_LargeNumber other){
        return new Short64_LargeNumber(MutiplyLargerNum(this.value, other.value));
    }
    
    private String MutiplyLargerNum(String so1, String so2){
        int[] result = new int[so1.length() + so2.length()];
        String tem = "";
        for (int i = so1.length() - 1; i >= 0 ;i--){
            int digit1 = so1.charAt(i) -'0';
            for(int j = so2.length() - 1; j >= 0; j--){
                int digit2 = so2.charAt(j) - '0';
                int product = digit1 * digit2;
                
                int index = i + j + 1;
                int sum = product + result[index];
                
                result[index] = sum % 10;
                result[index - 1] += sum / 10; 
            }
        }
        for(int i = 0; i < result.length; i++){
            tem = tem + result[i];
        }
        return tem;
    }
    
    public String addLargeNumber(String so1, String so2){ 
        
        int max = Math.max(so1.length(), so2.length());
        so1 = String.format("%" + max + "s" , so1).replace(' ', '0');
        so2 = String.format("%" + max + "s" , so2).replace(' ', '0');
    
        StringBuilder result = new StringBuilder();
        // gia su 2 do dai bang nhau
        int soDu = 0;
        for(int i = so1.length() - 1; i >= 0; i--){
            int s1 = so1.charAt(i) - '0';
            int s2 = so2.charAt(i) - '0';
            int sum = s1 + s2 + soDu;
            result.append(sum % 10);
            soDu = sum / 10;
        }
        if( soDu > 0){
            result.append(soDu);
        }
        return result.reverse().toString();
    }
    public static void main(String[] args) {
//        Short64_LargeNumber n1 = new Short64_LargeNumber("48484846488321");
//        Short64_LargeNumber n2 = new Short64_LargeNumber("71366525462546");
//        Short64_LargeNumber s = n1.addTwoNum(n2);
//        System.out.println("sum 2: " +s.getValue());
//        
//        BigInteger num1 = new BigInteger("48484846488321");
//        BigInteger num2 = new BigInteger("71366525462546");
//        BigInteger s2 = num1.add(num2);
//        System.out.println("sum 2: " +s2);

        Short64_LargeNumber so1 = new Short64_LargeNumber("25");
        Short64_LargeNumber so2 = new Short64_LargeNumber("10");
        Short64_LargeNumber s3 = so1.mutiplyTwoNumber(so2);
        System.out.println("result: " +s3.getValue());
    }
}

