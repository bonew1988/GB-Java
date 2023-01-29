package HW.HW2;

import java.io.*;
import java.util.*;

public class task002 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("HW/HW2/input.txt"));
            sc.useDelimiter("\\s+");
            String aStr = sc.next();
            double a = Integer.parseInt(aStr.substring(aStr.indexOf(":") + 1));
            String bStr = sc.next();
            double b = Integer.parseInt(bStr.substring(bStr.indexOf(":") + 1));
            sc.close();

            double result = Math.pow(a, b);
            System.out.println("Результат возведения в степень: " + result);

            BufferedWriter writer = new BufferedWriter(new FileWriter("HW/HW2/output.txt"));
            writer.write(String.valueOf(result));
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
        }
    }
}
