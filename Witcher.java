package players;

public class Witcher extends Hero {

    public Witcher(int health, int damage, String name) {
        super(health, damage, name, SuperAbilityEnum.REVIVE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() <= 0) {
                hero.setHealth(this.getHealth());
                this.setHealth(0);
                System.out.println(this.getName() + " revived " + hero.getName());
                break;
            }
        }
    }
}
