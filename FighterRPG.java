abstract class Fighter {

    @Override
    public String toString() {
        return "This is a fighter.";
    }

    abstract boolean isVulnerable();

    abstract int getDamagePoints(Fighter fighter);
}

class Warrior extends Fighter {

    private static final int NORMAL_DMG = 6;
    private static final int VULNERABLE_DMG = 10;

    @Override
    public String toString() {
        return "Fighter is a Warrior.";
    }

    @Override
    public boolean isVulnerable() {
        return false;
    }

    @Override
    public int getDamagePoints(Fighter fighter) {
        return fighter.isVulnerable() ? VULNERABLE_DMG : NORMAL_DMG;
    }

}

class Wizard extends Fighter {

    private static final int UNPREPARED_DMG = 3;
    private static final int PREPARED_DMG = 12;

    private boolean spellPrepared = false;

    public void prepareSpell() {
        spellPrepared = true;
    }

    @Override
    public String toString() {
        return "Fighter is a Wizard.";
    }

    @Override
    public boolean isVulnerable() {
        return !spellPrepared;
    }

    @Override
    public int getDamagePoints(Fighter fighter) {
        return spellPrepared ? PREPARED_DMG : UNPREPARED_DMG;
    }

}

/**
 * FighterRPG
 */
public class FighterRPG {

    public static void main(String[] args) {

        Warrior warrior = new Warrior();
        Wizard wizard = new Wizard();

        // Initial states
        System.out.println("Warrior vulnerable: " + warrior.isVulnerable());
        System.out.println("Wizard vulnerable: " + wizard.isVulnerable());

        // Damage calculations
        System.out.println("Warrior damage: " + warrior.getDamagePoints(wizard));
        System.out.println("Wizard damage: " + wizard.getDamagePoints(warrior));

        // Prepare wizard's spell
        wizard.prepareSpell();

        System.out.println("\nAfter preparing spell:");

        System.out.println("Wizard vulnerable: " + wizard.isVulnerable());
        System.out.println("Warrior damage: " + warrior.getDamagePoints(wizard));
        System.out.println("Wizard damage: " + wizard.getDamagePoints(warrior));
    }
}
