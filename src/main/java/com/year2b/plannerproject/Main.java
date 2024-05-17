package com.year2b.plannerproject;

import com.year2b.plannerproject.models.Todo;
import com.year2b.plannerproject.models.TodoDAO;
import com.year2b.plannerproject.utils.HibernateUtil;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TodoDAO todoDAO = new TodoDAO();
        Scanner scanner = new Scanner(System.in);
        while(true){
        System.out.println("Select operation:");
        System.out.println("1. Create");
        System.out.println("2. Read");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Create and save a new Todo
                    Todo todo = new Todo();
                    System.out.print("Enter Todo title: ");
                    String title = scanner.nextLine();
                    todo.setTitle(title);
                    todo.setCompleted(false);
                    todoDAO.saveOrUpdate(todo);
                    System.out.println("Todo created successfully");
                    break;
                case 2:
                    // Find and display a Todo
                    System.out.print("Enter Todo ID to find: ");
                    Long id = scanner.nextLong();
                    Todo foundTodo = todoDAO.findById(id);
                    if (foundTodo != null) {
                        System.out.println("Found Todo:");
                        System.out.println("ID: " + foundTodo.getId());
                        System.out.println("Title: " + foundTodo.getTitle());
                        System.out.println("Completed: " + foundTodo.isCompleted());
                    } else {
                        System.out.println("Todo not found");
                    }
                    break;
                case 3:
                    // Find, update, and save a Todo
                    System.out.print("Enter Todo ID to update: ");
                    Long updateId = scanner.nextLong();
                    Todo updateTodo = todoDAO.findById(updateId);
                    if (updateTodo != null) {
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter new Todo title: ");
                        String newTitle = scanner.nextLine();
                        updateTodo.setTitle(newTitle);
                        todoDAO.saveOrUpdate(updateTodo);
                        System.out.println("Todo updated successfully");
                    } else {
                        System.out.println("Todo not found");
                    }
                    break;
                case 4:
                    // Find and delete a Todo
                    System.out.print("Enter Todo ID to delete: ");
                    Long deleteId = scanner.nextLong();
                    Todo deleteTodo = todoDAO.findById(deleteId);
                    if (deleteTodo != null) {
                        todoDAO.delete(deleteTodo);
                        System.out.println("Todo deleted successfully");
                    } else {
                        System.out.println("Todo not found");
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }


        }



    }
}
