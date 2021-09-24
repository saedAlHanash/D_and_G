package Game.AllUnites;

import Game.AttackStrategy;
import Game.Player;
import Game.Unite;

public class PatriotMissileSystem extends Unite {
    public PatriotMissileSystem(Player owner, int x, int y, AttackStrategy attackStrategy) {
        super(Id,x, y, "S",2500,0.2f,50,400,0.9f,40,0,"a"
                , attackStrategy, owner);
        if (owner.teamID == 0)
            this.typesCanAttack += "m";
        Id++;
        checkAndSet.add(this);
    }
}
