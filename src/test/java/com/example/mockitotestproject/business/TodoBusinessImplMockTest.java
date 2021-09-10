package com.example.mockitotestproject.business;

import com.example.mockitotestproject.api.TodoService;
import com.example.mockitotestproject.api.TodoServiceStub;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TodoBusinessImplMockTest {



    @Test
    void retrieveTodosRelatedToSpring_Positive() {
        TodoService mockTodoService = Mockito.mock(TodoService.class);
        List<String> value = Arrays.asList("Hello Spring","Learn this Spring","Session is over boy");
        Mockito.when(mockTodoService.retrieveTodos("USER")).thenReturn(value);

             TodoBusinessImpl todoBusiness = new TodoBusinessImpl(mockTodoService);
        List<String> filteredTodos = todoBusiness.RetrieveTodosRelatedToSpring("USER");
        assertEquals(2, filteredTodos.size());
    }


    @Test
    public void retriveTodsRelatedToSpring_StrictListCheck() {
        TodoService mockTodoService = Mockito.mock(TodoService.class);
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceStub);
        List<String> filteredTodos = todoBusiness.RetrieveTodosRelatedToSpring("Dummy");
        assertEquals(Arrays.asList("Learn Spring MVC", "Learn Spring Data"), filteredTodos);
    }
}