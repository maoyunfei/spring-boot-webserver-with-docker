package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 *
 * @author maoyunfei
 * @date 2018/4/4
 */
@RestController
public class HelloController {

    @GetMapping("/hi")
    public String sayHi() {
        return "hello!";
    }

}
