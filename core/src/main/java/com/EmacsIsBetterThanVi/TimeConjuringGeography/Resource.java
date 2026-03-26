package com.EmacsIsBetterThanVi.TimeConjuringGeography;

public record Resource(ResourceType type, int count) {

    public static ResourceType typeFrom(String base, int i) {
        int id=0;
        switch (base){
            case "Coin":
                return ResourceType.Coin;
            case "Foil":
                id=1;
                break;
            case "Base":
                id=6;
                break;
            default:
                id=i;
        }
        id+=i;
        return switch (id) {
            case 1 -> ResourceType.FoilNone;
            case 2 -> ResourceType.FoilBasic;
            case 3 -> ResourceType.FoilCold;
            case 4 -> ResourceType.FoilRainbow;
            case 5 -> ResourceType.FoilGold;
            case 6 -> ResourceType.CardCommon;
            case 7 -> ResourceType.CardUncommon;
            case 8 -> ResourceType.CardRare;
            case 9 -> ResourceType.CardSuperrare;
            case 10 -> ResourceType.CardUltrarare;
            default -> ResourceType.Coin;
        };
    }
}
