package Exception_HW1;

import java.util.ArrayList;
import java.util.List;

public class task1 {
    public static void main(String[] args) {

        // String[] array = { "9", "3", "10", "20" };
        // System.out.println(convertAndSum(array));

        // int[] array1 = { 10, 20, 30 };
        // int[] array2 = { 10, 2, 4, 11 };
        // System.out.println(Arrays.toString(subArrayWithExceptionHandling(array1, array2)));

        String[] array = {"лес", "лед", "пот"};
        String[] ans = findAndReplace(array, "лед", "пар");
        for (String a : ans) {
            System.out.println(a);
        }



    }

    public static int convertAndSum(String[] arr) {
        int sum = 0;
        try {
            for (String a : arr) {
                sum += Integer.parseInt(a);
                if (sum > 100) {
                    throw new ArithmeticException("Превышен лимит суммы");
                }
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Ошибка преобразования строки в число");
        }

        return sum;
    }

    public static int[] mergeAndValidateArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];

        if (arr1.length == arr2.length) {
            System.arraycopy(arr1, 0, result, 0, arr1.length);
            System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
            for (int r : result) {
                if (r < 0) {
                    throw new RuntimeException("обнаружен отрицательный элемент");
                }

            }

            return result;
        }
        throw new IllegalArgumentException("длины массивов не равны");
    }

    public static int[] subArrayWithExceptionHandling(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];

        if (arr1.length == arr2.length) {
            for (int i = 0; i < result.length; i++) {
                result[i] = arr1[i] - arr2[i];
                if (result[i] < 0) {
                    throw new RuntimeException("Отрицательный резальтат разности");
                }

            }

            return result;
        }
        throw new IllegalArgumentException("Массивы разной длины");
    }

    public static String[] findAndReplace(String[] arr, String olds, String news){
        boolean er = true;
        String[] result = new String[arr.length]; 
        List<String> errors = new ArrayList<>();
        for (int i=0; i <arr.length; i++){
            if (arr[i].equals(olds)){
                result[i] = news;
                er = false;
            }
            else result[i] = arr[i];
        }
        if (er) {
            errors.add(String.format("Списке не найдено строка: '%s'", olds));
            String[] narr = new String[errors.size()];

            return errors.toArray(narr);
        }
        return result;
    }

}
