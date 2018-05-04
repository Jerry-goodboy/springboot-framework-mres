package cn.psa.mres.controller;

import cn.psa.mres.dto.TestMresLandTravelTimeDto;
import cn.psa.mres.entity.TestMresLandTravelTimeEntity;
import cn.psa.mres.handleResult.ReturnResult;
import cn.psa.mres.handleResult.ReturnResultGenerator;
import cn.psa.mres.service.AllTravelTimeBetweenZoneService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/v1")
public class AllTravelTimeBetweenZoneController {

    @Autowired
    private AllTravelTimeBetweenZoneService allTravelTimeBetweenZoneService;

    @RequestMapping(value = "/getTravelTime")
    @ResponseBody
    public ReturnResult getTravelTime( TestMresLandTravelTimeDto testMresLandTravelTimeDto)  {

        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://114.115.200.140:8080/singapore/getAllTravelTimeBetweenZone";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl , String.class);

        System.out.println("------ 接收开始 ------");
        System.out.println(response.getBody());
        System.out.println("------ 接收结束 ------");

        List<TestMresLandTravelTimeEntity> roleList = allTravelTimeBetweenZoneService.findAll();
        return ReturnResultGenerator.successResult(roleList);
    }

}
