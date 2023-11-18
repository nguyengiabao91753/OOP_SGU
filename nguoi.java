import java.util.Scanner;

abstract class nguoi {
    protected String hoten, gioitinh, diachi, sdt;
    Scanner sc = new Scanner(System.in);


    public nguoi(){
    }
    public nguoi(String hoten, String gioitinh, String diachi, String sdt){
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.sdt = sdt;
    }


    
    public void nhap(){
        System.out.print("\nNhap ho ten: ");
        hoten = sc.nextLine();
        System.out.print("\nNhap gioi tinh: ");
        gioitinh = sc.nextLine();
        System.out.print("\nNhap dia chi: ");
        diachi = sc.nextLine();
        System.out.print("\nNhap so dien thoai: ");
        sdt = sc.nextLine();
    }
    public abstract void xuat();
}
