package com.mstSimulator.MST.Example;


import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/")
public class MstController {

    @GetMapping
    public String home() {
        return "Welcome to the MST API!";
    }
}



