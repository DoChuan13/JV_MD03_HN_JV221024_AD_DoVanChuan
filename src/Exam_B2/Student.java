package Exam_B2;

import java.time.Year;
import java.util.Scanner;

public class Student {
    String studentId, studentName;
    int age;
    String sex;
    String phone, address;
    float html, css, javascript, avgMark;

    public Student() {
    }

    public Student(String studentId, String studentName, int age,
                   String sex, String phone, String address,
                   float html, float css, float javascript) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
        this.address = address;
        this.html = html;
        this.css = css;
        this.javascript = javascript;
    }
    //Get Method

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public float getHtml() {
        return html;
    }

    public float getCss() {
        return css;
    }

    public float getJavascript() {
        return javascript;
    }

    public float getAvgMark() {
        return avgMark;
    }

    //Set Method
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHtml(float html) {
        this.html = html;
    }

    public void setCss(float css) {
        this.css = css;
    }

    public void setJavascript(float javascript) {
        this.javascript = javascript;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public void calAvgMark() {
        float avgMark = (this.html + this.css + this.javascript * 2) / 4;
        this.setAvgMark(avgMark);
    }

    public void inputData() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập mã sinh viên: ");
        this.setStudentId(input.nextLine());
        System.out.print("Nhập tên sinh viên: ");
        this.setStudentName(input.nextLine());
        System.out.print("Nhập tuổi sinh viên: ");
        this.setAge(input.nextInt());
        System.out.print("Nhập giới tính: ");
        input.nextLine();
        this.setSex(input.nextLine());
        System.out.print("Nhập số điện thoại: ");
        this.setPhone(input.nextLine());
        System.out.print("Nhập địa chỉ: ");
        this.setAddress(input.nextLine());
        System.out.print("Nhập điểm HTML: ");
        this.setHtml(input.nextFloat());
        System.out.print("Nhập điểm CSS: ");
        this.setCss(input.nextFloat());
        System.out.print("Nhập điểm Javascript: ");
        this.setJavascript(input.nextFloat());
    }

    public void displayData() {
        calAvgMark();
        int currentYear = Year.now().getValue();
        int birthYear = currentYear - getAge();
        System.out.printf("%-20s%-20s%-20s%-20s\n" +
                        "%-20s%-20d%-20s%-20s%-20s%-20s\n" +
                        "%-20s%-60s%-20s%-20.2f\n",
                "Mã sinh viên: ", getStudentId(), "Tên sinh viên: ", getStudentName(),
                "Năm sinh: ", birthYear, "Giới tính: ", getSex(), "Điện thoại: ", getPhone(),
                "Địa chỉ: ", getAddress(), "Điểm trung bình: ", getAvgMark());
    }
}
