import java.io.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


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
	
	static HashMap <Integer,Boolean> hashTable;
	
	


	
	static void backtrackSolve (int currK, int currS) {
		
		
		
		
		if (currK > bestK ) {
			
			bestK = currK ; 
			
			bestX = currX.clone();
			
			
		}
		
		if (currK < numberOfcars) {
			
			// Insertion to left
			
			if(carLength.get(currK) <= currS && hashTable.get(2*(currK+1) + 3*(currS - carLength.get(currK))) == null ) {
				
				currX [currK] = 1;
				
				int newS = currS - carLength.get(currK);
				

				backtrackSolve( currK+1 , newS);
				
				hashTable.put(2*(currK+1) + 3*(currS - carLength.get(currK)), true);
				
			}
			
			
			//Insertion to right
			carTotalLength = 0;
			for (int i = 0 ; i < currK ; i ++ ) {
				carTotalLength = carTotalLength + carLength.get(i);
			}
			
			if( ferryLength - (carTotalLength + carLength.get(currK) - (ferryLength - currS)) >= 0  && hashTable.get(2*(currK+1) + 3*currS) == null) {
				
				currX [currK] = 0;
				
				backtrackSolve(currK + 1, currS);
				
				hashTable.put(2*(currK+1) + 3*currS, true);;
				
				
				
			}
			
			
		}
		
	}
	
	
	

	
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


				//Hash Table initialization
				hashTable = new HashMap<>(2*(numberOfcars + 1) + 3*(1+ferryLength));

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
