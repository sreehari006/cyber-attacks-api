package com.poc.attacks_api.ransom;

import com.poc.attacks_api.ransom.entity.Ransomware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cyber-security")
public class RansomController {
    @Autowired
    private RansomService ransomService;

    @GetMapping("/")
    String home() {
        return "home";
    }

    @GetMapping("/ransomware")
    public ResponseEntity<Page<Ransomware>> getUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Ransomware> ransomware = ransomService.getRansomware(page, size);
        return new ResponseEntity<>(ransomware, HttpStatus.OK);
    }

    @GetMapping("/ransomware/{name}")
    public ResponseEntity<List<Ransomware>> findByChildSomeField(@PathVariable String name) {
        List<Ransomware> parents = ransomService.getRansomwareByName(name);
        return new ResponseEntity<>(parents, HttpStatus.OK);
    }

    @PostMapping("/ransomware")
    public ResponseEntity<Ransomware> addRansomware(@RequestBody Ransomware ransomware) {
        Ransomware createdCustomer = ransomService.addRansomware(ransomware);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @DeleteMapping("/ransomware/{ransomwareId}")
    public ResponseEntity<Void> deleteRansom(@PathVariable Long ransomwareId) {
        ransomService.deleteRansomwareById(ransomwareId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/ransomware/{ransomwareId}")
    public ResponseEntity<Ransomware> patchCustomer(@PathVariable Long ransomwareId, @RequestBody Ransomware ransomUpdates) {
        Ransomware updatedRansomware = ransomService.patchRansomware(ransomwareId, ransomUpdates);
        return ResponseEntity.ok(updatedRansomware);
    }

    @PatchMapping("/ransomware/{ransomwareId}/{propType}/{value}")
    public ResponseEntity<Ransomware> patchCustomer(@PathVariable Long ransomwareId, @PathVariable String propType, @PathVariable String value) {
        Ransomware updatedRansomware = ransomService.patchRansomware(ransomwareId, propType, value);
        return ResponseEntity.ok(updatedRansomware);
    }
}
