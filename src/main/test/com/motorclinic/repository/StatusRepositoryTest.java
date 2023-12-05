package com.motorclinic.repository;

import com.motorclinic.entity.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class StatusRepositoryTest {

    @Autowired
    private StatusRepository statusRepository;

    @Test
    public void testSaveStatus() {
        // Arrange
        Status status = createStatus();

        // Act
        Status savedStatus = statusRepository.save(status);

        // Assert
        assertNotNull(savedStatus.getId());
        assertEquals("Good", savedStatus.getBrakes());
    }
    @Test
    public void testFindStatusById() {
        // Arrange
        Status status = createStatus();
        statusRepository.save(status);

        // Act
        Status foundStatus = statusRepository.findStatusById(status.getId());

        // Assert
        assertNotNull(foundStatus);
        assertEquals("Good", foundStatus.getBrakes());
    }

    @Test
    public void testUpdateStatus() {
        // Arrange
        Status status = createStatus();
        statusRepository.save(status);

        // Act
        Status retrievedStatus = statusRepository.findStatusById(status.getId());
        retrievedStatus.setBrakes("Needs Replacement");
        Status updatedStatus = statusRepository.save(retrievedStatus);

        // Assert
        assertEquals("Needs Replacement", updatedStatus.getBrakes());
    }

    @Test
    public void testDeleteStatus() {
        // Arrange
        Status status = createStatus();
        statusRepository.save(status);

        // Act
        statusRepository.deleteById(status.getId());

        // Assert
        assertNull(statusRepository.findStatusById(status.getId()));
    }
    private Status createStatus() {
        Status status = new Status();
        status.setBrakeFluid("Good");
        status.setBrakes("Good");
        status.setChain("Good");
        status.setChassis("Good");
        status.setClutch("Good");
        status.setClutchFluid("Good");
        status.setCoolant("Good");
        status.setEngine("Good");
        status.setExhaust("Good");
        status.setFootPegs("Good");
        status.setFrontTire("Good");
        status.setFuel("Good");
        status.setHorn("Good");
        status.setIndicators("Good");
        status.setIndicatorsDesc("Good");
        status.setLightsGood("Good");
        status.setMileage("Good");
        status.setMirrors("Good");
        status.setOil("Good");
        status.setOilLevel("Good");
        status.setRearTire("Good");
        status.setTank("Good");
        status.setThrottle("Good");
        status.setTransmission("Good");
        return status;
    }

}
