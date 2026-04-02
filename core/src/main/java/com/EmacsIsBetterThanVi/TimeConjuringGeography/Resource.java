package com.EmacsIsBetterThanVi.TimeConjuringGeography;

import java.util.Objects;

public final class Resource {
    private final ResourceType type;
    private final int count;

    public Resource(ResourceType type, int count) {
        this.type = type;
        this.count = count;
    }

    public static ResourceType typeFrom(String base, int i) {
        int id = 0;
        switch (base) {
            case "Coin":
                return ResourceType.Coin;
            case "Foil":
                id = 1;
                break;
            case "Base":
                id = 6;
                break;
            default:
                id = i;
        }
        id += i;
        switch (id) {
            case 1:
                return ResourceType.FoilNone;
            case 2:
                return ResourceType.FoilBasic;
            case 3:
                return ResourceType.FoilCold;
            case 4:
                return ResourceType.FoilRainbow;
            case 5:
                return ResourceType.FoilGold;
            case 6:
                return ResourceType.CardCommon;
            case 7:
                return ResourceType.CardUncommon;
            case 8:
                return ResourceType.CardRare;
            case 9:
                return ResourceType.CardSuperrare;
            case 10:
                return ResourceType.CardUltrarare;
            default:
                return ResourceType.Coin;
        }
    }

    public ResourceType type() {
        return type;
    }

    public int count() {
        return count;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Resource that = (Resource) obj;
        return Objects.equals(this.type, that.type) &&
            this.count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, count);
    }

    @Override
    public String toString() {
        return "Resource[" +
            "type=" + type + ", " +
            "count=" + count + ']';
    }

}
