import java.util.Scanner;

public class MoveToFront extends Encode{
  public static void main(String[]args){
    System.out.println("Enter a phrase to encrypt: ");
    Scanner input = new Scanner(System.in);
    
    //The user should input a lowercase word, with no spaces and integers
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
  
}