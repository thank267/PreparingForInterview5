package ru.geekbrain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrain.entities.Student;
import ru.geekbrain.repositories.StudentRepository;

import java.util.stream.IntStream;

@SpringBootApplication
@Slf4j
public class HibernateApp implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Starting hibernate application...");

		studentRepository.deleteAll();

		IntStream.range(0, 1000).forEach(i -> {
			Student student = new Student();
			student.setName("the Name " + i);
			student.setMark("the Mark " + i);
			studentRepository.save(student);
		});

		log.info("The 1000'th student :" + studentRepository.getById(1000L));

		studentRepository.update(1000L);
		log.info("The 1000'th updated student :" + studentRepository.getById(1000L));

		studentRepository.deleteById(1000L);

		log.info("The 1000'th student :" + studentRepository.getById(1000L));

		log.info("All students :" + studentRepository.findAll());

		studentRepository.deleteAll();

		log.info("All students :" + studentRepository.findAll());
	}



}
