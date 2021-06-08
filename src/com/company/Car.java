package com.company;

import java.util.*;

public class Car {
    final private String model;
    Integer price;
    final Integer mileage;
    final Segment segment;
    final String producer;
    final Color color;
    final Integer capacity;
    Integer newprice, breakages;
    Integer brake = 0, suspension = 0, engine = 0, body = 0, gearbox = 0;

    List<String> producersBudget = Arrays.asList("Fiat", "Kia", "Chevrolet", "Ford");
    List<String> producersStandard = Arrays.asList("Volkswagen", "Audi", "BMW", "Mercedes");
    List<String> producersPremium = Arrays.asList("Ferrari", "Bugatti");
    List <String> producersTruck = Arrays.asList("MAN", "Volvo", "Iveco");

    public Car(){
        this.segment = Segment.randomSegment();
        this.producer = generateProducer();
        this.model = generateModel();
        this.price = generatePrice();
        this.mileage = randomMileage();
        this.color = Color.randomColor();
        if(segment == Segment.TRUCK){
            this.capacity = generateCapacity();
        }else{
            this.capacity = null;
        }
        this.newprice = this.price;
        this.breakages = 0;
        showCar();
        generateBreakages();
        showBreakages();
    }

    public String generateProducer(){
        Random random = new Random();
        if(this.segment == Segment.BUDGET){
            final int sizeBudget = producersBudget.size();
            return producersBudget.get(random.nextInt(sizeBudget));
        }

        if(this.segment == Segment.STANDARD){
            final int sizeStandard = producersStandard.size();
            return producersStandard.get(random.nextInt(sizeStandard));
        }

        if(this.segment == Segment.PREMIUM){
            final int sizePremium = producersPremium.size();
            return producersPremium.get(random.nextInt(sizePremium));
        }

        if(this.segment == Segment.TRUCK){
            final int sizeTruck = producersTruck.size();
            return producersTruck.get(random.nextInt(sizeTruck));
        }
        return null;
    }

    public Integer randomMileage(){
        Random random = new Random();
        int min = 30;
        int max = 350;
        return (random.nextInt(max - min) + min) * 1000;
    }

    public Integer generatePrice(){
        int min = 10;
        Random random = new Random();
        if(this.segment == Segment.BUDGET){
            return 100 * min + (min + random.nextInt(30)) * 100;
        }
        if(this.segment == Segment.STANDARD){
            return 10 * 100 * min + (2 * min + random.nextInt(60)) * 100;
        }
        if(this.segment == Segment.TRUCK){
            return 20 * 100 * min + (4 * min + random.nextInt(100)) * 100;
        }
        if(this.segment == Segment.PREMIUM){
            return 30 * 100 * min + (6 * min + random.nextInt(200)) * 100;
        }
        return null;
    }

