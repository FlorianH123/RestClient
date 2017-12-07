import java.util.Arrays;

public class Primes {
    private String primesAsString;
    private long primesAsArray[];

    public Primes() {
    }

    public Primes(String primesAsString, long[] primesAsArray) {

        this.primesAsString = primesAsString;
        this.primesAsArray = primesAsArray;
    }

    public String getPrimesAsString() {
        return primesAsString;
    }

    public void setPrimesAsString(String primesAsString) {
        this.primesAsString = primesAsString;
    }

    public long[] getPrimesAsArray() {
        return primesAsArray;
    }

    public void setPrimesAsArray(long[] primesAsArray) {
        this.primesAsArray = primesAsArray;
    }

    @Override
    public String toString() {
        return "Primes{" +
                "primesAsString='" + primesAsString + '\'' +
                ", primesAsArray=" + Arrays.toString(primesAsArray) +
                '}';
    }
}
