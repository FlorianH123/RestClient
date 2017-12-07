import java.util.Arrays;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Primes primes = (Primes) o;
        return Objects.equals(primesAsString, primes.primesAsString) &&
                Arrays.equals(primesAsArray, primes.primesAsArray);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(primesAsString);
        result = 31 * result + Arrays.hashCode(primesAsArray);
        return result;
    }

    @Override
    public String toString() {
        return "Primes{" +
                "primesAsString='" + primesAsString + '\'' +
                ", primesAsArray=" + Arrays.toString(primesAsArray) +
                '}';
    }
}
