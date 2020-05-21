import java.util.Arrays;

public class Sorter {
    public void sort(int input[]){
        long start;
        long finish;
        long timeConsumedMillis;
        // Вариант 4, первая сортировка "TimSort"
        System.out.println("TimSort started");
        start = System.currentTimeMillis();

        Arrays.sort(input); // Алгоритм TimSort используется в стандартном методе Arrays.sort

        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("TimSort finished. Time: "+timeConsumedMillis + "ms");


        // Вариант 4, вторая сортировка аналог "STL::stable-sort"


    }
}
