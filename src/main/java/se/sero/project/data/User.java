package se.sero.project.data;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;


    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Collection<Todo> todos;

    protected User(){}

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        //this.todos = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Collection<Todo> getTodos() {
        return todos;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", id, firstName, lastName);
    }
}
