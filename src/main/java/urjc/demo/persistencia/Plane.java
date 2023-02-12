package urjc.demo.persistencia;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String registration;
    private String manufacturer;
    private String model;
    private long flightHours;

    public Plane() {
    }

    public Plane(String registration, String manufacturer, String model) {
        this.registration = registration;
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String matricula) {
        this.registration = matricula;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String fabricante) {
        this.manufacturer = fabricante;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String modelo) {
        this.model = modelo;
    }

    public long getFlightHours() {
        return flightHours;
    }

    public void setFlightHours(long horasVuelo) {
        this.flightHours = horasVuelo;
    }
}
