import java.util.*;
import java.time.LocalDateTime;

public class BookingSystem {
    private final Plane plane;
    private final Scanner scanner = new Scanner(System.in);

    public BookingSystem(LocalDateTime flightDateTime) {
        this.plane = new Plane(flightDateTime);
    }

    public void run() {
        while (true) {
            System.out.println("\nAIRPLANE BOOKING MENU:");
            System.out.println("Flight date: " + plane.getFlightDateTime());
            System.out.println("1. Show all seats");
            System.out.println("2. Book a seat");
            System.out.println("3. Pay for a seat");
            System.out.println("4. Cancel booking");
            System.out.println("5. Seat info");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine().trim();
            try {
                switch (choice) {
                    case "1" -> showAllSeats();
                    case "2" -> bookSeat();
                    case "3" -> paySeat();
                    case "4" -> cancelSeat();
                    case "5" -> seatInfo();
                    case "6" -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("⚠" + e.getMessage());
            }
        }
    }

    private void showAllSeats() {
        System.out.println("\nALL SEATS:");
        plane.getAllSeats().forEach(System.out::println);
    }

    private void bookSeat() {
        System.out.print("Enter seat ID (e.g. 3A): ");
        String id = scanner.nextLine().trim().toUpperCase();
        if (!plane.hasSeat(id)) throw new IllegalArgumentException("Invalid seat ID.");
        Seat seat = plane.getSeat(id);
        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine().trim();
        seat.book(name);
        System.out.println("Seat " + id + " booked successfully.");
    }

    private void paySeat() {
        System.out.print("Enter seat ID (e.g. 3A): ");
        String id = scanner.nextLine().trim().toUpperCase();
        Seat seat = plane.getSeat(id);
        seat.pay();
        System.out.println("Seat " + id + " paid successfully!");
    }

    private void cancelSeat() {
        System.out.print("Enter seat ID (e.g. 3A): ");
        String id = scanner.nextLine().trim().toUpperCase();
        Seat seat = plane.getSeat(id);
        seat.cancel();
        System.out.println("Seat " + id + " booking cancelled.");
    }

    private void seatInfo() {
        System.out.print("Enter seat ID (e.g. 3A): ");
        String id = scanner.nextLine().trim().toUpperCase();
        Seat seat = plane.getSeat(id);
        System.out.println(seat);
    }

    public static void main(String[] args) {
        LocalDateTime flightDate = LocalDateTime.of(2025, 10, 15, 14, 30);
        new BookingSystem(flightDate).run();
    }
}
