package ru.geekbrain.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "students")
@ToString(callSuper=true)
public class Student extends AbstractEntity {

	@Column(length = 250, nullable = false, unique = false)
	private String name;

	@Column(length = 250)
	private String mark;
}
