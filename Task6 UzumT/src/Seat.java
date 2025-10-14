public class Seat {
    private final String id;
    private final int row;
    private final char column;
    private final SeatClass seatClass;
    private String passengerName;

    public Seat(int row, char column, SeatClass seatClass) {
        this.row = row;
        this.column = column;
        this.id = row + "" + column;
        this.seatClass = seatClass;
    }

    public String getId() { return id; }
    public SeatClass getSeatClass() { return seatClass; }
    public boolean isBooked() { return passengerName != null; }
    public String getPassengerName() { return passengerName; }

    public void book(String name) {
        if (isBooked()) throw new IllegalStateException("Seat already booked by " + passengerName);
        this.passengerName = name;
    }

    public void cancel() {
        if (!isBooked()) throw new IllegalStateException("Seat not booked yet.");
        this.passengerName = null;
    }

    @Override
    public String toString() {
        return String.format("%-4s | %-8s | %-15s",
                id, seatClass, isBooked() ? "BOOKED by " + passengerName : "FREE");
    }
}
