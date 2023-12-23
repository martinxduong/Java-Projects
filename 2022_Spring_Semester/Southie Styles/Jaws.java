import java.util.*;
import java.io.*;
public class Jaws {

	public static int numberLine()
		throws FileNotFoundException {
		Scanner input=new Scanner(new File("jaws.txt"));
		int numLine=0;
		while (input.hasNextLine()) {
			numLine+=1;
			input.nextLine();
		}
		return numLine;
	}
	
	public static void checkR(String[] lineArray) {
		if (lineArray.length<=1) {}
		else {
			for (int i=0; i<lineArray.length; i++) {
				if (lineArray[i].contains("r")==true || lineArray[i].contains("R")==true) {
					String word=lineArray[i];
					int rCharAt=locationR(word);
					int wordLen=word.length()-1;
					if (rCharAt==wordLen && wordLen>=3) {
						if (word.substring(wordLen-2).toLowerCase().equals("eer")==true) {
							String newWord=word.substring(0,wordLen)+"yah";
							lineArray[i]=newWord;
						}else if (word.substring(wordLen-1).toLowerCase().equals("ir")==true) {
							String newWord=word.substring(0,wordLen)+"yah";
							lineArray[i]=newWord;
						}else if (word.substring(wordLen-2).toLowerCase().equals("oor")==true) {
							String newWord=word.substring(0,wordLen)+"wah";
							lineArray[i]=newWord;
						}
					}
					if (rCharAt!=0 && rCharAt!=wordLen) {
						if (word.charAt(rCharAt-1)=='a'|| word.charAt(rCharAt-1)=='e' || word.charAt(rCharAt-1)=='i' || word.charAt(rCharAt-1)=='o' || word.charAt(rCharAt-1)=='u') {
							if (lineArray[i].contains("r")==true) {
								String newWord=word.substring(0,rCharAt)+"h"+word.substring(rCharAt+1);
								lineArray[i]=newWord;
							}
						}else if (word.charAt(rCharAt-1)=='A'|| word.charAt(rCharAt-1)=='E' || word.charAt(rCharAt-1)=='I' || word.charAt(rCharAt-1)=='O' || word.charAt(rCharAt-1)=='U') {
							if (lineArray[i].contains("R")==true) {
								String newWord=word.substring(0,rCharAt)+"H"+word.substring(rCharAt+1);
								lineArray[i]=newWord;
							}
						}
					}
				}
			}
		}
	}
	
	public static int locationR(String word) {
		int rCharAt=0;
		for (int i=0; i<word.length();i++) {
			if (word.charAt(i)=='r' || word.charAt(i)=='R') {
				rCharAt=i;
			}
		}
		return rCharAt;
	}
	
	public static void appendR(String[] lineArray) {
		if (lineArray.length<=1) {}
		else {
			for (int i=0; i<lineArray.length; i++) {
				if(lineArray[i].contains("a")==true || lineArray[i].contains("A")==true) {
					String word=lineArray[i];
					int wordLen=word.length()-1;
					if (wordLen!=0) {
						if (word.charAt(wordLen)=='a') {
							String newWord=word+"r";
							lineArray[i]=newWord;
						}else if (word.charAt(wordLen)=='A') {
							String newWord=word+"R";
							lineArray[i]=newWord;
						}
					}
				}
			}
		}
	}
	
	public static void veryWicked(String[] lineArray) {
		if (lineArray.length<=1) {}
		else {
			for (int i=0; i<lineArray.length; i++) {
				String word=lineArray[i];
				if (word.contains("very") || word.contains("Very") || word.contains("VERY")) {
					if (word.substring(0,4).equals("very")==true) {
						String newWord="wicked"+word.substring(4);
						lineArray[i]=newWord;
					}else if (word.substring(0,4).equals("Very")==true) {
						String newWord="Wicked"+word.substring(4);
						lineArray[i]=newWord;
					}else if (word.substring(0,4).equals("VERY")==true) {
						String newWord="WICKED"+word.substring(4);
						lineArray[i]=newWord;
					}
				}
			}
		}
	}
	public static void main(String[] args) 
			throws FileNotFoundException {
		Scanner input=new Scanner(new File("jaws.txt"));
		PrintStream output=new PrintStream(new File("newJaws.txt"));
		int numLine=numberLine();
		while (input.hasNextLine()) {
			String[] lineArray=input.nextLine().split(" ");
			checkR(lineArray);
			appendR(lineArray);
			veryWicked(lineArray);
			int arrayLen=lineArray.length;
			String stringLine="";
			if (lineArray.length>1) {
				for (int i=0; i<arrayLen; i++) {
					stringLine+=" "+lineArray[i];
				}
				output.println(stringLine);
			}else {
				output.println();
			}
		}
	}
}
