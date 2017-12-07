import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class ClientApp {
    private static final String WEB_CONTEXT_PATH = "/getNPrimes";
    private static final String QUERY_PARAM      = "nPrimes";

    private WebTarget webTarget;

    public ClientApp(String baseUrl) {
        Client client = ClientBuilder.newClient();
        webTarget = client.target(baseUrl);
    }

    public String getPrimesAsString(int nPrimes) {
        return webTarget.path(WEB_CONTEXT_PATH)
                .queryParam(QUERY_PARAM, nPrimes)
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
    }

    public Long[] getPrimesAsArray(int nPrimes) {
        return webTarget.path(WEB_CONTEXT_PATH)
                .queryParam(QUERY_PARAM, nPrimes)
                .request(MediaType.TEXT_PLAIN)
                .get(Long[].class);
    }

    public Primes getPrimesAsObject(int nPrimes) {
        return webTarget.path(WEB_CONTEXT_PATH)
                .queryParam(QUERY_PARAM, nPrimes)
                .request(MediaType.TEXT_PLAIN)
                .get(Primes.class);
    }
}