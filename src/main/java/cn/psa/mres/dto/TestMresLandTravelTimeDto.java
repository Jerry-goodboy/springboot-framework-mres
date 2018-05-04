package cn.psa.mres.dto;

public class TestMresLandTravelTimeDto {
    private String incentiveZoneFromC;
    private String incentiveZoneToC;
    private long time;
    private String lastModifiedDt;

    public String getIncentiveZoneFromC() {
        return incentiveZoneFromC;
    }

    public void setIncentiveZoneFromC(String incentiveZoneFromC) {
        this.incentiveZoneFromC = incentiveZoneFromC;
    }

    public String getIncentiveZoneToC() {
        return incentiveZoneToC;
    }

    public void setIncentiveZoneToC(String incentiveZoneToC) {
        this.incentiveZoneToC = incentiveZoneToC;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getLastModifiedDt() {
        return lastModifiedDt;
    }

    public void setLastModifiedDt(String lastModifiedDt) {
        this.lastModifiedDt = lastModifiedDt;
    }
}
