package net.javaguides.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car_list")
public class AddCar {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "car_id")
	private int carId;

	@Column(name = "car_number")
	private long carNumber;

	@Column(name = "car_initial")
	private String carInitial;

	@Column(name = "car_kind")
	private String carKind;

	public AddCar() {

	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public long getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(long carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarInitial() {
		return carInitial;
	}

	public void setCarInitial(String carInitial) {
		this.carInitial = carInitial;
	}

	public String getCarKind() {
		return carKind;
	}

	public void setCarKind(String carKind) {
		this.carKind = carKind;
	}

	

}