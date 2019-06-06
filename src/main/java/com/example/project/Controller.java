package com.example.project;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import static com.example.project.Utils.DeserilizeObject;
import static com.example.project.Utils.SerializeObject;

@RestController
@CrossOrigin(allowedHeaders = {"*"})
public class Controller {

    @CrossOrigin
    @RequestMapping("/api/test")
    public static String test() {
        Users users=new Users();
        return "onur";
    }

    @CrossOrigin
    @RequestMapping("/api/registerUser")
    public static boolean registerUser(String name,String surname,String email,String password) throws JAXBException, IOException, SQLException {

        Users users=DeserilizeObject("object");
        if(users==null){users=new Users();}
        boolean added=users.AddUser(email,name,surname,password);
        String usrs= SerializeObject(users);
        Utils.writeFile("object",usrs);
        return added;
    }

    @CrossOrigin
    @RequestMapping("/api/loginUser")
    public static boolean loginUser(String email,String password) throws JAXBException, IOException, SQLException {
         Users users=DeserilizeObject("object");
         boolean login=users.UserLogin(email,password);
         return login;
    }

    @CrossOrigin
    @RequestMapping("/api/getList")
    public static String getList(String email){
        Users users=DeserilizeObject("object");
        User user=users.users.get(email);
        String obj=SerializeObject(user);
        return obj;
    }

    @CrossOrigin
    @RequestMapping("/api/addItem")
    public static String addItem(String email,String name,String description,String dateLine) throws IOException {
        Users users=DeserilizeObject("object");
        User user=users.users.get(email);
        ItemList itmList=user.getItemList();
        if(itmList==null){itmList=new ItemList();}
        itmList.addItems(name,description,dateLine);
        user.setItemList(itmList);
        users.users.remove(email);
        users.users.put(email,user);
        String obj=SerializeObject(users);
        Utils.writeFile("object",obj);
        String usrObj=SerializeObject(user);
        return usrObj;

    }

    @CrossOrigin
    @RequestMapping("/api/removeItem")
    public static String removeItem(String email,String name) throws IOException {
        Users users=DeserilizeObject("object");
        User user=users.users.get(email);
        ItemList itmList=user.getItemList();
        if(itmList==null){itmList=new ItemList();}
        itmList.deleteItem(name);
        user.setItemList(itmList);
        users.users.remove(email);
        users.users.put(email,user);
        String obj=SerializeObject(users);
        Utils.writeFile("object",obj);
        String usrObj=SerializeObject(user);
        return usrObj;
    }

    @CrossOrigin
    @RequestMapping("/api/updateItem")
    public static String updateItem(String email,String name) throws IOException {
        Users users=DeserilizeObject("object");
        User user=users.users.get(email);
        ItemList itmList=user.getItemList();
        if(itmList==null){itmList=new ItemList();}
        itmList.updateItem(name);
        user.setItemList(itmList);
        users.users.remove(email);
        users.users.put(email,user);
        String obj=SerializeObject(users);
        Utils.writeFile("object",obj);
        String usrObj=SerializeObject(user);
        return usrObj;
    }
}
