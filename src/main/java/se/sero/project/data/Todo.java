package se.sero.project.data;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.ws.rs.DefaultValue;
import java.io.Serializable;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue
    @Column(name = "todo_id")
    private Long id;

    @JsonBackReference
    @JoinColumn(name = "user_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    private String toDo;

    private String priority;


    protected Todo(){}


    public Todo(User user, String toDo, String priority) {
        this.user = user;
        this.toDo = toDo;
        this.priority = priority;

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
