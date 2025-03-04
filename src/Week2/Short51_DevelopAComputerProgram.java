
package Week2;

import java.util.Scanner;

public class Short51_DevelopAComputerProgram {
    
    static Scanner scanner = new Scanner(System.in);
    static double result = 0;
    public void menu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n---- Menu May Tinh ----");
            System.out.println("1. May Tinh Thuong");
            System.out.println("2. May Tinh BMI");
            System.out.println("3. Thoat");
            int luaChon = nhapSoNguyen("Chon mot lua chon: ");
            switch (luaChon) {
                case 1:
                    mayTinhThuong();
                    break;
                case 2:
                    tinhBMI();
                    break;
                case 3:
                    System.out.println("Thoat chuong trinh...");
                    exit = true;
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon mot lua chon hop le.");
            }
        }
    }
    public void mayTinhThuong() {
        double so1 = nhapSoThuc("Nhap so thu nhat: ");
        String phepTinh = nhapPhepTinh();
        double so2 = nhapSoThuc("Nhap so thu hai: ");
        switch (phepTinh) {
            case "+":
                result = so1 + so2;
                break;
            case "-":
                result = so1 - so2;
                break;
            case "*":
                result = so1 * so2;
                break;
            case "/":
                if (so2 != 0) {
                    result = so1 / so2;
                } else {
                    System.out.println("Loi: Khong the chia cho so 0.");
                    return;
                }
                break;
            case "^":
                result = Math.pow(so1, so2);
                break;
            default:
                System.out.println("Phep tinh khong hop le.");
                return;
        }
        System.out.println("Ket qua: " + result);
    }
    public void tinhBMI() {
        double canNang = nhapSoThuc("Nhap can nang cua ban (kg): ");
        double chieuCao = nhapSoThuc("Nhap chieu cao cua ban (m): ");
        if (chieuCao > 0) {
            double bmi = canNang / (chieuCao * chieuCao);
            System.out.println("Chi so BMI cua ban la: " + bmi);
            hienThiTrangThaiBMI(bmi);
        } else {
            System.out.println("Loi: Chieu cao phai lon hon 0.");
        }
    }
    public void hienThiTrangThaiBMI(double bmi) {
        if (bmi < 19) {
            System.out.println("Trang thai: Duoi chuan.");
        } else if (bmi >= 19 && bmi <= 25) {
            System.out.println("Trang thai: Chuan.");
        } else if (bmi > 25 && bmi <= 30) {
            System.out.println("Trang thai: Thua can.");
        } else if (bmi > 30 && bmi <= 40) {
            System.out.println("Trang thai: Beo - nen giam can.");
        } else if (bmi > 40) {
            System.out.println("Trang thai: Rat beo - can giam can ngay lap tuc.");
        }
    }
    public double nhapSoThuc(String thongDiep) {
        while (true) {
            System.out.print(thongDiep);
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Nhap khong hop le. Vui long nhap mot so thuc hop le.");
                scanner.next(); // bo qua dau vao khong hop le
            }
        }
    }
    public String nhapPhepTinh() {
        while (true) {
            System.out.print("Nhap phep tinh (+, -, *, /, ^): ");
            String phepTinh = scanner.next();
            if (phepTinh.equals("+") || phepTinh.equals("-") || phepTinh.equals("*") || phepTinh.equals("/") || phepTinh.equals("^")) {
                return phepTinh;
            } else {
                System.out.println("Phep tinh khong hop le. Vui long nhap mot trong cac phep tinh (+, -, *, /, ^).");
            }
        }
    }
    public int nhapSoNguyen(String thongDiep) {
        while (true) {
            System.out.print(thongDiep);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Nhap khong hop le. Vui long nhap mot so nguyen hop le.");
                scanner.next();
            }
        }
    }
}