package by.infosite.service.computer;

import by.infosite.model.computer.computer.Computer;

import java.util.List;

public interface ComputerService {

    Computer addComputer(Computer computer);
    boolean delete(Computer computer);
    boolean delete(long id);
    Computer getComputerByName(String name);
    Computer getComputerById(long id);
    Computer editComputer(Computer computer);
    List<Computer> getAllComputers();
}