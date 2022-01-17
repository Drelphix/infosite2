package by.infosite.model.service.computer;

import by.infosite.model.entity.computer.Disk;
import by.infosite.model.entity.computer.IpAddress;

import java.util.List;

public interface IpAddressService {
    IpAddress addDisk(IpAddress ipAddress);
    boolean deleteIpAddress(IpAddress ipAddress);
    boolean deleteIpAddress(long id);
    Disk getIpAddressById(long id);
    Disk editIpAddress(IpAddress ipAddress);
    List<IpAddress> getAllIpAddresses();
}
