package chapter10;

import java.util.List;
import java.util.stream.Collectors;

public class MorphismCondition {

    public List plumages(List<Bird> birds) {
        return birds.stream().map(bird ->  List.of(bird.name, plumage(bird))).collect(Collectors.toList());
    }

    public String plumage(Bird bird) { //깃털 상태
        return switch (bird.type) {
            case "유럽 제비" -> "보통이다";
            case "아프리카 제비" -> (bird.numberOfCoconuts > 2) ? "지쳤다" : "보통이다";
            case "노르웨이 파랑 앵무" -> (bird.voltage > 100) ? "그을렸다" : "예쁘다";
            default -> "알 수 없다";
        };
    }

    public Double airSpeedVelocity(Bird bird) {
        return switch (bird.type) {
            case "유럽 제비" -> 35.0;
            case "아프리카 제비" -> (double) (40 - 2 * bird.numberOfCoconuts);
            case "노르웨이 파랑 앵무" -> (double) ((bird.isNailed) ? 0 : 10 + bird.voltage / 10);
            default -> null;
        };
    }


}
