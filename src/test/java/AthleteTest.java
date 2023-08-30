import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class AthleteTest {
    Athlete testObject = new Athlete();
    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
    }

    @Test
    public void testStandingsCalculation_Succes() throws IOException {
        String csvData = "20,Fabio Quartararo,FR,25:25,xxxxx,xxxxx,oxxxo\n" +
                "93,Marc Marquez,SP,29:02,oxxxx,xxxxo,xxxxx\n" +
                "72,Marco Bezzecchi,IT,26:10,xxxxx,xxxxx,xxxox";

        BufferedReader reader = new BufferedReader(new StringReader(csvData));
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

        String result = athletes.get(0).getAthleteName();
        assertEquals("Fabio Quartararo", result);
    }
}
