public class StringPractice {
 
  public static boolean isPunct(char c) {
	  if (c=='\''||c==','||c=='.'||c==';'||c==':'||c=='!'||c=='?') {
		  return true;
	  }else {
		  return false;
	  }
  }

  public static int numPunct(String s) {
	  int num=0;
	  for (int x=0;x<=s.length()-1;x++) {
		  if (isPunct(s.charAt(x))==true) {
			  num+=1;
		  }
	  }
    return num;
  }
  
  public static int numPunct(String s, int startIndex) {
	  int num=0;
	  int stringLen=s.length()-1;
	  for (int x=startIndex;x<=stringLen;x++) {
		  if (isPunct(s.charAt(x))==true) {
			  num+=1;
		  }
	  }
    return num;
  }

  public static int indexOfFirstPunct(String s, int startPosition) {
	  int indexPunc=-1;
	  int stringLen=s.length()-1;
	  for (int x=startPosition;x<=stringLen;x++) {
		  if(isPunct(s.charAt(x))==true) {
			  indexPunc=x;
		  }
		  if(indexPunc!=-1) {
			  break;
		  }
	  }
    return indexPunc;
  }


  public static int indexOfFirstPunct(String s) {
	  int indexPunc=-1;
		int stringLen=s.length()-1;
		for (int x=0;x<=stringLen;x++) {
			if(isPunct(s.charAt(x))==true) {
				indexPunc=x;
			}
			if(indexPunc!=-1) {
				break;
			}
		}
		return indexPunc;
  }

  public static int indexOfLastPunct(String s) {
	  int indexPunc=-1;
	  int stringLen=s.length()-1;
	  for (int x=0;x<=stringLen;x++) {
		  if(isPunct(s.charAt(x))==true) {
			  indexPunc=x;
		  }
	  }
    return indexPunc;
  }

  public static String substitute(String s, char oldChar, char newChar) {
	  String newS="";
	  int stringLen=s.length()-1;
	  for (int x=0;x<=stringLen;x++) {
		  if(s.charAt(x)==oldChar) {
			  newS=newS+newChar;
		  }else {
			  newS=newS+s.charAt(x);
		  }
	  }
    return newS;
  }

  public static String substitutePunct(String s) {
	  String newS="";
	  int stringLen=s.length()-1;
	  boolean isPunctResult=true;
	  for (int x=0;x<=stringLen;x++) {
		  isPunctResult=isPunct(s.charAt(x));
		  if (isPunctResult==true) {
			  newS=newS+" ";
		  }else {
			  newS=newS+s.charAt(x);
		  }
	  }
    return newS;
  }

  public static String withoutPunct(String s) {
	  String newS="";
	  int stringLen=s.length()-1;
	  boolean isPunctResult=true;
	  for (int x=0;x<=stringLen;x++) {
		  isPunctResult=isPunct(s.charAt(x));
		  if (isPunctResult==true) {
			  newS=newS+"";
		  }else {
			  newS=newS+s.charAt(x);
		  }
	  }
    return newS;
  }

  public static boolean foundIn(String s, char c) {
	  String character="";
	  character+=c;
	  if (s.contains(character)) {
		  return true;
	  }else {
		  return false;
	  }
  }

  public static boolean containsNone(String s, String chars) {
	  int charNum=0;
	  int charLength=chars.length()-1;
	  String character="";
	  for (int x=0;x<=charLength;x++) {
		  character+=chars.charAt(x);
		  if (s.contains(character)) {
			  charNum+=1;
			  character="";
		  }else {
			  character="";
		  }
	  }
	  if (charNum==0) {
		  return true;
	  }else {
		  return false;
	  }
  }
  
  public static boolean onlyPunct(String s) {
	  int stringLen=s.length();
	  int numPunct=0;
	  for(int x=0;x<=stringLen-1;x++) {
		  if (isPunct(s.charAt(x))==true) {
			  numPunct+=1;
		  }
	  }
	  if (numPunct==stringLen) {
		  return true;
	  }else {
		  return false;
	  }
  }

  public static boolean noPunct(String s) {
	  int stringLen=s.length();
	  int numPunct=0;
	  for(int x=0;x<=stringLen-1;x++) {
		  if (isPunct(s.charAt(x))==true) {
			  numPunct+=1;
		  }
	  }
	  if (numPunct==0) {
		  return true;
	  }else {
		  return false;
	  }
  }

  public static boolean consecutivePuncts(String s) {
	  int stringLen=s.length()-1;
	  int numPunct=0;
	  for (int x=0; x<=stringLen;x++) {
		  if (isPunct(s.charAt(x))==true) {
			  numPunct+=1;
		  }else {
			  numPunct=0;
		  }
		  if (numPunct==2) {
			  break;
		  }
	  }
	  if (numPunct==2) {
		  return true;
	  }else {
		  return false;
	  }
  }
}
