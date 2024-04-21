package cinema.Service.ServiceImpl;

import cinema.Entity.Food;
import cinema.Repository.FoodRepo;
import cinema.Service.IFoodServices;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class FoodServicesImpl implements IFoodServices {
    @Autowired
    FoodRepo foodRepo;

    @Override
    public List<Food> getAllFood() {
        return foodRepo.findAll();
    }

    @Override
    public Food getFoodById(int foodId) {
        return foodRepo.findById(foodId)
                .orElseThrow(() -> new EntityNotFoundException("Food not found with id: " + foodId));
    }

    @Override
    public Food addFood(Food food) {
        return foodRepo.save(food);
    }

    @Override
    public Optional<Food> updateFood(int foodId, Food food) {
        Optional<Food> optionalFood = foodRepo.findById(foodId);
        if (optionalFood.isPresent()){
            Food food1 = optionalFood.get();
            // Copy các thuộc tính từ updatedFood vào foodToUpdate, giữ nguyên ID
            BeanUtils.copyProperties(food, food1,"id");
            return Optional.of(foodRepo.save(food1));
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteFood(int foodId) {
        if (foodRepo.existsById(foodId)){
            foodRepo.deleteById(foodId);
            return true;
        }
        return false;
    }
}
