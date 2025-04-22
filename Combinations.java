/**
 * Class to calculate combinations while staying under Modulo M.
 * 
 * Apparently X^-1 mod M == X^(M-2) mod M, so this uses that to do the division.
 */
class Combinations {
    long[] fact;
    long[] invFact;
    long M;

    public Combinations(int n, long mod) {
        M = mod;
        fact = new long[n + 1];
        invFact = new long[n + 1];
        fact[0] = 1;
        invFact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % M;
            invFact[i] = power(fact[i], M - 2);
        }
    }

    long power(long base, long exp) {
        long res = 1;
        base %= M;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % M;
            base = (base * base) % M;
            exp >>= 1;
        }
        return res;
    }

    long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        long num = fact[n];
        long den = (invFact[r] * invFact[n - r]) % M;
        return (num * den) % M;
    }
}