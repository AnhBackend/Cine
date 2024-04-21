package cinema.Controller.Tuan2;

import cinema.Entity.Food;
import cinema.Service.ServiceImpl.FoodServicesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/food")
@RequiredArgsConstructor
public class FoodController {
    @Autowired
    FoodServicesImpl foodSer;
    @GetMapping(value = "/getallfood")
    public ResponseEntity<List<Food>> getAllFood() {
        List<Food> foods = foodSer.getAllFood();
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }
    @RequestMapping(value = "getfoodbyid",method = RequestMethod.GET)
    public ResponseEntity<Food> getFoodById(@RequestParam int foodId){
        Food food = foodSer.getFoodById(foodId);
        return new ResponseEntity<>(food,HttpStatus.OK);
    }
    @PostMapping(value = "/addfood")
    public ResponseEntity<Food> addFood(@RequestBody Food food) {
        Food addedFood = foodSer.addFood(food);
        return new ResponseEntity<>(addedFood, HttpStatus.CREATED);
    }
    @PutMapping("/updatefood")
    public ResponseEntity<Optional<Food>> updateFood(@RequestParam int foodId, @RequestBody Food updatedFood) {
        Optional<Food> food = foodSer.updateFood(foodId, updatedFood);
        return new ResponseEntity<>(food,HttpStatus.OK);
    }
    @DeleteMapping("/deletefood")
    public ResponseEntity<?> deleteFood(@RequestParam int foodId) {
        boolean isDeleted = foodSer.deleteFood(foodId);
        if (isDeleted) {
            return ResponseEntity.ok("Xóa food thành công");
        } else {
            return ResponseEntity.ok("Xóa food thất bại");
        }
    }
}
