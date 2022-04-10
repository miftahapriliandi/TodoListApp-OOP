package repository;

import entity.TodoList;

public class TodoListRepositoryImpl implements TodoListRepository{

    public TodoList[] data = new TodoList[10];

    @Override
    public TodoList[] getAll() {
        return data;
    }

    public boolean isFull(){
        // check if model is full
        var isFull = true;
        for (int i = 0; i < data.length; i++) {
            if(data[i] == null){
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void resizeIfFull(){
        // if model full, resize array size 2x
        if(isFull()){
            var temp = data;
            data = new TodoList[data.length * 2];

            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
    }

    @Override
    public void add(TodoList todoList) {
        resizeIfFull();

        // add to data position NULL
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = todoList;
                break;
            }
        }
    }

    @Override
    public boolean rm(Integer number) {
        if((number-1) >= data.length){
            return false;
        } else if (data [number - 1] == null) {
            return false;
        } else {
            for (int i = (number -1); i < data.length; i++) {
                if (i == (data.length - 1)) {
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }
}
