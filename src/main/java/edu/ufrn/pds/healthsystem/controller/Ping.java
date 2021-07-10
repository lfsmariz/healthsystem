package edu.ufrn.pds.healthsystem.controller;

import edu.ufrn.pds.healthsystem.dto.SampleDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/")
public class Ping {

    @GetMapping("/ping")
    public String ping(){
        return  "pong";
    }

}
