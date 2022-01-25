package com.codegym;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CadreManagement {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Cadre> cadres;

    public CadreManagement() {
        this.cadres = new ArrayList<>();
    }

    public CadreManagement(ArrayList<Cadre> cadres) {
        this.cadres = cadres;
    }

    public ArrayList<Cadre> getCadres() {
        return cadres;
    }

    public void setCadres(ArrayList<Cadre> cadres) {
        this.cadres = cadres;
    }

    public void addNewCadres(Cadre newCadre) {
        cadres.add(newCadre);
    }

    public void displayAllCadres() {
        for (int i = 0; i < cadres.size(); i++) {
            System.out.println((i + 1) + ". " + cadres.get(i));
        }
        ;
    }

    public int findNameCadre(String name) {
        int index = -1;
        for (int i = 0; i < cadres.size(); i++) {
            if (cadres.get(i).equals(name)) {
                index = i;
            }
        }
        return index;
    }

    public void menu() {
        System.out.println("----MENU QUẢN LÝ CÁN BỘ----");
        System.out.println("1. Hiển thị tất cả cán bộ");
        System.out.println("2. Nhập thông tin  cán bộ mới");
        System.out.println("3. Tìm kiếm cán bộ theo họ tên");
        System.out.println("4. Thoát");
    }

    public Worker inputNewWorker() {
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

    public Engineer inputNewEngineer() {
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

    public Staff inputNewStaff() {
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

    public Cadre creatCadre() {
        System.out.println("1. Công nhân.");
        System.out.println("2. Kỹ sư");
        System.out.println("3. Nhân viên");
        System.out.println("0. Quay lại menu chính.");
        System.out.println("Bạn hãy lụa chọn: ");
        int choice = scanner.nextInt();
        Cadre newCadre = null;
        do {
            switch (choice) {
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
                case 3: {
                    System.out.println("---Thêm nhân viên---");
                    newCadre = inputNewStaff();
                    break;
                }
            }
            return newCadre;
        } while (choice != 0);
    }

    public void writeToFiles(String path) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Cadre cadre : cadres) {
            bufferedWriter.write(cadre.toString() + "\n");
        }
        bufferedWriter.close();
        fileWriter.close();
    }

    public void readFiles(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] lines = line.split(",");
            String name = lines[0].trim();
            String birthDay = lines[1].trim();
            String sex = lines[2].trim();
            String address = lines[3].trim();
            String level = lines[4].trim();
            Cadre cadre = null;
            cadre = new Worker(name, birthDay, sex, address, level);
            String majors = lines[4].trim();
            cadre = new Engineer(name, birthDay, sex, address, majors);
            String job = lines[4].trim();
            cadre = new Staff(name,birthDay,sex,address,job);
            this.cadres.add(cadre);
        }
        bufferedReader.close();
        fileReader.close();
    }
}
