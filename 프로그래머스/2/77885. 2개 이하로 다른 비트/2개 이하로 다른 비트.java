class Solution {
    // 1. 비트 방식 (추천)
     public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long x = numbers[i];

            // 가장 오른쪽에 있는 0의 위치 찾기
            long bit = 1;
            while ((x & bit) != 0) {
                bit <<= 1;
            }

            // 해당 0을 1로 바꾸고, 바로 오른쪽 비트를 0으로 변경
            answer[i] = x + bit - (bit >> 1);
        }

        return answer;
    }
    
    
//     public long[] solution(long[] numbers) {
//         long[] answer = new long[numbers.length];
        
//         for (int i = 0; i < numbers.length; i++) {
//             // 2진수 문자열 만들기
//             String num = Long.toBinaryString(numbers[i]);
//             char[] bits = num.toCharArray();
            
//             // 오른쪽에서 처음 만나는 0 찾기
//             int index = bits.length - 1;
            
//             while (index >= 0 && bits[index] == '1') {
//                 index--;
//             }
            
//             if (index < 0) {
//                 // 모든 비트가 1인 경우
//                 char[] newBits = new char[bits.length + 1];
//                 newBits[0] = '1';
                
//                 for (int j = 1; j < newBits.length; j++) {
//                     newBits[j] = bits[j-1];
//                 }
                
//                 newBits[1] = '0';
//                 answer[i] = Long.parseLong(new String(newBits), 2);
//             } else {
//                 // 찾은 0을 1로 변경
//                 bits[index] = '1';
                
//                 // 바로 오른쪽 비트 0으로 변경
//                 if (index + 1 < bits.length) {
//                     bits[index+1] = '0';
//                 }
                
//                 answer[i] = Long.parseLong(new String(bits), 2);
//             }
            
//         }
        
//         return answer;
//     }
}