/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Miftah Apriliandi
 */
public class TodoListApp {

    /**
     * @param args the command line arguments
     */

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        // TODO code application logic here
        // testShowTodoList();
        // testAddTodoList();
        // testRmTodoList();
        // testInput();
        // testViewShowTodoList();
        // testViewAddTodoList();
        // testViewRmTodoList();
        viewShowTodoList();
    }

    // show Todo List
    public static void showTodoList(){
        System.out.println("TODO LIST");

        for (int i = 0; i < model.length; i++) {
            String todo = model[i];
            int no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }

    }
    
    public static void testShowTodoList(){
        model[0] = "Learn Java Basic";
        model[1] = "Study Case : TodoList App";
        showTodoList();
    }
    
    // add Todo List
    public static void addTodoList(String todo){
        // check if model is full
        Boolean isFull = true;
        for (int i = 0; i < model.length; i++) {
            if(model[i] == null){
                isFull = false;
                break;
            }
        }

        // if model full, resize array size 2x
        if(isFull){
            String[] temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // add to data position NULL
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList(){
        for (int i = 0; i < 25; i++) {
            addTodoList("Example Todo : " + i);
        }

        showTodoList();
    }
    
    // remove Todo from List
    public static boolean rmTodoList(Integer number){
        if((number-1) >= model.length){
            return false;
        } else if (model [number - 1] == null) {
            return false;
        } else {
            for (int i = (number -1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRmTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        boolean result = rmTodoList(20);
        System.out.println(result);

        result = rmTodoList(7);
        System.out.println(result);

        result = rmTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input ("Nama");
        System.out.println("Hi, " + name);
        
        var kelas = input ("Kelas");
        System.out.println(kelas);
    }
    
    // show view Todo list
    public static void viewShowTodoList(){
        while (true){
            showTodoList();
            System.out.println("Menu : ");
            System.out.println("1. Add Todo");
            System.out.println("2. Delete Todo");
            System.out.println("x. Exit");

            var input = input("Select");

            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRmTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Error : Incorrect Choice");
            }
        }
    }

    public static void testViewShowTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");
        viewShowTodoList();
    }

    // show add Todo List
    public static void viewAddTodoList(){
        System.out.println("ADD TODO LIST");

        var todo = input("Todo (Press x to cancel)");

        if(todo.equals("x")){
            //cancel
        } else{
                addTodoList(todo);
            }
    }

    public static void testViewAddTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");

        viewAddTodoList();
        showTodoList();
    }

    // show remove Todo List
    public static void viewRmTodoList(){
        System.out.println("DELETE TODO LIST");

        var number = input("Number (Press x to cancel)");

        if (number.equals("x")){
            //cancel
        } else {
            Boolean success = rmTodoList(Integer.valueOf(number));
            if (!success){
                System.out.println("Failed to delete todo list number: " +  number);
            }
        }
    }

    public static void testViewRmTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        showTodoList();

        viewRmTodoList();

        showTodoList();
    }

}
