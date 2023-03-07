package Exam_B2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Student[] studentsList = new Student[200];
        int[] sizeArray = {200};
        int option;
        boolean inputStatus = false;
        do {
            System.out.print("\n****************HACKATHON-JAVA-ADVANCE-1-MENU***************\n" +
                    "1. Nhập số sinh viên và nhập thông tin cho các sinh viên\n" +
                    "2. In thông tin các sinh viên đang quản lý\n" +
                    "3. Sắp xếp các sinh viên theo điểm trung bình tăng dần\n" +
                    "4. Nhập vào tên sinh viên và tìm kiếm sinh viên theo tên\n" +
                    "5. Thống kê số sinh viên nam, nữ đang quản lý\n" +
                    "6. In ra thông tin các sinh viên xếp loại giỏi và trung bình\n" +
                    "7. Thoát\n");
            System.out.print("\nVui lòng chọn một mục thực thi: ");
            option = input.nextInt();
            if (!inputStatus && option != 1) {
                System.out.println("Chưa có thông tin sinh viên, vui lòng chọn 1!!!");
            } else {
                if (option != 7) {
                    switch (option) {
                        case 1:
                            inputStudentsList(studentsList, sizeArray);
                            inputStatus = true;
                            break;
                        case 2:
                            System.out.println("Danh sách các sinh viên là: ");
                            displayStudentsList(studentsList, sizeArray);
                            break;
                        case 3:
                            sortAscendingByPoint(studentsList, sizeArray);
                            break;
                        case 4:
                            findStudentByName(studentsList, sizeArray);
                            break;
                        case 5:
                            summaryMaleFemaleStudent(studentsList, sizeArray);
                            break;
                        case 6:
                            countExcellentAndAvg(studentsList, sizeArray);
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!!!");
                            break;
                    }
                } else {
                    System.out.println("Chuương trình sẽ kết thúc ngay sau đây!!!");
                }
            }
        } while (option != 7);
    }

    //1. Nhập số sinh viên và nhập thông tin cho các sinh viên
    public static void inputStudentsList(Student[] studentsList, int[] sizeArray) {
        Scanner input = new Scanner(System.in);
        int size;
        do {
            System.out.print("Nhập số sinh viên trong mảng (max = 200): ");
            size = input.nextInt();
            if (size < 0 || size > 200) {
                System.out.println("Kích thước mảng không hợp lệ, vui lòng nhập lại");
            }
        } while (size < 0 || size > 200);
        sizeArray[0] = size;
        for (int i = 0; i < size; i++) {
            System.out.printf("\nNhập thông tin sinh viên thứ %d\n", (i + 1));
            studentsList[i] = new Student();
            studentsList[i].inputData();
        }
        System.out.println("\nDanh sách sinh viên đã được nhập thành công!!!\n");
    }

    //2. In thông tin các sinh viên đang quản lý
    public static void displayStudentsList(Student[] studentsList, int[] sizeArray) {
        int size = sizeArray[0];
        for (int i = 0; i < size; i++) {
            System.out.printf("\nThông tin sinh viên thứ %d: \n", (i + 1));
            studentsList[i].displayData();
        }
    }

    //3. Sắp xếp các sinh viên theo điểm trung bình tăng dần
    public static void sortAscendingByPoint(Student[] studentsList, int[] sizeArray) {
        Student[] sortStudentsList = cloneStudentsList(studentsList, sizeArray);
        int size = sizeArray[0];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                float studentJ = sortStudentsList[j].getAvgMark();
                float studentI = sortStudentsList[i].getAvgMark();
                if (studentJ > studentI) {
                    Student temp = sortStudentsList[j];
                    sortStudentsList[j] = sortStudentsList[i];
                    sortStudentsList[i] = temp;
                }
            }
        }
        System.out.println("Mảng sinh viên có điểm trung bình tăng dần là: ");
        displayStudentsList(sortStudentsList, sizeArray);

    }

    //4. Nhập vào tên sinh viên và tìm kiếm sinh viên theo tên
    public static void findStudentByName(Student[] studentsList, int[] sizeArray) {
        int size = sizeArray[0];
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập tên sinh viên cần tìm kiếm: ");
        String searchValue = input.nextLine();
        System.out.println("Danh sách sinh viên có kết quả phù hợp:");
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (studentsList[i].getStudentName().equalsIgnoreCase(searchValue)) {
                studentsList[i].displayData();
                count++;
            } else if (i == size - 1 && count == 0) {
                System.out.println("\nKhông tìm thấy kết quả hợp lệ!!!");
            }

        }
    }

    //5. Thống kê số sinh viên nam, nữ đang quản lý
    public static void summaryMaleFemaleStudent(Student[] studentsList, int[] sizeArray) {
        int size = sizeArray[0];
        int countMale = 0, countFemale = 0;
        for (int i = 0; i < size; i++) {
            if (studentsList[i].getSex().equalsIgnoreCase("Nam")) {
                countMale++;
            }
            if (studentsList[i].getSex().equalsIgnoreCase("Nữ")) {
                countFemale++;
            }
        }
        System.out.printf("\nDanh sách sinh viên có %d Nam và %d Nữ\n", countMale, countFemale);
    }

    //6. In ra thông tin các sinh viên xếp loại giỏi và trung bình
    public static void countExcellentAndAvg(Student[] studentsList, int[] sizeArray) {
        int size = sizeArray[0];
        int countExc = 0, countAvg = 0;
        System.out.println("Danh sách sinh viên xếp loại giỏi:");
        for (int i = 0; i < size; i++) {
            float avgMark = studentsList[i].getAvgMark();
            if (avgMark >= 8 && avgMark < 9) {
                studentsList[i].displayData();
                countExc++;
            } else if (i == size - 1 && countExc == 0) {
                System.out.println("Không có sinh viên loại giỏi nào\n");
            }
        }
        System.out.println("Danh sách sinh viên xếp loại trung bình: ");
        for (int i = 0; i < size; i++) {
            float avgMark = studentsList[i].getAvgMark();
            if (avgMark >= 5 && avgMark < 7) {
                studentsList[i].displayData();
                countAvg++;
            } else if (i == size - 1 && countAvg == 0) {
                System.out.println("Không có sinh viên loại trung bình nào\n");
            }
        }
    }

    //Extra
    public static Student[] cloneStudentsList(Student[] studentsList, int[] sizeArray) {
        int size = sizeArray[0];
        Student[] cloneList = new Student[size];
        for (int i = 0; i < size; i++) {
            cloneList[i] = studentsList[i];
        }
        return cloneList;
    }
}
