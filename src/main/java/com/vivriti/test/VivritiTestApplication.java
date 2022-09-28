package com.vivriti.test;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class VivritiTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(VivritiTestApplication.class, args);

		log.info("---------------------------------------------------");
		log.info("Finding average of [1,2,3,4,5,6,7,8,9,10]...");
		int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		log.info(IntStream.of(values).average());
		log.info(List.of(values).stream().flatMapToInt(IntStream::of).average());
		log.info("---------------------------------------------------");
	}
}
