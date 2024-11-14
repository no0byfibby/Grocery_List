import java.util.*;

public class GroceryList
{
    public static String [] groceryList = new String [20];
    
    public static String [] checklist = new String [20];
    
    public static void shiftList(String [] groceries){
                int nullCount = 0;
                for(int i = 0; i < 20; i++){
                    if(groceries[i] == null) 
                    {nullCount++;}
                    else if(nullCount > 0){
                        groceries[i - nullCount] = groceries[i];
                        groceries[i] = null;
                    }
                }
    }

    public static void addAnItem(String [] groceries){
        Scanner enter1 = new Scanner(System.in);
        String addItem = " ";
        String userItem = " ";
        
        System.out.println("\nPlease type the name of the item you wish to add to the list");
       
       if(enter1.hasNextLine()){
        addItem = enter1.nextLine();
        
        for(int i = 0; i < 20; i++){
            if(groceries[i] == null){continue;}
            else{
           userItem = groceries[i];
           if(userItem.equalsIgnoreCase(addItem)){System.out.println("\nItem already exists. Returning to Main Menu.\n");
               return;
           }
           else{continue;}
            }
            
       }
       } else{System.out.println("\nInvalid input. Returning to Main Menu.\n");
       enter1.next(); return;}
       
    for(int j = 0; j < 20; j++){
        if(groceries[j] == null){
        groceries[j] = addItem;
        break;
        }
        else{continue;}
        }
       
    }
    
    public static void removeAnItem(String [] groceries){
        Scanner enter2 = new Scanner(System.in);
        String removeItem = " ";
        int removeItemNum = 0;
        boolean inList = false;
        
        System.out.println("\nPlease type the name or number of the item you wish to remove from the list.");
       
        if(enter2.hasNextInt()){
           removeItemNum = enter2.nextInt();
           int print = removeItemNum;
//System.out.println("Debug: removeItemNum = " + removeItemNum);
           if(removeItemNum < 1 || removeItemNum > 20){System.out.println("\nInvalid input. Returning to Main Menu.\n"); return;}
            else{
                removeItemNum--;
                if(groceries[removeItemNum] == null){System.out.println("\nItem "+print+" not found. Returning to Main Menu.\n"); return;}
                groceries[removeItemNum] = null;
                shiftList(groceries);
                System.out.println("\nItem "+print+" successfully removed from the grocery list. Returning to Main Menu.\n"); return;
            }
           
       }
       
       else if(enter2.hasNextLine()){
        removeItem = enter2.nextLine();
//System.out.println("Debug: removeItem = " + removeItem);
        for(int i = 0; i < 20; i++){if(groceries[i] != null && groceries[i].equalsIgnoreCase(removeItem)){
            inList = true; removeItemNum = i; break;}
            else{continue;}
        }
        if(!inList){System.out.println("\nItem "+removeItem+" not found. Returning to Main Menu.\n"); return;}
        else{
            groceries[removeItemNum] = null;
            shiftList(groceries);
            System.out.println("\nItem "+removeItem+" successfully removed from the grocery list. Returning to Main Menu.\n"); return;}    
       }
       
       else {System.out.println("\nInvalid input. Returning to Main Menu.\n"); enter2.next(); return;}
    }
    
    public static void checkAnItem(String [] groceries, String [] checklist){
        
        Scanner enter3 = new Scanner(System.in);
        String checkItem = " ";
        int checkItemNum = 0;
        boolean inList = false;
        
        System.out.println("\nPlease type the name or number of the item you wish to check off from the list.");
       
        if(enter3.hasNextInt()){
           checkItemNum = enter3.nextInt();
           int print = checkItemNum;
//System.out.println("Debug: removeItemNum = " + removeItemNum);
           if(checkItemNum < 1 || checkItemNum > 20){System.out.println("\nInvalid input. Returning to Main Menu.\n"); return;}
            else{
                checkItemNum--;
                if(groceries[checkItemNum] == null){System.out.println("\nItem "+print+" not found. Returning to Main Menu.\n"); return;}
                else if(checklist[checkItemNum] == "x"){System.out.println("\nItem "+print+" is already checked off. Returning to Main Menu.\n"); return;}
                checklist[checkItemNum] = "x";
                System.out.println("\nItem "+print+" successfully checked off. Returning to Main Menu.\n"); return;
            }
           
       }
       
       else if(enter3.hasNextLine()){
        checkItem = enter3.nextLine();
//System.out.println("Debug: removeItem = " + removeItem);
        for(int i = 0; i < 20; i++){if(groceries[i] != null && groceries[i].equalsIgnoreCase(checkItem)){
            inList = true; checkItemNum = i; break;}
            else{continue;}
        }
        if(!inList){System.out.println("\nItem "+checkItem+" not found. Returning to Main Menu.\n"); return;}
        else{
            if(checklist[checkItemNum] == "x"){System.out.println("\nItem "+checkItem+" is already checked off. Returning to Main Menu.\n"); return;}
            checklist[checkItemNum] = "x";
            System.out.println("\nItem "+checkItem+" successfully checked off. Returning to Main Menu.\n"); return;    
            }
       }
       
       else {System.out.println("\nInvalid input. Returning to Main Menu.\n"); enter3.next(); return;}
    }
    
    public static void printList(String [] groceries, String [] checklist){
        int i;
        int currNum = 0;
        
        for(i = 0; i < 20; i++){
            if(groceries[i] == null){break;}
            currNum = 1 + i;
            System.out.print(currNum+". "+checklist[i]+" ");
            System.out.println(groceries[i]);
        }
        
        return;
    }
    
    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in);
        int select = 0;
        for(int i = 0; i < 20; i++){checklist[i] = "-"; groceryList[i] = null;}
        
        do
        {  
           System.out.println("\nWelcome to Grocery List Management!\n1. Add Item to your Grocery List\n2. Remove Item from your Grocery List\n3. \"Check Off\" an Item from your Grocery List\n4. Display your Grocery List\n5. Exit\n");
           System.out.println("Please enter the number of an option above");
       
       if(enter.hasNextInt()){
        select = enter.nextInt();
       }
       else{System.out.println("\nInvalid input. Please enter an integer from 1 - 5.\n");
       enter.next();
           continue;
       }

        if (select < 1 || select > 5){
        System.out.println("\nInvalid input. Please enter an integer from 1 - 5.\n");
        continue;
        }
        else{
           if (select == 1){
               addAnItem(groceryList);
               continue;}
           
           else if (select == 2){
               removeAnItem(groceryList);
               continue;}
           
           else if (select == 3){
               checkAnItem(groceryList, checklist);
               continue;}
           
           else if (select == 4){
               printList(groceryList, checklist);
               continue;}
        }

       } while (select != 5);
    }
}
