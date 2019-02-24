package com.easechallenge.objects;


/**
 * @author jude.daguman
 *
 */
public class Runner{
	
	int p1;
	int p2;
	int maxLength;
	int maxDrop;
	String path;
	int startNode;
	int lastNode;
	
	public Runner(Runner temp) {
		this.p1 = temp.p1;
		this.p2 = temp.p2;
		this.path = temp.path;
		this.maxLength = temp.maxLength;
		this.maxDrop = temp.maxDrop;
		this.startNode = temp.startNode;
		this.lastNode = temp.lastNode;
	}
	
	public Runner() {
		// TODO Auto-generated constructor stub
	}

	public int getP1() {
		return p1;
	}
	public void setP1(int p1) {
		this.p1 = p1;
	}
	public int getP2() {
		return p2;
	}
	public void setP2(int p2) {
		this.p2 = p2;
	}
	public int getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}
	public int getMaxDrop() {
		return maxDrop;
	}
	public void setMaxDrop() {
		this.maxDrop = this.startNode - this.lastNode;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getStartNode() {
		return startNode;
	}
	public void setStartNode(int startNode) {
		this.startNode = startNode;
	}
	public int getLastNode() {
		return lastNode;
	}
	public void setLastNode(int lastNode) {
		this.lastNode = lastNode;
	}

	
	
}