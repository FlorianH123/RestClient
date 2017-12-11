import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class ClientApp {
    private static final String GET_PRIMES_AS_STRING_PATH = "getAsString";
    private static final String GET_PRIMES_AS_ARRAY_PATH = "getAsArray";
    private static final String GET_PRIMES_AS_OBJECT_PATH = "getAsObject";
    private static final String QUERY_PARAM      = "maxPrime";

    private WebTarget webTarget;

    public ClientApp(String baseUrl) {
        Client client = ClientBuilder.newClient();
        webTarget = client.target(baseUrl);
    }

    public String getPrimesAsString(int nPrimes) {
        return webTarget.path(GET_PRIMES_AS_STRING_PATH)
                .queryParam(QUERY_PARAM, nPrimes)
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
    }

    public long[] getPrimesAsArray(int nPrimes) {
        return webTarget.path(GET_PRIMES_AS_ARRAY_PATH)
                .queryParam(QUERY_PARAM, nPrimes)
                .request(MediaType.APPLICATION_JSON)
                .get(long[].class);
    }

    public Primes getPrimesAsObject(int nPrimes) {
        return webTarget.path(GET_PRIMES_AS_OBJECT_PATH)
                .queryParam(QUERY_PARAM, nPrimes)
                .request(MediaType.APPLICATION_JSON)
                .get(Primes.class);
    }
}