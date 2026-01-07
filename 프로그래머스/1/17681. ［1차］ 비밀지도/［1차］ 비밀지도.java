class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            // 비트 or 연산 후 이진수 문자열로 변환
            // toBinaryString을 사용하면 앞자리의 0이 생략됨
            String binary = Integer.toBinaryString(arr1[i] | arr2[i]);
            
            // n자리에 맞춰 앞쪽에 0 채우기
            while (binary.length() < n) {
                binary = "0" + binary;
            }
            
            binary = binary.replaceAll("1","#");
            binary = binary.replaceAll("0"," ");
            
            answer[i] = binary;            
        }
        return answer;
    }
}