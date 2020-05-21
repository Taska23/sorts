import sorts.BucketSort;
import sorts.HeapSort;
import sorts.IntroSort;
import sorts.QuickRadixSort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Sorter {
    public long[] sort(int[] input){
        long stats[] = new long[6];
        long start;
        long finish;
        long timeConsumedMillis;
        // Вариант 4, первая сортировка "TimSort"
        Integer [] example1 = IntStream.of(input).boxed().toArray(Integer []::new); //перевод примитивов в обёртку для вызова TimSort сортировки

        System.out.println("TimSort started");
        start = System.currentTimeMillis();

        Arrays.sort(example1); // Алгоритм TimSort используется в стандартном методе Arrays.sort для массива объектов

        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("TimSort finished. Time: "+timeConsumedMillis + " ms");
        stats[0] = timeConsumedMillis;


        // Вариант 4, вторая сортировка аналог "STL::stable-sort"
        int [] example2 = input.clone();

        System.out.println("StableSort started");
        start = System.currentTimeMillis();

        Arrays.sort(example2); // Arrays.sort для массива примитивов использует аналог "STL::stable-sort"

        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("StableSort finished. Time: "+timeConsumedMillis + " ms");
        stats[1] = timeConsumedMillis;


        // Вариант 4, Третья сортировка BucketSort
        int [] example3 = input.clone();
        System.out.println("BucketSort started");
        start = System.currentTimeMillis();

        BucketSort.sort(example3,BucketSort.maxValue(example3)); // для запуска необходимо внушительное количество ОЗУ выделенного jvm (+-16gb)

        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("BucketSort finished. Time: "+timeConsumedMillis + " ms");
        stats[2] = timeConsumedMillis;


        // Вариант 4, четвёртая сортировка QuickRadixSort
        int [] example4 = input.clone();
        System.out.println("QuickRadixSort started");
        start = System.currentTimeMillis();

        QuickRadixSort.radixsort(example4,example4.length);

        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("QuickRadixSort finished. Time: "+timeConsumedMillis + " ms");
        stats[3] = timeConsumedMillis;


        // Вариант 4, пятая сортировка IntroSort
        int [] example5 = input.clone();
        System.out.println("IntroSort started");
        start = System.currentTimeMillis();

        IntroSort.sort(example5);

        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("IntroSort finished. Time: "+timeConsumedMillis + " ms");
        stats[4] = timeConsumedMillis;


        // Вариант 4, шестая сортировка аналог "STL::sort"
        int [] example6 = input.clone();
        System.out.println("Sort started");
        start = System.currentTimeMillis();

        HeapSort.sort(example6);

        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("Sort finished. Time: "+timeConsumedMillis + " ms");
        stats[5] = timeConsumedMillis;


        return stats;// возврат массива элементов, где каждый элемент обозначает время, затраченное на сортировку
    }
}
