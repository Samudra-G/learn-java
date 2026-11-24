class Actions {

    public static boolean canFastAttack(boolean knightIsAwake) {
        if(!knightIsAwake)
            return true;

        return false;
    }

    public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
        if(!knightIsAwake && !archerIsAwake && !prisonerIsAwake)
            return false;

        return true;
    }

    public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
        if(!prisonerIsAwake || archerIsAwake)
            return false;

        return true;
    }

    public static boolean canFreePrisoner(
        boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake, boolean petDogPresent) {
        if(petDogPresent) {
            if(!archerIsAwake) return true;
        }
        else {
            if(!prisonerIsAwake) return false;
            if(!archerIsAwake && !knightIsAwake) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean result = Actions.canFastAttack(true);
        System.out.printf("Knight is sleeping! Is Fast Attack possible? %b%n", result);

        result = Actions.canSpy(false, true, false);
        System.out.printf("Everyone is sleeping but the Archer! Spy? %b%n", result);

        result = Actions.canSignalPrisoner(false, true);
        System.out.printf("Archer is sleeping! Can signal the prisoner? %b%n", result);

        result = Actions.canFreePrisoner(false, true, false, false);
        System.out.printf(
            "Annalyn's dog is not here! Archer is awake, but knight and prisoner are sleeping! Can prisoner be freed? %b%n",
            result
        );

    }
}
