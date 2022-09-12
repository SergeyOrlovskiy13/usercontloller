package org.example.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    int iduser;
    @NotEmpty(message = "name not be empty")
    @Size(min = 3, max = 10, message = "name must be between 2 and 10 characters")
    String username;
    @NotEmpty(message = "surname not be empty")
    String surname;
    @NotEmpty(message = "email not be empty")
    @Email(message = "email not valid")
    String email;
    @NotEmpty(message = "birthday not be empty")
    LocalDate birthday;
    String address;
    int phone;

    public int getIduser() {
        return iduser;
    }

    public String getUsername() {
        return username;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getPhone() {
        return phone;
    }
}
