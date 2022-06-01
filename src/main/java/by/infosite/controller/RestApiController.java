package by.infosite.controller;

import by.infosite.model.computer.Computer;
import by.infosite.service.data.ComputerDataService;
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
    @Autowired
    ComputerDataService computerDataService;

    @RequestMapping(value = "/api/computer", consumes = "application/json", produces = "application/json")
    public void getComputerInformation(@RequestBody HashMap<String, Object> jsonMap){
        Computer computer = computerFactory.getComputer(jsonMap);
        computerDataService.save(computer);
    }
}
