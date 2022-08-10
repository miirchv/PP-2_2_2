package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class CarController {

    private CarService carService;
    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String listCars(@RequestParam(value = "count", required = false) String quantity, Model model) {
        int count = 5;
        try {
            count = Integer.parseInt(quantity);
        } catch (Exception e){

        }
        model.addAttribute("carsCatalog", carService.getCars(count));
        return "cars/catalog";
    }

}