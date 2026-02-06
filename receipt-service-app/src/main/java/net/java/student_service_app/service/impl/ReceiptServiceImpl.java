package net.java.student_service_app.service.impl;

import net.java.student_service_app.dto.ReceiptRequestDTO;
import net.java.student_service_app.dto.ReceiptResponseDTO;
import net.java.student_service_app.entity.Receipt;
import net.java.student_service_app.exception.ResourceNotFoundException;
import net.java.student_service_app.repository.ReceiptRepository;
import net.java.student_service_app.service.ReceiptService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    private final ReceiptRepository repository;

    public ReceiptServiceImpl(ReceiptRepository repository) {
        this.repository = repository;
    }

    @Override
    public ReceiptResponseDTO createReceipt(ReceiptRequestDTO request) {

        Receipt receipt = new Receipt();
        receipt.setTransactionId("TXN-" + System.currentTimeMillis());
        receipt.setTransactionDate(LocalDateTime.now());
        receipt.setStudentName(request.getStudentName());
        receipt.setStudentId(request.getStudentId());
        receipt.setReferenceNumber(request.getReferenceNumber());
        receipt.setCardType(request.getCardType());
        receipt.setTuitionFee(request.getTuitionFee());
        receipt.setTotalAmount(request.getTuitionFee());

        return mapToDTO(repository.save(receipt));
    }

    @Override
    public ReceiptResponseDTO getReceipt(long id) {
        Receipt receipt = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Receipt not found"));
        return mapToDTO(receipt);
    }

    private ReceiptResponseDTO mapToDTO(Receipt receipt) {
        ReceiptResponseDTO dto = new ReceiptResponseDTO();
        dto.setTransactionId(receipt.getTransactionId());
        dto.setTransactionDate(receipt.getTransactionDate());
        dto.setStudentName(receipt.getStudentName());
        dto.setStudentId(receipt.getStudentId());
        dto.setReferenceNumber(receipt.getReferenceNumber());
        dto.setCardType(receipt.getCardType());
        dto.setTuitionFee(receipt.getTuitionFee());
        dto.setTotalAmount(receipt.getTotalAmount());
        return dto;
    }
}

