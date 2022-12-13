package com.restcalculator.controllers;
import com.restcalculator.Exceptions.InvalidOperationException;
import com.restcalculator.dto.DoMathRequest;
import com.restcalculator.services.MathOperatorImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin()
public class MathController {
	@PostMapping("/doMath")
	public ResponseEntity<Double> doMath(@RequestBody DoMathRequest operation) throws InvalidOperationException {
		MathOperatorImpl calculate = new MathOperatorImpl();
		double sum = calculate.doMath(operation.getOperand1(), operation.getOperand2(), operation.getOperator());
		return new ResponseEntity<>(sum, HttpStatus.OK);
	}


}
