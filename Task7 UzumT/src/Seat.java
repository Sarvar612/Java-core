import java.time.LocalDateTime;
import java.time.Duration;

public class Seat {
    private final String id;
    private final int row;
    private final char column;
    private final SeatClass seatClass;
    private SeatStatus status;
    private String passengerName;
    private LocalDateTime bookingTime;

    public Seat(int row, char column, SeatClass seatClass) {
        this.row = row;
        this.column = column;
        this.id = row + "" + column;
        this.seatClass = seatClass;
        this.status = SeatStatus.FREE;
    }

    public String getId() { return id; }
    public SeatClass getSeatClass() { return seatClass; }
    public SeatStatus getStatus() { return status; }
    public String getPassengerName() { return passengerName; }
    public LocalDateTime getBookingTime() { return bookingTime; }

    public boolean isFree() { return status == SeatStatus.FREE; }
    public boolean isBooked() { return status == SeatStatus.BOOKED; }

    public void book(String name) {
        if (!isFree()) throw new IllegalStateException("Seat not free.");
        this.passengerName = name;
        this.status = SeatStatus.BOOKED;
        this.bookingTime = LocalDateTime.now();
    }

    public void pay() {
        if (status != SeatStatus.BOOKED)
            throw new IllegalStateException("Seat must be booked before paying.");
        this.status = SeatStatus.PAID;
    }

    public void cancel() {
        if (status == SeatStatus.FREE)
            throw new IllegalStateException("Seat is not booked.");
        this.passengerName = null;
        this.status = SeatStatus.FREE;
        this.bookingTime = null;
    }

    public boolean isExpired() {
        if (status != SeatStatus.BOOKED || bookingTime == null) return false;
        Duration diff = Duration.between(bookingTime, LocalDateTime.now());
        return diff.toMinutes() > 24;
    }

    public void resetIfExpired() {
        if (isExpired()) cancel();
    }

    @Override
    public String toString() {
        String info = String.format("%-4s | %-8s | %-9s", id, seatClass, status);
        if (status == SeatStatus.BOOKED)
            info += " | " + passengerName + " (" + bookingTime.toLocalTime() + ")";
        else if (status == SeatStatus.PAID)
            info += " | " + passengerName + " [PAID]";
        return info;
    }
}
