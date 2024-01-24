package main;
import main.task.TaskManager;
import java.util.InputMismatchException;

import java.awt.*;
import java.util.Scanner;


public class UserInterface {
    private TaskManager ob1 = new TaskManager();
    private Scanner scan = new Scanner(System.in);

    public void start(){
        showMenu();
        int optionNumber = readOption();
        System.out.println(optionNumber);
        executeOption(optionNumber);
    }
    public void showMenu(){
        System.out.println("Menu");
        System.out.println("Sélectionner une option:");
        System.out.println("1.Add new task: ");
        System.out.println("2.display a specific task: ");
        System.out.println("3.Display all non completed tasks:");
        System.out.println("3.Display all the tasks");

    }

    public int readOption(){
        int option = scan.nextInt();
        String resultText = "";
        switch (option){
            case 1:
                resultText = "Your selected option is: Add new task ";
                break;
            case 2:
                resultText = "Your selected option is: Edit task ";
                break;
            case 3:
                resultText = "Your selected option: Display all non completed tasks";
                break;
            case 4:
                resultText = "Your selected option: Display all the tasks";
                break;
            default:
                resultText = "Uknown option";
                //think abt re-display the menu
        }
        System.out.println(resultText);
        return option;
    }
    public void executeOption(int option){
        switch (option){
            case 1:
                addTask();
                break;
            case 2:
                displayspecificTask();
                break;
            case 3:
                displaynoncompletedtasks();
                break;
            case 4:
                displayAllTasks();
                break;
        }

    }

    public void addTask(){
        try{
            System.out.println("Entrez ID de la tâche: ");
            int id = scan.nextInt();
            scan.nextLine();
            System.out.println("Entrez le titre de la tâche: ");
            String name = scan.nextLine();
            System.out.println("Entrez la description de la tâche: ");
            String description = scan.nextLine();
            ob1.addtask(id,name,description);
        }catch(InputMismatchException e){
            System.out.println("Erreur");
            scan.nextLine();
        }

        //InputMismatchException
    }

    public void displayspecificTask(){
        System.out.println("entrez Id");
        int id = scan.nextInt();
        ob1.displaytask(id);
    }

    public void displaynoncompletedtasks(){
        ob1.displayAllnonCompletedTasks();
    }
    public void displayAllTasks(){
        ob1.displayAlltasks();
    }
}
