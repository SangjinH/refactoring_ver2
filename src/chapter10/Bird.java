package chapter10;


public class Bird {

    String type;
    String name;
    int numberOfCoconuts;
    int voltage;
    boolean isNailed;

    String plumge;
    double airSpeedVelocity;

    public String plumge() {
        return this.plumge;
    }

    public Double airSpeedVelocity(Bird bird) {
        return this.airSpeedVelocity;
    }

    public Bird(Bird bird) {
    }

    public static Bird createBird(Bird bird) {
        return switch (bird.type) {
            case "유럽 제비" -> new EuropeanSwallow(bird);
            case "아프리카 제비" -> new AfricanSwallow(bird);
            case "노르웨이 파랑 앵무" -> new NorwegianBlueParrot(bird);
            default -> new Bird(bird);
        };
    }




}


