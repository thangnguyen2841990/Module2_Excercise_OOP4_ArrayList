package com.codegym;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
        int choice = -1;
        CadreManagement cadreManagement = new CadreManagement();
        do {
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            if (choice > 3) {
                System.out.println("chọn lại Menu!!!!");
            }
            switch (choice) {
                case 1: {
                    cadreManagement.displayAllCadres();
                    break;
                }

                case 2: {
                    System.out.println("----Nhập thông tin mới cho cán bộ");
                    System.out.println("Nhập số lượng cán bộ muốn nhập: ");
                    int n = scanner.nextInt();
                    Cadre newCadre;
                    for (int i = 0; i < n; i++) {
                        System.out.println("Cán bộ số: " + (i + 1));
                        newCadre = creatCadre();
                        cadreManagement.addNewCadres(newCadre);
                    }
                    break;
                }
                case 3: {
                    Scanner inputName = new Scanner(System.in);
                    System.out.println("----Tìm nhân viên theo tên----");
                    System.out.println("Nhập tên cán bộ cần tim: ");
                    String name = inputName.nextLine();
                    int index = cadreManagement.findNameCadre(name);
                    if (index == -1) {
                        System.out.println("Không tìm thấy cán bộ tên: " + name);
                    } else {
                        System.out.println(cadreManagement.getCadres().get(index));
                    }
                    break;
                }
            }

        } while (choice != 4);
    }

    public static void menu() {
        System.out.println("----MENU QUẢN LÝ CÁN BỘ----");
        System.out.println("1. Hiển thị tất cả cán bộ");
        System.out.println("2. Nhập thông tin  cán bộ mới");
        System.out.println("3. Tìm kiếm cán bộ theo họ tên");
        System.out.println("4. Thoát");
    }

    public static Worker inputNewWorker() {
        scanner.nextLine();
        System.out.println("Họ và tên: ");
        String name = scanner.nextLine();
        System.out.println("Ngày tháng năm sinh: ");
        String birthDay = scanner.nextLine();
        System.out.println("Giới tính: ");
        String sex = scanner.nextLine();
        System.out.println("Địa chỉ: ");
        String address = scanner.nextLine();
        System.out.println("Nhập số bậc của công nhân");
        String level = scanner.nextLine();
        return new Worker(name, birthDay, sex, address, level);
    }

    public static Engineer inputNewEngineer() {
        scanner.nextLine();
        System.out.println("Họ và tên: ");
        String name = scanner.nextLine();
        System.out.println("Ngày tháng năm sinh: ");
        String birthDay = scanner.nextLine();
        System.out.println("Giới tính: ");
        String sex = scanner.nextLine();
        System.out.println("Địa chỉ: ");
        String address = scanner.nextLine();
        System.out.println("Nhập ngành đào tạo: ");
        String majors = scanner.nextLine();
        return new Engineer(name, birthDay, sex, address, majors);
    }

    public static Staff inputNewStaff() {
        scanner.nextLine();
        System.out.println("Họ và tên: ");
        String name = scanner.nextLine();
        System.out.println("Ngày tháng năm sinh: ");
        String birthDay = scanner.nextLine();
        System.out.println("Giới tính: ");
        String sex = scanner.nextLine();
        System.out.println("Địa chỉ: ");
        String address = scanner.nextLine();
        System.out.println("Nhập công việc: ");
        String job = scanner.nextLine();
        return new Staff(name, birthDay, sex, address, job);
    }

    public static Cadre creatCadre() {
        System.out.println("1. Công nhân.");
        System.out.println("2. Kỹ sư");
        System.out.println("3. Nhân viên");
        System.out.println("Bạn hãy lụa chọn: ");
        Cadre newCadre;
        int choice1 = scanner.nextInt();
        switch (choice1) {
            case 1: {
                System.out.println("---Thêm công nhân---");
                newCadre = inputNewWorker();
                break;
            }
            case 2: {
                System.out.println("---Thêm kỹ sư---");
                newCadre = inputNewEngineer();
                break;
            }
            default: {
                System.out.println("---Thêm nhân viên---");
                newCadre = inputNewStaff();
                break;
            }
        }
        return newCadre;
    }
}

