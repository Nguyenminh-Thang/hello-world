import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Exam01 {

    /*
     * Complete the runningMedian function below.
     */
    static double[] runningMedian(int[] a) {
        /*
         * Write your code here.

         */
        int len = a.length;
        Queue maxPQ = new PriorityQueue(len/2 + 1, Collections.reverseOrder());
        Queue minPQ = new PriorityQueue(len/2 + 1);
        int mid = 0;
        double[] b = new double[len];

        for(int i = 0 ; i < len; i++) {
            if (a[i] <= mid)
                maxPQ.add(a[i]);
            else
                minPQ.add(a[i]);
            if(maxPQ.size() < minPQ.size())
                maxPQ.add(minPQ.poll());
            if (maxPQ.size() > minPQ.size() + 1)
                minPQ.add(maxPQ.poll());

            double bElement ;
            if(minPQ.size() != maxPQ.size()) bElement = 1.0 *(int) maxPQ.peek();
            else bElement = 1.0* ((int) maxPQ.peek() + (int) minPQ.peek()) / 2;
            b[i] = bElement;
            mid = (int)maxPQ.peek();
        }
        return b;

    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        int aCount = scanner.nextInt();

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = scanner.nextInt();
            a[aItr] = aItem;
        }

        double[] result = runningMedian(a);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            System.out.print(result[resultItr]);

            if (resultItr != result.length - 1) {
                System.out.print("\n");
            }
        }


    }
}
