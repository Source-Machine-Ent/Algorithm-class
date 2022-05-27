// 220527 5639 이진탐색 트리
package wonyoung.data_structer;


import java.io.*;
import java.util.*;

class Main {	
	static Node root;
	static ArrayList<Integer> postorderArr;

    public static void main(String[] args) throws Exception {
        // for coding
        System.setIn(new FileInputStream("./input/input_5639.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		postorderArr = new ArrayList();
		root = new Node(Integer.parseInt(bf.readLine()));
		String str = null;
		while((str = bf.readLine()) != null && str.length() != 0) {
			Node node = new Node(Integer.parseInt(str));
			putNode(root, node);
		}
		
		postorder(root);
		for(int i : postorderArr)
			System.out.println(i);
		
	}
	
	static void postorder(Node node) {
		if(node.left != null)
			postorder(node.left);
		if(node.right != null) 
			postorder(node.right);
		postorderArr.add(node.name);
	}
	
	static void putNode(Node startNode, Node inputNode) {
		if( startNode.name > inputNode.name) {
			if( startNode.left != null) {
				putNode(startNode.left, inputNode);
			}else {
				startNode.left = inputNode;
			}
		}
		if( startNode.name < inputNode.name) {
			if( startNode.right != null) {
				putNode(startNode.right, inputNode);
			}else {
				startNode.right = inputNode;
			}
		}
	}
}

class Node{
	int name;
	public Node(int name){
		this.name = name;
	}
	Node left;
	Node right;
}