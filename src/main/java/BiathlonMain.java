
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BiathlonMain {

    public static void main(String[] args) throws FileNotFoundException {
        String file = "src\\main\\resources\\input.csv";

        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<Athlete> athletes = new ArrayList<>();

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Athlete athlete = new Athlete();
                athlete.setAthleteNumber(Integer.parseInt(parts[0]));
                athlete.setAthleteName(parts[1]);
                athlete.setCountryCode(parts[2]);
                athlete.setSkiTimeResult(parts[3]);
                athlete.setFirstShooting(parts[4]);
                athlete.setSecondShooting(parts[5]);
                athlete.setThirdShooting(parts[6]);
                athletes.add(athlete);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(athletes, new AthleteComparator());

        System.out.println("Winner - " + athletes.get(0).getAthleteName() + " " + formatTime(athletes.get(0).calculateFinalTime()));
        System.out.println("Second place - " + athletes.get(1).getAthleteName() + " " + formatTime(athletes.get(1).calculateFinalTime()));
        System.out.println("Third place - " + athletes.get(2).getAthleteName() + " " + formatTime(athletes.get(2).calculateFinalTime()));
    }

    private static String formatTime(int seconds) {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        return String.format("%d:%02d", minutes, remainingSeconds);
    }
}
