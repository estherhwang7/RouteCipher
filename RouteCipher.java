//import java.util.*;
public class RouteCipher
{
  /** A two-dimensional array of single-character strings, instantiated in the constructor */
  private String[][] letterBlock;

  /** The number of rows of letterBlock, set by the constructor */
  private int numRows;

  /** The number of columns of letterBlock, set by the constructor */
  private int numCols;

  // Part (a)

  /** Places a string into letterBlock in row-major order.
   *  @param str the string to be processed
   *  Postcondition:
   *    if str.length() < numRows * numCols, "A" is placed in each unfilled cell
   *    if str.length() > numRows * numCols, trailing characters are ignored
   */
  private void fillBlock(String str)
  {
    int i = 0;

    for (int r = 0; r < numRows; r++)
    {
      for (int c = 0; c < numCols; c++)
      {
        if (i < str.length())
          letterBlock[r][c] = str.substring(i, i+1);
        else
          letterBlock[r][c] = "A";
        i++;
      }
    }
  }

  /** Extracts encrypted string from letterBlock in column-major order.
   *  Precondition: letterBlock has been filled
   *  @return the encrypted string from letterBlock
   */
  private String encryptBlock()
  {
    String str = "";

    for (int c = 0; c < numCols; c++)
      for (int r = 0; r < numRows; r++)
        str += letterBlock[r][c];

    return str;
  }

  
  public String encryptMessage(String message)
  {
    /**if (message.length() == 0)
    {
      return "";
    }
    fillBlock(message);
    if (message.length() <=this.numRows * this.numCols)
    {
      return encryptBlock();
    }
    return (encryptBlock() + encryptMessage(message.substring(this.numRows * this.numCols)));


    String cipherText = " ";
    int index = 0;
    while (index < message.length())
    {
      fillBlock(message.substring(index));
      cipherText += encryptBlock();
      index= numRows*numCols;
    }
    return cipherText;
    **/
    String code = " ";
    int matrixSize = numRows * NumColumns; //tells me how many cells I can fill 
    int partofmessage=matrixsize;
    while (message.length()>0){
     if partofmessage > message.length(){
         partofmessage = message.length();
     fillBlock(message);
     code+= encryptedBlock();  // this is a method that the FRQ provided for you
     message = message.substring(partofmessage); // need to get the next part of the message you didn't fill inside the matrix yet  you will repeat the process again inside while loop

     }
     return code;
    {
       





    }



  }

  public static void main (String[] args)
  {
    RouteCipher c = new RouteCipher();
    c.numRows = 2;
    c.numCols = 3;
    c.letterBlock = new String[c.numRows][c.numCols];
    System.out.println("[" + c.encryptMessage("Meet at midnight") +"]");
  }
}