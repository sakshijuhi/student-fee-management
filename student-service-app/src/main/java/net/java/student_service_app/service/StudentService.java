package net.java.student_service_app.service;
import net.java.student_service_app.dto.StudentRequestDTO;
import net.java.student_service_app.dto.StudentResponseDTO;
import net.java.student_service_app.entity.Student;
import net.java.student_service_app.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
public interface StudentService {

    StudentResponseDTO createStudent(StudentRequestDTO request);

    StudentResponseDTO getStudentById(Long id);

    List<StudentResponseDTO> getAllStudents();
}
