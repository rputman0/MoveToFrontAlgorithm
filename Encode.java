public class Encode{
  
  static String encodeIntegers(String message){
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    String encoded = reorderFirstLetter(alphabet,message);    
    String encodedInt = getIndexOf(alphabet,message,0);
    
    for(int i=1;i<message.length();i++){
     encodedInt += getIndexOf(encoded,message,i);
     encoded = reorder(encoded, getAlphabetPosition(encoded,message.charAt(i)) );
    }
    
    return encodedInt;
  }
  
   static String encodeAlphabet(String message){
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    String encoded = reorderFirstLetter(alphabet,message);
    
    for(int i=1;i<message.length();i++)
     encoded = reorder(encoded, getAlphabetPosition(encoded,message.charAt(i)) );
    
    return encoded;
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
