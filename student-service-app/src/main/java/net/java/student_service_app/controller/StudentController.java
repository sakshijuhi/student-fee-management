package net.java.student_service_app.controller;



import io.swagger.v3.oas.annotations.tags.Tag;
import net.java.student_service_app.dto.StudentRequestDTO;
import net.java.student_service_app.dto.StudentResponseDTO;
import net.java.student_service_app.entity.Student;
import net.java.student_service_app.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Student APIs")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<StudentResponseDTO> createStudent(
            @RequestBody StudentRequestDTO request) {
        return ResponseEntity.ok(service.createStudent(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(service.getStudentById(id));
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {
        return ResponseEntity.ok(service.getAllStudents());
    }
    @GetMapping("/")
    public String home() {
        return "Student Service is running";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
