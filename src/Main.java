import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {

        Sorter sorter = new Sorter();
        Random random = new Random();
        FileWriter fw = new FileWriter("stats.txt");
        fw.write("First row contains info about pool size and generation method\n");
        fw.write("Next row contains info about time(in ms) spent to sort array:\n");
        fw.write("TimSort | STL::stable-sort | BucketSort | QuickRadixSort | IntroSort | STL::sort");

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {

                for (int l = 0; l < 5 ; l++){
                    int size = 0;
                    long upperBound = 0;
                    switch (i){
                        case 0: size = 30000;
                        fw.write("Size: 30 000 ");
                        break;
                        case 1: size = 100000;
                            fw.write("Size: 100 000 ");
                            break;
                        case 2: size = 300000;
                            fw.write("Size: 300 000 ");
                            break;
                        case 3: size = 1000000;
                            fw.write("Size: 1 000 000 ");
                            break;
                        default: System.err.println("err");
                        break;
                    }
                    switch (j){
                        case 0: upperBound = (long)Math.pow(2,31);
                        fw.write("Bounds: 0 - 2^31 ");
                        break;
                        case 1: upperBound = size-1;
                            fw.write("Bounds: 0 - " + size + " ");
                            break;
                        case 2: upperBound = (long)Math.pow(2,15);
                            fw.write("Bounds: 0 - 2^15 ");
                            break;
                        case 3: upperBound = (long)Math.pow(2,31);
                            fw.write("Bounds: 0 - 2^31 (Normal Distribution) ");
                            break;
                        default: System.err.println("err");
                        break;
                    }
                    int[] arr = new int[size];
                    for (int g = 0; g < arr.length; g++){
                        if(j == 3){
                            int tmp = (int) (0 +  Math.random() * Math.pow(2,31) * (random.nextGaussian()));
                            if (tmp > 0) {
                                arr[g] = tmp;
                            }else{
                                arr[g] = tmp * -1;
                            }

                        }else{
                            arr[g] = 0 + (int) (Math.random() * upperBound);
                        }

                    }

                    fw.write(Arrays.toString(sorter.sort(arr)));
                    fw.write("\n");
                }
                fw.write("\n");
            }
            fw.write("\n");
        }
        fw.write("end.");
        fw.flush();
        fw.close();
    }
}
