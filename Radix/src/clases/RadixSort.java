package clases;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
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
		}
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

	public static int[] ArrayDescendente(){
		int x=20;
		int[] arr = new int[x];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = x;
			--x;
		}
		return arr;
	}

	public static int[] ArrayAscendente() {
		int[] arr = new int[20];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		return arr;
	}
	
	//Arraylist
	void countingSortA(Integer[] ai1, int size, int place) {
		int[] output = new int[size + 1];
		int max = ai1[0];
		for (int i = 1; i < size; i++) {
			if (ai1[i] > max)
				max = ai1[i];
		}
		int[] count = new int[max + 1];
		for (int i = 0; i < max; ++i)
			count[i] = 0;
		// Calculate count of elements
		for (int i = 0; i < size; i++)
			count[(ai1[i] / place) % 10]++;
		// Calculate cumulative count
		for (int i = 1; i < 10; i++)
			count[i] += count[i - 1];
		// Place the elements in sorted order
		for (int i = size - 1; i >= 0; i--) {
			output[count[(ai1[i] / place) % 10] - 1] = ai1[i];
			count[(ai1[i] / place) % 10]--;
		}
		for (int i = 0; i < size; i++)
			ai1[i] = output[i];
	}	
	
	//Function to get the largest element from an array
	int getMaxA(Integer[] ai1, int n) {
		int max = ai1[0];
		for (int i = 1; i < n; i++)
			if (ai1[i] > max)
				max = ai1[i];
		return max;
	}
	
	//Main function to implement radix sort
	void radixSortA(Integer[] ai1) {
		
		long startTime = System.nanoTime();
		int size = ai1.length;
		// Get maximum element
		int max = getMaxA(ai1, size);
		// Apply counting sort to sort elements based on place value.
		for (int place = 1; max / place > 0; place *= 10) {
			countingSortA(ai1, size, place);
		}
		long endTime = System.nanoTime();
        System.out.println("\t"+"Duración: " + (endTime-startTime)/1e6 + " ms");
        
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
		int[] arrayPrueba = {1, 333, 14, 69, 6, 113, 8, 14 , 20};
		//Instancia de RadixSort
		RadixSort rs1 = new RadixSort();
		//System.out.println("Mejor Caso: ");
		//int[] numerosAscendentes = ArrayAscendente();
		//System.out.println("\t"+"Ascendente: ");
		//rs1.radixSort(numerosAscendentes);
		//System.out.println("-----------------------------");
		//System.out.println("Peor Caso: ");
		//int[] numerosDescendentes = ArrayDescendente();
		//System.out.println("\t"+"Descendente: ");
		//System.out.println("Array Descendente: "+Arrays.toString(numerosDescendentes));
		rs1.radixSort(arrayPrueba);//Prueba
		//System.out.println("Array Descendente: "+Arrays.toString(numerosDescendentes));
		//Zona experimental
		//System.out.println("Array Dinamico: ");
		//ArrayList<Integer> n1 = new ArrayList<Integer>();
		//n1 = Resultado();
		//Object[] an1 = n1.toArray();
		//Integer[] ai1 = Arrays.asList(an1).toArray(new Integer[0]);
		//Imprime el Array Dinamico antes de ordenarlo con RadixSortA
		//System.out.println("\t"+Arrays.toString(ai1)); 
		//rs1.radixSortA((ai1));
		//Imprime el Array Dinamico antes de ordenarlo con RadixSortA
		//System.out.println("\t"+Arrays.toString(ai1));
	}
	
}
  
