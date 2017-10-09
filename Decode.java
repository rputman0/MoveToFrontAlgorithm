public class Decode extends Encode{

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
  
}