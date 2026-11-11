class Solution {
    public int[] findEvenNumbers(int[] digits) {
         int[] cnt = new int[10];
        for (int x : digits) {
            ++cnt[x];
        }       
        List<Integer> ans = new ArrayList<>();
        for (int x = 100; x < 1000; x += 2) {
            int[] cnt1 = new int[10];
            int temp = x;
            while (temp > 0) {
                ++cnt1[temp % 10];
                temp /= 10;
            }          
            boolean ok = true;
            for (int i = 0; i < 10; ++i) {
                if (cnt[i] < cnt1[i]) {
                    ok = false;
                    break;
                }
            }           
            if (ok) {
                ans.add(x);
            }
        }        
        return ans.stream().mapToInt(i -> i).toArray();
    }
}