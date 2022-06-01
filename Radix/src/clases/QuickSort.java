package clases;

public class QuickSort {

    public static int arrayPartition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = (start - 1);
        for (int ele = start; ele < end; ele++) {
            if (array[ele] <= pivot) {
                i++;
                int swap = array[i];
                array[i] = array[ele];
                array[ele] = swap;
            }
        }
        // Swapping the elements
        int swap = array[i + 1];
        array[i + 1] = array[end];
        array[end] = swap;
        return i + 1;
    }

    public static void quickSortAlgo(int[] arrayTobeSorted, int start, int end) {
        if (start < end) {
            int pivot = arrayPartition(arrayTobeSorted, start, end);
            quickSortAlgo(arrayTobeSorted, start, pivot - 1);
            quickSortAlgo(arrayTobeSorted, pivot + 1, end);
        }
    }
    
    public static int[] ArrayDescendente(){
    	int x=17000;
          int[] arr = new int[x];
          for (int i = 0; i < arr.length; i++) {
            arr[i] = x;
            --x;
          }
          return arr;
    }

    public static int[] ArrayAscendente() {
          int[] arr = new int[17000];
          for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
          }
          return arr;
    }    

    public static void main(String[] args) {

        int[] numerosAscendentes = ArrayAscendente();
        System.out.println("Mejor Caso: ");
        System.out.println("\t"+"Ascendente: ");
        quickSortAlgo(numerosAscendentes, 0, numerosAscendentes.length - 1);
        int[] numerosDescendentes = ArrayDescendente();
        System.out.println("-----------------------------");
        System.out.println("Peor Caso: ");
        System.out.println("\t"+"Descendente: ");
        long startTime3 = System.nanoTime();
        quickSortAlgo(numerosDescendentes, 0, numerosDescendentes.length - 1);
        long endTime3 = System.nanoTime();
        System.out.println("\t"+"Duración: " + (endTime3-startTime3)/1e6 + " ms");
    }
}
