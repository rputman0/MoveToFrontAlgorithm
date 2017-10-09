public class Encode{
  
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