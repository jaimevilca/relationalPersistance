package urjc.demo.persistencia;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class FlightCrewMemberId implements Serializable {

    private Long flightId;
    private Long crewMemberId;

    public FlightCrewMemberId() { }
    public FlightCrewMemberId(Long flightId, Long crewMemberId) {
        this.flightId = flightId;
        this.crewMemberId = crewMemberId;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Long getCrewMemberId() {
        return crewMemberId;
    }

    public void setCrewMemberId(Long crewMemberId) {
        this.crewMemberId = crewMemberId;
    }
}
