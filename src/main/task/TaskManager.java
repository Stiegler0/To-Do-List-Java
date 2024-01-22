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
        System.out.print("Tâche ajoutée: ");
        if (taskList.isEmpty())
            System.out.println("Liste vide");
        else{
            System.out.println(newtask);
        }


    }
    public void displaytask(int taskindex){
        Task selectedTask = taskList.get(taskindex);
        System.out.println(selectedTask.gettitle());
        //compare the id, loop through the array list and then display the convenable task
    }
}
