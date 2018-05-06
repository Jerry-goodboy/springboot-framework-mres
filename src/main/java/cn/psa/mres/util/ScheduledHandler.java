package cn.psa.mres.util;

import cn.psa.mres.service.AllTravelTimeBetweenZoneService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;

@Component
@PropertySource(name="config.properties",value= {"classpath:config.properties"},ignoreResourceNotFound=false,encoding="UTF-8")
public class ScheduledHandler implements ApplicationRunner {

    @Autowired
    private AllTravelTimeBetweenZoneService allTravelTimeBetweenZoneService;

    private Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        logger.info("------ 项目启动 ------");
        getAllTravelTime();
    }

//    @Scheduled(cron = "0/3 * * * * ?")
//    @Scheduled(cron = "${webServiceURL.requestTimeRateCron}")

    @Scheduled(cron = "${webServiceURL.requestTimeRateCron}")
    public void getAllTravelTime() throws Exception {
        allTravelTimeBetweenZoneService.getTravelTime();
        allTravelTimeBetweenZoneService.fileHandler();
        logger.info("------ getAllTravelTime ------");
    }
}
