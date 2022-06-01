package clases;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

class RadixSort {
//Using counting sort to sort the elements in the basis of significant places
	void countingSort(int array[], int size, int place) {
		int[] output = new int[size + 1]; //crea un array de longitud (size + 1)
		int max = array[0]; //igualo max al elemento de posicion 0 del array
		for (int i = 1; i < size; i++) {
			if (array[i] > max)
				max = array[i];
		}//Este for lo que hace es recorre el array y busca el mayor elemento
		// para que luego la variable max se quede con el maximo elemento
		//asignado.
		int[] count = new int[max + 1];//Crea un array de longitud (max + 1)
		// Calculate count of elements
		for (int i = 0; i < size; i++) {
			count[(array[i] / place) % 10]++;//
		}//Halla modulo de 
		// Calculate cumulative count
		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];//count[i] = count[i] + count[i - 1];
		}
		// Place the elements in sorted order
		for (int i = size - 1; i >= 0; i--) {
			output[count[(array[i] / place) % 10] - 1] = array[i];
			//Buscamos el lugar del primer valor del array entrada 
			//en las posiciones del array count, luego el mismo valor 
			//lo posiciono en el array de salida, en el lugar equivalente 
			//en el array count al valor de la posicion del primer valor 
			//del array de entrada.
			count[(array[i] / place) % 10]--;
		}

		for (int i = 0; i < size; i++) {
			array[i] = output[i];
		}//Construye el array original pero ordenado.
	}	
	
	//Function to get the largest element from an array
	int getMax(int array[], int n) {
		int max = array[0];
		for (int i = 1; i < n; i++)
			if (array[i] > max)
				max = array[i];
		return max;
	}
	
	//Main function to implement radix sort
	void radixSort(int[] array) {
		
		long startTime = System.nanoTime();
		int size = array.length;
		// Get maximum element
		int max = getMax(array, size);
		// Apply counting sort to sort elements based on place value.
		for (int place = 1; max / place > 0; place *= 10) { //*= -> place = place * 10
			countingSort(array, size, place);
		}
		long endTime = System.nanoTime();
        System.out.println("\t"+"Duración: " + (endTime-startTime)/1e6 + " ms");
        
	}

	public static int[] ArrayPeorCaso(int x){
		int y=0;
		int[] arr = new int[x];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = y;
			y++;
			if(y==10) {
				y=0;
			}
		}
		return arr;
	}

	public static int[] ArrayMejorCaso(int x) {
		int y=0;
		int[] arr = new int[x];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = y;
			y++;
			if(y==10) {
				y=0;
			}
		}
		return arr;
	}
	
	public static ArrayList<Integer> Resultado() { 
		Random rd = new Random();
		ArrayList<Integer> resultado = new ArrayList<Integer>();
		for (int i = 0; i < rd.nextInt(10000, 50000); i++) {
			resultado.add(rd.nextInt(1, 50000));
		}
		return resultado;
	}
	
	//Driver code
	public static void main(String args[]) {
		//Instancia de RadixSort
		Scanner reader = new Scanner(System.in);
		RadixSort rs1 = new RadixSort();
		System.out.println("Ingrese la cantidad de numeros a generar: ");
		int x = 0;
		x = reader.nextInt();
		System.out.println("Peor Caso: ");
		int[] ArrayWorstCase = ArrayPeorCaso(x);
		ArrayWorstCase[99] = 50000;
		//System.out.println("Array con el Peor Caso: "+Arrays.toString(ArrayWorstCase));
		rs1.radixSort(ArrayWorstCase);
		System.out.println("-----------------------------");
		System.out.println("Mejor Caso: ");
		int[] ArrayBestCase = ArrayMejorCaso(x);
		//System.out.println("Array con el Mejor Caso: "+Arrays.toString(ArrayBestCase));
		rs1.radixSort(ArrayBestCase);
		System.out.println("-----------------------------");
	}
}
  
