package by.infosite.service.factory;

import by.infosite.model.computer.Computer;

import java.util.HashMap;

public interface ComputerFactory {

    Computer  getComputer(HashMap<String, Object> computerJson) ;
}
