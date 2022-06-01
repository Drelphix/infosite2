package by.infosite.service.factory;

import by.infosite.model.computer.Computer;
import by.infosite.model.computer.ComputerJsonField;
import by.infosite.model.computer.disk.Disk;
import by.infosite.model.computer.ipaddress.IpAddress;
import by.infosite.model.computer.networkadapter.NetworkAdapter;
import by.infosite.model.computer.operationsystem.OperationSystem;
import by.infosite.model.computer.ram.Ram;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class ComputerFactoryJson implements ComputerFactory {
    private static final String COMMA = ",";

    @Override
    public Computer getComputer(HashMap<String, Object> computerMap){
        Computer computer = new Computer();
        for (Map.Entry<String, Object> json : computerMap.entrySet()) {
            if (json.getKey().equals(ComputerJsonField.COMPUTER_JSON_PARAM)) {
                Map<String, Object> pc = getGenericParameter(json.getValue());
                for (Map.Entry<String, Object> param : pc.entrySet()) {
                    Object value = param.getValue();
                    String key = param.getKey();
                    switch (key) {
                        case ComputerJsonField.COMPUTER_NAME -> {
                            computer.setName(getStringParameter(value));
                        }
                        case ComputerJsonField.COMPUTER_OS -> {
                            Map<String, Object> osMap = getGenericParameter(value);
                            OperationSystem operationSystem = getOS(osMap);
                            operationSystem.setComputer(computer);
                            computer.setOperationSystem(operationSystem);
                        }
                        case ComputerJsonField.COMPUTER_MOTHERBOARD -> {
                            computer.setMotherboard(getStringParameter(value));
                        }
                        case ComputerJsonField.COMPUTER_CPU -> {
                            computer.setCpu(getStringParameter(value));
                        }
                        case ComputerJsonField.COMPUTER_DISKS -> {
                            ArrayList arrayList = getGenericParameter(value);

                            for (int i = 0; i < arrayList.size(); i++) {
                                Map<String, Object> diskMap = getGenericParameter(arrayList.get(i));
                                Disk disk = getDisk(diskMap);
                                disk.setComputer(computer);
                                computer.addDisk(disk);
                            }

                        }
                        case ComputerJsonField.COMPUTER_NETWORK_ADAPTER -> {
                            ArrayList arrayList = getGenericParameter(value);
                            for (int i = 0; i < arrayList.size(); i++) {
                                Map<String, Object> networkMap = getGenericParameter(arrayList.get(i));
                                NetworkAdapter networkAdapter = getNetworkAdapter(networkMap);
                                networkAdapter.setComputer(computer);
                                computer.addNetworkAdapter(networkAdapter);
                            }
                        }
                        case ComputerJsonField.COMPUTER_RAM -> {
                            ArrayList arrayList = getGenericParameter(value);
                            for (int i = 0; i < arrayList.size(); i++) {
                                Map<String, Object> ramMap = getGenericParameter((arrayList.get(i)));
                                Ram ram = getRAM(ramMap);
                                ram.setComputer(computer);
                                computer.addRAM(ram);
                            }
                        }
                    }
                }
            }
        }
        return computer;
    }

    private OperationSystem getOS(Map<String, Object> osMap) {
        var operationSystem = new OperationSystem.OSBuilder();
        for (Map.Entry<String, Object> os : osMap.entrySet()) {
            Object value = os.getValue();
            String key = os.getKey();
            switch (key) {
                case ComputerJsonField.OS_CAPTION -> {
                    operationSystem.withCaption(getStringParameter(value));
                }
                case ComputerJsonField.OS_VERSION -> {
                    operationSystem.withVersion(getStringParameter(value));
                }
                case ComputerJsonField.OS_ARCHITECTURE -> {
                    operationSystem.withArchitecture(getStringParameter(value));
                }
            }
        }
        return operationSystem.build();
    }

    private Ram getRAM(Map<String, Object> ramMap) {
        var memoryBuilder = new Ram.MemoryBuilder();
        for (Map.Entry<String, Object> ram : ramMap.entrySet()) {
            Object value = ram.getValue();
            String key = ram.getKey();
            switch (key) {
                case ComputerJsonField.MEMORY_BANK_LABEL -> {
                    memoryBuilder.withBankLabel(getStringParameter(value));
                }
                case ComputerJsonField.MEMORY_CAPACITY -> {
                    memoryBuilder.withCapacity(getStringParameter(value));
                }
                case ComputerJsonField.MEMORY_LOCATION -> {
                    memoryBuilder.withLocation(getStringParameter(value));
                }
                case ComputerJsonField.MEMORY_SPEED -> {
                    memoryBuilder.withSpeed(getShortParameter(value));
                }
            }
        }
        return memoryBuilder.build();
    }

    private Disk getDisk(Map<String, Object> diskMap) {
        var diskBuilder = new Disk.DiskBuilder();
        for (Map.Entry<String, Object> disk : diskMap.entrySet()) {
            Object value = disk.getValue();
            String key = disk.getKey();
            switch (key) {
                case ComputerJsonField.DISK_MODEL -> {
                    diskBuilder.withModel(getStringParameter(value));
                }
                case ComputerJsonField.DISK_SIZE -> {
                    diskBuilder.withSize(getStringParameter(value));
                }
                case ComputerJsonField.DISK_SERIAL_NUMBER -> {
                    diskBuilder.withSerialNumber(getStringParameter(value));
                }
                case ComputerJsonField.DISK_STATUS -> {
                    diskBuilder.withStatus(getStringParameter(value));
                }
            }
        }
        return diskBuilder.build();
    }

    private NetworkAdapter getNetworkAdapter(Map<String, Object> networkMap) {
        var networkAdapterBuilder = new NetworkAdapter.NetworkAdapterBuilder();
        NetworkAdapter networkAdapter = new NetworkAdapter();
        for (Map.Entry<String, Object> network : networkMap.entrySet()) {
            Object value = network.getValue();
            String key = network.getKey();
            switch (key) {
                case ComputerJsonField.NETWORK_ADAPTER_DESCRIPTION -> {
                    networkAdapter.setDescription(getStringParameter(value));
                }
                case ComputerJsonField.NETWORK_ADAPTER_MAC_ADDRESS -> {
                    networkAdapter.setMacAddress(getStringParameter(value));
                }
                case ComputerJsonField.NETWORK_ADAPTER_IP_ADDRESSES -> {
                    String[] ipList = getStringParameter(value).split(COMMA);
                    for (String ip : ipList) {
                        IpAddress ipAddress = new IpAddress();
                        ipAddress.setIp(ip);
                        ipAddress.setNetworkAdapter(networkAdapter);
                        networkAdapter.addIpAddress(ipAddress);
                    }
                }
            }
        }
        return networkAdapter;
    }

    private <T> T getGenericParameter(Object object) {
        return (T) object;
    }

    private String getStringParameter(Object object) {
        return object.toString();
    }

    private short getShortParameter(Object object) {
        return Short.parseShort(object.toString());
    }
}
