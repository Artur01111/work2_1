package players;

public class Avrora extends Hero {

    private int invisibilityRounds;
    private boolean isInvisible;

    public Avrora(int health, int damage, String name) {
        super(health, damage, name, SuperAbilityEnum.INVISIBLE);
        this.invisibilityRounds = 0;
        this.isInvisible = false;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (!isInvisible && invisibilityRounds == 0) {
            isInvisible = true;
            invisibilityRounds = 2;
            System.out.println(this.getName() + " is now invisible");
        }
    }

    @Override
    public void setHealth(int health) {
        if (!isInvisible || invisibilityRounds == 0) {
            super.setHealth(health);
        }
    }

    public void decrementInvisibility() {
        if (isInvisible) {
            invisibilityRounds--;
            if (invisibilityRounds == 0) {
                isInvisible = false;
                System.out.println(this.getName() + " is no longer invisible");
            }
        }
    }
}
