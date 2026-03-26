package com.EmacsIsBetterThanVi.TimeConjuringGeography;

public class CardCrafting {
    // Note that crafted cards can not be dismantled, also, this is a static class.
    public static Resource getCost(int rarity, int Foil, int base){
        double cost=Math.pow(1.24, rarity);
        switch (Foil){
            case 1:
                cost*=0.9; // Foil reduces the cost by 10%.
                break;
            case 2:
                cost*=1.5; // Cold Foil gives two copies of the card.
                break;
            case 3:
                if (rarity>0)
                    cost*=2; // Rainbow foil allows crafting 1 higher a rarity for twice as many coins
                break;
            case 4:
                cost=0; // Gold foil nullifies cost.
                break;
        }
        return new Resource(ResourceType.Coin, (int)Math.round(cost));
    }
    public static Resource[] dismantle(){
        return null;
    }
    public static Resource[] getResources(int id, int Foil){
        Resource[] resources = new Resource[3];
        int rarity = CardDB.getRarity(id);
        resources[0]=getCost(rarity, Foil, rarity);
        if (Foil==3 && rarity !=0)
            resources[1]=new Resource(Resource.typeFrom("Base", rarity-1), 1);
        else resources[1]=new Resource(Resource.typeFrom("Base", rarity), 1);
        resources[2]=new Resource(Resource.typeFrom("Foil", Foil), 1);
        return resources;
    }
}
