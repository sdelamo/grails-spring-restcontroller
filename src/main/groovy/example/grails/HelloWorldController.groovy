package example.grails

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/hello")
class HelloWorldController {

    @GetMapping
    Map<String, String> index() {
        [message: 'Hello World']
    }
}
