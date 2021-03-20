package com.example.springcloudfunctiontest.functions;

import java.util.function.Function;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Revert implements Function<String, String> {

	@Override
	public String apply(String value) {
		String r = new StringBuilder(value).reverse().toString();
		log.info(value);
		log.info(r);
		return r;
	}

}
