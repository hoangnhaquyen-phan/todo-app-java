package main;

public class Task {
    private static int nextId = 1;

    private int id;
    private String title;
    private String description;
    public enum Priority {must_do, nice_to_do}
    private Priority prio;
    private boolean isDone;
    
    

    public Task(String title, String description, Priority prio) {
        this.id = nextId;
        nextId++;
        
        this.title = title;
        this.description = description;
        this.prio = prio;
        this.isDone = false;
    }

   //encapsulation for id
   public int getId() {
    return id;
   }

   //encapsulation for title
   public String getTitle() {
        return title;
   }
   public void setTitle(String title) {
        if (title != null && !title.isBlank()) {
            this.title = title;
        }
   }
   //encapsulation for description
   public String getDescription() {
    return description;
   }
   public void setDescription(String description) {
        if (description != null && !description.isBlank()) {
            this.description = description;
        }
   }
   //encapsulation for priority
   public Priority getPrio() {
    return prio; 
   }
   public void setPrio(Priority prio) {
    if(prio != null){
        this.prio = prio;
    }
   }
    //encapsulation for isDone
   public boolean isDone() {
        return isDone;
   }
   public void toggleDone() {
        isDone = !isDone;
   }

    @Override
    public String toString() {
        return  "ID: " + id
                + "\nTitle: " + title
                + "\nDescription: " + description
                + "\nPriority: "  + prio
                + "\nisDone: " + isDone;
    } 
}
