package Game.AllUnites;

import Game.AttackStrategy;
import Game.Player;
import Game.Unite;

public class MirageTank extends Unite {

    public MirageTank( Player owner, int x, int y, AttackStrategy attackStrategy) {
        super(0,x, y, "t",750,0.1f,1000,10,1f,15,60,"stS"
                ,attackStrategy,owner);

        if (owner.teamID == 0)
            this.typesCanAttack += "m";
        Id++;
        checkAndSet.add(this);
    }
}