    public String generateModel(){
        switch (this.producer){
            case "Fiat":
                List<String> modelsFiat = Arrays.asList("Punto", "Panda", "Albea", "Ducato");
                final int modelsFiatSize = modelsFiat.size();
                Random randomFiat = new Random();
                return modelsFiat.get(randomFiat.nextInt(modelsFiatSize));
            case "Kia":
                List<String> modelsKia = Arrays.asList("Rio", "Ceed", "Sportage", "Optima");
                final int modelsKiaSize = modelsKia.size();
                Random randomKia = new Random();
                return modelsKia.get(randomKia.nextInt(modelsKiaSize));
            case "Chevrolet":
                List<String> modelsChevrolet = Arrays.asList("Lacetti", "Cruze", "Aveo", "Spark");
                final int modelsChevroletSize = modelsChevrolet.size();
                Random randomChevrolet = new Random();
                return modelsChevrolet.get(randomChevrolet.nextInt(modelsChevroletSize));
            case "Ford":
                List<String> modelsFord = Arrays.asList("Focus", "Mondeo", "Fiesta", "Figo");
                final int modelsFordSize = modelsFord.size();
                Random randomFord = new Random();
                return modelsFord.get(randomFord.nextInt(modelsFordSize));
            case "Volkswagen":
                List<String> modelsVolkswagen = Arrays.asList("Golf", "Passat", "Touareg", "Jetta");
                final int modelsVolkswagenSize = modelsVolkswagen.size();
                Random randomVolkswagen = new Random();
                return modelsVolkswagen.get(randomVolkswagen.nextInt(modelsVolkswagenSize));
            case "Audi":
                List<String> modelsAudi = Arrays.asList("A4", "A6", "Q8", "A3");
                final int modelsAudiSize = modelsAudi.size();
                Random randomAudi = new Random();
                return modelsAudi.get(randomAudi.nextInt(modelsAudiSize));
            case "BMW":
                List<String> modelsBMW = Arrays.asList("3", "X3", "X5", "X6");
                final int modelsBMWSize = modelsBMW.size();
                Random randomBMW = new Random();
                return modelsBMW.get(randomBMW.nextInt(modelsBMWSize));
            case "Mercedes":
                List<String> modelsMercedes = Arrays.asList("GLE", "AMG", "Classe A", "Classe S");
                final int modelsMercedesSize = modelsMercedes.size();
                Random randomMercedes = new Random();
                return modelsMercedes.get(randomMercedes.nextInt(modelsMercedesSize));
            case "Ferrari":
                List<String> modelsFerrari = Arrays.asList("458", "488");
                final int modelsFerrariSize = modelsFerrari.size();
                Random randomFerrari = new Random();
                return modelsFerrari.get(randomFerrari.nextInt(modelsFerrariSize));
            case "Bugatti":
                List<String> modelsBugatti = Arrays.asList("Chiron", "Veyron", "Divo");
                final int modelsBugattiSize = modelsBugatti.size();
                Random randomBugatti = new Random();
                return modelsBugatti.get(randomBugatti.nextInt(modelsBugattiSize));
            case "MAN":
                List<String> modelsMAN = Arrays.asList("TGX", "TGS");
                final int modelsMANSize = modelsMAN.size();
                Random randomMAN = new Random();
                return modelsMAN.get(randomMAN.nextInt(modelsMANSize));
            case "Volvo":
                List<String> modelsVolvo = Arrays.asList("VNL 860", "VNL 670");
                final int modelsVolvoSize = modelsVolvo.size();
                Random randomVolvo = new Random();
                return modelsVolvo.get(randomVolvo.nextInt(modelsVolvoSize));
            case "Iveco":
                List<String> modelsIveco = Arrays.asList("S-WAY", "Eurocargo");
                final int modelsIvecoSize = modelsIveco.size();
                Random randomIveco = new Random();
                return modelsIveco.get(randomIveco.nextInt(modelsIvecoSize));
            default:
                return null;
        }
    }

    public Integer generateCapacity(){
        int min = 30;
        int max = 60;
        Random random = new Random();
        return (min + random.nextInt(max - min)) * 100;
    }

    public void generateBreakages(){
        Random random = new Random();
        Double probabilityBrake = random.nextDouble();
        Double probabilitySuspension = random.nextDouble();
        Double probabilityEngine = random.nextDouble();
        Double probabilityBody = random.nextDouble();
        Double probabilityGearbox = random.nextDouble();

        if(probabilityBrake >= 0.0 && probabilityBrake <= 0.75){
            brake = (int)(this.price * 0.1);
            breakages += brake;
        }

        if(probabilitySuspension >= 0.0 && probabilitySuspension <= 0.6){
            suspension = (int)(this.price * 0.2);
            breakages += suspension;
        }
        if(probabilityEngine >= 0.0 && probabilityEngine <= 0.1){
            engine = this.price;
            breakages += engine;
        }
        if(probabilityBody >= 0.0 && probabilityBody <= 0.3){
            body = (int) (this.price * 0.5);
            breakages += body;
        }
        if(probabilityGearbox >= 0.0 && probabilityGearbox <= 0.3){
            gearbox = (int) (this.price * 0.5);
            breakages += gearbox;
        }
    }

