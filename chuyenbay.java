
import java.util.Scanner;

public class chuyenbay {
    private String machuyenbay;
    private String thoigiankhoihanh;
    private String diemxuatphat;
    private String diemden;
    private int soghe;
    public chuyenbay(){
        machuyenbay=" ";
        thoigiankhoihanh=" ";
        diemxuatphat=" ";
        diemden=" ";
        soghe=0;
    }
    public chuyenbay(chuyenbay tmp){
        machuyenbay=tmp.machuyenbay;
        thoigiankhoihanh=tmp.thoigiankhoihanh;
        diemxuatphat=tmp.diemxuatphat;
        diemden=tmp.diemden;
        soghe=tmp.soghe;
    }
    public void nhap(){
        Scanner input=new Scanner(System.in);
        System.out.println("Nhập mã chuyến bay: ");
        machuyenbay=input.nextLine();
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
        System.out.printf("Mã chuyến bay: %s || Thời gian: %s || Điểm xuất phát: %s || Điểm đến: %s || Tổng số ghế: %d ||\n",machuyenbay,thoigiankhoihanh,diemxuatphat,diemden,soghe);
    }
    public String getMachuyenbay() {
        return machuyenbay;
    }
    public static void main(String[] argv){
        chuyenbay m1=new chuyenbay();
        m1.nhap();
        m1.xuat();
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
