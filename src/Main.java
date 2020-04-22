/**
 * Реализовал следующую логику:
 * 1) программе передается некоторое количество int;
 * 2) последний является искомым числом;
 * 3) остальные являются элементами массива, который сортируется,
 * в нем же происходит бинарный поиск искомого числа.
 * <p>
 * В случае, если я не совсем корректно понял условие, прошу уточнить,
 * каким образом будут передаваться входные данные.
 */

public class Main {

    public static void main(String[] args) {

        int[] array = new int[args.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.valueOf(args[i]);
        }

        bubbleSort(array);

        for (int i = 0; i < array.length - 1; i++) {
            System.out.println(array[i]);
        }

        binarySearch(array, array.length - 2, array[array.length - 1]);
    }

    public static void binarySearch(int[] array, int last, int item) {
        int position;
        int first = 0;

        position = (first + last) / 2;


        while ((first < last)) {
            if (array[position] > item) {
                last = position - 1;
            } else if (array[position] < item) {
                first = position + 1;
            } else {
                last = position;
            }
            position = (first + last) / 2;
        }

        if (array[position] == item) {
            System.out.println(array[position] + " c индексом " + position + " - искомое число");
        } else {
            System.out.println("В массиве нет числа " + item);
        }
    }

    public static void bubbleSort(int[] array) {
        boolean isSorted = false;
        int buffer;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 2; i++) {
                if (array[i] > array[i + 1]) {
                    isSorted = false;

                    buffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buffer;
                }
            }
        }
    }
}
