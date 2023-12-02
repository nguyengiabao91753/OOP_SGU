import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.util.Scanner;

public class chuyenbay {
    private String machuyenbay;
    private int count=0;
    private HangHangKhong hang;
    private String thoigiankhoihanh;
    private String diemxuatphat;
    private String diemden;
    private int soghe;
    private String status;
    public chuyenbay(){
        machuyenbay=" ";
        hang =new HangHangKhong();
        thoigiankhoihanh=" ";
        diemxuatphat=" ";
        diemden=" ";
        status = "show";
        soghe=0;
        count++;
    }
    public int getCount() {
        return count;
    }
    public chuyenbay(chuyenbay tmp){
        machuyenbay=tmp.machuyenbay;
        hang=tmp.hang;
        thoigiankhoihanh=tmp.thoigiankhoihanh;
        diemxuatphat=tmp.diemxuatphat;
        diemden=tmp.diemden;
        soghe=tmp.soghe;
        status = "show";
    }
    public HangHangKhong getHang() {
        return hang;
    }
    public void setHang(HangHangKhong hang) {
        this.hang = hang;
    }
    
    public void nhap() throws Exception{
        Scanner input=new Scanner(System.in);
        // System.out.println("Nhập mã chuyến bay: ");
        if(getCount()<10){
            machuyenbay="CB0"+getCount();
        }
        else {
            machuyenbay="CB"+getCount();
        }
        System.out.println("Nhập mã hãng hàng không: ");
        hang.setMaHang(input.nextLine());
        //Kiểm tra mã đó có tồn tại trong file không
        boolean flag=true;
        while (flag) {
            QuanLyHangHangKhong tmp=new QuanLyHangHangKhong();
            tmp.docFile();
            for(HangHangKhong index:tmp.getDanhSachHang()){
                if(index.getMaHang().equals(hang.getMaHang())){
                    hang=index;
                    flag=false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Nhập hàng không không tồn tại,nhập lại.");
                hang.setMaHang(input.nextLine());
            }
        }
        
        System.out.println("Nhập thời gian khởi hành: ");
        thoigiankhoihanh=input.nextLine();
        System.out.println("Nhập điểm xuất phát bay: ");
        diemxuatphat=input.nextLine();
        System.out.println("Nhập điểm đến: ");
        diemden=input.nextLine();
        System.out.println("Nhập số lượng ghế của chuyến bay: ");
        soghe=input.nextInt();
        
    }
    public void xuat(){
        System.out.printf("Mã chuyến bay: %s || Mã hãng hàng không: %s || Tên hãng hàng không: %s ||Thời gian: %s || Điểm xuất phát: %s || Điểm đến: %s || Tổng số ghế: %d ||\n",machuyenbay,hang.getMaHang(),hang.getTenHang(),thoigiankhoihanh,diemxuatphat,diemden,soghe);
    }
    public String getMachuyenbay() {
        return machuyenbay;
    }
    public String getThoigiankhoihanh() {
        return thoigiankhoihanh;
    }
    public String getDiemxuatphat() {
        return diemxuatphat;
    }
    public String getDiemden() {
        return diemden;
    }
    public int getSoghe() {
        return soghe;
    }
    public void setMachuyenbay(String machuyenbay) {
        this.machuyenbay = machuyenbay;
    }
    public void setThoigiankhoihanh(String thoigiankhoihanh) {
        this.thoigiankhoihanh = thoigiankhoihanh;
    }
    public void setDiemxuatphat(String diemxuatphat) {
        this.diemxuatphat = diemxuatphat;
    }
    public void setDiemden(String diemden) {
        this.diemden = diemden;
    }
    public void setSoghe(int soghe) {
        this.soghe = soghe;
    }
}
