package com.gildedrose.core;

public abstract class Item {

    public String name;

    public int sellIn;

    public int quality;

    /**
     * Item is any type of item
     * @param name name of the item
     * @param sellIn value in amount of days
     * @param quality value as an integer
     */
    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    abstract public void updateQuality();

    public void updateSellInValue() {
        this.sellIn --;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
