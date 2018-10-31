//  Description: The LinkedListProj class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered.

import java.io.*;

public class LinkedListProj
{
   public static void main(String[] args)
   {
      char input1;
       String inputInfo = new String();
       int operation2;
       String line = new String();

       //create a linked list to be used in this method.
       LinkedList list1 = new LinkedList();

       try
        {
         // print out the menu
         printMenu();

         // create a BufferedReader object to read input from a keyboard
         InputStreamReader isr = new InputStreamReader (System.in);
         BufferedReader stdin = new BufferedReader (isr);

         do
          {
           System.out.print("What action would you like to perform?\n");
           line = stdin.readLine().trim();  //read a line
           input1 = line.charAt(0);
           input1 = Character.toUpperCase(input1);

           if (line.length() == 1)   //check if a user entered only one character
            {
             switch (input1)
              {
               case 'A':   //Add String
                      System.out.print("Please enter a string to add:\n");
                      String str1 = stdin.readLine().trim();
                      list1.addElement(str1);
                      break;
               case 'C':   //Count the size of the linked list
                      int size = list1.size();
                      System.out.print("The size of the linked list is " + size + "\n");
                      break;
               case 'L':   //List Strings
                      System.out.print(list1.toString());
                      break;
               case 'P':   //RemoveElementsAtOddIndices
                      list1.removeElementsAtOddIndices();
                      System.out.print("Elements at odd indices removed\n");
                      break;
               case 'Q':   //Quit
                      break;
               case 'R':  //RemoveAdditionalOccurrences
                      System.out.print("Please enter a string to remove its duplicates:\n");
                      String remove = stdin.readLine().trim();
                      list1.removeAdditionalOccurrences(remove);
                      break;
                case 'S':    //Search By Index
                      System.out.print("Please enter an index to search:\n");
                      int index2 = Integer.parseInt(stdin.readLine().trim());
                      try
                        {
                            String found = (String) list1.searchByIndex(index2);
                            System.out.print("The string at the index " + index2
                                     + " is "+ found + "\n");
                        }
                      catch(IndexOutOfBoundsException ex)
                        {
                            System.out.print("The index is out of bounds\n");
                            System.out.print("There is no string at the index\n");
                        }
                      break;
                case 'T':   //Search and Increase
                      System.out.print("Please enter a string to search:\n");
                      String str2 = stdin.readLine().trim();
                      System.out.print("Please enter a number to increase:\n");
                      inputInfo = stdin.readLine().trim();
                      int howMany = Integer.parseInt(inputInfo);
                      list1.searchAndIncrease(str2, howMany);
                      break;
               case '?':   //Display Menu
                      printMenu();
                      break;
               default:
                      System.out.print("Unknown action\n");
                      break;
              }
           }
          else
           {
             System.out.print("Unknown action\n");
            }
          } while (input1 != 'Q' || line.length() != 1);
        }
       catch (IOException exception)
        {
          System.out.print("IO Exception\n");
        }
    }

    /** The method printMenu displays the menu to a user **/
    public static void printMenu()
     {
       System.out.print("Choice\t\tAction\n" +
                        "------\t\t------\n" +
                        "A\t\tAdd String\n" +
                        "C\t\tCount Its Size\n" +
                        "L\t\tList Strings\n" +
                        "P\t\tRemove Elements At Odd Indices\n" +
                        "Q\t\tQuit\n" +
                        "R\t\tRemove Additional Occurrences\n" +
                        "S\t\tSearch By Index\n" +
                        "T\t\tSearch And Increase\n" +
                        "?\t\tDisplay Help\n\n");
    } //end of printMenu()
}

