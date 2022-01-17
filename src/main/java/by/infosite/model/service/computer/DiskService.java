package by.infosite.model.service.computer;

import by.infosite.model.entity.computer.Disk;

import java.util.List;

public interface DiskService {

   Disk addDisk(Disk disk);
   boolean deleteDisk(Disk disk);
   boolean deleteDisk(long id);
   Disk getDiskById(long id);
   Disk editDisk(Disk disk);
   List<Disk> getAllDisks();
}
