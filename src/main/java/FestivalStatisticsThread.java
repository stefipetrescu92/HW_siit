public class FestivalStatisticsThread extends Thread{
    private final FestivalGate gate;

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
                generateStatistics();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void generateStatistics() {
        int totalAttendees = gate.ticketQueue.size();
        int fullCount = 0, fullVIPCount = 0, freePassCount = 0, oneDayCount = 0, oneDayVIPCount = 0;

        for (TicketType ticketType : gate.ticketQueue) {
            switch (ticketType) {
                case FULL:
                    fullCount++;
                    break;
                case FULL_VIP:
                    fullVIPCount++;
                    break;
                case FREE_PASS:
                    freePassCount++;
                    break;
                case ONE_DAY:
                    oneDayCount++;
                    break;
                case ONE_DAY_VIP:
                    oneDayVIPCount++;
                    break;
            }
        }

        System.out.println(totalAttendees + " people entered");
        System.out.println(fullCount + " people have full tickets");
        System.out.println(fullVIPCount + " have full VIP passes");
        System.out.println(freePassCount + " have free passes");
        System.out.println(oneDayCount + " have one-day passes");
        System.out.println(oneDayVIPCount + " have one-day VIP passes");
    }
}
