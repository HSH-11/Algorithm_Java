class Solution {
    public int solution(String s) {

        int answer = s.length();

        // 압축 단위
        for (int size = 1; size <= s.length() / 2; size++) {

            StringBuilder compressed = new StringBuilder();

            String prev = s.substring(0, size);
            int count = 1;

            // 다음 문자열과 비교
            for (int i = size; i < s.length(); i += size) {

                int end = Math.min(i + size, s.length());
                String current = s.substring(i, end);

                if (prev.equals(current)) {
                    count++;
                } else {

                    if (count > 1) {
                        compressed.append(count);
                    }

                    compressed.append(prev);

                    prev = current;
                    count = 1;
                }
            }

            // 마지막 문자열 처리
            if (count > 1) {
                compressed.append(count);
            }

            compressed.append(prev);

            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }
}