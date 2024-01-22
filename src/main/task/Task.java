package main.task;

import jdk.jfr.Description;

// display the task
// encapsulation des détails de la tâche
//
public class Task {
    private int ID;
    private String title;
    private String Description;
    private boolean completed;

    public Task(int ID, String title, String Description){
        this.ID = ID;
        this.title = title;
        this.Description = Description;
        this.completed = false;
    }

    public int getID(){
        return ID;
    }
    public void setID(int ID){
        this.ID=ID;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }


    public String getDescription(){
        return Description;
    }
    public void setDescription(String Description){
        this.title=Description;
    }

    public boolean getCompleted(){
        return completed;
    }
    public void setCompleted(boolean completed){
        this.completed=completed;
    }

    @Override
    public String toString() {
        return "Tâche à faire, numéor:  " + ID +
                "\n\tTitre: " + title +
                "\n\tDétails: " + Description;
    }


}
