package cn.psa.mres.service;

import cn.psa.mres.entity.TestMresLandTravelTimeEntity;

import java.util.List;

public interface AllTravelTimeBetweenZoneService {
    List<TestMresLandTravelTimeEntity> findAll();
    TestMresLandTravelTimeEntity findOne(String id);
    TestMresLandTravelTimeEntity save(TestMresLandTravelTimeEntity entity);
    List<TestMresLandTravelTimeEntity> delete(String id);
    String getTravelTime();
    String fileHandler();
}
