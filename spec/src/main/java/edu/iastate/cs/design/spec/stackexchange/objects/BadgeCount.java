package edu.iastate.cs.design.spec.stackexchange.objects;

/**
 * Created by chanika on 9/23/2015.
 */
public class BadgeCount {

    private int bronze;

    private int silver;

    private int gold;

    public int getBronze() {
        return bronze;
    }

    public int getSilver() {
        return silver;
    }

    public int getGold() {
        return gold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BadgeCount that = (BadgeCount) o;

        if (bronze != that.bronze) return false;
        if (gold != that.gold) return false;
        return silver == that.silver;
    }

    @Override
    public int hashCode() {
        int result = bronze;
        result = 31 * result + gold;
        result = 31 * result + silver;
        return result;
    }
}
