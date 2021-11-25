package LA2Q1;

import java.util.*;

public class ViduniDivijaTestingSortingMethods {
    public static void header(){
        System.out.println("*******************************************************\n" +
                "Names: Divija Bhargava and Viduni Weihena Epa.\n" +
                "Student Numbers: 251159008 and 251152022\n" +
                "Goal of this project: Brief description of the project.\n" +
                "*******************************************************");
    }
    public static void footer(){
        System.out.println("***************************************\n" +
                "This is " + java.time.LocalTime.now() + " on the " + java.time.LocalDate.now() +"\n"+
                "Completion of Lab Assignment 2 is successful!\n" +
                "Good bye! Divija Bhargava and Viduni Weihena Epa \n" +
                "***************************************");
    }

//    public static <T extends Comparable <? super T>>long selectionSort (T [] a){
//
//        for(int i = 0; i<a.length-1;i++){
//            a[i].equals(a[a.length-1]);
//            for(int j = i+1; j<a.length-1; j++){
//                if(a[j].compareTo(a[j+1]) < 0){
//
//                }
//            }
//
//        }
//        return 0;
//    }

    public static < T extends Comparable <? super T >> long bubbleSort(T[] a){
        long start = System.nanoTime();
        int i, j;
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
        long totalTime = (System.nanoTime() - start)/1000000;
        return totalTime;
    }

    public static < T extends Comparable <? super T >> long insertionSort(T[] a){
        for (int i = 0; i <a.length; i++) {

            T key = a[i];

            for (int j = i-1; j>=0 && a[j].compareTo(key)<0; j--) {
                a[j+1] = a[j];
                a[j] = key;
            }


        }
        return 0;
    }

    public static <T extends Comparable<? super T>> long mergeSort(T[] S){
        return 0;
    }
    //[you can tweak the recursive merge-sort code given in the Unit 4 – companion document]

    public static <T extends Comparable<? super T>> long quickSort(T[] s, Comparator<T> comp, int a, int b){
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

        return 0;
    }//[you can implement the in-place quick-sort algorithm given in the lecture handout]

    public static long bucketSort(Integer[] a, int first, int last, int maxDigits) {
        return 0;
    }

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
       // List<Integer> firstList = new ArrayList<Integer>(Arrays.asList(firstArr));
       // Collections.sort(firstList);

        //Now swap the first array with the backup array (you need to do this to make sure that you are sorting the same unsorted array every time)
        Integer [] temp  = firstArr;
        firstArr = backupArr;
        backupArr = temp;
        
        Integer arrrrrrrrr [] = {4, 2, 6, 3, 2};
        System.out.println(bubbleSort(arrrrrrrrr));
        //Call the selectionSort() method by passing the first array, and print the time.
       // selectionSort(firstArr);

        //Repeat steps vi) and vii) for each call, and print the time (see the sample output)
        System.out.println(bubbleSort(backupArr));
        //Call your footer method.
        footer();

    }
}
