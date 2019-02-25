package com.easechallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.easechallenge.objects.FileManager;
import com.easechallenge.objects.Runner;
/**
 * @author jude.daguman
 *
 */
public class EaseExamv2{
	
	public static void main (String[] args) {
		
		List<Integer [] > mapArray = new ArrayList<Integer []>();
		FileManager fm = new FileManager();
		mapArray = fm.readFile();
		Runner resultSet = new Runner();
		Stack<Runner> inputStack = new Stack<Runner>();
		
		inputStack = initialize(mapArray);
		resultSet = newSearchNSEW(inputStack, mapArray, resultSet);
		StringBuilder sb = new StringBuilder(resultSet.getPath());
		sb.reverse();
		sb.deleteCharAt(0);
		sb.reverse();
		System.out.println("Longest Path: " + resultSet.getMaxLength());
		System.out.println("Path Values: " + sb.toString());
		System.out.println("Longest Drop: " + resultSet.getMaxDrop());
		
	}
	
	public static Stack<Runner> initialize (List<Integer [] > mapArray) {
		//initialize stack loop from last to first
		Stack<Runner> runner = new Stack<Runner>();
		for (int row = mapArray.size()-1; row >= 0 ; row--) {
			for (int col = (mapArray.get(row).length-1); col >= 0; col--) {
				Runner r = new Runner();

				r.setP1(row);
				r.setP2(col);
				r.setMaxLength(1);
				r.setStartNode(mapArray.get(row)[col]);
				r.setLastNode(mapArray.get(row)[col]);
				r.setPath(mapArray.get(row)[col] + "-");
				
				runner.push(r);
			}
		}
		
		return runner;
		
	}
	//search north-south-east-west via dfs
	public static Runner newSearchNSEW(Stack<Runner> inputStack, List<Integer [] > mapArray, Runner resultSet) {

		while (!inputStack.isEmpty()) {

			Runner runner = new Runner ();
			Boolean moveStatus = false;
			
			runner = inputStack.pop();
			int value = mapArray.get(runner.getP1())[runner.getP2()];
			
			
			if (runner.getP2()-1 >= 0 && runner.getP2()+1 < mapArray.get(runner.getP1()).length) {
				//check west value
				int westCoor = runner.getP2()-1;
				if ((mapArray.get(runner.getP1())[runner.getP2()-1])!= null && (mapArray.get(runner.getP1())[runner.getP2()-1]) < value) {
					
					Runner westRunner = new Runner(runner);
					StringBuilder stringBuilder = new StringBuilder();
					int westValue = mapArray.get(runner.getP1())[runner.getP2()-1];
					westRunner.setP2(westCoor);
					westRunner.setMaxLength(runner.getMaxLength()+1);
					westRunner.setLastNode(westValue);
					stringBuilder.append(runner.getPath() + westValue + "-");
					westRunner.setPath(stringBuilder.toString());
					inputStack.push(westRunner);
					moveStatus = true;
					
				}
			}
			if (runner.getP1()-1 >= 0 && runner.getP1()-1 < mapArray.size()) {
				// check north value
				int northCoor = runner.getP1()-1;
				if ((mapArray.get(runner.getP1()-1)[runner.getP2()])!= null && (mapArray.get(runner.getP1()-1)[runner.getP2()]) < value) {
					
					Runner northRunner = new Runner(runner);
					StringBuilder stringBuilder = new StringBuilder();
					int northValue = mapArray.get(runner.getP1()-1)[runner.getP2()];
					northRunner.setP1(northCoor);
					northRunner.setMaxLength(runner.getMaxLength()+1);
					northRunner.setLastNode(northValue);
					stringBuilder.append(runner.getPath() + northValue + "-");
					northRunner.setPath(stringBuilder.toString());
					inputStack.push(northRunner);
					moveStatus = true;
					
				}
			}
			
			if (runner.getP2()+1 >= 0 && runner.getP2()+1 < mapArray.get(runner.getP1()).length) {
					//check east value
				int eastCoor = runner.getP2()+1;
				if ((mapArray.get(runner.getP1())[runner.getP2()+1])!= null && (mapArray.get(runner.getP1())[runner.getP2()+1]) < value) {
					
					Runner eastRunner = new Runner(runner);
					StringBuilder stringBuilder = new StringBuilder();
					int eastValue = mapArray.get(runner.getP1())[runner.getP2()+1];
					eastRunner.setP2(eastCoor);
					eastRunner.setMaxLength(runner.getMaxLength()+1);
					stringBuilder.append(runner.getPath() + eastValue + "-");
					eastRunner.setLastNode(eastValue);
					eastRunner.setPath(stringBuilder.toString());
					inputStack.push(eastRunner);
					moveStatus = true;
					
				}
			}
			if(runner.getP1()+1 >= 0 && runner.getP1()+1 < mapArray.size()) {
				// check south value
				int southCoor = runner.getP1()+1;
				if ((mapArray.get(runner.getP1()+1)[runner.getP2()])!= null && (mapArray.get(runner.getP1()+1)[runner.getP2()]) < value) {
					
					Runner southRunner = new Runner(runner);
					StringBuilder stringBuilder = new StringBuilder();
					int southValue = mapArray.get(runner.getP1()+1)[runner.getP2()];
					southRunner.setP1(southCoor);
					southRunner.setMaxLength(runner.getMaxLength()+1);
					stringBuilder.append(runner.getPath() + southValue + "-");
					southRunner.setPath(stringBuilder.toString());
					southRunner.setLastNode(southValue);
					inputStack.push(southRunner);
					moveStatus = true;
					
				}
			}
			
			if(!moveStatus) {
				if(runner.getMaxLength() > resultSet.getMaxLength() ) {
					resultSet = runner;
					resultSet.setMaxDrop();
				} else if(runner.getMaxLength() == resultSet.getMaxLength()) {
						runner.setMaxDrop();
					if(runner.getMaxDrop() > resultSet.getMaxDrop()) {
						resultSet = runner;
					}
				}
			}
		}
		
		return resultSet;
		
	}
	
	
}