package com.codegym;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1;
        CadreManagement cadreManagement = new CadreManagement();
        try {
            cadreManagement.readFiles("cadre.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        do {
            cadreManagement.menu();
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            if (choice > 3) {
                System.out.println("chọn lại Menu!!!!");
            }
            switch (choice) {
                case 1: {
                    System.out.println("Danh sách cán bộ");
                    if (cadreManagement.getCadres().size() == 0) {
                        System.out.println("Không có cán bộ để hiển thị");
                    } else {
                        cadreManagement.displayAllCadres();
                    }
                    break;
                }

                case 2: {
                    System.out.println("----Nhập thông tin mới cho cán bộ");
                    Cadre newCadre;
                    newCadre = cadreManagement.creatCadre();
                    cadreManagement.addNewCadres(newCadre);
                    System.out.println("Đã thêm thành công!");
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
            try {
                cadreManagement.writeToFiles("cadre.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (choice != 4);
    }


}

