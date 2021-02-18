package desy.demo.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

public class UserLoginBindingModel {
    private String email;
    private String password;

    public UserLoginBindingModel() {
    }
    @Email(message = "Email must contain '@'")
    public String getEmail() {
        return email;
    }

    public UserLoginBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @Length(min=3,max=20, message ="Password length must be between 3 and 20 characters")
    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
