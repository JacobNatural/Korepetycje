package zajecia01;


import java.util.*;

public class AllAnagram {

    public static void showAnagrams(String text){

        String[] tempArray;
        List<String[]> listOfAnagrams = new ArrayList<>();
        String[] splitText = text.split("");
        Set<String> stringSetForSize = new HashSet<>(Arrays.asList(splitText));
        String[] arrayForAnnagram = new String[stringSetForSize.size()];
        listOfAnagrams.add(arrayForAnnagram);

        Arrays.sort(splitText);
        String temp = "";
        for(int i = 0, j = 0; i < splitText.length ; i++){  // check if some latters are more than one
            temp += splitText[i];
            if(i == splitText.length - 1){
                arrayForAnnagram[j] = temp;
            }else
            if(!splitText[i].equals(splitText[i + 1]) ){
                arrayForAnnagram[j] = temp;
                temp = "";
                j++;
            }
        }
        for(int b = 0; b < arrayForAnnagram.length -1; b++) { // how many permutations
            int size = listOfAnagrams.size();
              for(int a = 0; a < size; a++) {   // itrating on list with permiatations
            for (int j = b, k = j + 1; k < listOfAnagrams.get(a).length; k++) { // index of change of permutations
                tempArray = change(listOfAnagrams.get(a), j, k);
                listOfAnagrams.add(tempArray);
            }
              }
        }
        int indexOfPermuations = 1;

       for(String[] s : listOfAnagrams){
           System.out.println(indexOfPermuations);
           for(int i  = 0; i < s.length; i++){
               System.out.print(s[i] );
           }
           indexOfPermuations++;
           System.out.println();
       }
    }

    public static String[] change(String[] array, int i, int j){
        String arrayNewAdress[] = new String[array.length];
        String temp;
        for(int k = 0; k < array.length; k++){
            arrayNewAdress[k] = array[k];
        }
        temp = arrayNewAdress[i];
        arrayNewAdress[i] = arrayNewAdress[j];
        arrayNewAdress[j] = temp;
        return arrayNewAdress;
    }




    public static void main(String[] args) {
       showAnagrams("ABDD");
    }
}
