package win.shangyh.demo.sbwebjpa.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * HelloController
 */
@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {

    @GetMapping
    public Object hello(@RequestParam(required = false,defaultValue = "Stranger") String user){
        log.error("test error");
        log.debug("test debug");
        return "Hello "+user+"!";
    }
}