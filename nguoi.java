import java.util.Scanner;
abstract class nguoi {
    protected String hoTen, gioiTinh, diaChi, sdt;
    static Scanner sc = new Scanner(System.in);


    public nguoi(){
        hoTen = "";
        gioiTinh = "";
        diaChi = "";
        sdt = "";
    }
    public nguoi(String hoTen, String gioiTinh, String diaChi, String sdt){
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }


  
    public void nhap(){
        System.out.print("\nNhap ho ten: ");
        hoTen = sc.nextLine();
        System.out.print("\nNhap gioi tinh: ");
        gioiTinh = sc.nextLine();
        System.out.print("\nNhap dia chi: ");
        diaChi = sc.nextLine();
        System.out.print("\nNhap so dien thoai: ");
        sdt = sc.nextLine();
    }

    public abstract void xuat();
}