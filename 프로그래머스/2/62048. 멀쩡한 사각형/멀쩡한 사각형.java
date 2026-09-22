// W와 H의 최대공약수를 G라고 한다.
// W와 H를 G개의 동일한 작은 패턴으로 나눌 수 있다.
//
// 작은 패턴의 크기
// (W / G) × (H / G)
//
// 작은 패턴에서 대각선이 지나가는 사각형의 개수
// W / G + H / G - 1
//
// 이 패턴이 G번 반복되므로
// (W / G + H / G - 1) * G
//
// = W + H - G
// = W + H - gcd(W, H)

class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        
        int G = gcd(w,h);
        answer = (long) w * h - (w + h - G);
        
        return answer;
    }
    
    private int gcd (int a, int b) {
        
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        
        return a;
    }
}