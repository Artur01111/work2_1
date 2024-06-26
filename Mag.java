package players;

import game.RPG_Game;

public class Mag extends Hero {

    private int boostAmount;

    public Mag(int health, int damage, String name, int boostAmount) {
        super(health, damage, name, SuperAbilityEnum.BOOST);
        this.boostAmount = boostAmount;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                hero.setDamage(hero.getDamage() + boostAmount);
            }
        }
        System.out.println(this.getName() + " increased attack of every hero by " + boostAmount);
    }
}
