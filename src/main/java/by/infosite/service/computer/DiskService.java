package by.infosite.service.computer;

import by.infosite.model.computer.disk.Disk;

import java.util.List;

public interface DiskService {

   Disk addDisk(Disk disk);
   boolean deleteDisk(Disk disk);
   boolean deleteDisk(long id);
   Disk getDiskById(long id);
   Disk editDisk(Disk disk);
   List<Disk> getAllDisks();
}
