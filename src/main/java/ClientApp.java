import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class ClientApp {
    private WebTarget webTarget;
    private String webContextPath;

    public ClientApp(String baseUrl) {
        Client client = ClientBuilder.newClient();
        webTarget = client.target(baseUrl);
    }

    public String getPrimesAsString(int nPrimes) {
        webContextPath = "/primesAsString";

        return webTarget.path(webContextPath)
                .queryParam("nPrimes", nPrimes)
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
    }

    public Long[] getPrimesAsArray(int nPrimes) {
        webContextPath = "/primesAsArray";

        return webTarget.path(webContextPath)
                .queryParam("nPrimes", nPrimes)
                .request(MediaType.TEXT_PLAIN)
                .get(Long[].class);
    }

    public Primes getPrimesAsObject(int nPrimes) {
        return webTarget.path(webContextPath)
                .queryParam("nPrimes", nPrimes)
                .request(MediaType.TEXT_PLAIN)
                .get(Primes.class);
    }
}