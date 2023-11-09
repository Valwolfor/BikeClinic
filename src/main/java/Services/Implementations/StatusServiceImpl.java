package Services.Implementations;

import Beans.Status;
import Repository.StatusRepository;
import Services.Interfaces.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StatusServiceImpl implements StatusService {

    private final StatusRepository repository;

    @Autowired
    public StatusServiceImpl(StatusRepository repository) {
        this.repository = repository;
    }

    @Override
    public Status createStatus(Status status) {
        return repository.save(status);
    }

    @Override
    public Status updateStatus(Status status) {
        Status oldStatus = repository.findById(status.getId()).orElse(null);
        if (oldStatus != null) {
            //no se puede cambiar id ni el kilometraje
            oldStatus.setBrakeFluid(status.getBrakeFluid());
            oldStatus.setBrakes(status.getBrakes());
            oldStatus.setChain(status.getChain());
            oldStatus.setClutch(status.getClutch());
            oldStatus.setChassis(status.getChassis());
            oldStatus.setCoolant(status.getCoolant());
            oldStatus.setEngine(status.getEngine());
            oldStatus.setCoolant(status.getCoolant());
            oldStatus.setExhaust(status.getExhaust());
            oldStatus.setFootPegs(status.getFootPegs());
            oldStatus.setFrontTire(status.getFrontTire());
            oldStatus.setFuel(status.getFuel());
            oldStatus.setHorn(status.getHorn());
            oldStatus.setIndicators(status.getIndicators());
            oldStatus.setIndicatorsDescription(status.getIndicatorsDescription());
            oldStatus.setLightsGood(status.getLightsGood());
            oldStatus.setMirrors(status.getMirrors());
            oldStatus.setOil(status.getOil());
            oldStatus.setOilLevel(status.getOilLevel());
            oldStatus.setRearTire(status.getRearTire());
            oldStatus.setTank(status.getTank());
            oldStatus.setThrottle(status.getThrottle());
            oldStatus.setTransmission(status.getTransmission());
        }
        assert oldStatus != null;
        return repository.save(oldStatus);
    }

    @Override
    public void deleteStatus(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Status getStatusById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Status getStatusByMotorcycleId(Long id) {
        return repository.findByMotorcycleId(id);
    }

    @Override
    public List<Status> getAllStatuss() {
        return repository.findAll();
    }
}
