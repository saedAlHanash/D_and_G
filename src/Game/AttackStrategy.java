package Game;

import java.util.ArrayList;

public interface AttackStrategy {
    Object PrioritizeUnitToAttack(ArrayList<Object> units, Unite thisUnite);
}
