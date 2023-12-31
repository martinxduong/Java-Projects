import java.util.List;
import java.util.ArrayList;

public class ArrayListHW {
    
    //2.1
    public static <E> boolean isUnique(List<E> list){
        /*boolean result=true;
        for(int i=0;i<list.size();i++){
            String iString=(String) list.get(i);
            for(int x=0;x<list.size();x++){
                String xString=(String) list.get(x);
                if(iString.equals(xString)==false){
                    result=false;
                }

            }
        }*/
        boolean result=true;
        for(int x=0; x<list.size(); x++){
            for(int y=0; y<list.size(); y++){
                if(x!=y){
                    if(list.get(x).equals(list.get(y))==true){
                        result=false;
                    }
                }
            }
        }

        System.out.println(result);
        return result;
    }

    //2.2
    public static <E> List allMultiples(List<Integer> list, int multiple){
        List<Integer> multipleList=new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            int item=(int) list.get(i);
            if(item % multiple==0){
                multipleList.add(item);
            }

            }
            return multipleList;
        }

    //2.3
    public static <E> List allStringsOfSize(List<String> list, int length){
        List<String> listLength=new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            String item=(String) list.get(i);
            int itemLength= ((java.lang.String) item).length();
            if(itemLength==length){
                listLength.add("\""+item+"\"");
            }
    
            

        }
        return listLength;
    }

    //2.4
    public static <E> boolean isPerumatation(List<E> listA, List<E> listB){
        if(listA.size()!=listB.size()){
            return false;
        }
            for(E item: listA){
                int countA=0;
                int countB=0;

            for(int i=0; i<listA.size(); i++){
                if(listA.get(i).equals(item)){
                    countA++;
                }
            }
            for(int i=0; i<listB.size(); i++){
                if(listB.get(i).equals(item)){
                countB++;
                }
            }
            if(countA!=countB){
                return false;
            }
        }
        String hello="hi";
        return true;
    }

    //2.5
    public static <E> List stringToListOfWords(String inputString){
        List<String> listOfWords=new ArrayList<>();
        String listElement="\"";
        String alphabet="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i=0;i<inputString.length(); i++){
            String characterString="";
            characterString+=inputString.charAt(i);
            if(alphabet.contains(characterString)){
                listElement+=characterString;
            }
            else if(alphabet.contains(characterString)==false){
                if(listElement!="\""){
                    listElement+="\"";
                    listOfWords.add(listElement);
                    listElement="\"";
                }
                //else if(listElement=="\"" || listElement=="\" "){
                    //;
                //}
            }
        }
        return listOfWords;
    }

    //2.6
    public static <E> void removeAllInstances(List<E> list, E item){
        List<E> removedAllInstances=new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            if(list.get(i)==item){
                list.remove(i);
            }
            if((i-1)>0 && list.get(i-1)==item){
                list.remove(i-1);
            }
            if((i+1)<list.size() && list.get(i+1)==item){
                list.remove(i+1);
            }
        }
    }



 

    public static void main(String args[]){
        //2.1
        System.out.println("2.1:");
        List<String> isUniqueList=new ArrayList<>();
        isUniqueList.add("Hi");
        isUniqueList.add("Hey");
        isUniqueList.add("Hello");
        isUniqueList.add("Hiya");
        isUnique(isUniqueList);
        System.out.println();

        //2.2:
        System.out.println("2.2:");
        List<Integer> allMultiplesList=new ArrayList<>();
        allMultiplesList.add(1);
        allMultiplesList.add(25);
        allMultiplesList.add(2);
        allMultiplesList.add(5);
        allMultiplesList.add(30);
        allMultiplesList.add(19);
        allMultiplesList.add(57);
        allMultiplesList.add(2);
        allMultiplesList.add(25);
        System.out.println(allMultiples(allMultiplesList,5));
        System.out.println();

        //2.3:
        System.out.println("2.3");
        List<String> allStringsOfSizeList=new ArrayList<>();
        allStringsOfSizeList.add("I");
        allStringsOfSizeList.add("like");
        allStringsOfSizeList.add("to");
        allStringsOfSizeList.add("eat");
        allStringsOfSizeList.add("eat");
        allStringsOfSizeList.add("eat");
        allStringsOfSizeList.add("apples");
        allStringsOfSizeList.add("and");
        allStringsOfSizeList.add("bananas");
        System.out.println(allStringsOfSize(allStringsOfSizeList,3));
        System.out.println();

        //2.4:
        System.out.println("2.4:");
        List<String> listA=new ArrayList<>();
        List<String> listB=new ArrayList<>();
        listA.add("1");
        listA.add("2");
        listA.add("4");
        listB.add("2");
        listB.add("1");
        listB.add("4");
        System.out.println(isPerumatation(listA, listB));
        System.out.println();

        //2.5:
        System.out.println("2.5:");
        String inputString="Hello, world!";
        System.out.println(stringToListOfWords(inputString));
        System.out.println();

        //2.6:
        System.out.println("2.6:");
        List<Integer> listInteger=new ArrayList<>();
        List<String> listString=new ArrayList<>();
        listInteger.add(1);
        listInteger.add(4);
        listInteger.add(5);
        listInteger.add(6);
        listInteger.add(5);
        listInteger.add(5);
        listInteger.add(2);
        System.out.println("Before: "+listInteger);
        removeAllInstances(listInteger,5);
        System.out.println("After: "+listInteger);
        listString.add("abc");
        listString.add("def");
        listString.add("ghi");
        listString.add("jkl");
        listString.add("mno");
        listString.add("pqr");
        listString.add("def");
        System.out.println();
        System.out.println("Before: "+listString);
        removeAllInstances(listString,"def");
        System.out.println("After: "+listString);

        



       /* 
        Integer a=7000;
        Integer b=7;

        String x="apple";
        String y="lemon";

        System.out.println(x.compareTo(y));
        */
    }
}
