package com.recipes.Spring5recipe;

import com.recipes.Spring5recipe.bootstrap.DataLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Spring5RecipeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Spring5RecipeApplication.class, args);
		try {
			context.getBean(DataLoader.class).run(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
