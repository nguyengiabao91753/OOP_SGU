import java.io.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Base64;


public class user {
    private String taiKhoan;
    private String matKhau;
    private String mkmahoa;

    public user(String taiKhoan, String matKhau) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public void nhap(ArrayList<user> danhSachUser) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Nhập tài khoản: ");
            String taiKhoanMoi = scanner.nextLine();
            if (ktraTaiKhoan(taiKhoanMoi, danhSachUser)) {
                this.taiKhoan = taiKhoanMoi;
                break;
            } else {
                System.out.println("Tài khoản đã tồn tại. Vui lòng nhập tài khoản khác.");
            }
        }

        while (true) {
            System.out.print("Nhập mật khẩu: ");
            String matKhauMoi = scanner.nextLine();

            System.out.print("Nhập lại mật khẩu: ");
            String nhapLaiMatKhau = scanner.nextLine();

            if (matKhauMoi.equals(nhapLaiMatKhau)) {
                this.matKhau = matKhauMoi;
                break;
            } else {
                System.out.println("Mật khẩu không trùng khớp. Vui lòng nhập lại.");
            }
        }
    }

    public boolean ktraTaiKhoan(String newTaiKhoan, ArrayList<user> danhSachUser) {
        for (user user : danhSachUser) {
            if (user.getTaiKhoan().equalsIgnoreCase(newTaiKhoan)) {
                return false;
            }
        }
        return true;
    }

    public void xuatThongTin() {
        System.out.println("Tài khoản: " + getTaiKhoan());
        System.out.println("Mật khẩu: " + anPassword());
    }

    private String anPassword() {
        byte[] mahoa = Base64.getEncoder().encode(matKhau.getBytes());
        mkmahoa = new String(mahoa);
        return mkmahoa;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}

