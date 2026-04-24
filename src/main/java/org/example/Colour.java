package org.example;

public class Colour {

    private String type;
    private String colorName;
    private int litrePerBucket;
    private int noOfBuckets;
    private int volume;
    private String baseName;
    private int price;
    private int stock;

    public Colour(){

    }

    public Colour( String type, String colorName,String baseName, int litrePerBucket,int noOfBuckets, int price, int stock){
        this.type = type;
        this.colorName = colorName;
        this.baseName = baseName;
        this.litrePerBucket = litrePerBucket;
        this.noOfBuckets= noOfBuckets;
        this.price = price;
        this.stock = stock;
    }

    public void bucket(){
        System.out.print(volume);

    }
    public void totalLitre(){
        int total = noOfBuckets * litrePerBucket;
        System.out.print(total + "is total");
        System.out.print(litrePerBucket);
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
    public int getnoOfBuckets(){
        return noOfBuckets;
    }
    public int getPrice(){
        return price;
    }
    public int getVolume(){
        return volume;
    }
    public int getStock(){
        return stock;
    }
}
