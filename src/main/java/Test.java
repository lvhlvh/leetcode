public class Test {
    public static void main(String[] args) {
        System.out.println(new Test().encryption("hello", "234137"));
    }

    public String encryption(String plaintext, String key) {
        StringBuffer sb = new StringBuffer();
        int len = plaintext.length();
        for (int i = 0; i < len; i++) {
            char ch = plaintext.charAt(i);
            int k = key.charAt(i) - '0';
            if ((i & 1) == 0) {
                sb.append((char) ('a' + (ch - 'a' + k) % 26));
            } else {
                sb.append((char) ('a' + (ch - 'a' - k + 26) % 26));
            }
        }
        return sb.toString();
    }

}
