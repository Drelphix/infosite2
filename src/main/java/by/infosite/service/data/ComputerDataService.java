package by.infosite.service.data;

import by.infosite.model.computer.Computer;
import by.infosite.model.computer.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ComputerDataService {

    @Autowired
    private ComputerRepository computerRepository;

    @Transactional
    public void save(Computer computer){
        Optional<Computer> computerOptional = computerRepository.findComputerByName(computer.getName());
        if (computerOptional.isPresent()){
            Computer computerDatabase = computerOptional.get();
            if(!computer.equals(computerDatabase)){
                computer.changeId(computerDatabase);
                computerRepository.save(computer);
            }
        } else {
            computerRepository.save(computer);
        }
    }

}
