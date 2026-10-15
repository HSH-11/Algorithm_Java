import java.util.*;

class Solution {
    public long solution(String expression) {
        String[][] priorities = {
            {"+", "-", "*"},
            {"+", "*", "-"},
            {"-", "+", "*"},
            {"-", "*", "+"},
            {"*", "+", "-"},
            {"*", "-", "+"}
        };
        
        List<Long> numbers = new ArrayList<>();
        List<String> ops = new ArrayList<>();
        
        // 숫자와 연산자 분리
        StringBuilder num = new StringBuilder();
        
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                numbers.add(Long.parseLong(num.toString()));
                num.setLength(0);
                ops.add(String.valueOf(c));
            } else {
                num.append(c);
            }
        }
        // 마지막 연산 숫자 추가
        numbers.add(Long.parseLong(num.toString()));
        
        long answer = 0;
        
        // 6가지 우선순위 완탐
        for (String[] priority : priorities) {
            long result = calculate(numbers, ops, priority);
            answer = Math.max(answer, Math.abs(result));
        }
        
        return answer;
    }
    
    private long calculate(List<Long> numbers, List<String> ops, String[] priority) {
        List<Long> nums = new ArrayList<>(numbers);
        List<String> operators = new ArrayList<>(ops);
        
        for (String op : priority) {
            for (int i = 0; i < operators.size();) {
                if (operators.get(i).equals(op)) {
                    long a = nums.get(i);
                    long b = nums.get(i+1);
                    long result = 0;
                    
                    switch (op) {
                        case "+":
                            result = a + b;
                            break;
                        case "-":
                            result = a - b;
                            break;
                        case "*":
                            result = a * b;
                            break;
                    }
                    
                    nums.set(i, result); // 첫 번째 숫자를 계산 결과로 변경
                    nums.remove(i+1);
                    operators.remove(i);
                } else {
                    i++;
                }
            }
        }
        
        return nums.get(0);
    }
}