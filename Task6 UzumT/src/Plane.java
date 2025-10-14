import java.util.*;

public class Plane {
    private final Map<String, Seat> seats = new LinkedHashMap<>();

    public Plane() {
        char[] cols = {'A','B','C','D','E','F'};
        for (int row = 1; row <= 21; row++) {
            SeatClass seatClass = (row <= 5) ? SeatClass.BUSINESS : SeatClass.ECONOMY;
            for (char col : cols) {
                Seat seat = new Seat(row, col, seatClass);
                seats.put(seat.getId().toUpperCase(), seat);
            }
        }
    }

    public Seat getSeat(String id) {
        return seats.get(id.toUpperCase());
    }

    public Collection<Seat> getAllSeats() {
        return seats.values();
    }

    public List<Seat> getSeatsByClass(SeatClass sc) {
        List<Seat> list = new ArrayList<>();
        for (Seat s : seats.values())
            if (s.getSeatClass() == sc)
                list.add(s);
        return list;
    }

    public boolean hasSeat(String id) {
        return seats.containsKey(id.toUpperCase());
    }
}
