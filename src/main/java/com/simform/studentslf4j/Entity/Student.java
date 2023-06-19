package com.simform.studentslf4j.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

  @Id
  @Column(name = "student_id")
  long id;
  @Column(name = "student_name")
  String name;
  @Column(name = "student_technology")
  String technology;
}
