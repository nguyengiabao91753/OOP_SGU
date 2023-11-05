import java.util.Scanner;
class nhanvien extends nguoi {
    private String maNV, chucvu;
    Scanner sc = new Scanner(System.in);


    public nhanvien(){
        maNV = "";
        chucvu = "";
        hoten = "";
        gioitinh = "";
        diachi = "";
        sdt = "";
    }
    public nhanvien(String maNV, String chucvu, String hoten, String gioitinh, String diachi, String sdt){
        super(hoten,gioitinh,diachi,sdt);
        this.maNV = maNV;
        this.chucvu = chucvu;
    }



    public void nhap(){
        System.out.println("Nhap ma nhan vien: ");
        maNV = sc.nextLine();
        System.out.println("Nhap chuc vu: ");
        chucvu = sc.nextLine();
        super.nhap();
    }
    @Override public void xuat(){
        System.out.println("Nhan vien {" + maNV + ", " + chucvu + ", " + hoten + ", " + gioitinh + ", " + diachi + ", " + sdt +"}");
    }



    public String getmaNV(){
        return maNV;
    }
    public void setmaNV(String maNV){
        this.maNV = maNV;
    }



    public String getchucvu(){
        return chucvu;
    }
    public void setchucvu(String chucvu){
        this.chucvu = chucvu;
    }



    public String gethoten(){
        return hoten;
    }
    public void sethoten(String hoten){
        this.hoten = hoten;
    }



    public String getgioitinh(){
        return gioitinh;
    }
    public void setgioitinh(String gioitinh){
        this.gioitinh = gioitinh;
    }



    public String getdiachi(){
        return diachi;
    }
    public void setdiachi(String diachi){
        this.diachi = diachi;
    }


    
    public String getsdt(){
        return sdt;
    }
    public void setsdt(String sdt){
        this.sdt=sdt;
    }
}