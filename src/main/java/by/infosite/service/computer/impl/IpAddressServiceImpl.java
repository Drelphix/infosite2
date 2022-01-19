package by.infosite.service.computer.impl;

import by.infosite.model.computer.disk.Disk;
import by.infosite.model.computer.ipaddress.IpAddress;
import by.infosite.service.computer.IpAddressService;

import java.util.List;

public class IpAddressServiceImpl implements IpAddressService {
    @Override
    public IpAddress addDisk(IpAddress ipAddress) {
        return null;
    }

    @Override
    public boolean deleteIpAddress(IpAddress ipAddress) {
        return false;
    }

    @Override
    public boolean deleteIpAddress(long id) {
        return false;
    }

    @Override
    public Disk getIpAddressById(long id) {
        return null;
    }

    @Override
    public Disk editIpAddress(IpAddress ipAddress) {
        return null;
    }

    @Override
    public List<IpAddress> getAllIpAddresses() {
        return null;
    }

}
