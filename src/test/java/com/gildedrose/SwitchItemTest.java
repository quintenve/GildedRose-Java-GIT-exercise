package com.gildedrose;

import com.gildedrose.core.GildedRose;
import com.gildedrose.core.Item;
import com.gildedrose.items.NormalItem;
import com.gildedrose.items.SwitchItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SwitchItemTest {

    private Item[] items = new Item[] {new SwitchItem("+5 Dexterity Vest", 10, 20)};
    private GildedRose app = new GildedRose(items);

    @Test
    void decreaseQualitySwitch() {
        app.calculateNextDay();
        assert(app.items[0].sellIn == 9);
        assert(app.items[0].quality == 21);
    }

    @Test
    void decreaseQualityExpired() {
        app.items[0].sellIn = 1;
        app.items[0].quality = 20;
        app.calculateNextDay();
        assert(app.items[0].sellIn == 0);
        assert(app.items[0].quality == 21);
        app.calculateNextDay();
        assert(app.items[0].sellIn == -1);
        assert(app.items[0].quality == 20);
        app.calculateNextDay();
        assert(app.items[0].sellIn == -2);
        assert(app.items[0].quality == 19);
    }

    @Test
    void noQualityBelowZero() {
        app.items[0].sellIn = 1;
        app.items[0].quality = 1;
        app.calculateNextDay();
        assert(app.items[0].sellIn == 0);
        assert(app.items[0].quality == 2);
        app.calculateNextDay();
        assert(app.items[0].sellIn == -1);
        assert(app.items[0].quality == 1);
        app.calculateNextDay();
        assert(app.items[0].sellIn == -2);
        assert(app.items[0].quality == 0);
    }

    @Test
    void noQualityAboveFifty() {
        app.items[0].sellIn = 5;
        app.items[0].quality = 48;
        app.calculateNextDay();
        assert(app.items[0].sellIn == 4);
        assert(app.items[0].quality == 49);
        app.calculateNextDay();
        assert(app.items[0].sellIn == 3);
        assert(app.items[0].quality == 50);
        app.calculateNextDay();
        assert(app.items[0].sellIn == 2);
        assert(app.items[0].quality == 50);
    }

}
