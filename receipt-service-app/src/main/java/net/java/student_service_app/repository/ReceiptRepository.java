package net.java.student_service_app.repository;

import net.java.student_service_app.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

    List<Receipt> findByStudentId(long studentId);

    Optional<Receipt> findByTransactionReference(String transactionReference);
}


