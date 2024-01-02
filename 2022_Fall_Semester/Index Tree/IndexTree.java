package index;

import java.io.*;
import java.util.Scanner;



/* 
Your class. Notice how it has no generics.
This is because we use generics when we have no idea what kind of data we are getting
Here we know we are getting two pieces of data:  a string and a line number
*/
public class IndexTree {

	/*
	This is your root 
	again, your root does not use generics because you know your nodes
	hold strings, an int, and a list of integers
	*/
	private IndexNode root;

	/*
	Make your constructor
	It doesn't need to do anything
	*/
	public IndexTree(){
	}

	/*
	complete the methods below
	
	this is your wrapper method
	it takes in two pieces of data rather than one
	call your recursive add method
	*/
	public void add(String word, int lineNumber){
		this.root = add(this.root, word, lineNumber);
	}
	
	/*
	your recursive method for add
	Think about how this is slightly different the the regular add method
	When you add the word to the index, if it already exists, 
	you want to  add it to the IndexNode that already exists
	otherwise make a new indexNode
	*/
	private IndexNode add(IndexNode root, String word, int lineNumber){
		if(root == null){
			return new IndexNode(word, lineNumber);
		}

		int comparison = word.compareTo(root.word);
		if(comparison == 0){ // item already exists
			root.list.add(lineNumber);
			root.occurences++;
			return root;
		}

		if(comparison < 0){ // left
			root.left = add(root.left, word, lineNumber);
			return root;
		}
		else{ // right
			root.right = add(root.right, word, lineNumber);
			return root;
		}
	}
	
	// returns true if the word is in the index
	public boolean contains(String word){
		return contains(this.root, word);
	}

	private boolean contains(IndexNode root, String word){
		if(root == null){
			return false;
		}

		int comparison = word.compareTo(root.word);
		if(comparison == 0){
			return true;
		}
		else if(comparison < 0){ // it is less than the item in the root ; left
			return contains(root.left, word);
		} else{ // it is greater than the item in the root ; right
			return contains(root.right, word);
		}
	}
	
	/*
	call your recursive method
	use book as guide
	*/
	public void delete(String word){ // Wrapper method;
		this.root = this.delete(this.root, word);

	}
	
	/*
	your recursive case
	remove the word and all the entries for the word
	This should be no different than the regular technique.
	*/
	private IndexNode delete(IndexNode root, String word){
		if(root == null){
			return null;
		}
		
		int comparison = word.compareTo(root.word);
		if(comparison < 0){
			root.left = delete(root.left, word);
			return root;
		}
		else if(comparison > 0){
			root.right = delete(root.right, word);
			return root;
		} else{
			if(root.left == null && root.right == null){ // leaf
				return null;
			}
			else if(root.left != null && root.right == null){ // left has a node
				return root.left;
			}
			else if(root.left == null && root.right != null){ // right has a node
				return root.right;
			} else{ // Smallest thing that is bigger than the root or the biggest thing that is smaller than the root
				IndexNode current = root.left; //Biggest thign that is smaller than me
				while(current.right != null){
					current = current.right;
				}

				root.word = current.word;
				root.left = delete(root.left, root.word);
				return root;
			}
		}
	}
	
	/*
	prints all the words in the index in inorder order
	To successfully print it out
	this should print out each word followed by the number of occurrences and the list of all occurrences
	each word and its data gets its own line
	*/
	public String printIndex(){ // Wrapper Method
		StringBuilder sb = new StringBuilder();
		inOrderTraverse(root, sb);
		//printIndex(root);
		return sb.toString();
	}

	private String printIndex(IndexNode root){
		/*
		System.out.print(root.word+root.occurences);

		for(int i=0;i<root.list.size();i++){
			System.out.println(root.list.get(i));
		}
		printIndex(root.left);
		printIndex(root);
		printIndex(root.right);
		
		if(root == null){
			return "";
		}

		printIndex(root.left);
		System.out.println(root);
		printIndex(root.right);
		*/
		if(root == null){
			return "";
		}
		String output = "";
		output += printIndex(root.left);
		output += root.word + " ";
		output += printIndex(root.right);
		return output;
	}

	private void inOrderTraverse(IndexNode root, StringBuilder sb){ // left subtree, root, right subtree

		if(root == null){
			;
		} else{
			inOrderTraverse(root.left, sb);
			sb.append(root.toString());
			sb.append("\n");
			inOrderTraverse(root.right, sb);
		}
	}

	
	
	public static void main(String[] args){
		IndexTree index = new IndexTree();

		/*
		add all the words to the tree
		print out the index
		test removing a word from the index
		*/
		String fileName = "pg100.txt";
		int lineNum = 0;
		try{
			Scanner scanner = new Scanner(new File(fileName));
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				lineNum += 1;
				String[] words = line.split("\\s+");
				for(String word : words){
					word = word.toLowerCase();
					word = word.replaceAll(":", "");
					word = word.replaceAll(",", "");
					word = word.replaceAll("\\.","");
					word = word.replaceAll("\\?","");
					word = word.replaceAll(";", "");
					word = word.replaceAll("\\)", "");
					word = word.replaceAll("\\(", "");
					word = word.replaceAll("\\!", "");
					word = word.replaceAll("\\[", "");
					word = word.replaceAll("\\]", "");
					word = word.replaceAll("\"", "");
					word = word.replaceAll("}", "");
					index.add(word, lineNum);
				}
			}
			scanner.close();
		} catch (FileNotFoundException e1){
			e1.printStackTrace();
		}
		System.out.println(index.printIndex());
		System.out.println(index.contains("basket"));
		index.delete("basket");
		System.out.println(index.contains("basket"));
	}
}
