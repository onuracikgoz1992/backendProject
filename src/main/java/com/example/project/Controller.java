package com.example.project;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.project.DefaultDbProvider;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.sql.SQLException;

@RestController
@CrossOrigin(allowedHeaders = {"*"})
public class Controller {
    ObjectMapper objectMapper=new ObjectMapper();
    @Bean
    @CrossOrigin
    @RequestMapping("/test")
    public String test() throws JAXBException, IOException, SQLException {
        return "onur";
    }
    @Bean
    @CrossOrigin
    @RequestMapping("/api/sendMessage")
    public void sendMessage() throws JAXBException, IOException, SQLException {
        DefaultDbProvider.creditRequest("3149026234");
    }


}
