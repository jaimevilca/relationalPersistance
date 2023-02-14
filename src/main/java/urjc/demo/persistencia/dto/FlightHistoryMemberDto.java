package urjc.demo.persistencia.dto;

import java.time.LocalDateTime;

public class FlightHistoryMemberDto {

      private String name;
      private String surname;

      private String city;

      private LocalDateTime departureDate;

      public FlightHistoryMemberDto(String name, String surname, String city, LocalDateTime departureDate) {
            this.name = name;
            this.surname = surname;
            this.city = city;
            this.departureDate = departureDate;
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

      public String getCity() {
            return city;
      }

      public void setCity(String city) {
            this.city = city;
      }

      public LocalDateTime getDepartureDate() {
            return departureDate;
      }

      public void setDepartureDate(LocalDateTime departureDate) {
            this.departureDate = departureDate;
      }


      @Override
      public String toString() {
            return "FlightHistoryMemberDto{" +
                    "name='" + name + '\'' +
                    ", surname=" + surname +
                    ", city=" + city +
                    ", departureDate=" + departureDate +
                    '}';
      }
}
