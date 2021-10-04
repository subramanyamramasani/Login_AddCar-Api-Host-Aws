package net.javaguides.springboot.controller;

import java.sql.PreparedStatement;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.entity.AddCar;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.entity.Validate;
import net.javaguides.springboot.repository.CarRepository;
import net.javaguides.springboot.repository.UserRepository;



@RestController
@RequestMapping("/api")
public class AddLoginController {

	@Autowired
	CarRepository carRepository;

	@Autowired
	UserRepository userRepository;

	@PostMapping("/addcar")
	public Validate addCar(@RequestBody AddCar addCar) {
		Validate val = new Validate();
		val.setReturnCode("0");
		val.setReturnMsg("inserted successfully");

		carRepository.save(addCar);

		return val; 
	}

	@PostMapping("/login")
	public Validate login(@RequestBody User user) {
		Validate val = new Validate();
		if (displayUsers(user.getUsername(), user.getPassword())) {
			val.setReturnCode("0");
			val.setReturnMsg("user authenticated");
		} else {
			val.setReturnCode("1");
			val.setReturnMsg("user not found");
		}
		return val;
	}

	public Boolean displayUsers(String userName, String password) {
		Boolean res = false;

		try {

			List<User> users = userRepository.findAll();

			for (User other : users) {

				if (userName.equals(other.getUsername())) {
					if (password.equals(other.getPassword())) {

						res = true;
					}
				}
			}

		} catch (Exception e) {

			System.out.println(e);
		}
		return res;
	}

	@GetMapping("/allcars")
	public Iterable<AddCar> allCars() {

		return carRepository.findAll();
	}

	@GetMapping("/{carId}")
	public Optional<AddCar> countryById(@PathVariable("carId") int carId) {

		return carRepository.findById(carId);
	}

	@PutMapping("/updatecar")
	public AddCar updateCar(@RequestBody AddCar addCar) {

		return carRepository.save(addCar);
	}

	@DeleteMapping("/{carId}")
	public void deleteCountry(@PathVariable("carId") int carId) {

		carRepository.deleteById(carId);
	}
}