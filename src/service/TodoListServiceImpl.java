package service;

import entity.TodoList;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService{

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        TodoList[] model = todoListRepository.getAll();
        System.out.println("TODO LIST");

        for (int i = 0; i < model.length; i++) {
            var todoList = model[i];
            var no = i + 1;

            if (todoList != null) {
                System.out.println(no + ". " + todoList.getTodo());
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        TodoList todoList = new TodoList(todo);
        todoListRepository.add(todoList);
        System.out.println("Success add Todo : " + todo);
    }

    @Override
    public void rmTodoList(Integer number) {
        boolean success = todoListRepository.rm(number);
        if (success) {
            System.out.println("Success remove todo : " + number);
        } else {
            System.out.println("Failed to remove todo : " + number);
        }
    }
}
