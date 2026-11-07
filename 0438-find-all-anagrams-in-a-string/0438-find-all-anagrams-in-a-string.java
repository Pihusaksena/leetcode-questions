class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }
        int[] pCount = new int[26];
        int[] windowCount = new int[26];
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            windowCount[s.charAt(right) - 'a']++;
            if (right - left + 1 > p.length()) {
                windowCount[s.charAt(left) - 'a']--;
                left++;
            }
            if (right - left + 1 == p.length()) {
                if (matches(pCount, windowCount)) {
                    result.add(left);
                }
            }
        }
        return result;
    }
    private boolean matches(int[] pCount, int[] windowCount) {
        for (int i = 0; i < 26; i++) {
            if (pCount[i] != windowCount[i]) {
                return false;
            }
        }
        return true;
    }
}