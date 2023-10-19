package huffmanAlgorithm;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class MyHufman {
   public static Node root;
   public static Map<Character, String> code = new HashMap<>();

   public static void showRoot(Node focusNode, String s){
       if(focusNode != null) {
           if(Character.isLetter(focusNode.sign)) code.put(focusNode.sign, s);
           showRoot(focusNode.left, s +"0");
           showRoot(focusNode.right,  s +  "1");
       }
   }

   public static Map<Character, Integer> latterAndAmount(String text){
       Map<Character, Integer> result_map = new HashMap<>();
       char[] textCharArray = text.toCharArray();

       for(Character c : textCharArray){
           if(result_map.containsKey(c)){
               result_map.put(c,result_map.get(c) + 1);
           }else{
               result_map.put(c, 1);
           }
       }
       return result_map;
   }

   public static void createCodeHufman(String text){
       Map<Character, Integer> map;
       map = latterAndAmount(text);
       List<Node> nodeList = new ArrayList<>();

       for(Map.Entry<Character, Integer> entry : map.entrySet()){
           Node node = new Node();
           node.key = entry.getValue();
           node.sign = entry.getKey();
           nodeList.add(node);
       }

       nodeList.sort(new MyComparator());

       Node createNode = new Node(nodeList.get(0).key + nodeList.get(1).key, '-');

       root = createNode;
       root.left = nodeList.get(0);
       root.right = nodeList.get(1);

       for(int i = 2; i < nodeList.size(); i++){
           Node newNodeTemp = new Node(root.key + nodeList.get(i).key, '-');
           newNodeTemp.left = root;
           newNodeTemp.right = nodeList.get(i);
           root = newNodeTemp;
       }
   }

   public static String changeTextForCode(String text){
       String[] splitText = text.split("");
       String result = "";

       for(String s : splitText){
           result += code.get(s.charAt(0));
       }
       return result;
   }

   public static String changeFromCodeToText(String binaryText){
       String text = "";
       List<DataForSort> listForCompare = new ArrayList<>();
       for(Map.Entry<Character, String> entry : code.entrySet()){
           DataForSort dataForSort = new DataForSort(entry.getKey(), entry.getValue());
           listForCompare.add(dataForSort);


       }
       listForCompare.sort(new StringComparator());

       for(DataForSort s: listForCompare){
           binaryText = binaryText.replaceAll(s.s, String.valueOf(s.c));
       }
       return binaryText;
   }



    public static void main(String[] args) {
       String text = "ABCCADDFG";
       System.out.println("Text do kompresi\t" + text);

        createCodeHufman(text);
        showRoot(root, "");
        String binaryCode = changeTextForCode(text);
        System.out.println("Binarny cod po kompresi\t" + binaryCode);
        System.out.println("Odwrocenie kompresi\t" + changeFromCodeToText(binaryCode));
    }

}

class Node{
    int key;
    char sign;
    Node left;
    Node right;

    Node(int key, char sign){
        this.key = key;
        this.sign = sign;
    }
    Node() {}

    public String toString(){
        return key + " " + sign;
    }
}

class DataForSort{
    Character c;
    String s;
    DataForSort(Character c, String s){
        this.c = c;
        this.s = s;
    }
    public String toString(){
        return s;
    }
}

class MyComparator implements Comparator<Node>{
    public int compare(Node x, Node y){

        if(x.key < y.key) return -1;
        if(x.key > y.key) return 1;
        return 0;
    }
}

class StringComparator implements  Comparator<DataForSort>{
    public int compare(DataForSort x, DataForSort y){
        if(x.s.length() > y.s.length()) return -1;
        if(x.s.length() < y.s.length()) return 1;
        return 0;
    }
}