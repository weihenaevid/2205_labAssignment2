package LA2Q1;

import java.util.*;

public class ViduniDivijaTestingSortingMethods {
    public static void header(){
        System.out.println("*******************************************************\n" +
                "Names: Divija Bhargava and Viduni Weihena Epa.\n" +
                "Student Numbers: 251159008 and 251152022\n" +
                "Goal of this project: To write all the sorting methods we have learned and test their execution time for an Integer type dataset.\n" +
                "*******************************************************");
    }
    public static void footer(){
        System.out.println("***************************************\n" +
                "This is " + java.time.LocalTime.now() + " on the " + java.time.LocalDate.now() +"\n"+
                "Completion of Lab Assignment 2 is successful!\n" +
                "Good bye! Divija Bhargava and Viduni Weihena Epa \n" +
                "***************************************");
    }

    public static <T extends Comparable <? super T>>long selectionSort (T [] a){
        long startSelect = System.nanoTime();
        for(int i = 0; i<a.length-1;i++){
            a[i].equals(a[a.length-1]);
            for(int j = i+1; j<a.length-1; j++){
                if(a[j].compareTo(a[j+1]) < 0){

                }
            }

        }
        long totalTime = (System.nanoTime() - startSelect)/1000000;
        return totalTime;
    }

    public static < T extends Comparable <? super T >> long bubbleSort(T[] a){
        long startBubble = System.nanoTime();
        int i,j;
        T temp;
        boolean again = true;
        for (i = 0; i < (a.length - 1 ); i++) {

            for (j = 0; j < a.length-1 && (again = true); j++) {
                again = false;
                if (a[j].equals(a[j + 1]));
                {
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    again = true;
                }
            }
        }
        long totalTime = (System.nanoTime() - startBubble);
        return totalTime;
    }

    public static < T extends Comparable <? super T >> long insertionSort(T[] a){
        long startInsert = System.nanoTime();
        for (int i = 0; i <a.length; i++) {

            T key = a[i];

            for (int j = i-1; j>=0 && a[j].compareTo(key)<0; j--) {
                a[j+1] = a[j];
                a[j] = key;
            }


        }
        long totalTime = (System.nanoTime() - startInsert)/1000000;
        return totalTime;
    }

    public static <T extends Comparable<? super T>> long mergeSort(T[] S, Comparator<T> comp){
        long startMerge = System.nanoTime();
            int n = S.length;
            if (n < 2) return n; // array is trivially sorted
            // divide
            int mid = n/2;
            T[] S1 = Arrays.copyOfRange(S, 0, mid); // copy of first half
            T[] S2 = Arrays.copyOfRange(S, mid, n); // copy of second half
            // conquer (with recursion)
            mergeSort(S1, comp); // sort copy of first half
            mergeSort(S2, comp); // sort copy of second half
            // merge sorted halves back into original
            int i = 0, j = 0;
            while (i + j < S.length) {
                if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0))
                    S[i+j] = S1[i++]; // copy ith element of S1 and increment i
            else
                S[i+j] = S2[j++]; // copy jth element of S2 and increment j
            }
        long totalTime = (System.nanoTime() - startMerge)/1000000;
        return totalTime;

    }
    //[you can tweak the recursive merge-sort code given in the Unit 4 – companion document]

    public static <T extends Comparable<? super T>> long quickSort(T[] s, Comparator<T> comp, int a, int b){
        long startQuick = System.nanoTime();
        // in-place partitioning using quicksort
        int mid = (a + b)/2;
        if (a>=b) return mid;
        int left = a;
        int right = b-1;
        T pivot = s[b];
        T temp;

        while(left<=right){
            // scan until reaching value equal to or greater than pivot
            while(left<=right && comp.compare(s[left], pivot)<0)
                left ++;
            // scan until reaching value equal to or less than pivot
            while(left<=right && comp.compare(s[left], pivot)>0)
                right --;
            //
            if(left <= right){
                // swap and shrink range
                temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left++; right--;
            }
        }
        // put pivot in its final place
        temp = s[left];
        s[left] = s[b];
        s[b] = temp;
        // recursive calls
        quickSort(s, comp, a, left-1);
        quickSort(s, comp, left+1, b);

        long totalTime = (System.nanoTime() - startQuick)/1000000;
        return totalTime;
    }//[you can implement the in-place quick-sort algorithm given in the lecture handout]

    // driver method
    public static void main(String[] args) {
        //Call your header method.
        header();
        int arrayLastIndexNum = 5;
        //Declare an Integer type array of a variable size sz which you can present to 50000.
        Integer [] firstArr = new Integer [arrayLastIndexNum];

        //Create a backup Integer type array with the same size.
        Integer [] backupArr = new Integer [arrayLastIndexNum];

        //Populate the first array with random values from 1 to sz, by using Math.random() method.
        for (int i = 0; i < firstArr.length-1; i++) {
            firstArr[i] = (int) (1 + Math.random() * arrayLastIndexNum);
            //System.out.println(firstArr[i] + " confusion");
        }
        // printing it out for fun
        for (int i = 0; i < firstArr.length; i++) {
            //System.out.println(firstArr[i] + " delete this later ");
        }
        //Copy the content of the first array to the backup array (You can use System.arraycopy() method).
        System.arraycopy(firstArr, 0, backupArr, 1, arrayLastIndexNum-1);


        //Convert the first array to an ArrayList and then sort it using Collections’ sort method. Check the time and print it on the screen (see the sample output).
//        List<Integer> firstList = new ArrayList<Integer>(Arrays.asList(firstArr));
//        Collections.sort(firstList);
//        System.out.println(firstList);

        //Now swap the first array with the backup array (you need to do this to make sure that you are sorting the same unsorted array every time)
        Integer [] temp  = firstArr;
        firstArr = backupArr;
        backupArr = temp;

        System.out.println("Testing execution time of different sorting algorithms for sorting 50000 random numbers:");
        //Call the selectionSort() method by passing the first array, and print the time.
       // System.out.println("Collections' sort time is: " );
       // System.out.println("My Selection-sort time is: " + selectionSort(firstArr));
        System.out.println("My Bubble-Sort sort time is: " + bubbleSort(firstArr));
       // System.out.println("My Insertion-sort time is: " + insertionSort(firstArr));
       // System.out.println("My Merge-sort time is: " + mergeSort(firstArr, Integer::compareTo));
       // System.out.println("My Quick-sort time is: " + quickSort(firstArr, Integer::compareTo, 0, backupArr.length-1));
        //Call your footer method.
        footer();

    }
}
