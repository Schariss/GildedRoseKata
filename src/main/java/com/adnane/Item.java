package com.adnane;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

//    @Override
//    public boolean equals(Object obj) {
//        // If the object is compared with itself then return true
//        if (obj == this)
//            return true;
//        if(!this.name.equals(((Item) obj).name)
//                || this.sellIn != ((Item) obj).sellIn
//                || this.quality != ((Item) obj).quality
//        )
//            return false;
//        if(obj == null)
//            return false;
//        if(obj.getClass() != this.getClass())
//            return false;
//        return true;
//    }
//
//    @Override
//    public int hashCode(){
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((name == null) ? 0 : name.hashCode());
//        result = prime * result + quality;
//        result = prime * result + sellIn;
//        return result;
//    }
}
