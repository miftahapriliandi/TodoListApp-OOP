package view;

import service.TodoListService;
import util.InputUtil;

public class TodoListView {

    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList(){
        while (true){
            todoListService.showTodoList();

            System.out.println("Menu : ");
            System.out.println("1. Add Todo");
            System.out.println("2. Delete Todo");
            System.out.println("x. Exit");

            var input = InputUtil.input("Select");

            if (input.equals("1")) {
                addTodoList();
            } else if (input.equals("2")) {
                rmTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Error : Incorrect Choice");
            }
        }
    }

    public void addTodoList(){
        System.out.println("ADD TODO LIST");

        var todo = InputUtil.input("Todo (Press x to cancel)");

        if(todo.equals("x")){
            //cancel
        } else{
            todoListService.addTodoList(todo);
        }
    }

    public void rmTodoList(){
        System.out.println("DELETE TODO LIST");

        var number = InputUtil.input("Number (Press x to cancel)");

        if (number.equals("x")){
            //cancel
        } else {
            todoListService.rmTodoList(Integer.valueOf(number));
        }
    }

}
