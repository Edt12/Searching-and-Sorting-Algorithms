import java.time.Duration;
import java.time.Instant;

public class Main {
    final  static  String EXECUTION_TIME = "Execution Time %d";
    final static String FOUND_MESSAGE = "Found %d in array";

    /**
     * Bubble Sort Algorithm
     * @param array Array to sort
     */
    static void bubbleSort(int[] array){
        Instant start = Instant.now();
        boolean swapped = true;
        while (swapped  != false){
            swapped = false;
            for (int i = 0; i < array.length - 1;i++ ){
                if (array[i] > array[i + 1]){
                    int  temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                    swapped = true;

                }
            }
        }
        Instant end = Instant.now();
        long timeElapsed = Duration.between(start,end).toNanos();

        System.out.printf(EXECUTION_TIME,timeElapsed);
        System.out.println();

    }

    /**
     * Sequential Search algorithm
     * @param array Unsorted array
     * @param searchValue Value searching for
     */
    static void sequentialSearch(int[] array , int searchValue){
        Instant start = Instant.now();

        int i = 0;
        boolean found = false;
        while (i < array.length && found == false ){
            if (searchValue == array[i]){
                found = true;
                System.out.printf(FOUND_MESSAGE , searchValue);
            }
            i++;
        }
        Instant end = Instant.now();
        long timeElapsed = Duration.between(start,end).toNanos();

        System.out.printf(EXECUTION_TIME,timeElapsed);


        System.out.println();
    }

    /**
     * Binary Search algorithm
     * @param sortedArray Sorted Array
     * @param searchValue Value searching for
     * @return true or false depending on whether value found
     */
    static boolean binarySearch(int[] sortedArray ,int searchValue){
        Instant start = Instant.now();
        int lower = 0;
        int upper = sortedArray.length - 1;
        boolean found = false;
        while (sortedArray[lower] <= sortedArray[upper] && found == false){
            int upperPlusLower = upper + lower;
            int middle = Math.floorDiv(upperPlusLower,2);
            if (middle == searchValue){
                found = true;

            }else if (middle > searchValue){
                upper = middle + 1;
            }else {
                lower = middle - 1;
            }


        }
        Instant end = Instant.now();
        long timeElapsed = Duration.between(start,end).toNanos();

        System.out.printf(EXECUTION_TIME,timeElapsed);


        System.out.println();

        return found;
    }

    /**
     * Insertion sort (other "sorted "list is just temp value list is compared against)
     * @param array Array you want to sort
     */
    static void insertionSort(int[] array){
        Instant start = Instant.now();
        int current = 0;
        while (current < array.length){
            int index = current;
            int Val = array[current];
            while (index > 0 && Val < array[index - 1]){
                    int tempVal = array[index];
                    array[index] = array[index - 1];
                    array[index - 1] = tempVal;
                    index--;
            }
            current++;



        }

        Instant end = Instant.now();
        long timeElapsed = Duration.between(start,end).toNanos();

        System.out.printf(EXECUTION_TIME,timeElapsed);


        System.out.println();

    }

    /**
     * Selection sort
     * @param array Array to be sorted
     */
    static void selectionSort(int[] array){
        int index = 0;
        int tempVal = 0;
        while (index < array.length){
            int min = array[index];
            if (array[index] < min ){
                min = array[index];

            }
            index++;
            tempVal = array[index];
            array[index] = min;
            
        }
    }

    /**
     * Merge sort split
     * @param array array to be sorted
     */
    static void mergeSortSplit(int[] array){
            if (array.length <= 1){
                return;
            }
            int middle = array.length / 2;
            System.out.println(middle);
            int [] leftArray = new int[middle];
            int [] rightArray = new int[array.length - middle];

            int j = 0;
            for(int  i = 0; i <array.length;i++){
                if (i < middle){
                    leftArray[i] = array[i];

                } else if (i >  middle){
                    rightArray[j] = array[i];
                    j++;

                }

                mergeSortSplit(leftArray);
                mergeSortSplit(rightArray);
                mergeSortMerge(leftArray , rightArray , array);


            }



    }
    static void mergeSortMerge(int[] leftArray , int [] rightArray ,int[] array){
        int i = 0;
        int l = 0;
        int r = 0;
        while (i < leftArray.length && i < rightArray.length){
            if (leftArray[l] < rightArray [r]){
                array[i] = leftArray[l];
                i++;
                l++;
            } else if (rightArray[r] < leftArray[l]) {
                array[i] = rightArray[i];
                i++;
                r++;
            }
        }
        while (l < leftArray.length){
            array[i] = leftArray[l];
            l ++;
        }
        while (r < rightArray.length){
            array[i] = rightArray[r];
            r++;
        }

    }
    public static void main(String[] args) {
        int [] List = { 5,2,3,1,7,6,9,2,4,6,7,8,2,4,6,7,8,9,3,1,2,4,7,10,30,21,3,121,52,51,2,51,5,215,521,5,15,5,52,1,51,125,
        21,21,15,51,52,12,52,1556,46,43,63,46,364,6,43,7,7,3,73,7,3,7,37,3,73,7,3,3,21,24,1,241,4,1,4,12,411,4,212,14,1,42,21
        ,14,21,2144,124,121,42,421,41,412,412,412,4,12,421,241,21,21,1,42,24,21,421,142,12,4,2,5,52323,532,3,52,523,3,235,532
        ,32,532,53,352,52,53,235,2,352,32,532,352,352,235,352,353,252,33,51,1,2,2451,52,12,52,125,15,52,12,25,12,5521,5,12,5,1,25,52,
        22121,452,1,2,15,5,1,521,5,21,22,11,52,12,52,1,51,215,51,1515,12,51,15,5,21,52,511,5,12,2,5,5,125,21,52,1,55,112,5,51,2,521,15
        ,52,1,521,52,12,51,5,1,53,1,531,53,31,5133,15,31,351,315,5,13,53,531,5313,15,3315,153,31,553,1,513,31,315,315,531,153,513,531,513,153,153,135,135
        ,3,513,351,351,53,531553,31,5,31,315,3,513,531,531,513,351,53,531,35,315,51,51,531,53,153,531,53,1,3553,1,3,51535,6,7,8,9,0,};

        int[] sortedList = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        mergeSortSplit(List);


        for (int elem : List){
            System.out.println(elem);
        }
    }
}