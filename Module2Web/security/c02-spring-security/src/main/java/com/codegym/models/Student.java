package com.codegym.models;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student implements Validator {
//public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//    @NotEmpty
//    @Pattern(regexp="(^$|[0-9]{3})")
    private String name; // findByName

//    @Min(value = 18, message = "Bat buoc phai >= 18")
//    @Range(min = 2, max = 5)
//    @Min(2)
//    @Max(5)
    private String dateOfBirth; //findByDateOfBirth


    @ManyToOne
    private ClassStudent classStudent;

    public Student() {

    }

    public Student(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public Student(Integer id, String name, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ClassStudent getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(ClassStudent classStudent) {
        this.classStudent = classStudent;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Student student = (Student) target;

        ValidationUtils.rejectIfEmpty(errors, "name", "name.xyz");
        if (student.name.length() < 5) {
            errors.rejectValue("name", "name.length");
        }
    }

}
