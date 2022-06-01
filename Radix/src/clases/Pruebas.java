package clases;

import java.util.Arrays;

public class Pruebas {

	public static void main(String[] args) {
		int size = 7;
		int[] array = {1, 14, 69, 6, 8, 1000, 14 , 20};
		//System.out.println(array.length);
		for (int place = 1; 69 / place > 0; place *= 10) { //*= -> place = place * 10
			System.out.println(place);
			int max = array[0]; //igualo max al elemento de posicion 0 del array
			for (int i = 1; i < size; i++) {
				if (array[i] > max)
					max = array[i];
			}
			int[] count = new int[max + 1];
			for (int i = 0; i < size; i++) {
				count[(array[i] / place) % 10]++;
				System.out.println("Array Count: "+count[i]);
			}
		}
		
		int[] output = new int[size + 1];
		System.out.println("Array Output: "+Arrays.toString(output));
	}
}
