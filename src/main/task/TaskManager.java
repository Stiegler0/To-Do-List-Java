package main.task;
import java.time.LocalDateTime;
import java.util.*;
import java.io.*;

// classe pour gérer les opérations: ajout, ....
public class TaskManager {
    private Scanner scan = new Scanner(System.in);

    //ndiro array list tant que attribut de classe 7sn ma variable local f method
    private ArrayList<Task> taskList = new ArrayList<>();
    public void addtask(int id, String name, String description, LocalDateTime creationtime, String formatedDate){
        // add method in ArrayList class:
        //taskList.add(Task.ob);
        Task newtask = new Task(id, name, description,creationtime, formatedDate);
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
                System.out.println("Time creation: " + tak.getFormatedDate());

                System.out.println("---------------");
            }
        }
        serializeTaskList();
    }
    public void serializeTaskList(){
        try{
            FileOutputStream fileout = new FileOutputStream("task.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(taskList);
            out.close();
            fileout.close();
            //System.out.printf("Serialization is done");
        }catch (IOException i){
            i.printStackTrace();
        }
    }
    public ArrayList<Task> loadTasks(String filename){
        ArrayList<Task> tasks = null;
        try{
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            tasks = (ArrayList<Task>) in.readObject();
            in.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public void displaytask(int taskid){
        taskList = (ArrayList<Task>) loadTasks("task.ser");
        // provide code to display the task
        for (Task tak: taskList){
            if(taskid==tak.getID()){
                System.out.println("ID: " + tak.getID());
                System.out.println("Titre: " + tak.getTitle());
                System.out.println("Description: " + tak.getDescription());
                System.out.println("Time Creation: " + tak.getCreationtime());

                System.out.println("---------------");
            }else{
                System.out.println("Task not found");
            }
        }

        //compare the id, loop through the array list and then display the convenable task
    }


    public void displayAllnonCompletedTasks() {

        taskList = (ArrayList<Task>) loadTasks("task.ser");

        for (Task tak : taskList) {
            //if (taskList != null) {
            if (tak.getCompleted() == false) {
                System.out.println("ID: " + tak.getID());
                System.out.println("Titre: " + tak.getTitle());
                System.out.println("Description: " + tak.getDescription());
                System.out.println("Status: " + tak.getCompletionStatus());
                System.out.println("---------------");
            } else {
                System.out.println("Liqte sans tache à faire");
            }
            //}else{
            // System.out.println("Liste vide");
            // }
        }
    }


    public void checkstatusofTask(int id){
        for (Task tak: taskList){
             System.out.println("ID: " + tak.getID());
             System.out.println("Titre: " + tak.getTitle());
             System.out.println("---------------");

             System.out.println("Status: "+ tak.getCompletionStatus());
             System.out.println("---------------");
             System.out.println("Want to modify its status ? [YES]/[NO]");
             String respon = scan.nextLine();
             if(respon.equalsIgnoreCase("YES")){
                 //response.equalsIgnoreCase
                 tak.setCompleted(true);
                 serializeTaskList();
             }
            System.out.println("Status: "+ tak.getCompletionStatus());
            System.out.println("---------------");


             //System.out.println(tak.getCompleted());
        }

    }

    public void displayAlltasks(){
        taskList =  loadTasks("task.ser");
        for (Task tak: taskList){
            System.out.println("ID: " + tak.getID());
            System.out.println("Titre: " + tak.getTitle());
            System.out.println("Description: " + tak.getDescription());
            System.out.println("Status: " + tak.getCompletionStatus());
            System.out.println("---------------");
        }
    }
}
