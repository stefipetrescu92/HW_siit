import java.util.Random;

public class FestivalSimulation {
    public static void main(String[] args) {
        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(gate);
        statisticsThread.start();

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            TicketType ticketType = TicketType.values()[random.nextInt(TicketType.values().length)];
            FestivalAttendeeThread attendeeThread = new FestivalAttendeeThread(ticketType, gate);
            attendeeThread.start();
        }
    }
}
