import java.io.*;
import java.util.*;

public class Storage {
    private final File file;

    public Storage(String filename) {
        this.file = new File(filename);
    }

    public Map<String, String> load() {
        Map<String, String> map = new HashMap<>();
        if (!file.exists()) return map;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    String seatId = parts[0].trim().toUpperCase();
                    String name = parts[1].trim();
                    if (!seatId.isEmpty() && !name.isEmpty()) {
                        map.put(seatId, name);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке файла: " + e.getMessage());
        }
        return map;
    }

    public void save(Map<String, Seat> seats) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            for (Seat s : seats.values()) {
                if (s.isBooked()) {
                    String name = s.getPassengerName().replace(",", " ");
                    pw.println(s.getId() + "," + name);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении файла: " + e.getMessage());
        }
    }
}
