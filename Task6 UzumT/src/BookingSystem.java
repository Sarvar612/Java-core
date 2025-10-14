import java.util.*;

public class BookingSystem {
    private final Plane plane;
    private final Scanner scanner;

    public BookingSystem() {
        this.plane = new Plane();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\nAIRPLANE BOOKING MENU:");
            System.out.println("1. Show all seats");
            System.out.println("2. Show by class");
            System.out.println("3. Book a seat");
            System.out.println("4. Cancel booking");
            System.out.println("5. Seat info");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine().trim();
            try {
                switch (choice) {
                    case "1" -> showAllSeats();
                    case "2" -> showByClass();
                    case "3" -> bookSeat();
                    case "4" -> cancelSeat();
                    case "5" -> seatInfo();
                    case "6" -> {
                        System.out.println("👋 Goodbye!");
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
        System.out.println("\n--- ALL SEATS ---");
        plane.getAllSeats().forEach(System.out::println);
    }

    private void showByClass() {
        System.out.print("Enter class (BUSINESS/ECONOMY): ");
        try {
            SeatClass sc = SeatClass.valueOf(scanner.nextLine().trim().toUpperCase());
            plane.getSeatsByClass(sc).forEach(System.out::println);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid class name.");
        }
    }

    private void bookSeat() {
        System.out.print("Enter seat ID (e.g. 3A): ");
        String id = scanner.nextLine().trim().toUpperCase();

        if (!plane.hasSeat(id))
            throw new IllegalArgumentException("Invalid seat ID.");

        Seat seat = plane.getSeat(id);
        if (seat.isBooked())
            throw new IllegalStateException("Seat already booked by " + seat.getPassengerName());

        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine().trim();
        seat.book(name);
        System.out.println("Seat " + id + " booked successfully for " + name);
    }

    private void cancelSeat() {
        System.out.print("Enter seat ID (e.g. 3A): ");
        String id = scanner.nextLine().trim().toUpperCase();

        if (!plane.hasSeat(id))
            throw new IllegalArgumentException("Invalid seat ID.");

        Seat seat = plane.getSeat(id);
        if (!seat.isBooked())
            throw new IllegalStateException("Seat not booked.");

        seat.cancel();
        System.out.println("Seat " + id + " booking cancelled.");
    }

    private void seatInfo() {
        System.out.print("Enter seat ID (e.g. 3A): ");
        String id = scanner.nextLine().trim().toUpperCase();

        if (!plane.hasSeat(id))
            throw new IllegalArgumentException("Invalid seat ID.");

        Seat seat = plane.getSeat(id);
        System.out.println(seat);
    }

    public static void main(String[] args) {
        new BookingSystem().run();
    }
}
