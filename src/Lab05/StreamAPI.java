package Lab05;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        List<Integer> listInt = List.of(2, 5, 10, 8, 10, 15, 7, 7);
        List<String> listStr = List.of("Lorem", "ipsum", "dolor", "sit", "amet", "locus", "list");
        List<String> listStrMap = List.of("lorem", "ipsum", "dolor", "sit", "amet");
        List<String> emptyList = List.of();
        int[] intArray = {14, 12, 31, 45, 5, 60, 71};
        int[] intArrayNoEvens = {15, 17, 31, 45, 5, 63, 77};

        //метод, возвращающий среднее значение списка целых чисел;
        System.out.println("List average: " + listAverage(listInt));

        //метод, приводящий все строки в списке в верхний регистр и добавляющий к ним префикс «_new_»;
        System.out.println("List uppercase: " + listUpperCase(listStr));

        //метод, возвращающий список квадратов всех встречающихся только один раз элементов списка;
        System.out.println("Squares of unique elements: " + getSquaresOfUnique(listInt));

        //метод, принимающий на вход коллекцию строк и возвращающий все строки,
        // начинающиеся с заданной буквы, отсортированные по алфавиту;
        String letter = "l";
        List<String> result = getFromLetterSorted(listStr, letter);
        System.out.println("Started from " + letter + " and sorted: " + result);

        //метод, принимающий на вход коллекцию и возвращающий её последний элемент или кидающий исключение,
        // если коллекция пуста;
        try {
            System.out.println("Last element of int list: " + getLastElement(listInt));
            System.out.println("Last element of string list: " + getLastElement(listStr));
            System.out.println("Last element of empty list: " + getLastElement(emptyList));
        } catch (RuntimeException e) {
            System.out.println("The list can't be empty");
        }

        //метод, принимающий на вход массив целых чисел, возвращающий сумму чётных чисел или 0, если чётных чисел нет;
        System.out.println("Sum of even numbers " + sumEvenNumbers(intArray));
        System.out.println("Sum of even numbers " + sumEvenNumbers(intArrayNoEvens));

        //метод, преобразовывающий все строки в списке в Map, где первый символ – ключ, оставшиеся – значение;
        System.out.println("Strings mapping: " + mapStrings(listStrMap));
    }

    //метод, возвращающий среднее значение списка целых чисел;
    private static double listAverage(List<Integer> listInt) {
        return listInt.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(Double.NaN);
    }

    //метод, приводящий все строки в списке в верхний регистр и добавляющий к ним префикс «_new_»;
    private static String listUpperCase(List<String> listStr) {
        return listStr.stream()
                .map(String::toUpperCase)
                .map(s -> "_new_" + s)
                .toString();
    }

    //метод, возвращающий список квадратов всех встречающихся только один раз элементов списка;
    private static List<Integer> getSquaresOfUnique(List<Integer> listInt) {
        return listInt.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey())
                .map(i -> i * i)
                .collect(Collectors.toList());
    }

    //метод, принимающий на вход коллекцию строк и возвращающий все строки,
    // начинающиеся с заданной буквы, отсортированные по алфавиту;
    private static List<String> getFromLetterSorted(Collection<String> listStr, String letter) {
        return listStr.stream()
                .filter(s -> s.substring(0, 1).toLowerCase().equals(letter))
                .map(String::toLowerCase)
                .sorted()
                .collect(Collectors.toList());
    }

    //метод, принимающий на вход коллекцию и возвращающий её последний элемент или кидающий исключение,
    // если коллекция пуста;
    private static Optional<Object> getLastElement(Collection<? extends Object> objects) {
        return Optional.ofNullable(objects.stream()
                .reduce((c, b) -> b)
                .orElseThrow(NullPointerException::new));
    }

    //метод, принимающий на вход массив целых чисел, возвращающий сумму чётных чисел или 0, если чётных чисел нет;
    private static int sumEvenNumbers(int[] intArray) {
        return Arrays.stream(intArray)
                .filter(x -> x % 2 == 0)
                .sum();
    }

    //метод, преобразовывающий все строки в списке в Map, где первый символ – ключ, оставшиеся – значение;
    private static Map<String, String> mapStrings(List<String> listStr) {
        return listStr.stream()
                .collect(Collectors.toMap((p) -> p.substring(0, 1), (p) -> p.substring(1)));
    }

}
