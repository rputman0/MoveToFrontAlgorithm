import java.util.Scanner;

public class MoveToFront extends Decode{
  public static void main(String[]args){
    System.out.println("Enter a phrase to encrypt: ");
    Scanner input = new Scanner(System.in);
    
    //The user should not input an integer, 
    //otherwise changes the message to lowercase and removes any spaces
    try{
     String message = input.nextLine();
     message = message.toLowerCase();
     message = message.replaceAll(" ","");
    
     String numbers = encodeIntegers(message);
     
     System.out.println(numbers + "\n" + encodeAlphabet(message) +
                 "\nDecoded Message: " + decodeMessage(numbers));
    }
    catch(Exception e){
     System.err.println("Error: You cannot type that. Please enter another phrase.");
    }
    input.close();
  }
  
}
