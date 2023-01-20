// Дан массив чисел, требуется получить новую выборку (массив) только четных чисел
// Мой код:

package seminars.seminar1;

// import java.util.ArrayList;
// import java.util.List;

// public class task01 {

//     public static void main(String[] args) {
//         int[] myArray = {1, 2, 3, 4, 12, 24, 45, 657, 68};
//         List<Integer> integers = new ArrayList<>();
//         for (int i = 0; i < myArray.length; i++) {
//             if (myArray[i] % 2 == 0) {
//                 integers.add(myArray[i]);
//             }
//         }
//         System.out.println(integers);
        
        

//     }
// }

// Код коллег:

import java.util.ArrayList;
import java.util.List;

public class task01 {
    public static void main(String[] args) {

//        int[] initArr = {1, 4, 6, 5, 87, 9, 4, 8, -1, -4};
        int[] initArr = generateInitArr(10);
        List<Integer> evenNumArr = createArr(initArr);
        printArr(evenNumArr);
    }

    static int[] generateInitArr(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
                array[i] = ((int)(Math.random() * 31) - 15);
                System.out.printf("array[" + i + "] = ");
                System.out.println(array[i]);
            }
        return array;
    }

    static List<Integer> createArr(int[] initArr) {
        List<Integer> evenNumArr = new ArrayList<>();

        for (int j : initArr) {
            if (j % 2 == 0) {
                evenNumArr.add(j);
            }
        }

        return evenNumArr;
    }

    static void printArr(List<Integer> evenNumArr) {

        for (Integer item :
                evenNumArr) {
//            System.out.println(item);
            System.out.printf("item = %d", item);
            System.out.println();

        }
    }
}