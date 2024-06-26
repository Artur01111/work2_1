package players;

import game.RPG_Game;

public class TrickyBastard extends Hero {

    private boolean isPretendingDead;
    private int pretendRound;

    public TrickyBastard(int health, int damage, String name) {
        super(health, damage, name, SuperAbilityEnum.PRETEND_DEAD);
        this.isPretendingDead = false;
        this.pretendRound = RPG_Game.random.nextInt(5) + 1;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (RPG_Game.round == pretendRound) {
            this.isPretendingDead = true;
            System.out.println(this.getName() + " is pretending to be dead");
        } else if (RPG_Game.round == pretendRound + 1) {
            this.isPretendingDead = false;
            System.out.println(this.getName() + " is back in the fight");
        }
    }

    @Override
    public void setHealth(int health) {
        if (!isPretendingDead) {
            super.setHealth(health);
        }
    }
}
