package main.task;
import java.util.*;

// classe pour gérer les opérations: ajout, ....
public class TaskManager {
    //ndiro array list tant que attribut de classe 7sn ma variable local f method
    private ArrayList<Task> taskList = new ArrayList<>();
    public void addtask(int id, String name, String description){
        // add method in ArrayList class:
        //taskList.add(Task.ob);
        Task newtask = new Task(id, name, description);
        taskList.add(newtask);
        System.out.println("Tâche ajoutée: ");
        if (taskList.isEmpty())
            System.out.println("Liste vide");
        else{
            //System.out.println(newtask);
            //System.out.println(newtask.getTitle());
            for (Task tak : taskList) {
                System.out.println("ID: " + tak.getID());
                System.out.println("Titre: " + tak.getTitle());
                System.out.println("Description: " + tak.getDescription());
                System.out.println("---------------");
            }
        }



    }
    public void displaytask(int taskid){
        for (Task tak: taskList){
            if(taskid==tak.getID()){
                System.out.println("ID: " + tak.getID());
                System.out.println("Titre: " + tak.getTitle());
                System.out.println("Description: " + tak.getDescription());
                System.out.println("---------------");
            }else{
                System.out.println("Task not found");
            }
        }

        //compare the id, loop through the array list and then display the convenable task
    }

    public void displayAllnonCompletedTasks(){
        for (Task tak: taskList){
            if(tak.getCompleted() == false){
                System.out.println("ID: " + tak.getID());
                System.out.println("Titre: " + tak.getTitle());
                System.out.println("Description: " + tak.getDescription());
                System.out.println("Status: " + tak.getCompletionStatus());
                System.out.println("---------------");
            }
        }
    }

    public void checkstatusofTask(int id){
        for (Task tak: taskList){
             System.out.println("ID: " + tak.getID());
             System.out.println("Titre: " + tak.getTitle());
             System.out.println("---------------");

             System.out.println("Status: "+ tak.getCompletionStatus());
             System.out.println("---------------");

             //System.out.println(tak.getCompleted());
        }

    }

    public void displayAlltasks(){
        for (Task tak: taskList){
            System.out.println("ID: " + tak.getID());
            System.out.println("Titre: " + tak.getTitle());
            System.out.println("Description: " + tak.getDescription());
            System.out.println("---------------");
        }
    }
}
