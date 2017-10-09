//Move-To-Front Algorithm
//Takes a character from a given word and gets the position of it in the alphabet
//It then  moves the character to the front of the alphabet, and repeats till the word is complete
import java.util.Scanner;

public class MoveToFrontAlgorithm{
  public static void main(String[]args){
    System.out.println("Enter a phrase to encrypt: ");
    Scanner input = new Scanner(System.in);
    
    //make sure the user input is in lower case, with no strings
    try{
     String message = input.nextLine();
     message = message.toLowerCase();
     message = message.replaceAll(" ","");
    
     encodeMessage(message);
    }
    catch(Exception e){
     System.out.println();
    }
    input.close();
  }
  
  static String decodeMessage(int[] numbers){
   String alphabet = "abcdefghijklmnopqrstuvwxyz";
   String decode = "";
   
   for(int i=0;i<numbers.length;i++){
     decode += alphabet.charAt(numbers[i]) + "";
     alphabet = reorder(alphabet,numbers[i]);
   }
   
   System.out.println(decode + "\n" + alphabet);
   return decode;
  }
  
  static String decodeMessage(String integers){
   return decodeMessage(toIntegerArray(integers));
  }
  
  static int[] toIntegerArray(String numbers){
   String[] integers = numbers.split(" ");
   int[] array = new int[integers.length];
   
   for(int i=0;i<integers.length;i++)
     array[i] = Integer.parseInt(integers[i]);
   
   return array;
  }
  
  static String encodeMessage(String word){
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    String encoded = reorderFirstLetter(alphabet,word);    
    String encodedInt = getIndexOf(alphabet,word,0);
    
    for(int i=1;i<word.length();i++){
     encodedInt += getIndexOf(encoded,word,i);
     encoded = reorder(encoded, getAlphabetPosition(encoded,word.charAt(i)) );
    }
    
    System.out.println(encodedInt + "\n" + encoded + "\n");
    return encodedInt;
  }
  
  static String reorderFirstLetter(String alphabet, String word){
    String encoded = "";
    for(int i=0;i<alphabet.length();i++)
     if(word.charAt(0) == alphabet.charAt(i))
      encoded = reorder(alphabet,i);
    
    return encoded;
  }
   
  static int getAlphabetPosition(String alphabet, char letter){
    for(int i=0;i<alphabet.length();i++)
      if(letter == alphabet.charAt(i))
        return i;
    
    return -1;
  }
  
  static String getIndexOf(String encoded, String word, int position){
    return encoded.indexOf(word.charAt(position)) + " ";
  }
  
  static String reorder(String alphabet,int index){
    return alphabet.charAt(index) + alphabet.substring(0,index) + alphabet.substring(index+1);
  }
  
}