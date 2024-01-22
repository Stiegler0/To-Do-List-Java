package main;
import main.task.TaskManager;

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
        System.out.println("2.display the task: ");
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
                resultText = "Your selected option: Delete task";
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
            case 2:
                displayspecificTask();
        }

    }

    public void addTask(){
        System.out.println("Entrez ID de la tâche: ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.println("Entrez le titre de la tâche: ");
        String name = scan.nextLine();
        System.out.println("Entrez la description de la tâche: ");
        String description = scan.nextLine();
        ob1.addtask(id,name,description);
    }

    public void displayspecificTask(){
        System.out.println("entrez Id");
        //ob1.displaytask();
    }
}
