package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDaoImp implements CarDao {

    private List<Car> carList;

    {
        carList = new ArrayList<>();
        carList.add(new Car("BMW", "M5", 10000000));
        carList.add(new Car("LandRover", "Defender", 9000000));
        carList.add(new Car("Porsche", "Panamera", 13000000));
        carList.add(new Car("Mercedes", "Maybach", 12000000));
        carList.add(new Car("Audi", "Q8", 11000000));
    }

    @Override
    public List<Car> getCars(int quantity) {
        return carList.stream().limit(quantity).toList();
    }
}
