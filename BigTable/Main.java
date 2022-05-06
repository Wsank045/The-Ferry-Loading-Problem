import java.io.*;

import java.util.ArrayList;


class Main {
	
	static int bestK ;
	
	static int [] currX;
	
	static int [] bestX;
	
	static int numberOfcars;
	
	static int numberOfCases;
	
	static ArrayList<Integer> carLength;
	
	static int carTotalLength;
	
	static int ferryLength;
	
	static int freeRight = 0;
	
	
	static boolean [][] bigTable;
	
	


	
	static void backtrackSolve (int currK, int currS) {
		
		
		
		
		if (currK > bestK ) {
			
			bestK = currK ; 
			
			bestX = currX.clone();
			
			
		}
		
		if (currK < numberOfcars) {
			
			// Insertion to left
			
			if(carLength.get(currK) <= currS && bigTable [currK +1] [currS - carLength.get(currK)] == false ) {
				
				currX [currK] = 1;
				
				
				int newS = currS - carLength.get(currK);
				

				backtrackSolve( currK+1 , newS);
				
				bigTable [currK +1][ newS] = true ;
				
			}
			
			
			//Insertion to right
			carTotalLength = 0;
			for (int i = 0 ; i < currK ; i ++ ) {
				carTotalLength = carTotalLength + carLength.get(i);
			}
			
			if( ferryLength - (carTotalLength + carLength.get(currK) - (ferryLength - currS)) >= 0  && bigTable [currK + 1] [currS] == false) {
				
				currX [currK] = 0;
				
				backtrackSolve(currK + 1, currS);
				
				bigTable [currK +1 ] [currS] = true ;
				
				
				
			}
			
			
		}
		
	}
	
	// private static boolean isPossibleToAddRight (int currK, int currS) {
		
	// 	int usedLeft = ferryLength - currS;
		
	// 	int totalUsed = 0;
		
	// 	if(currK == 0) {
	// 		totalUsed = 0;
	// 	}
	// 	else {
	// 		for(int i =0 ; i < currK ; i ++) {
	// 			totalUsed = totalUsed + carLength.get(i);
	// 		}
	// 	}
		
		
	// 	int usedRight = totalUsed - usedLeft ;
	// 	freeRight = ferryLength - usedRight;
	// 	return carLength.get(currK) <= freeRight ;
	// }
	
	

	
	public static void main(String[] args) {
		 
        BufferedReader bReader = null;
			

		
		
		try (BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out)))
		{
			
			bReader = new BufferedReader(new InputStreamReader(System.in));
			
			//Initialize the number of cases
			String cases = bReader.readLine().trim();
			numberOfCases = Integer.parseInt(cases);
			
			
			//First blank line
			
			String blankString = bReader.readLine();
			
			
			//Initialize cars Length
			
			carLength = new ArrayList<>();
			
			
		
			
			String line = "";

			for(int i = 0 ; i < numberOfCases ; i++) {

				
				carLength.clear();

				//Ferry Length 
				line = bReader.readLine().trim();
				ferryLength = Integer.parseInt(line)*100;
				

				//CarLength initialisation
				while ( ! line.equals("0")) {
					line = bReader.readLine().trim();
				
					int lineInteger = Integer.parseInt(line);
					carLength.add(lineInteger);
					
				}

				numberOfcars = carLength.size() - 1;
				bReader.readLine();

				//BigTable initialisation
				bigTable = new boolean [numberOfcars + 1] [ferryLength + 1];
				
				for(int j = 0 ; j < numberOfcars +1 ; j++) {
					
					for (int k = 0 ; k < ferryLength + 1 ; k++) {
						bigTable [j][k] = false;
					}
					
				}

				//Backtrack solve
				
				bestK = -1;
				bestX = new int [numberOfcars];
				currX = new int [numberOfcars];
				
				backtrackSolve(0, ferryLength);

				//Writing
				Integer bestK_1 = (Integer) bestK;
				
				if( i != 0) {
					bWriter.newLine();
				}
				
				bWriter.write(bestK_1.toString());
			
				bWriter.newLine();
				
				for(int j = 0 ; j < bestK ; j++) {
					if(bestX[j] == 1) {
						bWriter.write("port");
						
					}
					else {
						bWriter.write("starboard");
						
					}
					bWriter.newLine();
				}
					

			}

			
				
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		finally {
			try {
				bReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
        
        
       	
	}
		
}
