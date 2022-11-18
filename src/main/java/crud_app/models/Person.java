package crud_app.models;

import javax.validation.constraints.*;
import java.util.Objects;

public class Person {

    int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 3, max = 15, message = "Minimum character: 3, maximum character: 15")
    String name;

    @Min(value = 0, message = "Value must be greater then zero")
    @Max(value = 100, message = "Value must be glower then 100")
    int age;

    @NotEmpty(message = "EMail should not be empty")
    @Email(message = "Email should be valid")
    String email;

    public Person() {
    }

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id
                && age == person.age
                && Objects.equals(name, person.name)
                && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, email);
    }
}
