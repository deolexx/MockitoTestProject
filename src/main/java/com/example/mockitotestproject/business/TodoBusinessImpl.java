package com.example.mockitotestproject.business;

import com.example.mockitotestproject.api.TodoService;

import java.util.ArrayList;
import java.util.List;

public class TodoBusinessImpl {
  TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> RetrieveTodosRelatedToSpring(String user) {
        List<String > filterdTodos = new ArrayList<>();
        List<String> listoftodos = todoService.retrieveTodos(user);
        for (String todo : listoftodos) {
            if(todo.contains("Spring"))filterdTodos.add(todo);
        }
        return filterdTodos;
    }

}
