package com.example.project;
import java.util.HashMap;


public class Users {

    public HashMap<String,User> users=new HashMap();

    public Boolean AddUser(String email,String name,String surname,String password){
        if(!this.users.containsKey(email)) {
            User user = new User(name, surname, password);
            this.users.put(email, user);
            return true;
        }else{
            return false;
        }
    }

    public Boolean UserLogin(String email,String password){
        if(this.users.containsKey(email)){
            User user=this.users.get(email);
            if(user.getPassword().equals(password)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
