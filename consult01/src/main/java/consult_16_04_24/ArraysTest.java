package consult_16_04_24;

import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {

        // Одномерные массивы
        int[] numbers = new int[5];
        boolean[] booleans = new boolean[5];

        int[] numbers1 = {2,8,3,6,8};

        numbers[3] = 12;

        System.out.println(numbers[3]);
        System.out.println(Arrays.toString(numbers));

        for (int number : numbers1){
            System.out.println(number);
        }

        // Двумерные массивы -> массив в массиве int[][]
        int[][] numbers2D = new int[4][5];

        int[][] numbers2Da = new int[7][];  // когда внутренние массивы будут разные
        numbers2Da[0] = new int[3];
        numbers2Da[1] = new int[6];
        numbers2Da[2] = new int[9];

        int[][] numbers2Db = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};

        for (int[] innerArray : numbers2Db){
            for (int cell : innerArray ){
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
