package ru.geekbrain.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrain.entities.Student;

@Repository
public class StudentRepository extends AbstractJpaDAO<Student, Long> {

	public StudentRepository() {
		setClazz(Student.class);
	}

	@Transactional
	public void update(Long id) {

		Student student = findById(id).orElseThrow();
		student.setName("updated Name");
		student.setMark("updated Mark");
		save(student);

	}
}
