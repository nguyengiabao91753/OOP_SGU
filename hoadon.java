import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class hoadon {
    private String maHD;
    private ve ve;
    private String ngaytao;
    private String maNV;
    Scanner nhap = new Scanner(System.in);

    public hoadon() {
        ve = new ve();
        ngaytao = "";
        maHD = "";
        maNV = "";
    }

    public ve getVe() {
        return ve;
    }

    public void setVe(ve ve) {
        this.ve = ve;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public void themhoadon() {
        // System.out.println("Nhập mã hóa đơn: ");
        // maHD = nhap.nextLine();

        System.out.println("Nhập mã nhân viên: ");
        maNV = nhap.nextLine();
        if (ve.getTrangthai().equals("da thanh toan")) {
            LocalDateTime ngayTao = LocalDateTime.now(); // Lấy thời gian thực tế
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            ngaytao = ngayTao.format(formatter);
        }

    }

    public void xuat() {
        System.out.println("Mã hóa đơn: " + maHD);
        System.out.println("Mã nhân viên: " + maNV);
        ve.xuat();
        System.out.println("Ngày tạo: " + ngaytao);
    }
}



class Main {
    public static void main(String[] args) throws Exception {
        quanly_hoadon quanlyhoadon = new quanly_hoadon();
        quanlyhoadon.docfile();
        quanlyhoadon.xuat();
        // quanly_hoadon.thongke();
        // quanly_hoadon quanly_hoadon = new quanly_hoadon();
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy
        // HH:mm:ss");
        // quanly_hoadon.docfile();
        // quanly_hoadon.xuat();
        // int[] a = new int[1000];
        // int i=0, t=0;
        // //truyền năm vào mảng
        // for (hoadon hoadon : quanly_hoadon.getQuanly_hoadon()) {
        // LocalDateTime date = LocalDateTime.parse(hoadon.getNgaytao(), formatter);
        // int nam = date.getYear() + 1900;
        // for(int j =0; j<1000;j++){
        // t = 0;
        // if(a[j] == nam){
        // t=1;
        // }
        // }
        // if(t==0){
        // a[i] = nam;
        // i++;
        // }
        // }
        // quanly_hoadon.xuat();
        // //sắp xếp mảng tăng dần
        // for(int x=0;x<1000-1;x++){
        // for(int z = x+1; z<1000;z++){
        // if(a[z] < a[x]){
        // int tmp = a[x];
        // a[x] = a[z];
        // a[z] = tmp;
        // }
        // }
        // }
        // //Thống kê
        // for(int j =0; j<i;j++){
        // int sum=0;
        // System.out.println("Năm "+a[j]+": ");
        // for (hoadon hoadon : quanly_hoadon.getQuanly_hoadon()) {
        // if (hoadon.getNgaytao().contains(String.valueOf(a[j]))) {
        // sum+= hoadon.getVe().getGia();
        // }
        // }
        // System.out.println(" Tổng doanh thu: "+sum);
        // }
    }
}
