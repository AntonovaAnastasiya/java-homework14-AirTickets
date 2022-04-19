package ru.netology.domain;

import java.util.Objects;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int ticketPrice;
    private String departureAirport;
    private String arrivalAirport;
    private int travelTime;

    public Ticket() {
    }

    public Ticket(int id, int ticketPrice, String departureAirport, String arrivalAirport, int travelTime) {
        this.id = id;
        this.ticketPrice = ticketPrice;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public boolean matchDeparture(String search) {
        return this.departureAirport.contains(search);
    }

    public boolean matchArrival(String search) {
        return this.arrivalAirport.contains(search);
    }

    @Override
    public int compareTo(Ticket t) {
        return this.ticketPrice - t.ticketPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && ticketPrice == ticket.ticketPrice && travelTime == ticket.travelTime && Objects.equals(departureAirport, ticket.departureAirport) && Objects.equals(arrivalAirport, ticket.arrivalAirport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ticketPrice, departureAirport, arrivalAirport, travelTime);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", ticketPrice=" + ticketPrice +
                ", departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", travelTime=" + travelTime +
                '}';
    }
}
