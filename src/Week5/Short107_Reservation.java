    
package Week5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Short107_Reservation {
    private String bookingID;
    private String customerName;
    private String phoneNumber;
    private String roomNumber;
    private Date bookingDate;
    private Short107_FlightInformation flightInfo;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Short107_Reservation(String bookingID, String customerName, String phoneNumber, String roomNumber, String bookingDate, Short107_FlightInformation flightInfo) throws ParseException {
        this.bookingID = bookingID;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.roomNumber = roomNumber;
        this.bookingDate = dateFormat.parse(bookingDate);
        this.flightInfo = flightInfo;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Short107_FlightInformation getFlightInfo() {
        return flightInfo;
    }

    public void setFlightInfo(Short107_FlightInformation flightInfo) {
        this.flightInfo = flightInfo;
    }

    
    
    @Override
    public String toString() {
        return bookingID + " - " + customerName + " - " + phoneNumber + " - " + roomNumber + " - " + dateFormat.format(bookingDate) + " - " + (flightInfo != null ? flightInfo : "No Flight Info");
    }
}
