package org.example;

import java.util.*;

class CheckType{

    String[] values = {"WeatherCoatAllGuard","Wallmasta","WeatherCoatAllGuardXP","EasyClean","Bison", "SilkEmulsion", "SilkGlamour"};


    ArrayList<String> exterior = new ArrayList<>();


    ArrayList<String> interior = new ArrayList<>();

    HashMap<String, List<String>> base = new HashMap<>();
    HashMap<String, List<Integer>> nameBaseLitre = new HashMap<>();

    public CheckType(){
        base.put("weathercoatallguard", Arrays.asList("po","w1","n1","n2","yellow","brown"));
        base.put("wallmasta",Arrays.asList("po","w1","n1","yellow"));
        base.put("weathercoatallguardxp",Arrays.asList("po","w1","n1","n2","yellow","brown"));
        base.put("easyclean",Arrays.asList("po","w1","yellow","brown"));
        base.put("bison",Arrays.asList("po","w1","yellow"));
        base.put("silkemulsion",Arrays.asList("po","w1","n1","n2","yellow","brown"));
        base.put("silkglamour",Arrays.asList("po","w1","n1","n2","yellow","brown"));

        for(Map.Entry<String, List<String>> entry : base.entrySet()){
            String nameKey = entry.getKey();
            List<String> baseValue = entry.getValue();


            for(String baseAll : baseValue){
                String nameAndBase = nameKey + "-" + baseAll;

                if(baseAll.equals("n1") || baseAll.equals("n2")){
                    nameBaseLitre.put(nameAndBase,Arrays.asList(1,4));

                }
                else {
                    nameBaseLitre.put(nameAndBase,Arrays.asList(1,4,10,20));

                }

            }

        }
    }



    public String checkType(String type){
        String choice = type;

        if(choice.equals("1") || choice.equalsIgnoreCase("exterior")){
            type = "exterior";

            exterior.addAll(Arrays.asList(values).subList(0, 3));

            for(int i = 0; i< exterior.size(); i++){
                System.out.println((i+1)+ "." +exterior.get(i));

            }



            return type;
        }

        else if (choice.equals("2") || choice.equalsIgnoreCase("interior")){
            type = "interior";

            interior.addAll(Arrays.asList(values).subList(3, 7));

            for (int i = 0; i< interior.size(); i++){
                System.out.println((i+1) +"."+ interior.get(i));
            }

            return type;

        }
        else{
            return "Error";
        }

    }

    public String checkName(String type, String nameNumber){
        if(type.equals("exterior")&& (nameNumber.equals("1") || nameNumber.equalsIgnoreCase("weathercoatallguard"))){
            for (Map.Entry<String, List<String>> entry : base.entrySet()){
                String colorName = entry.getKey();
                if(colorName.equals("weathercoatallguard")){
                    List<String> bases = entry.getValue();
                    for(int i=0; i< bases.size(); i++){
                        System.out.println((i+1)+"."+ bases.get(i));

                    }
                }
            }
            return "WeatherCoatAllGuard";
        }
        else if(type.equals("exterior")&& nameNumber.equals("2") || nameNumber.equalsIgnoreCase("wallmasta")){
            return "Wallmasta";
        }
        else if(type.equals("Exterior")&& nameNumber.equals("3") ||  nameNumber.equalsIgnoreCase("weathercoatallguardxp")){
            return "WeatherCoatAllGuardXP";
        }
        else if(type.equals("Interior")&& nameNumber.equals("1") ||  nameNumber.equalsIgnoreCase("easyclean")){
            return "EasyClean";
        }
        else if(type.equals("Interior")&& nameNumber.equals("2") ||  nameNumber.equalsIgnoreCase("bison")){
            return "Bison";
        }
        else if(type.equals("Interior")&& nameNumber.equals("3") ||  nameNumber.equalsIgnoreCase("silkemulsion")){
            return "SilkEmulsion";
        }
        else if(type.equals("Interior")&& nameNumber.equals("4") ||  nameNumber.equalsIgnoreCase("silkglamour")){
            return "SilkGlamour";
        }
        else {
            return "Enter valid number";
        }

    }
    public String baseCheck(String colourName, String baseName){

        String colorKey = colourName.toLowerCase();

        if(base.containsKey(colorKey)){
            List<String> allowedBase = base.get(colorKey);
            if(baseName.matches("\\d+")){
                int j=1;
                int i = Integer.parseInt(baseName)-1;

                if(i>=0 && i< allowedBase.size()){
                    String printLitres = colorKey+ "-"+allowedBase.get(i);
                    List<Integer> literValue = nameBaseLitre.get(printLitres);
                    for(int l : literValue){
                        System.out.println(j+"."+l);
                        j++;
                    }
                    return allowedBase.get(i).toUpperCase();
                }
                else{
                    return "error";
                }
            }if(allowedBase.contains(baseName)){
                return baseName.toLowerCase();

            }
            else {
                return "Error";
            }
        }
        else {
            return "Error";
        }

    }

    public int checkLitre(int liter, String name,String baseName){

        String key = name.toLowerCase() + "-" + baseName.toLowerCase();
        List<Integer> litres = nameBaseLitre.get(key);

        if(litres== null){
            System.out.print("invalid");
            return 0;
        }

        for(int allowedLitres: litres){
            if(allowedLitres == liter){
                return liter;
            }
        }

        if(liter>=0 && liter<litres.size()){
            return litres.get(liter-1);
        }
        return 0;

    }




}













//class Check {
//    String[] values = {"WeatherCoatAllGuard", "Bison", "Wallmasta", "EasyClean",
//            "WeatherCoatAllGuardXP", "SilkEmulsion", "SilkGlamour"};
//
//
//    public Boolean nameMethod(String name) {
//        for (int i = 0; i < values.length; i++) {
//            System.out.print(values[i]);
//            if (name.equals.tolower(values[i])) {
//                return  true;
//
//            }
//
//        }
//        return false;
//    }
//    public void
//}
