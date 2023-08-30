
public class Athlete {
    private int athleteNumber;
    private String athleteName;
    private String countryCode;
    private String skiTimeResult;
    private String firstShooting;
    private String secondShooting;
    private String thirdShooting;

    public Athlete(int athleteNumber, String athleteName, String countryCode, String skiTimeResult, String firstShooting, String secondShooting, String thirdShooting) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.firstShooting = firstShooting;
        this.secondShooting = secondShooting;
        this.thirdShooting = thirdShooting;
    }

    public Athlete() {

    }

    public int calculateFinalTime() {
        int totalPenalty = calculatePenalty(firstShooting) + calculatePenalty(secondShooting) + calculatePenalty(thirdShooting);
        return convertTimeToSeconds(skiTimeResult) + totalPenalty;
    }

    private int calculatePenalty(String shootingResults) {
        int penalty = 0;
        for (char symbol : shootingResults.toCharArray()) {
            if (symbol == ShootingResult.MISS.symbol) {
                penalty += ShootingResult.MISS.getPenalty();
            }
        }
        return penalty;
    }

    private int convertTimeToSeconds(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }

    public int getAthleteNumber() {
        return athleteNumber;
    }

    public void setAthleteNumber(int athleteNumber) {
        this.athleteNumber = athleteNumber;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getSkiTimeResult() {
        return skiTimeResult;
    }

    public void setSkiTimeResult(String skiTimeResult) {
        this.skiTimeResult = skiTimeResult;
    }

    public String getFirstShooting() {
        return firstShooting;
    }

    public void setFirstShooting(String firstShooting) {
        this.firstShooting = firstShooting;
    }

    public String getSecondShooting() {
        return secondShooting;
    }

    public void setSecondShooting(String secondShooting) {
        this.secondShooting = secondShooting;
    }

    public String getThirdShooting() {
        return thirdShooting;
    }

    public void setThirdShooting(String thirdShooting) {
        this.thirdShooting = thirdShooting;
    }
}
