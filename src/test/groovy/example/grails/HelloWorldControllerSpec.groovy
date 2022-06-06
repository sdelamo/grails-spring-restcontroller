package example.grails

import io.micronaut.http.HttpRequest
import spock.lang.Specification
import grails.testing.mixin.integration.Integration
import grails.testing.spock.OnceBefore
import spock.lang.Shared
import spock.lang.Specification
import io.micronaut.http.client.HttpClient

@Integration
class HelloWorldControllerSpec extends Specification {
    @Shared
    HttpClient client

    @OnceBefore
    void init() {
        String baseUrl = "http://localhost:$serverPort"
        this.client = HttpClient.create(baseUrl.toURL())
    }

    void "/hello respond Hello World using a SpringBoot RestController"() {
        expect:
        '{"message":"Hello World"}' == client.toBlocking().retrieve(HttpRequest.GET('/hello'))
    }
}
