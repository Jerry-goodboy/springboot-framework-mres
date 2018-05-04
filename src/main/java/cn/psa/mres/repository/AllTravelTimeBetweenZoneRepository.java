package cn.psa.mres.repository;

import cn.psa.mres.entity.TestMresLandTravelTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface AllTravelTimeBetweenZoneRepository extends JpaRepository<TestMresLandTravelTimeEntity,String> , JpaSpecificationExecutor<TestMresLandTravelTimeEntity>, Serializable
{
}
