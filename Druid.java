package players;

import game.RPG_Game;

public class Druid extends Hero {

    private boolean hasSummoned;
    private boolean isAngelSummoned;

    public Druid(int health, int damage, String name) {
        super(health, damage, name, SuperAbilityEnum.SUMMON);
        this.hasSummoned = false;
        this.isAngelSummoned = false;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (!hasSummoned) {
            if (RPG_Game.random.nextBoolean()) {
                for (Hero hero : heroes) {
                    if (hero instanceof Medic) {
                        ((Medic) hero).setHealth(((Medic) hero).getHealPoints() + 10);
                    }
                }
                isAngelSummoned = true;
                System.out.println(this.getName() + " summoned an Angel to help the heroes");
            } else {
                if (boss.getHealth() < 1500) {
                    boss.setDamage(boss.getDamage() + (boss.getDamage() / 2));
                }
                System.out.println(this.getName() + " summoned a Crow to help the boss");
            }
            hasSummoned = true;
        }
    }
}
