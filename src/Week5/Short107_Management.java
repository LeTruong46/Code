package Week5;

import java.awt.Choice;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Short107_Management {
    private List<Short107_Reservation> reservations = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    
    private void createReservation() throws ParseException {
        System.out.println("*** Create new reservation ***");
        System.out.print("ID: ");
        String id = scanner.nextLine();
        if (!id.matches("\\d{6}")) {
            System.out.println("Data input is invalid"); 
            return;
        }
        System.out.print("Name: ");
        String name = scanner.nextLine();
        if (!name.matches("[a-zA-Z ]+")) {
            System.out.println("Data input is invalid"); 
            return;
        }
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        if (!phone.matches("\\d{12}")) {
            System.out.println("Data input is invalid"); 
            return;
        }
        System.out.print("RoomNumbers: ");
        String room = scanner.nextLine();
        if (!room.matches("\\d{4}")) {
            System.out.println("Data input is invalid"); 
            return;
        }
        System.out.print("BookingDate (dd/MM/yyyy): ");
        String bookingDate = scanner.nextLine();
        System.out.print("Need airport pick up? (Y/N): ");
        String pickUp = scanner.nextLine();
        Short107_FlightInformation flightInfo = null;
        if (pickUp.equalsIgnoreCase("Y")) {
            System.out.print("Flight: ");
            String flight = scanner.nextLine();
            System.out.print("Seat: ");
            String seat = scanner.nextLine();
            System.out.print("TimePickUp (dd/MM/yyyy hh:mma): ");
            String timePickUp = scanner.nextLine();
            flightInfo = new Short107_FlightInformation(flight, seat, timePickUp);
        }
        reservations.add(new Short107_Reservation(id, name, phone, room, bookingDate, flightInfo));
        System.out.println("Information saved successfully.");
    }
    
    public void updateReservation() {
    System.out.print("Enter Booking ID to update: ");
    String id = scanner.nextLine();
    for (Short107_Reservation res : reservations) {
        if (res.getBookingID().equals(id)) {
            System.out.println("Updating reservation for: " + res.getCustomerName());
            
            System.out.print("Enter new phone number (or press Enter to keep current: " + res.getPhoneNumber() + "): ");
            String phone = scanner.nextLine();
            if (!phone.isEmpty()) {
                res.setPhoneNumber(phone);
            }

            System.out.print("Enter new room number (or press Enter to keep current: " + res.getRoomNumber() + "): ");
            String room = scanner.nextLine();
            if (!room.isEmpty()) {
                res.setRoomNumber(room);
            }

            System.out.print("Update flight information? (Y/N): ");
            if (scanner.nextLine().equalsIgnoreCase("Y")) {
                System.out.print("New Flight Number (or press Enter to keep current): ");
                String flightNumber = scanner.nextLine();
                System.out.print("New Seat Number (or press Enter to keep current): ");
                String seatNumber = scanner.nextLine();
                System.out.print("New Time Pick Up (dd/MM/yyyy hh:mma, or press Enter to keep current): ");
                String timePickUp = scanner.nextLine();

                if (!flightNumber.isEmpty() || !seatNumber.isEmpty() || !timePickUp.isEmpty()) {
                    try {
                        String updatedFlight = flightNumber.isEmpty() ? res.getFlightInfo().getFlightNumber() : flightNumber;
                        String updatedSeat = seatNumber.isEmpty() ? res.getFlightInfo().getSeatNumber() : seatNumber;
                        String updatedTime = timePickUp.isEmpty() ? 
                            new SimpleDateFormat("dd/MM/yyyy hh:mma").format(res.getFlightInfo().getTimePickUp()) : timePickUp;
                        
                        res.setFlightInfo(new Short107_FlightInformation(updatedFlight, updatedSeat, updatedTime));
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Flight information not updated.");
                    }
                }
            }

            System.out.println("Reservation updated successfully.");
            return;
        }
    }
    System.out.println("No reservation found with given ID.");
}


    public void deleteReservation() {
        System.out.print("Enter Booking ID to delete: ");
        String id = scanner.nextLine();
        reservations.removeIf(res -> res.getBookingID().equals(id));
        System.out.println("Reservation deleted successfully.");
    }

    public void printFlightInformation() {
        for (Short107_Reservation res : reservations) {
            if (res.getFlightInfo() != null) {
                System.out.printf("ID: %s - Flight: %s - Seat: %s - Pickup Time: %s\n",
                        res.getBookingID(), res.getFlightInfo().getFlightNumber(), res.getFlightInfo().getSeatNumber(), res.getFlightInfo().getTimePickUp());
            }
        }
    }

    public void printAllReservations() {
        for (Short107_Reservation res : reservations) {
            System.out.printf("ID: %s - Name: %s - Phone: %s - Room: %s - Date: %s\n",
                    res.getBookingID(), res.getCustomerName(), res.getPhoneNumber(), res.getRoomNumber(), res.getBookingDate());
        }
    }
    public void menuReservation() throws ParseException{
        int choice;
        do {            
            System.out.println("\n*** Reservation Management ***");
            System.out.println("1. Create Reservation");
            System.out.println("2. Update Reservation");
            System.out.println("3. Delete Reservation");
            System.out.println("4. Print Flight Information");
            System.out.println("5. Print All Reservations");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createReservation();
                    break;
                case 2: 
                    updateReservation();
                    break;
                case 3:
                    deleteReservation();
                    break;
                case 4:
                    printFlightInformation();
                    break;
                case 5: 
                    printAllReservations();
                    break;
                case 6:
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 6);
    }
}
