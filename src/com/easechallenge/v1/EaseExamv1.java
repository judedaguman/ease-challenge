package com.easechallenge.v1;
/**
 * @author jude.daguman
 *
 */
public class EaseExamv1{
	
	public static void main (String[] args) {
		
		//test 4x4 example
		int longestPath = 0;
        int[][] mapArray = { {4, 8, 7, 3}, {2, 5, 9, 3}, {6, 3, 2, 5}, {4,4,1,6} };
		//MountainMap testMap = new MountainMap();
        //display(mapArray,numRows,numCols);
        longestPath = findLongestPath(mapArray);
		System.out.println("longest:  " + longestPath);
        
		
	}
	
	
	public static int findLongestPath(int[][] mapArray) {
		
		//validate out of bounds & null values
	    if(mapArray.length==0||mapArray[0].length==0||mapArray==null) {
	    	return 0;
	    }
	        
	    
	    int[] maxLength = new int[1];
	    for(int row=0; row<mapArray.length; row++)    {
	        for(int col=0; col<mapArray[0].length; col++){
	        	//start recursion per num
	        	//initialize len = 1
	            searchNSEW(mapArray, row, col, maxLength, 1);
	            //test print
	            System.out.println("start point " + mapArray[row][col]);
	        }
	        
	    }
	 
	    return maxLength[0];
	}
	
	//compare North South East West
	public static void searchNSEW(int[][] mapArray, int row, int col, int[] maxLength, int len){
		
		//E(1,0) W(-1,0), N(0,1), S(0,-1)
	    int[] xCoor={0, 1, -1, 0};
	    int[] yCoor={1, 0, 0, -1};
	    
		//compare path to current max path
		if(maxLength[0]> len) {
			maxLength[0] = maxLength[0];
		} else {
			maxLength[0] = len;
		}
	    
	    //loop directions
	    for(int i=0; i<4; i++){
	    	
	        int x = row+xCoor[i];
	        int y = col+yCoor[i];
	        
	        if(x>=0 && x<mapArray.length && y>=0 && y<mapArray[0].length && mapArray[x][y]<mapArray[row][col]){
	            //recurse until out of bounds
	        	searchNSEW(mapArray, x, y, maxLength, len+1);
	            
	        }
	        
	        
	    }
	    
	    
	}
	
	
}