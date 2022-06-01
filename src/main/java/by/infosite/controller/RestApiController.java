package by.infosite.controller;

import by.infosite.exception.ComputerFactoryException;
import by.infosite.model.computer.Computer;
import by.infosite.service.factory.ComputerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class RestApiController {
    @Autowired
    ComputerFactory computerFactory;

    @RequestMapping(value = "/api/computer", consumes = "application/json", produces = "application/json")
    public String getComputerInformation(@RequestBody HashMap<String, Object> jsonMap){
        Computer computer = null;
        try {
            computer = computerFactory.getComputer(jsonMap);
        } catch (ComputerFactoryException e) {
            e.printStackTrace();
        }
        return computer.toString();
    }
}
