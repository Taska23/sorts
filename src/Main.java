public class Main {
    public static void main(String[] args) {


        int a = 0; // Начальное значение диапазона - "от"
        long b = 2147483647; // Конечное значение диапазона - "до" для 30тс
        long c = 100000-1; // Конечное значение диапазона - "до" для 100тс
        long d = (long)Math.pow(2,15); // Конечное значение диапазона - "до" для 300тс
        long g = 2147483647; // Конечное значение диапазона - "до" для 1мл



        int[] thiT  = new int[30_000];
        for (int i = 0; i < thiT.length; i++) {
            thiT[i] = a + (int) (Math.random() * b);
        }
        int[] tenTT  = new int[100_000];
        for (int i = 0; i < tenTT.length; i++) {
            tenTT[i] = a + (int) (Math.random() * c);
        }
        int[] thiTT  = new int[300_000];
        for (int i = 0; i < thiTT.length; i++) {
            thiTT[i] = a + (int) (Math.random() * d);
        }
        int[] oneM  = new int[1_000_000];
        for (int i = 0; i < oneM.length; i++) {
            oneM[i] = a + (int) (Math.random() * g);
        }


        Sorter sorter = new Sorter();
        System.out.println("Starting sorts at 30k");
        sorter.sort(thiT);
        System.out.println("Starting sorts at 100k");
        sorter.sort(tenTT);
        System.out.println("Starting sorts at 300k");
        sorter.sort(thiTT);
        System.out.println("Starting sorts at 1kk");
        sorter.sort(oneM);
    }
}
