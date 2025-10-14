import java.util.*;
import java.time.LocalDateTime;

public class Plane {
    private final Map<String, Seat> seats = new LinkedHashMap<>();
    private final LocalDateTime flightDateTime;

    public Plane(LocalDateTime flightDateTime) {
        this.flightDateTime = flightDateTime;
        char[] cols = {'A','B','C','D','E','F'};
        for (int row = 1; row <= 21; row++) {
            SeatClass seatClass = (row <= 5) ? SeatClass.BUSINESS : SeatClass.ECONOMY;
            for (char col : cols) {
                seats.put(row + "" + col, new Seat(row, col, seatClass));
            }
        }
    }

    public Collection<Seat> getAllSeats() {
        seats.values().forEach(Seat::resetIfExpired);
        return seats.values();
    }

    public Seat getSeat(String id) {
        Seat seat = seats.get(id.toUpperCase());
        if (seat != null) seat.resetIfExpired();
        return seat;
    }

    public LocalDateTime getFlightDateTime() {
        return flightDateTime;
    }

    public boolean hasSeat(String id) {
        return seats.containsKey(id.toUpperCase());
    }
}
