package players;

import game.RPG_Game;

public class Boss extends GameEntity {

    private SuperAbilityEnum defence;

    public Boss(int health, int damage, String name) {
        super(health, damage, name);
    }

    public SuperAbilityEnum getDefence() {
        return defence;
    }

    public void chooseDefence() {
        SuperAbilityEnum[] variants = SuperAbilityEnum.values();
        int randomIndex = RPG_Game.random.nextInt(variants.length);
        this.defence = variants[randomIndex];
    }

    public void attackBoss(Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() <= 0) {
                continue;
            }
            if (hero instanceof Berserk) {
                int randomDamage = RPG_Game.random.nextInt(10) + 1;
                ((Berserk) hero).setBlockedDamage(randomDamage);
                hero.setHealth(hero.getHealth() - (this.getDamage() - ((Berserk) hero).getBlockedDamage()));
            } else {
                hero.setHealth(hero.getHealth() - this.getDamage());
            }
        }
    }

    @Override
    public String toString() {
        return "BOSS " + super.toString() + " Defence = " + this.defence;
    }
}
