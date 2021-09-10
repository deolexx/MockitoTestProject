package com.example.mockitotestproject.business;

import com.example.mockitotestproject.api.TodoService;
import com.example.mockitotestproject.api.TodoServiceStub;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodoBusinessImplTest {
    TodoService todoServiceStub = new TodoServiceStub();
    TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceStub);
    List<String> filteredTodos = todoBusiness.RetrieveTodosRelatedToSpring("Dummy");
    @Test
    void retrieveTodosRelatedToSpring_Positive() {
        assertEquals(2,filteredTodos.size());
    }
    @Test
    public void retriveTodsRelatedToSpring_StrictListCheck(){
        assertEquals(Arrays.asList("Learn Spring MVC","Learn Spring Data"),filteredTodos);
    }
}