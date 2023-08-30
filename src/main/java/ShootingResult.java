
public enum ShootingResult {
    HIT('x', 0),
    MISS('o', 10);

    final char symbol;
    private final int penalty;

    ShootingResult(char symbol, int penalty) {
        this.symbol = symbol;
        this.penalty = penalty;
    }

    public static ShootingResult fromSymbol(char symbol) {
        for (ShootingResult result : values()) {
            if (result.symbol == symbol) {
                return result;
            }
        }
        throw new IllegalArgumentException("Invalid symbol: " + symbol);
    }

    public int getPenalty() {
        return penalty;
    }
}
