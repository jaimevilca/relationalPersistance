package urjc.demo.persistencia.dto;

public class MemberTotalFlightsDto {

    private String name;
    private String surname;

    private long  totalFlights;

    private double totalTime;

    public MemberTotalFlightsDto(String name, String surname, long totalFlights, double totalTime) {
        this.name = name;
        this.surname = surname;
        this.totalFlights = totalFlights;
        this.totalTime = totalTime;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getTotalFlights() {
        return totalFlights;
    }

    public void setTotalFlights(long totalFlights) {
        this.totalFlights = totalFlights;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    @Override
    public String toString() {
        return "FlightHistoryMemberDto{" +
                "name='" + name + '\'' +
                ", surname=" + surname +
                ", totalFlights=" + totalFlights +
                ", totalTime=" + totalTime +
                '}';
    }
}
