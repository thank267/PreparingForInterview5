package ru.geekbrain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@MappedSuperclass
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AbstractEntity {

	@Id
	@EqualsAndHashCode.Include()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

}
