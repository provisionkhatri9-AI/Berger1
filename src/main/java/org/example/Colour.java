package org.example;

public class Colour {

    private String type;
    private String colorName;
    private int litrePerBucket;
    private int noOfBuckets;
    private String baseName;
    private int price;


    public Colour(){

    }

    public Colour( String type, String colorName,String baseName, int litrePerBucket,int noOfBuckets, int price){
        this.type = type;
        this.colorName = colorName;
        this.baseName = baseName;
        this.litrePerBucket = litrePerBucket;
        this.noOfBuckets= noOfBuckets;
        this.price = price;

    }

    public String getType() {
        return type;
    }
    public String getName(){

        return colorName;
    }
    public String getBaseName(){
        return  baseName;
    }
    public int getlitrePerBucket(){
        return litrePerBucket;
    }
    public int getPrice(){
        return price;
    }
    public int getVolume(){
        return noOfBuckets * litrePerBucket;
    }
    public int getStock(){
        return noOfBuckets;
    }
}
