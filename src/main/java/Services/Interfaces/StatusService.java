package Services.Interfaces;

import Beans.Status;

import java.util.List;

public interface StatusService {

    Status createStatus(Status status);
    Status updateStatus(Status status);
    void deleteStatus(Long id);
    Status getStatusById(Long id);
    Status getStatusByMotorcycleId (Long id);
    List<Status> getAllStatuss();

}
