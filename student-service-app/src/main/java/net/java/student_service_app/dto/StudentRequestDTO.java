package net.java.student_service_app.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class StudentRequestDTO {

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Schema(example = "Sharaf Aboobacker")
    private String studentName;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Schema(example = "Grade 1")
    private String grade;

    @Schema(example = "9876543210")
    private String mobileNumber;

    @Schema(example = "Skiply School of Excellence")
    private String schoolName;
}

