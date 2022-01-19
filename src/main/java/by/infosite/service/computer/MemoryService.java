package by.infosite.service.computer;

import by.infosite.model.computer.memory.Memory;

import java.util.List;

public interface MemoryService {
    Memory addMemory(Memory memory);
    boolean deleteMemory(Memory memory);
    boolean deleteMemory(long id);
    Memory getMemoryById(long id);
    Memory editMemory(Memory memory);
    List<Memory> getAllMemory();
}
