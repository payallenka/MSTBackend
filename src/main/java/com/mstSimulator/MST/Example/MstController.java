package com.mstSimulator.MST.Example;


import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/")
public class MstController {

    private final MstAlgorithm mstAlgorithm;

    public MstController() {
        this.mstAlgorithm = new MstAlgorithm();
    }

    // Request body model to accept input
    static class GraphInput {
        public int V;
        public List<int[]> edges;
    }

    @PostMapping
    public int getMst(@RequestBody GraphInput input) {
        return mstAlgorithm.calculateMst(input.V, input.edges);
    }
}



