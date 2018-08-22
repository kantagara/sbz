package rs.ac.uns.ftn.XML.projekat.web.controller;

import java.awt.*;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/api/greeting", produces = MediaType.TEXT_PLAIN_VALUE)
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return "Hello";
    }
}