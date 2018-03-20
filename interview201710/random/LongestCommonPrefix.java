class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[] { "abc", "abccc", "abcedefss", "abd" };
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            if(!strs[i].startsWith(prefix)) {
                for(int j = prefix.length()-1; j >= 0; j--) {
                    prefix = prefix.substring(0, j);
                    if(strs[i].startsWith(prefix)) break;
                }
            }
        }
        
        return prefix;
    }
}
