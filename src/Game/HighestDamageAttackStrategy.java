package Game;

import java.io.Serializable;
import java.util.ArrayList;

public class HighestDamageAttackStrategy implements AttackStrategy, Serializable {
    Unite temp;

    @Override
    public Object PrioritizeUnitToAttack(ArrayList<Object> units, Unite thisUnite) {

        if (units.size() == 1)
            return  units.get(0);
        else if (units.size() == 0)
            return null;
        else {

            temp = (Unite) units.get(0);
            for (int i = 1; i < units.size(); i++) {
                if(units.get(i) instanceof Unite) {
                    if (thisUnite.unitProperty.attack-temp.unitProperty.health  <
                            thisUnite.unitProperty.attack- ((Unite) units.get(i)).unitProperty.health  )
                            //((Unite) units.get(i)).unitProperty.health - thisUnite.unitProperty.attack <= 0)
                        temp = (Unite) units.get(i);
                }
            }
        }
        return temp;
    }
}
