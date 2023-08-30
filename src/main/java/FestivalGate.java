import java.util.LinkedList;
import java.util.Queue;

public class FestivalGate {
    final Queue<TicketType> ticketQueue = new LinkedList<>();

    public synchronized void addTicket(TicketType ticketType) {
        ticketQueue.add(ticketType);
    }

    public synchronized TicketType pollTicket() {
        return ticketQueue.poll();
    }
}
