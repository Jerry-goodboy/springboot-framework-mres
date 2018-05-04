package cn.psa.mres.service.impl;

import cn.psa.mres.entity.TestMresLandTravelTimeEntity;
import cn.psa.mres.repository.AllTravelTimeBetweenZoneRepository;
import cn.psa.mres.service.AllTravelTimeBetweenZoneService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class AllTravelTimeBetweenZoneServiceImpl implements AllTravelTimeBetweenZoneService {

    @Autowired
    private AllTravelTimeBetweenZoneRepository allTravelTimeBetweenZoneRepository;

    @Override
    public List<TestMresLandTravelTimeEntity> findAll() {
        return allTravelTimeBetweenZoneRepository.findAll();
    }

    @Override
    public TestMresLandTravelTimeEntity findOne(String id) {
        return allTravelTimeBetweenZoneRepository.findOne(id);
    }

    @Override
    public TestMresLandTravelTimeEntity save(TestMresLandTravelTimeEntity entity) {
        return allTravelTimeBetweenZoneRepository.save(entity);
    }

    @Override
    public List<TestMresLandTravelTimeEntity> delete(String id) {
        allTravelTimeBetweenZoneRepository.delete(id);
        return allTravelTimeBetweenZoneRepository.findAll();
    }
}
