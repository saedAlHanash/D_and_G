package Game;

import java.io.Serializable;
import java.util.ArrayList;

public class LowestHealthAttackStrategy implements AttackStrategy, Serializable {
    Unite temp;
    @Override
    public Object PrioritizeUnitToAttack(ArrayList<Object> units,Unite thisUnite) {
        if (units.size() == 1)
            return units.get(0);
        else if (units.size() == 0)
            return null;
        else {

            for (int i = 1; i <units.size() ; i++) {
                if(units.get(i) instanceof Unite) {
                    temp=(Unite) units.get(0);
                    if (temp.unitProperty.health > ((Unite) units.get(i)).unitProperty.health)
                        temp = (Unite) units.get(i);
                }
            }
        }
        return temp;
    }
}
