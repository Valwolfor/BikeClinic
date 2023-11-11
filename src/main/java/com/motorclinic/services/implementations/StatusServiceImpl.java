//package com.motorclinic.services.implementations;
//
//import com.motorclinic.entity.Status;
//import com.motorclinic.repository.StatusRepository;
//import com.motorclinic.services.interfaces.StatusService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//@Transactional
//public class StatusServiceImpl implements StatusService {
//
//    private final StatusRepository repository;
//
//    @Autowired
//    public StatusServiceImpl(StatusRepository repository) {
//        this.repository = repository;
//    }
//
//    /**
//     * Crea un nuevo estado de servicio.
//     *
//     * @param status El estado a crear.
//     * @return El estado creado.
//     */
//    @Override
//    public Status createStatus(Status status) {
//        return repository.save(status);
//    }
//
//    /**
//     * Actualiza la información de un estado de servicio existente.
//     *
//     * @param status El estado con la información actualizada.
//     * @return El estado actualizado.
//     */
//    @Override
//    public Status updateStatus(Status status) {
//        Status oldStatus = repository.findById(status.getId()).orElse(null);
//        if (oldStatus != null) {
//            // No se puede cambiar el ID ni el kilometraje
//            oldStatus.setBrakeFluid(status.getBrakeFluid());
//            oldStatus.setClutchFluid(status.getClutchFluid());
//            oldStatus.setBrakes(status.getBrakes());
//            oldStatus.setChain(status.getChain());
//            oldStatus.setClutch(status.getClutch());
//            oldStatus.setChassis(status.getChassis());
//            oldStatus.setCoolant(status.getCoolant());
//            oldStatus.setEngine(status.getEngine());
//            oldStatus.setCoolant(status.getCoolant());
//            oldStatus.setExhaust(status.getExhaust());
//            oldStatus.setFootPegs(status.getFootPegs());
//            oldStatus.setFrontTire(status.getFrontTire());
//            oldStatus.setFuel(status.getFuel());
//            oldStatus.setHorn(status.getHorn());
//            oldStatus.setIndicators(status.getIndicators());
//            oldStatus.setIndicatorsDescription(status.getIndicatorsDescription());
//            oldStatus.setLightsGood(status.getLightsGood());
//            oldStatus.setMirrors(status.getMirrors());
//            oldStatus.setOil(status.getOil());
//            oldStatus.setOilLevel(status.getOilLevel());
//            oldStatus.setRearTire(status.getRearTire());
//            oldStatus.setTank(status.getTank());
//            oldStatus.setThrottle(status.getThrottle());
//            oldStatus.setTransmission(status.getTransmission());
//        }
//        assert oldStatus != null;
//        return repository.save(oldStatus);
//    }
//
//    /**
//     * Elimina un estado de servicio por su ID.
//     *
//     * @param id El ID del estado a eliminar.
//     */
//    @Override
//    public void deleteStatus(Long id) {
//        repository.deleteById(id);
//    }
//
//    /**
//     * Obtiene un estado de servicio por su ID.
//     *
//     * @param id El ID del estado a obtener.
//     * @return El estado de servicio encontrado.
//     */
//    @Override
//    public Status getStatusById(Long id) {
//        return repository.findStatusById(id);
//    }
//
//    /**
//     * Obtiene un estado de servicio por el ID de la motocicleta asociada.
//     *
//     * @param id El ID de la motocicleta.
//     * @return El estado de servicio encontrado.
//     */
//    @Override
//    public Status getStatusByMotorcycleId(Long id) {
//        return repository.findByMotorcycleId(id);
//    }
//
//    /**
//     * Obtiene todos los estados de servicio.
//     *
//     * @return Lista de todos los estados de servicio.
//     */
//    @Override
//    public List<Status> getAllStatuss() {
//        return repository.findAllStatus();
//    }
//}
