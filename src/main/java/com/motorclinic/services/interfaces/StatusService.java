package com.motorclinic.services.interfaces;

import com.motorclinic.entity.Status;

import java.util.List;

public interface StatusService {

    Status createStatus(Status status);
    Status updateStatus(Status status);
    void deleteStatus(Long id);
    Status getStatusById(Long id);
    Status getStatusByMotorcycleId (Long id);
    List<Status> getAllStatuss();

}
