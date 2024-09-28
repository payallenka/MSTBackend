package com.mstSimulator.MST.Example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MstController {

    @GetMapping("/")
    public String home() {
        return "Welcome to the MST API!";
    }
}
