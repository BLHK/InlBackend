package se.sero.project.data;

import javax.persistence.*;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    private Long id;

    //@JoinColumn(name ="user_id", nullable = false)
    @ManyToOne//(cascade = CascadeType.PERSIST)
    private User user;

    private String toDo;

    private String priority;

    protected Todo(){}


    public Todo(Long id, String toDo, String priority, User user) {
        this.id = id;
        this.toDo = toDo;
        this.priority = priority;
        this.user = user;

    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getToDo() {
        return toDo;
    }

    public String getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", id, user, toDo, priority);
    }
}
