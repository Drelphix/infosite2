package by.infosite.model.service.computer;

import by.infosite.model.entity.computer.NetworkAdapter;

import java.util.List;

public interface NetworkAdapterService {
    NetworkAdapter addNetworkAdapter(NetworkAdapter networkAdapter);
    boolean deleteNetworkAdapter(NetworkAdapter networkAdapter);
    boolean deleteNetworkAdapter(long id);
    NetworkAdapter getNetworkAdapterById(long id);
    NetworkAdapter editNetworkAdapter(NetworkAdapter adapter);
    List<NetworkAdapter> getAllNetworkAdapters();
}
