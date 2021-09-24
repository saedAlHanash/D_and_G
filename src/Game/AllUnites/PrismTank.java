package Game.AllUnites;

import Game.AttackStrategy;
import Game.Player;
import Game.Unite;

public class PrismTank extends Unite {
    public PrismTank(Player owner, int x, int y, AttackStrategy attackStrategy) {
        super(Id,x, y, "t",1000,0.35f,300,150,0.6f,20,20,"stS"
                , attackStrategy, owner);
        if (owner.teamID == 0)
            this.typesCanAttack += "m";
        Id++;
        checkAndSet.add(this);
    }
}
