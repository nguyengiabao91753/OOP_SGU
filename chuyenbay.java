import java.util.Scanner;

public class chuyenbay {
    private String machuyenbay;
    private String thoigiankhoihanh;
    private String diemxuatphat;
    private String diemden;
    private int soghe;
    private int giave;
    public chuyenbay(){
        machuyenbay=" ";
        thoigiankhoihanh=" ";
        diemxuatphat=" ";
        diemden=" ";
        soghe=0;
        giave=0;
    }
    public void nhap(){
        Scanner input=new Scanner(System.in);
        System.out.println("Nhap ma chuyen bay: ");
        machuyenbay=input.nextLine();
        System.out.println("Thoi gian khoi hanh: ");
        thoigiankhoihanh=input.nextLine();
        System.out.println("Nhap diem xuat phat bay: ");
        diemxuatphat=input.nextLine();
        System.out.println("Nhap diem den: ");
        diemden=input.nextLine();
        System.out.println("Nhap so luong ghe: ");
        soghe=input.nextInt();
        System.out.println("Nhap gia ve: ");
        giave=input.nextInt()    ;
    }
    public void xuat(){
        System.out.printf("Ma chuyen bay: %s || Thoi gian: %s || Diem xuat phat: %s || Diem den: %s || So ghe: %d || Gia ve: %d\n",machuyenbay,thoigiankhoihanh,diemxuatphat,diemden,soghe,giave);
    }
    public String getmachuyenbay(){
        return machuyenbay;
    }
    public static void main(String[] argv){
        chuyenbay m1=new chuyenbay();
        m1.nhap();
        m1.xuat();
    }
}
