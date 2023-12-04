import java.util.Scanner;

abstract class nguoi {
    protected String hoTen, gioiTinh, diaChi, sdt, status;
    static Scanner sc = new Scanner(System.in);


    public nguoi(){
        hoTen = "";
        gioiTinh = "";
        diaChi = "";
        sdt = "";
        status = "show";
    }
    public nguoi(String hoTen, String gioiTinh, String diaChi, String sdt, String status){
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.status = status;
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


    
    public String getHoTen(){
        return hoTen;
    }
    public void setHoTen(String hoTen){
        this.hoTen = hoTen;
    }



    public String getGioiTinh(){
        return gioiTinh;
    }
    public void setGioiTinh(String gioiTinh){
        this.gioiTinh = gioiTinh;
    }



    public String getDiaChi(){
        return diaChi;
    }
    public void setDiaChi(String diaChi){
        this.diaChi = diaChi;
    }



    public String getSdt(){
        return sdt;
    }
    public void setSdt(String sdt){
        this.sdt = sdt;
    }



    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
}