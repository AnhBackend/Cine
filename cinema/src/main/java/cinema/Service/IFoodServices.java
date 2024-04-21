package cinema.Service;

import cinema.Entity.Cinema;
import cinema.Entity.Food;

import java.util.List;
import java.util.Optional;

public interface IFoodServices {
    public List<Food> getAllFood();
    public Food getFoodById(int foodId);
    public Food addFood(Food food);
    public Optional<Food> updateFood(int foodId, Food food);
    public boolean deleteFood(int foodId);
}
