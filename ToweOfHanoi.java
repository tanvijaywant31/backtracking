import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;


enum Tower {
    FROM, USING, TO;
}

final class TowerPair {

    private final Tower source;
    private final Tower destination;

    public TowerPair (Tower source, Tower destination) {
        this.source = source;
        this.destination = destination;
    }

    public Tower getSource() {
        return source;
    }

    public Tower getDestination() {
        return destination;
    }
}

/**
 * BB: 7
 *
 * Complexity:
 * O (2 ^ n)
 */
public final class ToweOfHanoi {

    private ToweOfHanoi () {}

    /**
     * Solves the problem of tower of hanoi
     *
     * @param n     The number of plates
     * @return      The Set of sequential steps to take to solve the hanoi problem.
     */
    public static List<TowerPair> solve(int n) {
        if (n <= 0) throw new IllegalArgumentException("The number of plates " + n  + " should be greater than zero.");

        final List<TowerPair> moves = new ArrayList<TowerPair>();
        moveTowers(n, Tower.FROM, Tower.USING, Tower.TO, moves);
        return moves;
    }

    public static void moveTowers(int n, Tower from, Tower using, Tower to, List<TowerPair> moves) {
        if (n == 0) return;

        moveTowers(n - 1, from, to, using, moves);
        moves.add(new TowerPair(from, to));
        moveTowers(n - 1, using, from, to, moves);
    }

    public static void main(String[] args) {
        for (TowerPair getHanoi : solve(3)) {
            System.out.println(getHanoi.getSource() + " : " + getHanoi.getDestination());
        }
    }
}
