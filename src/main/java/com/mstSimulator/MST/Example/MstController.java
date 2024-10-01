package com.mstSimulator.MST.Example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/mst")
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
    public ResponseEntity<Map<String, Object>> getMst(@RequestBody GraphInput input) {
        // Log input data for debugging
        System.out.println("Received Vertices: " + input.V);
        System.out.println("Received Edges: ");
        input.edges.forEach(edge -> System.out.println("Edge: " + edge[0] + " - " + edge[1] + " with weight " + edge[2]));

        // Validate input
        if (input.V <= 0 || input.edges == null || input.edges.isEmpty()) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Invalid input");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        // Calculate MST sum
        int mstSum = mstAlgorithm.calculateMst(input.V, input.edges);

        // Log the MST sum
        System.out.println("Calculated MST Sum: " + mstSum);

        // Create a response map
        Map<String, Object> response = new HashMap<>();
        response.put("mst_sum", mstSum);
        
        return ResponseEntity.ok(response);
    }

}
