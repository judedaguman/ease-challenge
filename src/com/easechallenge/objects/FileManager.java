package com.easechallenge.objects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * @author jude.daguman
 *
 */
public class FileManager{
	
public List<Integer [] > readFile(){
	List<Integer [] > mapArray = new ArrayList<Integer []>();
	FileReader fr;
			try {
				fr = new FileReader(new File("").getAbsolutePath()+"\\src\\com\\easechallenge\\map.txt");
				BufferedReader br = new BufferedReader(fr);
		        String line = br.readLine();
		       
		        String[] arrayLength = line.split(" ", 2);
		        Integer rowLength = Integer.parseInt(arrayLength[0]);
		        Integer colLength = Integer.parseInt(arrayLength[1]);
		        line = null;
		        Integer[][] arr = new Integer[rowLength][colLength];
		        	for (int i = 0; i < rowLength; i++) {
		                String[] st = br.readLine().trim().split(" ");
		                for (int j = 0;j < colLength; j++) {
		                	arr[i][j]  = Integer.parseInt(st[j]) ;
		                }
		           }
		        	
		          for (int i= 0;  i< rowLength; i++) {
	        		mapArray.add(arr[i]);
				
			}
		        
		        br.close();
		        
		        
			} catch (FileNotFoundException e) {
				System.out.println("Error File Not Found");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("File Read Error");
				e.printStackTrace();
			}
			
		return mapArray;	
	}

}