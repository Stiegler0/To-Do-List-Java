package main;
import main.task.TaskManager;
import java.util.InputMismatchException;

import java.awt.*;
import java.util.Scanner;


public class UserInterface {
    private TaskManager ob1 = new TaskManager();
    private Scanner scan = new Scanner(System.in);

    public void start(){
        boolean isRunning = true;
        while(isRunning){
            showMenu();
            int optionNumber = readOption();
            if(optionNumber==6){
                isRunning=false;
            }else{
                executeOption(optionNumber);
            }
        }

    }
    public void showMenu(){
        System.out.println("Menu");
        System.out.println("Sélectionner une option:");
        System.out.println("1.Add new task: ");
        System.out.println("2.display a specific task: ");
        System.out.println("3.Display all non completed tasks:");
        System.out.println("4.Display all the tasks");
        System.out.println("5.Display status of your task:");
        System.out.println("6.Exit");

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
            case 5:
                resultText = "Your selected option:: Display status of your task";
                break;
            case 6:
                resultText ="see u soon <3";
                break;

            default:
                resultText = "Your selected option: Uknown option";
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
            case 5:
                status();
            case 6:
                break;
        }

    }

    public void addTask(){
        boolean input_valide = false;
        while(!input_valide){
            try{
                System.out.println("Entrez ID de la tâche: ");
                int id = scan.nextInt();
                scan.nextLine();
                System.out.println("Entrez le titre de la tâche: ");
                String name = scan.nextLine();
                System.out.println("Entrez la description de la tâche: ");
                String description = scan.nextLine();
                ob1.addtask(id,name,description);
                input_valide=true;
            }catch(InputMismatchException e){
                System.out.println("Erreur: " + e);
                scan.nextLine();
            }

        }


        //InputMismatchException
    }

    public void displayspecificTask(){
        System.out.println("Entrez Id");
        int id = scan.nextInt();
        ob1.displaytask(id);
    }

    public void displaynoncompletedtasks(){
        ob1.displayAllnonCompletedTasks();
    }
    public void displayAllTasks(){
        ob1.displayAlltasks();
    }

    public void status(){
        System.out.println("Entrez Id");
        int id = scan.nextInt();
        ob1.checkstatusofTask(id);
    }
}


