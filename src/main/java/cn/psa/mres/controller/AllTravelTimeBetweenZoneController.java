package cn.psa.mres.controller;

import cn.psa.mres.dto.TestMresLandTravelTimeDto;
import cn.psa.mres.entity.TestMresLandTravelTimeEntity;
import cn.psa.mres.handleResult.ReturnResult;
import cn.psa.mres.handleResult.ReturnResultGenerator;
import cn.psa.mres.service.AllTravelTimeBetweenZoneService;
import cn.psa.mres.util.ConfigHander;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/v1")
public class AllTravelTimeBetweenZoneController {

    @Autowired
    private AllTravelTimeBetweenZoneService allTravelTimeBetweenZoneService;

    private Logger logger = LogManager.getLogger(this.getClass());

    @RequestMapping(value = "/getTravelTime")
    @ResponseBody
    public ReturnResult getTravelTime( TestMresLandTravelTimeDto testMresLandTravelTimeDto)  {
        String jsonStr = allTravelTimeBetweenZoneService.getTravelTime();

        JSONArray obj= JSONObject.parseArray(jsonStr);//获取jsonobject对象
        String test1 = obj.getJSONObject(0).getString("Incentive_zone_to_c");
        logger.info(test1);

        List<TestMresLandTravelTimeEntity> roleList = allTravelTimeBetweenZoneService.findAll();
        return ReturnResultGenerator.successResult(roleList);
    }

}
