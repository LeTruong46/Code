package Week5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Short107_FlightInformation {
    private String flightNumber;
    private String seatNumber;
    private Date timePickUp;

    public Short107_FlightInformation(String flightNumber, String seatNumber, String timePickUp) throws ParseException {
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
        this.timePickUp = new SimpleDateFormat("dd//MM/yyyy hh:mma").parse(timePickUp);
    }
    
    public Short107_FlightInformation(){
        this.flightNumber = " ";
        this.seatNumber = " ";
        this.timePickUp = new Date();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Date getTimePickUp() {
        return timePickUp;
    }

    public void setTimePickUp(Date timePickUp) {
        this.timePickUp = timePickUp;
    }
    
    
    @Override
    public String toString() {
        return flightNumber + " - " + seatNumber + " - " + new SimpleDateFormat("dd/MM/yyyy hh:mma").format(timePickUp);
    }
}
