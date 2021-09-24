package Game.AllUnites;

import Game.AttackStrategy;
import Game.Player;
import Game.Unite;

public class NavySEAL extends  Unite {
        public NavySEAL( Player owner, int x, int y, AttackStrategy attackStrategy) {
            super(Id,x, y, "s",400,0.2f,250,50,2,3,20,"st"
                    , attackStrategy, owner);
            this.nameType="NavySEAL";
            if (owner.teamID == 0)
                this.typesCanAttack += "m";
            Id++;
            checkAndSet.add(this);
        }
}
