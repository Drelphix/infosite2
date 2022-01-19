package by.infosite.service.computer;

import by.infosite.model.computer.operationsystem.OperationSystem;

import java.util.List;

public interface OperationSystemService {
    OperationSystem addOperationSystem(OperationSystem operationSystem);
    boolean deleteOperationSystem(OperationSystem operationSystem);
    boolean deleteOperationSystem(long id);
    OperationSystem getOperationSystemById(long id);
    OperationSystem editOperationSystem(OperationSystem operationSystem);
    List<OperationSystem> getAllOperationSystems();
}
