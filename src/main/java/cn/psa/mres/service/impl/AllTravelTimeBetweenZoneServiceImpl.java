package cn.psa.mres.service.impl;

import cn.psa.mres.entity.TestMresLandTravelTimeEntity;
import cn.psa.mres.repository.AllTravelTimeBetweenZoneRepository;
import cn.psa.mres.service.AllTravelTimeBetweenZoneService;
import cn.psa.mres.util.ConfigHander;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class AllTravelTimeBetweenZoneServiceImpl implements AllTravelTimeBetweenZoneService {

    @Autowired
    private AllTravelTimeBetweenZoneRepository allTravelTimeBetweenZoneRepository;

    @Autowired
    private ConfigHander configHander;

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    private Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public String getTravelTime(){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(configHander.getGetAllTravelTimeBetweenZone() , String.class);

        logger.info("------ 接收开始 ------");
        logger.info(response.getBody());
        logger.info("------ 接收结束 ------");

        JSONArray obj= JSONObject.parseArray(response.getBody());//获取jsonobject对象
        String test1 = obj.getJSONObject(0).getString("Incentive_zone_to_c");
        logger.info(test1);

        StringBuilder sql = new StringBuilder();
        sql.append("select t.* from test_MRES_LAND_TRAVEL_TIME t");
        sql.append(" where t.INCENTIVE_ZONE_TO_C = '777'");
        List<TestMresLandTravelTimeEntity> rows = entityManager.createNativeQuery(sql.toString(),TestMresLandTravelTimeEntity.class).getResultList();
        logger.info(rows.get(0).getIncentiveZoneToC());

        return response.getBody();
    }

    @Override
    public String fileHandler() {
        try{
            File file = new File(configHander.getDirPath());
            if (file.exists() && file.isDirectory()){
                File[] listFiles = file.listFiles();
                if (listFiles.length == 0) {
                    logger.info("文件夹下没有文件");
                }else {
                    for (File fi : listFiles) {
                        // 列举文件名字与大小
                        logger.info(fi.getName() + "   大小    " + fi.length() * 1.0 / 1024 + "KB");

                        List lines = FileUtils.readLines(fi, "UTF-8");
                        logger.info(lines.size());
                    }
                }
            }else {
                logger.info("文件夹不存在或者该路径为文件路径");
                return "failed";
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return "success";
    }

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
