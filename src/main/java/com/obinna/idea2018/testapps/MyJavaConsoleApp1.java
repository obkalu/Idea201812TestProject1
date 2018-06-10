package com.obinna.idea2018.testapps;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class MyJavaConsoleApp1 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        long start1 = System.nanoTime();
        int sumByIteration = sumByIteration(numbers);
        long timeTaken1 = System.nanoTime() - start1;
        System.out.printf("Via Iteration in %d nano secs: The sum of numbers in %s is: %d\n", timeTaken1, numbers, sumByIteration);

        long start2 = System.nanoTime();
        int sumByRecursion = sumByRecursion(numbers);
        long timeTaken2 = System.nanoTime() - start2;
        System.out.printf("Via Recursion in %d nano secs: The sum of numbers in %s is: %d\n", timeTaken2, numbers, sumByRecursion);
    }

    /**
     * Computes the sum of the integers in a given list of integers,
     * using Iteration.
     * @param ints list of integers
     * @return sum of the integers
     */
    private static int sumByIteration(List<Integer> ints) {
        int sum = 0;
        // Using the Iterator
        Iterator<Integer> it = ints.iterator();
        while (it.hasNext()) {
            sum += it.next();
        }
        return sum;
    }

    /**
     * Computes the sum of the integers in a given list of integers,
     * using Recursion.
     * @param ints list of integers
     * @return sum of the integers
     */
    private static int sumByRecursion(List<Integer> ints) {
        return sumByRecursionHelper(ints, 0);
    }

    private static int sumByRecursionHelper(List<Integer> ints, int sum) {
        if (ints.size() == 0)
            return sum;
        sum += ints.get(0);
        return sumByRecursionHelper(getListLessFirst(ints), sum);
    }

    private static List<Integer> getListLessFirst(List<Integer> ints) {
        return ints.stream()
                .skip(1L)
                .collect(Collectors.toList());
    }
}
