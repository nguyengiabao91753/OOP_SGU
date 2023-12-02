import java.io.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

interface IXuat {
    void xuat();
}

public class HangHangKhong implements IXuat {
    private String tenHang;
    private String maHang;
    private String status;

    public HangHangKhong() {
        tenHang = "";
        maHang = "";
        status = "show";
    }

    public HangHangKhong(String tenHang, String maHang,String status) {
        this.tenHang = tenHang;
        this.maHang = maHang;
        this.status = status;
    }

    public void nhap() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên hãng hàng không: ");
        tenHang = input.nextLine();
        System.out.println("Nhập mã hãng hàng không: ");
        maHang = input.nextLine();
    }

    public void xuat() {
        System.out.printf("Mã hãng hàng không: %s\n", maHang);
        System.out.printf("Tên hãng hàng không: %s\n", tenHang);
    }

    public String getTenHang() {
        return tenHang;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

