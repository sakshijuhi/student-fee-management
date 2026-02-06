package net.java.student_service_app.service;

import net.java.student_service_app.dto.ReceiptRequestDTO;
import net.java.student_service_app.dto.ReceiptResponseDTO;

public interface ReceiptService {

    ReceiptResponseDTO createReceipt(ReceiptRequestDTO request);

    ReceiptResponseDTO getReceipt(long id);
}
