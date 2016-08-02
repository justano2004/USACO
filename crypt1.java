/*
ID: xiangmo1
LANG: JAVA
TASK: crypt1
*/

import java.io.*;
import java.util.*;


public class crypt1 {
    public void calculate() throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream("crypt1.in");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        int totalNumbers = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");
        int totalFound = 0;
        for(int j = 0; j < totalNumbers; j++) {
            for(int k = 0; k < totalNumbers; k++) {
                for(int l = 0; l < totalNumbers; l++) {
                    for(int m = 0; m < totalNumbers; m++) {
                        for(int n = 0; n < totalNumbers; n++) {
                            int number1 = 100 * Integer.parseInt(numbers[j]) + 10 * Integer.parseInt(numbers[k]) + Integer.parseInt(numbers[l]);
                            int number2 = 10 * Integer.parseInt(numbers[m]) + Integer.parseInt(numbers[n]);
                            boolean result = checkSolution(number1, number2, numbers);
                            if (result == true)  {
                                totalFound++;
                            }
                        }
                    }
                }
            }
        }
        FileOutputStream fos = new FileOutputStream("crypt1.out");     
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        bw.write("" + totalFound);
        bw.newLine();
        bw.close();
    }
    public boolean checkSolution(int number1, int number2, String[] numbers) {
        int product1 = (number2 % 10) * number1;
        int product2 = (number2 / 10) * number1;
        if(product1 > 999 || product2 > 999) {
            return false;
        }
        product2 *= 10;
        int finalProduct = product1 + product2;
        List<String> numbersList = Arrays.asList(numbers);
        while(product1 > 0) {
            String digit = Integer.toString(product1 % 10);
            if (!numbersList.contains(digit)) {
                return false;
            }
            product1 /= 10;
        }
        product2 /= 10;
        while(product2 > 0) {
            String digit = Integer.toString(product2 % 10);
            if (!numbersList.contains(digit)) {
                return false;
            }
            product2 /= 10;
        }
        while(finalProduct > 0) {
            String digit = Integer.toString(finalProduct % 10);
            if (!numbersList.contains(digit)) {
                return false;
            }
            finalProduct /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            crypt1 myCrypt1 = new crypt1();
            myCrypt1.calculate();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
