package by.infosite.service.computer;

import by.infosite.model.computer.disk.Disk;
import by.infosite.model.computer.ipaddress.IpAddress;

import java.util.List;

public interface IpAddressService {
    IpAddress addDisk(IpAddress ipAddress);
    boolean deleteIpAddress(IpAddress ipAddress);
    boolean deleteIpAddress(long id);
    Disk getIpAddressById(long id);
    Disk editIpAddress(IpAddress ipAddress);
    List<IpAddress> getAllIpAddresses();
}
