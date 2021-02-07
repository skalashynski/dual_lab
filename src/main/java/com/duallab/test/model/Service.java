package com.duallab.test.model;

import java.time.LocalTime;
import java.util.Objects;

public class Service {
    private Company company;
    private LocalTime departure;
    private LocalTime arrival;

    public Service(Company company, LocalTime departure, LocalTime arrival) {
        this.company = company;
        this.departure = departure;
        this.arrival = arrival;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LocalTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalTime departure) {
        this.departure = departure;
    }

    public LocalTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalTime arrival) {
        this.arrival = arrival;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return company == service.company &&
                Objects.equals(departure, service.departure) &&
                Objects.equals(arrival, service.arrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, departure, arrival);
    }

    @Override
    public String toString() {
        return "Line{" +
                "company=" + company +
                ", departure=" + departure +
                ", arrival=" + arrival +
                '}';
    }
}