    public void newBreakage(){
        Random random = new Random();
        Double breakageProbability = random.nextDouble();
        if(breakageProbability >= 0.0 && breakageProbability < 0.2){
            brake = (int)(this.price * 0.1);
            breakages += brake;
            System.out.println("Oops! Adrian didn't repair anything. " +
                    "More than that, he broke brake.");
        }
        if(breakageProbability >= 0.2 && breakageProbability < 0.4){
            suspension = (int)(this.price * 0.2);
            breakages += suspension;
            System.out.println("Oops! Adrian didn't repair anything. " +
                    "More than that, he broke suspension.");
        }
        if(breakageProbability >= 0.4 && breakageProbability < 0.6){
            engine = this.price;
            breakages += engine;
            System.out.println("Oops! Adrian didn't repair anything. " +
                    "More than that, he broke engine.");
        }
        if(breakageProbability >= 0.6 && breakageProbability < 0.8){
            body = (int) (this.price * 0.5);
            breakages += body;
            System.out.println("Oops! Adrian didn't repair anything. " +
                    "More than that, he broke body.");
        }
        if(breakageProbability >= 0.8 && breakageProbability <= 1){
            gearbox = (int) (this.price * 0.5);
            breakages += gearbox;
            System.out.println("Oops! Adrian didn't repair anything. " +
                    "More than that, he broke gearbox.");
        }

    }

    public void showBreakages(){
        System.out.println("This car is going to be more expensive after these repairs: " +
                "brake: " + brake + ", " +
                "suspension: " + suspension + ", " +
                "engine: " + engine + ", " +
                "body: " + body + ", " +
                "gearbox: " + gearbox + ".\nTotal price of the car after all repairs is " + (this.price + breakages) + ".");

    }

    public void repairCar(){
        System.out.println("Choose a mechanic to repair your car by typing a number");
        System.out.println("1 - Janusz. 100% guarantee of repair. The cost - ");
        System.out.println("2 - Marian. Has a 10% chance of failure. " +
                "In case of failure Janusz is going to repair the car. The cost - ");
        System.out.println("3 - Adrian. Has a 20% chance of failure and 2% of breaking something else. " +
                "In case of failure Janusz is going to repair the car. The cost - ");

        Scanner sc = new Scanner(System.in);
        int choose = sc.nextInt();
        switch (choose){
            case 1:
                int priceJanusz = (int)(breakages * 0.9);
                // отнять деньги из класса владельца
                this.price += breakages;
                System.out.println("The car has got repaired successfully");
                break;
            case 2:
                int priceMarian = (int)(breakages * 0.6);
                Random random = new Random();
                Double probabilityMarian = random.nextDouble();
                if(probabilityMarian >= 0 && probabilityMarian < 0.1) {
                    System.out.println("Marian couldn't repair your car. Now Janusz is going to do that");
                    // отнять priceJanusz из класса владельца
                }
                this.price += breakages;
                System.out.println("The car has got repaired successfully");
                break;
            case 3:
                int priceAdrian = (int)(breakages * 0.3);
                Random random1 = new Random();
                Double probabilityAdrian = random1.nextDouble();
                if(probabilityAdrian >= 0.0 && probabilityAdrian < 0.2){
                    if(probabilityAdrian >= 0.0 && probabilityAdrian < 0.02){
                        newBreakage();
                    }
                    System.out.println("Adrian couldn't repair your car. Now Janusz is going to do that.");
                    // отнять priceJanusz из класса владельца
                }
                this.price += breakages;
                System.out.println("The car has got repaired successfully");
                break;
            default:
                System.out.println("Invalid input.");
                break;
        }
        this.price += breakages;
    }

    public void showCar(){
        System.out.println(producer + " " + model + " | Segment: " + segment + " | Color: " + color +
                " | Mileage: " + mileage);
        if(this.segment == Segment.TRUCK)
            System.out.println("Capacity: " + capacity + ".");
        System.out.println("The price: " + price + ".");
    }

    @Override
    public String toString() {
        return "_________________________________________________________________" +
                "_________________________________________________________________";
    }
}
