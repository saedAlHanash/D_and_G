package Game;

import java.util.ArrayList;
import java.util.Random;

public class RandomAttackStrategy implements AttackStrategy {
    @Override
    public Object PrioritizeUnitToAttack(ArrayList<Object> units, Unite thisUnite) {
        if (units.size() == 0)
            return null;
        else if (units.size()==1)
        {
            return units.get(0);
        }
        else {
            return units.get(new Random().nextInt(units.size() - 1));
        }
    }
}
