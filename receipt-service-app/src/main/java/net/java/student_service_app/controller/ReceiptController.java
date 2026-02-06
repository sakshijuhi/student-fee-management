package net.java.student_service_app.controller;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.java.student_service_app.dto.ReceiptRequestDTO;
import net.java.student_service_app.dto.ReceiptResponseDTO;
import net.java.student_service_app.entity.Receipt;
import net.java.student_service_app.service.ReceiptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/api/receipts")
@Tag(name = "Receipt APIs")
public class ReceiptController {

    private final ReceiptService service;

    public ReceiptController(ReceiptService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ReceiptResponseDTO> createReceipt(
            @RequestBody ReceiptRequestDTO request) {
        return ResponseEntity.ok(service.createReceipt(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceiptResponseDTO> getReceipt(@PathVariable long id) {
        return ResponseEntity.ok(service.getReceipt(id));
    }
}

