import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Serializable;
import java.util.Scanner;

public class chuyenbay {
    private String machuyenbay;
    private String mahangkhong;
    private String thoigiankhoihanh;
    private String diemxuatphat;
    private String diemden;
    private int soghe;
    public chuyenbay(){
        machuyenbay=" ";
        mahangkhong = " ";
        thoigiankhoihanh=" ";
        diemxuatphat=" ";
        diemden=" ";
        soghe=0;
    }
    public chuyenbay(chuyenbay tmp){
        machuyenbay=tmp.machuyenbay;
        mahangkhong = tmp.mahangkhong;
        thoigiankhoihanh=tmp.thoigiankhoihanh;
        diemxuatphat=tmp.diemxuatphat;
        diemden=tmp.diemden;
        soghe=tmp.soghe;
    }
    public void nhap(){
        Scanner input=new Scanner(System.in);
        System.out.println("Nhập mã chuyến bay: ");
        machuyenbay=input.nextLine();
        System.out.println("Nhập mã hãng hàng không: ");
        mahangkhong=input.nextLine();
        //Kiểm tra mã đó có tồn tại trong file không
        boolean flag=true;
        while (flag) {
            try {
            BufferedReader fr = new BufferedReader(new FileReader("dataHanghangkhong.txt"));
            String line = fr.readLine();
            while (line != null) {
                String[] arr = line.split(",");
                if (mahangkhong.equals(arr[0])) {
                    flag=false;
                    break;
                }
                line = fr.readLine();
            }
            
            } catch (Exception e) {
                // TODO: handle exception
            }
            if (flag) {
                System.out.println("Nhập hàng không không tồn tại,nhập lại.");
                mahangkhong=input.nextLine();
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
        System.out.printf("Mã chuyến bay: %s || Mã hãng hàng không %s || Thời gian: %s || Điểm xuất phát: %s || Điểm đến: %s || Tổng số ghế: %d ||\n",machuyenbay,mahangkhong,thoigiankhoihanh,diemxuatphat,diemden,soghe);
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
    public String getMahangkhong() {
        return mahangkhong;
    }
    public void setMahangkhong(String mahangkhong) {
        this.mahangkhong = mahangkhong;
    }
}
