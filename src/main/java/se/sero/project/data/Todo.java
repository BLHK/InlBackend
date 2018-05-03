package se.sero.project.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.ws.rs.DefaultValue;
import java.io.Serializable;

@Entity
@Table(name = "todos")
public final class Todo {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

    //@JsonBackReference
    //@JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
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
