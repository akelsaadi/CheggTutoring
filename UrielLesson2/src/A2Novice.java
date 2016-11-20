import java.util.Scanner;

public class A2Novice {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		process(s);
	}

	public static void process(Scanner s) {
		int width = s.nextInt();
		int height = s.nextInt();
		int[][] imageArray = new int[height][width];
		String[] outputArray = {"#","M","X","D","<",">","s",":","-"," "};
		int[] inputArray = new int[width*height];
		int min = 99;
		int max = 0;
		double average = 0.0;
		
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				imageArray[j][i] = s.nextInt();				
				if(imageArray[j][i] < min) {
					min = imageArray[j][i];
				}
				
				if(imageArray[j][i] > max) {
					max = imageArray[j][i];
				}
				
				average += imageArray[j][i];
			}
		}
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				
				if(imageArray[i][j] <= 9) {
					System.out.print(outputArray[0]);
				} else if(imageArray[i][j] <= 19) {
					System.out.print(outputArray[1]);
				} else if(imageArray[i][j] <= 29) {
					System.out.print(outputArray[2]);
				} else if(imageArray[i][j] <= 39) {
					System.out.print(outputArray[3]);
				} else if(imageArray[i][j] <= 49) {
					System.out.print(outputArray[4]);
				} else if(imageArray[i][j] <= 59) {
					System.out.print(outputArray[5]);
				} else if(imageArray[i][j] <= 69) {
					System.out.print(outputArray[6]);
				} else if(imageArray[i][j] <= 79) {
					System.out.print(outputArray[7]);
				} else if(imageArray[i][j] <= 89) {
					System.out.print(outputArray[8]);
				} else if(imageArray[i][j] <= 99) {
					System.out.print(outputArray[9]);
				}
				
			}
			System.out.println("");
		}
		
		average = average/inputArray.length;
		
		//printTable(imageArray);
		
		//System.out.println(inputArray[i][j]);
		System.out.println("Min value = " + min);
		System.out.println("Max value = " + max);
		System.out.println("Average value = " + average);
		
	}
	
	public static void max(int[] input) {
	    int target;
	  
	    for(int start = 0; start < input.length; start++) {
	    	target = start;
	    	for(int cursor = start; cursor < input.length; cursor++) {
	    		if(input[cursor] > input[target]) {
	    			target = cursor;
	    		}
	    	}
	    	swap(input, start, target);
	    }
	    
	  }
	
	public static void swap(int[] input, int i, int j) {
		  int temp = input[i];
		  input[i] = input[j];
		  input[j] = temp;	  
	  }
	
	static void printTable(String[][] table) {
	    for(int i = 0; i < table.length; i++) {
	      for(int j = 0; j < table[i].length; j++) {
	    	  printCell(table[i][j]);
	      }
		    System.out.print("\n");
	    }
	}
	
	static void printCell(String number) {
	    System.out.print(String.format("%1$1s", number));
	  }
}