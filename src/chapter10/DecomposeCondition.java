package chapter10;

import java.time.LocalDateTime;

public class DecomposeCondition {

    public static void main(String[] args) {

        LocalDateTime aDate = LocalDateTime.now();
        Plan plan = new Plan();
        double charge;
        int quantity = 0;

        charge = isSummer(aDate, plan) ? summerCharge(plan, quantity) : regularCharge(plan, quantity);
    }

    private static double regularCharge(Plan plan, int quantity) {
        return quantity * plan.regularRate + plan.regularServiceCharge;
    }

    private static double summerCharge(Plan plan, int quantity) {
        return quantity * plan.summerRate;
    }

    private static boolean isSummer(LocalDateTime aDate, Plan plan) {
        return !aDate.isBefore(plan.summerStart) && !aDate.isAfter(plan.summerEnd);
    }

    public static class Plan {

        private LocalDateTime summerStart;
        private LocalDateTime summerEnd;
        private double summerRate;

        private double regularRate;
        private int regularServiceCharge;
    }



}
