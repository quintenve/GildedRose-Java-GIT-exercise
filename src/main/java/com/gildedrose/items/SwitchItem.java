package com.gildedrose.items;

import com.gildedrose.core.Item;

public class SwitchItem extends Item {
    /**
     * Item is any type of item
     *
     * @param name    name of the item
     * @param sellIn  value in amount of days
     * @param quality value as an integer
     */
    public SwitchItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        int factor;
        if (this.sellIn >= 0) factor = 1;
        else factor = -1;

        if (this.quality < 50) this.quality = Math.max(this.quality + factor, 0);
        else this.quality = 50;
    }
}