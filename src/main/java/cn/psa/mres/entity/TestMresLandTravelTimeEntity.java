package cn.psa.mres.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "test_MRES_LAND_TRAVEL_TIME", schema = "MRESTEST", catalog = "")
public class TestMresLandTravelTimeEntity {
    private String incentiveZoneFromC;
    private String incentiveZoneToC;
    private long time;
    private String lastModifiedDt;
    private String id;

    @Id
    @Column(name = "ID", nullable = false, length = 10)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "INCENTIVE_ZONE_FROM_C", nullable = false, length = 10)
    public String getIncentiveZoneFromC() {
        return incentiveZoneFromC;
    }

    public void setIncentiveZoneFromC(String incentiveZoneFromC) {
        this.incentiveZoneFromC = incentiveZoneFromC;
    }

    @Basic
    @Column(name = "INCENTIVE_ZONE_TO_C", nullable = false, length = 10)
    public String getIncentiveZoneToC() {
        return incentiveZoneToC;
    }

    public void setIncentiveZoneToC(String incentiveZoneToC) {
        this.incentiveZoneToC = incentiveZoneToC;
    }

    @Basic
    @Column(name = "TIME", nullable = false, precision = 0)
    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Basic
    @Column(name = "LAST_MODIFIED_DT", nullable = false, length = 20)
    public String getLastModifiedDt() {
        return lastModifiedDt;
    }

    public void setLastModifiedDt(String lastModifiedDt) {
        this.lastModifiedDt = lastModifiedDt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestMresLandTravelTimeEntity that = (TestMresLandTravelTimeEntity) o;
        return time == that.time &&
                Objects.equals(incentiveZoneFromC, that.incentiveZoneFromC) &&
                Objects.equals(incentiveZoneToC, that.incentiveZoneToC) &&
                Objects.equals(lastModifiedDt, that.lastModifiedDt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(incentiveZoneFromC, incentiveZoneToC, time, lastModifiedDt);
    }
}
