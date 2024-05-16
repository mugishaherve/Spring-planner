package com.year2b.plannerproject;

import com.year2b.plannerproject.models.Todo;
import com.year2b.plannerproject.models.TodoDAO;
import com.year2b.plannerproject.utils.HibernateUtil;

public class Main {

    public static void main(String[] args) {
        TodoDAO todoDAO = new TodoDAO();

        // Create and save a new Todo
        Todo todo = new Todo();
        todo.setTitle("Learn Hibernate");
        todo.setCompleted(false);
        todoDAO.saveOrUpdate(todo);

        // Find and update the Todo
        Todo savedTodo = todoDAO.findById(todo.getId());
        if (savedTodo != null) {
            savedTodo.setCompleted(true);
            todoDAO.saveOrUpdate(savedTodo);
        }

        // Find and delete the Todo
        Todo todoToDelete = todoDAO.findById(todo.getId());
        if (todoToDelete != null) {
            todoDAO.delete(todoToDelete);
        }

        // Shutdown Hibernate
        HibernateUtil.shutdown();
    }
}

