package net.java.student_service_app.service.impl;

import net.java.student_service_app.dto.StudentRequestDTO;
import net.java.student_service_app.dto.StudentResponseDTO;
import net.java.student_service_app.entity.Student;
import net.java.student_service_app.exception.ResourceNotFoundException;
import net.java.student_service_app.repository.StudentRepository;
import net.java.student_service_app.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO request) {
        Student student = new Student();
        student.setStudentName(request.getStudentName());
        student.setGrade(request.getGrade());
        student.setMobileNumber(request.getMobileNumber());
        student.setSchoolName(request.getSchoolName());

        return mapToDTO(repository.save(student));
    }

    @Override
    public StudentResponseDTO getStudentById(Long id) {
        Student student = repository.findById(String.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        return mapToDTO(student);
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    private StudentResponseDTO mapToDTO(Student student) {
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setId(student.getId());
        dto.setStudentName(student.getStudentName());
        dto.setGrade(student.getGrade());
        dto.setMobileNumber(student.getMobileNumber());
        dto.setSchoolName(student.getSchoolName());
        return dto;
    }
}

