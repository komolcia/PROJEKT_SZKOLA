package net.javaguides.springboot;

import net.javaguides.springboot.controller.ClassController;
import net.javaguides.springboot.model.Class;
import net.javaguides.springboot.repository.ClassRepository;
import net.javaguides.springboot.service.ClassServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringbootThymeleafCrudWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootThymeleafCrudWebAppApplication.class, args);

	}

}
