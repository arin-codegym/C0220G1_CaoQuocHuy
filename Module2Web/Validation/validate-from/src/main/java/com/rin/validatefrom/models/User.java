package com.rin.validatefrom.models;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.*;
import javax.validation.ConstraintViolation;
import javax.validation.constraints.*;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;

import java.sql.Date;
import java.time.*;
//import java.util.Calendar;

import java.util.Calendar;
import java.util.Set;

@Component
@Entity
@Table(name = "users")
public class User implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstName")
    @NotBlank
    @Size(min = 5, max = 45, message = "Length from 5 to 45")
    private String firstName;

    @Column(name = "lastName")
    @NotBlank
    @Size(min = 5, max = 45, message = "Length from 5 to 45")
    private String lastName;

    @Column(name = "phoneNumber")
    @Pattern(regexp = "((09|03|07|08|05)+([0-9]{8})\\b)",message = "dau so la (09|03|07|08|05) va gom 10 so" )
    private String phoneNumber;

    @Column(name = "age")
    @NotNull
    @Min(17)
    private int age;

    @Column(name = "email")
    @Pattern(regexp = "^[\\w]{1,}[\\w.+-]{0,}@[\\w-]{2,}([.][a-zA-Z]{2,}|[.][\\w-]{2,}[.][a-zA-Z]{2,})$")
    private String email;

    @Column(name = "birthday")
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date birthday;

    public Date getBirthday() {
        return  birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public User() {
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if (user.getBirthday()==null){
            errors.rejectValue("birthday","birthday.null");
        }else {
        Date date = user.getBirthday();
//        Instant instant = Instant.ofEpochMilli(date.getTime());
//        LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
            LocalDate localDate=date.toLocalDate();
        Calendar cal = Calendar.getInstance();
        ValidationUtils.rejectIfEmpty(errors, "birthday", "birthday.empty");
        if (localDate.getYear() < 1900 || localDate.getYear() > cal.get(Calendar.YEAR)) {
            errors.rejectValue("birthday", "birthday.year");
        }
    }
    }
}
