package ru.nulfild.courseWork5sem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nulfild.courseWork5sem.Entities.HouseEntity;
import ru.nulfild.courseWork5sem.Services.HouseService;
import ru.nulfild.courseWork5sem.Services.UserService;

import java.security.cert.Extension;

@RestController
@RequestMapping("/houses")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @PostMapping
    public ResponseEntity createHouse(@RequestBody HouseEntity house,
                                      @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(houseService.createHouse(house, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{houseId}")
    public ResponseEntity buyPlan(@PathVariable Long houseId, @RequestParam Long planId) {
        try {
            houseService.buyPlan(houseId, planId);
            return ResponseEntity.ok("Good!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{houseId}")
    public ResponseEntity getPrices(@PathVariable Long houseId, @RequestParam Long planId) {
        try {
            return ResponseEntity.ok(houseService.getPrice(houseId, planId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getHouse() {
        try {
            return ResponseEntity.ok(houseService.getAllHouses());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
