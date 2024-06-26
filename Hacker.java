package players;

import game.RPG_Game;

public class Hacker extends Hero {

    private int stealHealthAmount;
    private boolean canSteal;

    public Hacker(int health, int damage, String name, int stealHealthAmount) {
        super(health, damage, name, SuperAbilityEnum.STEAL);
        this.stealHealthAmount = stealHealthAmount;
        this.canSteal = true;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (canSteal) {
            boss.setHealth(boss.getHealth() - stealHealthAmount);
            Hero randomHero = heroes[RPG_Game.random.nextInt(heroes.length)];
            randomHero.setHealth(randomHero.getHealth() + stealHealthAmount);
            System.out.println(this.getName() + " stole " + stealHealthAmount + " health from " + boss.getName() + " and gave it to " + randomHero.getName());
            canSteal = false;
        } else {
            canSteal = true;
        }
    }
}
