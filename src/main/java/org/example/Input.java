package org.example;

import java.util.Scanner;

public class Input {



        public Colour inputField() {

            Scanner sc = new Scanner(System.in);
            Colour colour = new Colour();

            System.out.println("choose colour type:");
            System.out.println("1. Exterior");
            System.out.println("2. Interior");


            String type = sc.nextLine().toLowerCase().trim().replace(" ","");

            CheckType checkType= new CheckType();
            type = checkType.checkType(type);

            System.out.print("Enter name:");
            String nameNumber = sc.nextLine();
            String colorName = checkType.checkName(type,nameNumber);

            System.out.print(colorName);

            System.out.print("Enter Base:");
            String baseName = sc.nextLine().toLowerCase().replace(" ","").trim();

            baseName = checkType.baseCheck( colorName, baseName);
            System.out.print(baseName);


            System.out.print("Liter");
            int litrePerBucket = sc.nextInt();

            litrePerBucket = checkType.checkLitre(litrePerBucket,colorName,baseName);


            System.out.print("No of Buckets");
            int numberOfBuckets = sc.nextInt();


            System.out.print("Enter Price");
            int price = sc.nextInt();

            System.out.print("Enter Stock");
            int stock = sc.nextInt();

            return new Colour( type,colorName, baseName, litrePerBucket, numberOfBuckets,  price, stock);

        }


}
