package com.example.JuintTesting;

import com.example.JuintTesting.pattern.Combo;
import com.example.JuintTesting.pattern.ComboFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class JuintTestingApplication {

	public static void main(String[] args) {
		ComboFactory comboFactory = new ComboFactory();

		comboFactory.getCombo(Combo.LITE_COMBO).print();
		System.out.println("======================================");

		comboFactory.getCombo(Combo.FAMILY_COMBO).print();
	}

}
