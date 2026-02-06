package net.java.student_service_app.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class ReceiptRequestDTO {

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    @Schema(example = "Sharaf Aboobacker")
    private String studentName;

    @Schema(example = "1")
    private long studentId;

    @Schema(example = "123456781234")
    private String referenceNumber;

    @Schema(example = "VISA")
    private String cardType;

    @Schema(example = "0.10")
    private double tuitionFee;
}

