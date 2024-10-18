package org.example;

import java.util.*;
public class Stock{
    static Scanner input = new Scanner(System.in);

    static String[] cred = {"Harsha","harsha.99"};

    static String[][]sup = new String[0][2];

    static int numberOfSuppliers = 0;

    static String[]itemCategory = new String[0];

    static int numberOfItemCategories = 0;

    static String [][] addItem= new String[0][6];

    static int numberOfItems = 0;

    public static void loginPage(){
        System.out.println("\t\t\t+-------------------------+");
        System.out.println("\t\t\t|\tLOGIN PAGE            |");
        System.out.println("\t\t\t+-------------------------+");

        while (true){
            System.out.print("Username : ");
            String uname = input.next();

            if (uname.equals(cred[0])){
                //System.out.println("Username is correct...");
                System.out.println();
                break;
            }else{
                System.out.println("Invalid Username...! Please Try Again...");
                System.out.println();
            }
        }


        while(true){
            System.out.print("Password : ");
            String password = input.next();

            if(password.equals(cred[1])){
                System.out.println("Login successful...!");
                break;
            }else{
                System.out.println("Incorrect Password...! Please Try Again...");
                System.out.println();
            }
        }
        clearConsole();
        homePage();

    }


    public final static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.equals("Linux")) {
                System.out.print("\033\143");
            } else if (os.equals("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            //handle the exception
            System.err.println(e.getMessage());
        }
    }

    public static void homePage(){
        System.out.println("\t\t+------------------------------------------------------+");
        System.out.println("\t\t|\t WELCOME TO IJSE STOCK MANAGEMENT SYSTEM       |");
        System.out.println("\t\t+------------------------------------------------------+");

        System.out.println();

        System.out.println("[1] Change The Credentials\t\t[2] Supplier Manage");
        System.out.println("[3] Stock Manage\t\t\t[4] Log Out");
        System.out.println("[5] Exit The System");

        System.out.println();

        while(true){
            System.out.print("Enter an option to continue : ");
            int opt = input.nextInt();

            if(!(opt >= 1 && opt <= 5)){
                System.out.println("Please enter a correct number of an option ...!");
                System.out.println();

            }else if(opt == 1){
                clearConsole();
                credentialManage();
            }else if (opt == 4){
                logout();
            }else if (opt == 5){
                clearConsole();
                exitPage();
                break;
            }else if (opt == 2){
                clearConsole();
                supplierManage();
                break;
            }else if (opt == 3){
                clearConsole();
                stockMangement();
                break;
            }else if (opt == 4){
                clearConsole();
                loginPage();
                break;
            }else{
                break;
            }
        }
    }

    public static void exitPage(){
        while(true){
            System.out.print("Do you want to exit the system (Y/N) ? : ");
            String checkInput = input.next();

            if (checkInput.equals("y") || checkInput.equals("Y")){

                clearConsole();
                return;

            }else if(checkInput.equals("n") || checkInput.equals("N")){
                clearConsole();
                homePage();
            }else {
                System.out.println("Please enter y or n...!\n");
            }
        }
    }


    public static void credentialManage(){
        System.out.println("\t\t\t+------------------------------+");
        System.out.println("\t\t\t|\tCREDENTIAL MANAGE      |");
        System.out.println("\t\t\t+------------------------------+");

        System.out.println();
        while (true){
            System.out.print("Please enter the username to verify it's you : ");
            String vname = input.next();

            if(vname.equals(cred[0])){
                System.out.println("Hey Harsha..!");
                System.out.println();
                break;
            }else{
                System.out.println("Invalid username..! Please try again...");
                System.out.println();
            }
        }

        while (true){
            System.out.print("Enter your current password : ");
            String vpass = input.next();

            if (vpass.equals(cred[1])){
                System.out.println();
                System.out.print("Enter your new password : ");
                String npass = input.next();
                cred[1] = npass;
                System.out.println();
                System.out.println("Password changed successfully...");
                break;
            }else{
                System.out.print("Incorrect password...! Please Try Again...");
            }
        }

        while(true){
            System.out.print("Do you want to go home page (Y/N) ? : ");
            String checkInput = input.next();

            if (checkInput.equals("y") || checkInput.equals("Y")){

                clearConsole();
                homePage();
                break;

            }else if(checkInput.equals("n") || checkInput.equals("N")){
                clearConsole();
                credentialManage();
            }else {
                System.out.println("Please enter y or n...!");
            }
        }
    }

    public static void logout(){
        clearConsole();
        loginPage();
    }

    public static void supplierManage(){
        System.out.println("\t\t\t+------------------------------+");
        System.out.println("\t\t\t|\tSUPPLIER MANAGE        |");
        System.out.println("\t\t\t+------------------------------+");

        System.out.println();

        System.out.println("[1] Add Supplier\t\t[2] Update Supplier");
        System.out.println("[3] Delete Supplier\t\t[4] View Supplier");
        System.out.println("[5] Search Supplier\t\t[6] Home Page");

        System.out.println();

        while(true){
            System.out.print("Enter an option to continue : ");
            int opt = input.nextInt();

            if(!(opt >= 1 && opt <= 6)){
                System.out.println("Please enter a correct number of an option ...!");
                System.out.println();

            }else if(opt == 1){
                clearConsole();
                addSupplier();
                break;
            }else if (opt == 2){
                clearConsole();
                updateSupplier();
                break;
            }else if (opt == 3){
                clearConsole();
                deleteSupplier();
                break;
            }else if (opt == 4){
                clearConsole();
                viewSupplier();
                break;
            }else if (opt == 5){
                clearConsole();
                searchSupplier();
                break;
            }else if (opt == 6){
                clearConsole();
                homePage();
                break;
            }else{
                break;
            }
        }
    }

    public static void growSup(){
        String [][] newSup = new String[numberOfSuppliers+1][2];
        for (int i = 0; i<numberOfSuppliers; i++){
            for (int j = 0; j<sup[i].length;j++){
                newSup[i][j] = sup[i][j];

            }
        }
        sup = newSup;
    }

    public static void growItemCategory(){
        String [] newItemCategory = new String[numberOfItemCategories+1];
        for (int i = 0; i<numberOfItemCategories; i++){
            newItemCategory[i] = itemCategory[i];

        }
        itemCategory = newItemCategory;
    }



    public static void addSupplier(){
        System.out.println("\t\t\t+------------------------------+");
        System.out.println("\t\t\t|\t  ADD SUPPLIER         |");
        System.out.println("\t\t\t+------------------------------+");

        System.out.println();
        while(true){
            while(true){

                boolean idExists;

                do{
                    growSup();

                    System.out.print("Supplier ID	: ");
                    String id  = input.next();

                    idExists = false;
                    for(int i=0; i<sup.length-1; i++){

                        if (id.equals(sup[i][0])){
                            idExists = true;
                            System.out.println("Already exists, try another supplier id..!");
                            System.out.println();
                            //break;
                        }
                    }

                    if (!idExists){
                        sup[sup.length-1][0] = id;
                        numberOfSuppliers++;
                    }

                } while(idExists);


                System.out.print("Supplier Name	: ");
                String name  = input.next();
                sup[sup.length-1][1] = name;

                System.out.println();
                System.out.println(Arrays.deepToString(sup));

                System.out.print("Added Successfully..!");

                while(true){
                    System.out.print("Do you want to add another Supplier (Y/N) ? : ");
                    String checkInput2 = input.next();

                    if (checkInput2.equals("y") || checkInput2.equals("Y")){

                        clearConsole();
                        addSupplier();
                        break;

                    }else if(checkInput2.equals("n") || checkInput2.equals("N")){
                        clearConsole();
                        supplierManage();
                        return;
                    }else {
                        System.out.println();
                        System.out.println("Please enter y or n...!");

                    }

                }

            }

        }

    }

    public static void updateSupplier(){
        System.out.println("\t\t\t+------------------------------+");
        System.out.println("\t\t\t|\t UPDATE SUPPLIER       |");
        System.out.println("\t\t\t+------------------------------+");

        System.out.println();
        while(true){
            while (true){
                System.out.print("Supplier ID	: ");
                String id  = input.next();

                boolean found = false;

                for(int i=0; i<sup.length; i++){
                    if(id.equals(sup[i][0])){
                        System.out.print("Supplier Name : "+sup[i][1]);
                        System.out.println();

                        System.out.print("Enter the new supplier name : ");
                        String newName = input.next();
                        System.out.println();

                        sup[i][1] = newName;
                        found = true;
                        break;
                    }
                }

                if (!found){
                    System.out.println("Can't find supplier id..Please Try Again..!");
                    System.out.println();
                    break;
                }

                while(true){
                    System.out.print("Update  Successfully..! Do you want to update another Supplier (Y/N) ? : ");
                    String checkInput3 = input.next();

                    if (checkInput3.equals("y") || checkInput3.equals("Y")){

                        clearConsole();
                        updateSupplier();

                    }else if(checkInput3.equals("n") || checkInput3.equals("N")){
                        clearConsole();
                        supplierManage();
                        return;
                    }else {
                        System.out.println("Please enter y or n...!");
                    }
                }
            }
        }
    }


    public static void deleteSupplier(){
        System.out.println("\t\t\t+------------------------------+");
        System.out.println("\t\t\t|\t DELETE SUPPLIER       |");
        System.out.println("\t\t\t+------------------------------+");

        System.out.println();
        while(true){
            while (true){
                System.out.print("Supplier ID	: ");
                String id  = input.next();

                boolean found = false;

                for(int i=0; i<sup.length; i++){
                    if(id.equals(sup[i][0])){
                        found = true;

                        String[][] newSup = new String[sup.length-1][2];
                        int index = 0;

                        for(int j=0; j<sup.length; j++){
                            if(!id.equals(sup[j][0])) {
                                newSup[index++] = sup[j];

                            }
                        }
                        sup = newSup;
                        numberOfSuppliers--;
                        break;
                    }
                }
                System.out.println(Arrays.deepToString(sup));


                if (!found){
                    System.out.println("Can't find supplier id..Please Try Again..!");
                    System.out.println();
                    break;
                }

                while(true){
                    System.out.print("Deleted  Successfully..! Do you want to delete another Supplier (Y/N) ? : ");
                    String checkInput3 = input.next();

                    if (checkInput3.equals("y") || checkInput3.equals("Y")){

                        clearConsole();
                        updateSupplier();

                    }else if(checkInput3.equals("n") || checkInput3.equals("N")){
                        clearConsole();
                        supplierManage();

                        return;
                    }else {
                        System.out.println("Please enter y or n ...!");
                    }
                }
            }
        }
    }

    public static void viewSupplier(){
        System.out.println("\t\t\t+------------------------------+");
        System.out.println("\t\t\t|\t  VIEW SUPPLIER        |");
        System.out.println("\t\t\t+------------------------------+");

        System.out.println();

        System.out.printf("+--------------------------+----------------------------+%n");
        System.out.printf("|%-20S|%-25S|%n","	Supplier ID", "	    Supplier Name     ");
        System.out.printf("+--------------------------+----------------------------+%n");

        for (int i=0; i<sup.length; i++){

            String supId =  String.format("%-16s", sup[i][0]);
            String supName = String.format("%-19s", sup[i][1]);
            System.out.printf("|          %s|         %s|%n",supId,supName);
        }
        System.out.printf("+--------------------------+----------------------------+%n");

        while(true){
            System.out.print("Do you want to go supplier manage page (Y/N) ? : ");
            String checkInput2 = input.next();

            if (checkInput2.equals("y") || checkInput2.equals("Y")){

                clearConsole();
                supplierManage();
                break;

            }else if(checkInput2.equals("n") || checkInput2.equals("N")){
                clearConsole();

                return;
            }else {
                System.out.println();
                System.out.println("Please enter y or n ...!");

            }
        }
    }

    public static void searchSupplier(){
        System.out.println("\t\t\t+------------------------------+");
        System.out.println("\t\t\t|\t SEARCH SUPPLIER       |");
        System.out.println("\t\t\t+------------------------------+");

        System.out.println();
        while(true){
            while (true){
                System.out.print("Supplier ID	: ");
                String id  = input.next();

                boolean found = false;

                for(int i=0; i<sup.length; i++){
                    if(id.equals(sup[i][0])){
                        System.out.print("Supplier Name : "+sup[i][1]);
                        System.out.println();
                        found = true;
                        break;
                    }
                }

                if (!found){
                    System.out.println("Can't find supplier id..Please Try Again..!");
                    System.out.println();
                    break;
                }


                while(true){
                    System.out.print("Searched  Successfully..! Do you want to add another find supplier (Y/N) ? : ");
                    String checkInput3 = input.next();

                    if (checkInput3.equals("y") || checkInput3.equals("Y")){

                        clearConsole();
                        searchSupplier();

                    }else if(checkInput3.equals("n") || checkInput3.equals("N")){
                        clearConsole();
                        supplierManage();
                        return;
                    }else {
                        System.out.println();
                        System.out.println("Please enter y or n..!");
                    }
                }
            }
        }

    }

    public static void stockMangement(){
        System.out.println("\t\t\t+------------------------------+");
        System.out.println("\t\t\t|\tSTOCK MANAGEMENT       |");
        System.out.println("\t\t\t+------------------------------+");

        System.out.println();

        System.out.println("[1] Manage Item Categories\t\t[2] Add Item");
        System.out.println("[3] Get items Supplier Wise \t\t[4] View Items");
        System.out.println("[5] Rank Items Per Unit Price\t\t[6] Home Page");

        System.out.println();

        while(true){
            System.out.print("Enter an option to continue : ");
            int opt = input.nextInt();

            if(!(opt >= 1 && opt <= 6)){
                System.out.println("Please enter a correct number of an option ...!");
                System.out.println();

            }else if(opt == 1){
                clearConsole();
                manageItemCategory();
                break;
            }else if(opt == 2){
                clearConsole();
                addItem();
                break;
            }else if(opt == 3){
                clearConsole();
                GetItemSupplier();
                break;
            }else if(opt == 4){
                clearConsole();
                ViewItems();
                break;
            }else if(opt == 5){
                clearConsole();
                RankItemsPerUnitPrice();
                break;
            }else if(opt == 6){
                clearConsole();
                homePage();
                break;
            }else{
                System.out.println("Not a option please try again!\n");
            }
        }
    }

    public static void manageItemCategory(){
        System.out.println("\t\t\t+----------------------------------+");
        System.out.println("\t\t\t|\tMANAGE ITEM CATEGORY       |");
        System.out.println("\t\t\t+----------------------------------+");

        System.out.println();

        System.out.println("[1] Add New Item category\t\t[2] Delete Item Category");
        System.out.println("[3] Update Item Category \t\t[4] Stock Management");

        System.out.println();

        while(true){
            System.out.print("Enter an option to continue : ");
            int opt = input.nextInt();

            if(!(opt >= 1 && opt <= 6)){
                System.out.println("Please enter a correct number of an option ...!");
                System.out.println();

            }else if(opt == 1){
                clearConsole();
                addItemCategory();
                break;
            }else if(opt == 2){
                clearConsole();
                deleteItemCategory();
                break;
            }else if(opt == 3){
                clearConsole();
                updateItemCategory();
                break;
            }else if(opt == 4){
                clearConsole();
                stockMangement();
                break;
            }else{
                break;
            }
        }
    }

    public static void addItemCategory(){
        System.out.println("\t\t\t+-------------------------------+");
        System.out.println("\t\t\t|\tADD ITEM CATEGORY       |");
        System.out.println("\t\t\t+-------------------------------+");

        System.out.println();

        while(true){
            while(true){

                boolean cateExists;

                do{
                    growItemCategory();

                    System.out.print("Enter the new item categeory	: ");
                    String itemCat  = input.next();

                    cateExists = false;
                    for(int i=0; i<itemCategory.length-1; i++){

                        if (itemCat.equals(itemCategory[i])){
                            cateExists = true;
                            System.out.println("Already exists, try another new item category..!");
                            System.out.println();
                            break;
                        }
                    }

                    if (!cateExists){
                        itemCategory[itemCategory.length-1] = itemCat;
                        numberOfItemCategories++;
                    }

                } while(cateExists);

                System.out.println();
                System.out.println(Arrays.toString(itemCategory));

                System.out.print("Added Successfully..!");

                while(true){
                    System.out.print("Do you want to add another Category (Y/N) ? : ");
                    String checkInput = input.next();

                    if (checkInput.equals("y") || checkInput.equals("Y")){

                        clearConsole();
                        addItemCategory();
                        break;

                    }else if(checkInput.equals("n") || checkInput.equals("N")){
                        clearConsole();
                        manageItemCategory();
                        break;
                    }else {
                        System.out.println();
                        System.out.println("Please enter y or n...!");

                    }

                }
            }

        }

    }

    public static void deleteItemCategory(){
        System.out.println("\t\t\t+----------------------------------+");
        System.out.println("\t\t\t|\tDELETE ITEM CATEGORY       |");
        System.out.println("\t\t\t+----------------------------------+");

        System.out.println();

        while(true){
            while (true){
                System.out.print("Enter Category Name	: ");
                String cate  = input.next();

                boolean found = false;

                for(int i=0; i<itemCategory.length; i++){
                    if(cate.equals(itemCategory[i])){
                        found = true;

                        String[] newItemCate = new String[itemCategory.length-1];
                        int index = 0;

                        for(int j=0; j<itemCategory.length; j++){
                            if(!cate.equals(itemCategory[j])){
                                newItemCate[index++] = itemCategory[j];

                            }
                        }
                        itemCategory = newItemCate;
                        numberOfItemCategories--;
                        break;
                    }
                }
                System.out.println(Arrays.toString(itemCategory));


                if (!found){
                    System.out.println("Can't find item category name..Please Try Again..!");
                    System.out.println();
                    break;
                }

                while(true){
                    System.out.print("Deleted  Successfully..! Do you want to delete another category (Y/N) ? : ");
                    String checkInput3 = input.next();

                    if (checkInput3.equals("y") || checkInput3.equals("Y")){

                        clearConsole();
                        deleteItemCategory();
                        break;
                    }else if(checkInput3.equals("n") || checkInput3.equals("N")){
                        clearConsole();
                        manageItemCategory();
                        return;

                    }else {
                        System.out.println("Please enter y or n ...!");
                    }
                }
            }
        }
    }

    public static void updateItemCategory(){
        System.out.println("\t\t\t+----------------------------------+");
        System.out.println("\t\t\t|\tUPDATE ITEM CATEGORY       |");
        System.out.println("\t\t\t+----------------------------------+");

        System.out.println();

        while(true){
            while (true){
                System.out.print("Enter the category name : ");
                String cName  = input.next();

                boolean found = false;

                for(int i=0; i<itemCategory.length; i++){
                    if(cName.equals(itemCategory[i])){
                        System.out.print("The category name is : "+itemCategory[i]);
                        System.out.println();

                        System.out.print("Enter the new category name : ");
                        String newCName = input.next();
                        System.out.println();

                        itemCategory[i] = newCName;
                        found = true;
                        break;
                    }
                }

                if (!found){
                    System.out.println("Can't find category name...! Please Try Again..!");
                    System.out.println();
                    break;
                }

                while(true){
                    System.out.print("Update  Successfully..! Do you want to update another Category name (Y/N) ? : ");
                    String checkInput3 = input.next();

                    if (checkInput3.equals("y") || checkInput3.equals("Y")){

                        clearConsole();
                        updateItemCategory();
                        break;
                    }else if(checkInput3.equals("n") || checkInput3.equals("N")){
                        clearConsole();
                        manageItemCategory();
                        return;
                    }else {
                        System.out.println("Please enter y or n...!");
                    }
                }
            }
        }
    }

    public static void addItem(){
        System.out.println("\t\t\t+-----------------------+");
        System.out.println("\t\t\t|\t ADD ITEM       |");
        System.out.println("\t\t\t+-----------------------+");

        System.out.println();


        if(itemCategory.length==0){
            while(true){
                System.out.print("oops! it seems that u dont have any item category in the system.Do u want to add new item catagory(y/n) :");
                char opt = input.next().charAt(0);

                if(opt=='Y' || opt == 'y'){
                    clearConsole();
                    addItemCategory();
                    break;

                }else if(opt=='N' || opt == 'n'){
                    clearConsole();
                    stockMangement();
                    break;
                }else{
                    System.out.println();
                    System.out.println("Please enter a valid option");
                }
            }

        }

        if(sup.length==0){
            while(true){
                System.out.print("oops! it seems that u dont have any supplier in the system.Do u want to add new supplier.(y/n)");
                char opt = input.next().charAt(0);

                if(opt=='Y' || opt == 'y'){
                    clearConsole();
                    addSupplier();
                    break;

                }else if(opt=='N' || opt == 'n'){
                    clearConsole();
                    stockMangement();
                    break;
                }else{
                    System.out.println();
                    System.out.println("Please enter a valid option");
                }
            }
        }
        while(true){
            boolean flag=false;
            System.out.print("item code: ");
            String itemcode=input.next();

            for(int i=0;i<addItem.length;i++){
                if(itemcode.equals(addItem[i][1])){
                    flag=true;
                }
            }
            if(flag==false){

                System.out.println("\nSuppliers list:");
                System.out.printf("+--------------+--------------+----------------+%n");
                System.out.printf("|%6s   %6s %12s |%14s  |%n","#","|","SUPPLIER ID","SUPPLIER NAME");
                System.out.printf("+--------------+--------------+----------------+%n");
                for(int i =0; i<sup.length; i++){
                    System.out.printf("|%6s   %6s %12s |%14s  |%n",(i+1),"|",sup[i][0],sup[i][1]);
                }
                System.out.printf("+--------------+--------------+----------------+%n");

                addItem=grow();
                addItem[addItem.length-1][1]=itemcode;
                while(true){
                    System.out.print("Enter the supplier number: ");
                    int num=input.nextInt();
                    if(num <= sup.length){
                        addItem[addItem.length-1][0]=sup[num-1][0];
                        break;
                    }else{
                        System.out.println("Please enter the correct supplier number..!");
                    }
                }


                System.out.println(Arrays.deepToString(addItem));

                System.out.println("\nItem Categories:");
                System.out.printf("+--------------+----------------+%n");
                System.out.printf("|%8s  %5S  %12s |%n","#","|","CATEGORY NAME");
                System.out.printf("+--------------+----------------+%n");
                for(int i =0; i<itemCategory.length;i++){
                    System.out.printf("|%8s  %5S    %-8s  %3S%n",(i+1),"|",itemCategory[i],"|");
                }
                System.out.printf("+--------------+----------------+%n");
                while(true){
                    System.out.print("\nEnter the category number : ");
                    int CatNum = input.nextInt();
                    if(CatNum <= itemCategory.length){
                        addItem[addItem.length-1][2]=itemCategory[CatNum-1];
                        break;
                    }else {
                        System.out.println("Please enter the correct category number..!");

                    }
                }
                System.out.print("\nDescription : ");
                String desc=input.next();
                addItem[addItem.length-1][3] =desc;

                System.out.print("Unit Price : ");
                String price=input.next();
                addItem[addItem.length-1][4] = price;

                System.out.print("Qty on hand : ");
                String qty=input.next();
                addItem[addItem.length-1][5] =qty;

                while(true){
                    System.out.print("Added successfully! Do you want to add another Item(Y/N)? ");
                    char option=input.next().charAt(0);
                    if(option=='y'  ||  option=='Y'){
                        clearConsole();
                        addItem();
                        break;
                    }
                    if(option=='n'  || option=='N'){
                        clearConsole();
                        stockMangement();
                        return;
                    }else{
                        System.out.println("Not a option please try again!\n");
                    }
                }
            }else{
                System.out.println("Already defined this item code...!");
                System.out.println();
            }
        }
    }


    public static String[][] grow(){
        String[][] temp= new String[addItem.length+1][6];
        for (int i = 0; i < addItem.length; i++) {
            temp[i]= addItem[i];
        }
        return temp;
    }

    public static void GetItemSupplier() {

        clearConsole();

        System.out.println("+================================================================+");
        System.out.println("|                GET ITEM SUPPLIER WISE                          |");
        System.out.println("+================================================================|");

        for(String[] demo : addItem){
            System.out.println(Arrays.toString(demo));
        }


        while(true){

            System.out.println();
            System.out.print("Enter Supplier Id : ");
            String supId =input.next();

            boolean found = false;


            for (int i = 0; i < sup.length; i++) {
                if (supId.equals(sup[i][0])){
                    System.out.println("Supplier Name : " + sup[i][1] + "\n\n");


                    System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");
                    System.out.printf("|     %s    |    %s    |     %s    |     %s   |     %s      |%n", "ITEM CODE", "DESCRIPTION", "UNIT PRICE", "QTY ON HAND", "CATEGORY");
                    System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");

                    for (int j = 0; j < addItem.length; j++){
                        if (supId.equals(addItem[j][0])){
                            System.out.printf("|    %10s    |    %-10s     |    %10s     |    %10s     |   %10s      |%n", addItem[j][1], addItem[j][2], addItem[j][3], addItem[j][4], addItem[j][5]);
                        }
                    }
                    System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("Can't find supplier ID. Try again ✗");
                continue;
            }
            break;
        }


        while(true){
            System.out.print("Do you want to view agin(Y/N)  ?");
            char ch = input.next().charAt(0);

            if(ch == 'n' || ch == 'N'){
                clearConsole();
                stockMangement();
                break;

            }else if(ch == 'y' || ch == 'Y'){
                GetItemSupplier();
            }else{
                System.out.println("Please enter correct command..!\n");
            }
        }

    }
    public static void ViewItems(){
        clearConsole();
        System.out.println("+///////////////////////// View  Items /////////////////////////+");
        System.out.println();

        System.out.println();

        for (int i = 0; i < itemCategory.length; i++){
            System.out.println("\n"+itemCategory[i]+":");
            System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");
            System.out.printf("|        %s       |        %s       |        %s       |        %s      |        %s        |%n","SID","CODE","DESC","PRICE","QTY");
            System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");
            for (int j = 0; j < addItem.length; j++){
                if(itemCategory[i].equals(addItem[j][2])){
                    System.out.printf("|    %10s    |    %10s     |    %10s     |    %10s     |    %10s     |%n",addItem[j][0],addItem[j][1],addItem[j][3],addItem[j][4],addItem[j][5]);

                    System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");

                }
            }
            continue;
        }

        System.out.print("Do you want to go stock manage page?(Y/N)  ");

        char ch = input.next().charAt(0);
        if(ch == 'n' || ch == 'N'){
            clearConsole();
            ViewItems();

        }else if (ch == 'y' || ch == 'Y'){
            System.out.println();
            clearConsole();
            stockMangement();

        }

    }
    public static void RankItemsPerUnitPrice() {
        Scanner input = new Scanner(System.in);
        clearConsole();
        clearConsole();
        System.out.println("+///////////////////////// Rank  Items  Per  Unit  Price /////////////////////////+");
        System.out.println();

        for (int i = 0; i < addItem.length-1; i++){
            for (int j = 0; j < addItem.length-1; j++){
                if(Integer.parseInt(addItem[j][4])>Integer.parseInt(addItem[j+1][4])){
                    String [] temp = addItem[j+1];
                    addItem[j+1] = addItem[j];
                    addItem[j] = temp;
                }
            }
        }

        System.out.println();
        System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+-------------------+%n");
        System.out.printf("|        %s       |        %s       |        %s       |        %s      |        %s        |        %s        |%n","SID","CODE","DESC","PRICE","QTY","CAT");
        System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+-------------------+%n");

        for (int i = 0; i < addItem.length; i++){
            System.out.printf("|    %10s    |    %10s     |    %10s     |    %10s     |    %10s     |    %10s     |%n",addItem[i][0],addItem[i][1],addItem[i][3],addItem[i][4],addItem[i][5],addItem[i][2]);
        }
        System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+-------------------+%n");

        System.out.print("Do you want to go stock manage page?(Y/N)  ");

        char ch = input.next().charAt(0);
        if(ch == 'n' || ch == 'N'){
            clearConsole();
            RankItemsPerUnitPrice();
        }else if(ch == 'y' || ch == 'Y'){
            clearConsole();
            stockMangement();

        }
    }


    public static void main(String[] args){
        loginPage();

    }
}
