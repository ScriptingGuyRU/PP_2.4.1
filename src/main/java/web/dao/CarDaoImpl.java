package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    private List<Car> carList = new ArrayList<>();

    public CarDaoImpl() {

        for(int i = 0; i < 17; i++) {
            carList.add(new Car("model_" + i, "00" + i + "ru",2000 + i));
        }
    }

    @Override
    public List<Car> getSomeCars() {

        int countOfCar = (int) ((Math.random()+3)*4); //рандом от 3 до 16

        List<Car> cars = new ArrayList<>();

        for(int i = 0; i < countOfCar; i++){
            int numberCarInMainList = (int) (Math.random()*16);
            cars.add(carList.get(numberCarInMainList));
        }

        return cars;
    }
}
