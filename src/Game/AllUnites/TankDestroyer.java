package Game.AllUnites;

import Game.AttackStrategy;
import Game.Player;
import Game.Unite;

public class TankDestroyer extends Unite {
    public TankDestroyer(Player owner, int x, int y, AttackStrategy attackStrategy) {
        super(Id, x, y, "t", 1000, 0.5f, 400, 150, 0.6f, 20, 20, "st"
                , attackStrategy, owner);
        if (owner.teamID == 0)
            this.typesCanAttack += "m";
        Id++;
        checkAndSet.add(this);
    }
}
