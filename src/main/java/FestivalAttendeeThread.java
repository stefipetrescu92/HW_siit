import java.util.Random;

public class FestivalAttendeeThread extends Thread{
    private final TicketType ticketType;
    private final FestivalGate gate;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.ticketType = ticketType;
        this.gate = gate;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(2000));
            gate.addTicket(ticketType);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
