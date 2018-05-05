package cn.psa.mres.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//@PropertySource(name="config.properties",value= {"classpath:config.properties"},ignoreResourceNotFound=false,encoding="UTF-8")
//@PropertySource(name="config.properties",value= {"file:${user.dir}/config/config.properties"},ignoreResourceNotFound=false,encoding="UTF-8")

@ConfigurationProperties(prefix="webServiceURL")

@PropertySource(name="config.properties",value= {"classpath:config.properties"},ignoreResourceNotFound=false,encoding="UTF-8")
@Component
public class ConfigHander {

    private String getAllTravelTimeBetweenZone;
    private String requestTimeRate;
    private String dirPath;

    public String getDirPath() {
        return dirPath;
    }

    public void setDirPath(String dirPath) {
        this.dirPath = dirPath;
    }

    public String getRequestTimeRate() {
        return requestTimeRate;
    }

    public void setRequestTimeRate(String requestTimeRate) {
        this.requestTimeRate = requestTimeRate;
    }

    public String getGetAllTravelTimeBetweenZone() {
        return getAllTravelTimeBetweenZone;
    }

    public void setGetAllTravelTimeBetweenZone(String getAllTravelTimeBetweenZone) {
        this.getAllTravelTimeBetweenZone = getAllTravelTimeBetweenZone;
    }

}
