package chapter10;


import java.util.HashMap;
import java.util.Map;

public class GuardClause {

    /**
     * 직원의 급여를 계산하는 함수
     * Before refactor
     *
     * @param employee
     * @return
     */
    public Map<String, Object> payAmount(Employee employee) {

        Map<String, Object> result = new HashMap<>();

        if (employee.isSeparated) { // 퇴사한 직원인가?
            result.put("amount", 0);
            result.put("reasonCode", "SEP");
        }
        else {
            if (employee.isRetired) { // 은퇴한 직원인가?
                result.put("amount", 0);
                result.put("reasonCode", "RET");
            }
            else {
                // 급여 계산 로직 ( 현직자에 관한 계산로직 )
                // ,,,
            }
        }
        return result;
    }

    public Map<String, Object> payAmountAfterRefactor(Employee employee) {

        Map<String, Object> result = new HashMap<>();

        if (employee.isSeparated) { // 퇴사한 직원인가?
            result.put("amount", 0);
            result.put("reasonCode", "SEP");
        }
        if (employee.isRetired) { // 은퇴한 직원인가?
            result.put("amount", 0);
            result.put("reasonCode", "RET");
        }

        // 급여 계산 로직 ( 현직자에 관한 계산로직 )
        // ,,,
        return result;
    }

    /**
     * 조건 반대로 만들기
     * Before refactor
     */
    public double adjustedCapital(Instrument anInstrument) {
        double result = 0;
        if (anInstrument.capital > 0) {
            if (anInstrument.interestRate > 0 && anInstrument.duration > 0) {
                result = (anInstrument.income / anInstrument.duration) * anInstrument.adjustmentFactor;
            }
        }
        return result;
    }

    /**
     * 조건 반대로 만들기
     * After refactor
     */
    public double adjustedCapitalAfterRefactoring(Instrument anInstrument) {

        if (   anInstrument.capital      <= 0
            || anInstrument.interestRate <= 0
            || anInstrument.duration     <= 0) return 0;

        return (anInstrument.income / anInstrument.duration) * anInstrument.adjustmentFactor;
    }



}
