package leetcode;

public class SuperPow {

    public static void main(String[] args) {
        superPow(2, new int[] {1,0});
    }

    public static int superPow1(int a, int[] b) {
        if(a == 1){
            return 1;
        }
        int pow = 0;
        int counter = 0;
        int mod = 1337;

        for (int i = b.length - 1; i >= 0; i--) {
            pow = pow + b[i] * (int) Math.pow(10, counter);
            counter++;
        }

        int mod1 = a%mod;


        if (pow == 1){
            return mod1 % mod;
        }


        int holder = mod1;
        while (pow!=1){
            holder = holder*mod1;
            holder = holder%mod;
            pow--;
        }

        return holder % mod;
    }

    static final int MOD = 1337;

    public static int superPow(int a, int[] b) {
        int result = 1;
        for (int digit : b) {
            result = modPow(result, 10) * modPow(a, digit) % MOD;
        }

        return result;
    }

    static int modPow(int base, int exp) {
        base %= MOD;
        int result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }
        return result;
    }

}
