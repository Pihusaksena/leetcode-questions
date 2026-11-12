class Solution {
    public int totalNumbers(int[] digits) {
       int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }
        int count = 0;
        for (int num = 100; num <= 998; num += 2) {
            int hundreds = num / 100;
            int tens = (num / 10) % 10;
            int units = num % 10;
            freq[hundreds]--;
            freq[tens]--;
            freq[units]--;
            if (freq[hundreds] >= 0 && freq[tens] >= 0 && freq[units] >= 0) {
                count++;
            }
            freq[hundreds]++;
            freq[tens]++;
            freq[units]++;
        }
        return count; 
    }
}