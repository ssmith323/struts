package org.superbiz.struts;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListAllUsers {

    private final UserService service;

    public ListAllUsers(UserService service) {
        this.service = service;
    }


    private int id;
    private String errorMessage;
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String execute() {

        try {
            this.users = service.findAll();
        } catch (Exception e) {
            this.errorMessage = e.getMessage();
            return "failure";
        }

        return "success";
    }
}