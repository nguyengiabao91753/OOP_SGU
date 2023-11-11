import java.util.*;
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
        System.out.println("Ma nhan vien: " + maNV);
        System.out.println("Chuc vu: " + chucvu);
        System.out.println("Ho ten nhan vien: " + hoten);
        System.out.println("Gioi tinh: " + gioitinh);
        System.out.println("Dia chi: " + diachi);
        System.out.println("So dien thoai: " + sdt);
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



class DSNV {
    nhanvien[] dsnv;
    int n;
    Scanner sc = new Scanner(System.in);



    public DSNV(){
        dsnv = new nhanvien[0];
        n = 0;
    }
    public DSNV(nhanvien[] ds, int nn){
        dsnv = Arrays.copyOf(ds,nn);
        n = nn;
    }



    public void nhap(){
        System.out.println("Nhap so luong nhan vien: ");
        n = sc.nextInt(); sc.nextLine();
        dsnv = new nhanvien[n];
        for(int i=0; i<n; i++){
            System.out.println("Nhap thong tin nhan vien thu " + (i+1) + ": ");
            dsnv[i] = new nhanvien();
            dsnv[i].nhap();
        }
    }
    public void xuat(){
        for(int i=0; i<n; i++){
            System.out.println("\nThong tin nhan vien thu " + i + ":");
            dsnv[i].xuat();
        }
    }



    public void them(){
        dsnv = Arrays.copyOf(dsnv,n+1);
        dsnv[n] = new nhanvien();
        System.out.println("Nhap thong tin nhan vien duoc them: ");
        dsnv[n].nhap();
        n++;
    }



    public void xoa(){
        System.out.println("Nhap ma nhan vien can xoa: ");
        String tmp = sc.nextLine();
        xoa(tmp);
    }
    public void xoa(String ma){
        for(int i=0; i<n; i++){
            if( dsnv[i].getmaNV().equals(ma) ){
                for(int j=i; j<n-1; j++){
                    dsnv[j] = dsnv[j+1];
                }
                dsnv = Arrays.copyOf(dsnv,n-1);
                n--;
                break;
            }
        }
    }
}