package com.example.assignment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyContent {

    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    //add dummy items
    static {
        DummyItem milk = new DummyItem("1", "milk");
        ITEMS.add(milk);
        ITEM_MAP.put(milk.id, milk);

        DummyItem bread = new DummyItem("2", "bread");
        ITEMS.add(bread);
        ITEM_MAP.put(bread.id, bread);

        DummyItem butter = new DummyItem("3", "butter");
        ITEMS.add(butter);
        ITEM_MAP.put(butter.id, butter);

        DummyItem sugar = new DummyItem("4", "sugar");
        ITEMS.add(sugar);
        ITEM_MAP.put(sugar.id, sugar);

    }

    public static class DummyItem implements Serializable {
        public final String id, name;

        public DummyItem(String id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
