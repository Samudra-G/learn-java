enum Archetype {
    Wizard,
    Warrior,
    Archer,
    Knight
}

enum TravelMethod {
    HORSEBACK,
    WALKING
}

class Character {

    private String characterClass;
    private int level;
    private int hitPoints;

    public void setCharacterClass(Archetype obj) {
        this.characterClass = obj.toString();
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHitPoints(int hitpoints) {
        this.hitPoints = hitpoints;
    }

    public String getCharacterClass() {
        return this.characterClass;
    }

    public int getLevel() {
        return this.level;
    }

    public int getHitPoints() {
        return this.hitPoints;
    }

}

class Destination {

    private String name;
    private int inhabitants;

    public void setName(String name) {
        this.name = name;
    }

    public void setInhabitants(int inhabitants) {
        this.inhabitants = inhabitants;
    }

    public String getName() {
        return this.name;
    }

    public int getInhabitants() {
        return this.inhabitants;
    }
}

public class GameMaster {

	public static void describe(Character obj) {
	    System.out.printf("You're a level %d %s with %d hitpoints.%n", obj.getLevel(), obj.getCharacterClass(), obj.getHitPoints());
	}

	public static void describe(Destination obj) {
	    System.out.printf("You've arrived at %s, which has %d inhabitants.%n", obj.getName(), obj.getInhabitants());
	}

	public static void describe(TravelMethod method) {
        switch (method) {
            case HORSEBACK:
                System.out.println("You're traveling to your destination on horseback.");
                break;
            case WALKING:
                System.out.println("You're traveling to your destination by walking.");
                break;
            default:
                System.out.println("Invalid choice.");
        		break;
        }
	}

	public static void describe(Character character, Destination destination) {
	    describe(character, destination, TravelMethod.WALKING);
	}

	public static void describe(Character character, Destination destination, TravelMethod method) {
        describe(character);
        describe(destination);
	    describe(method);
	}

	public static void main(String[] args) {
		Character character = new Character();
		character.setCharacterClass(Archetype.Archer);
		character.setHitPoints(40);
		character.setLevel(5);

		Destination destination = new Destination();
		destination.setName("Muros");
		destination.setInhabitants(732);

		GameMaster.describe(character);
		GameMaster.describe(destination);
		GameMaster.describe(TravelMethod.HORSEBACK);

		Character raj = new Character();
		raj.setCharacterClass(Archetype.Knight);
		raj.setHitPoints(142);
		raj.setLevel(14);

		GameMaster.describe(raj, destination);
	}

}
