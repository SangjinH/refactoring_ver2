package chapter10;

public class CombineCondition {

    public int disabilityAmount(Employee anEmployee) {
        if (isNotEligibleForDisability(anEmployee)) return 0;

        return 100;
    }

    public boolean isNotEligibleForDisability(Employee employee) {
        return employee.seniority < 2 || employee.monthsDisabled > 12 || employee.isPartTime;
    }

}
