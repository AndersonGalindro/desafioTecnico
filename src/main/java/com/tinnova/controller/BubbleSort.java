package com.tinnova.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bubbleBort")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class BubbleSort {

	@GetMapping
	public ResponseEntity<?> bubbleSort(@RequestParam Integer index0, @RequestParam Integer index1,
			@RequestParam Integer index2, @RequestParam Integer index3, @RequestParam Integer index4,
			@RequestParam Integer index5, @RequestParam Integer index6, @RequestParam Integer index7) {

		Integer[] vector = { index0, index1, index2, index3, index4, index5, index6, index7 };

		BubbleSort.order(vector);

		return new ResponseEntity(vector, HttpStatus.OK);
	}

	public static void order(Integer[] vector) {
		for (int i = 0; i < vector.length - 1; i++) {

			for (Integer j = 0; j < vector.length - 1 - i; j++) {

				Integer nextValue = vector[j + 1];

				if (vector[j] > nextValue) {

					Integer aux = vector[j];
					vector[j] = nextValue;
					vector[j + 1] = aux;

				}
			}
		}
	}

}
