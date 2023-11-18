import java.util.*;
class nhanvien extends nguoi {
    private String maNV;
    private int luong;
    Scanner sc = new Scanner(System.in);


    public nhanvien(){
        maNV = "";
        luong = 0;
        hoten = "";
        gioitinh = "";
        diachi = "";
        sdt = "";
    }
    public nhanvien(String maNV, String hoten, String gioitinh, String diachi, String sdt, int luong){
        super(hoten,gioitinh,diachi,sdt);
        this.maNV = maNV;
        this.luong = luong;
    }



    public void nhap(){
        System.out.print("Nhap ma nhan vien: ");
        maNV = sc.nextLine();
        super.nhap();
        System.out.print("Nhap muc luong: ");
        luong = sc.nextInt(); sc.nextLine();
    }
    @Override public void xuat(){
        System.out.println("Ma nhan vien: " + maNV);
        System.out.println("Ho ten nhan vien: " + hoten);
        System.out.println("Gioi tinh: " + gioitinh);
        System.out.println("Dia chi: " + diachi);
        System.out.println("So dien thoai: " + sdt);
        System.out.println("Luong: " + luong);
    }



    public String getmaNV(){
        return maNV;
    }



    public int getluong(){
        return luong;
    }
    public void setluong(int luong){
        this.luong = luong;
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



class DSNhanVien {
    nhanvien[] dsnv;
    int n;
    Scanner sc = new Scanner(System.in);



    public DSNhanVien(){
        dsnv = new nhanvien[0];
        n = 0;
    }
    public DSNhanVien(nhanvien[] ds, int nn){
        dsnv = Arrays.copyOf(ds,nn);
        n = nn;
    }



    public void nhap(){
        System.out.print("Nhap so luong nhan vien: ");
        n = sc.nextInt(); sc.nextLine();
        dsnv = new nhanvien[n];
        for(int i = 0; i < n; i++){
            System.out.println("Nhap thong tin nhan vien thu " + (i+1) + ": ");
            dsnv[i] = new nhanvien();
            dsnv[i].nhap();
        }
    }
    public void xuat(){
        for(int i=0; i<n; i++){
            System.out.println("\nThong tin nhan vien thu " + (i+1) + ":");
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



    public void timkiem(){
        System.out.println("\nNhap ma nhan vien can tim: ");
        String tmp = sc.nextLine();
        timkiem(tmp);
    }
    public void timkiem(String ma){
        for(int i = 0; i < n; i++)
            if( dsnv[i].getmaNV().equals(ma) ){
                dsnv[i].xuat();
                break;
            }
    }



    public void xoa(){
        System.out.println("Nhap ma nhan vien can xoa: ");
        String tmp = sc.nextLine();
        xoa(tmp);
    }
    public void xoa(String ma){
        for(int i = 0; i < n; i++){
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



    public void sua(){
        System.out.println("\nNhap ma nhan vien can sua: ");
        String tmp = sc.nextLine();
        sua(tmp);
    }
    public void sua(String ma){
        for(int i = 0; i < n; i++)
            if( dsnv[i].getmaNV().equals(ma) ){
                int chon;
                do{
                    System.out.println("\n>-----------------------------<");
                    System.out.println("Chon thong tin muon sua:");
                    System.out.println("1-Ho ten");
                    System.out.println("2-Gioi tinh");
                    System.out.println("3-Dia chi");
                    System.out.println("4-So dien thoai");
                    System.out.println("5-Luong");
                    System.out.println("0-Tro ve trang truoc");
                    System.out.print("Nhap lua chon: ");
                    chon = sc.nextInt(); sc.nextLine();
                    switch(chon){
                        case 1:
                            System.out.print("\nNhap ho ten moi: ");
                            String tmp1 = sc.nextLine();
                            dsnv[i].sethoten(tmp1);
                            break;
                        case 2:
                            System.out.print("\nNhap gioi tinh moi: ");
                            String tmp2 = sc.nextLine();
                            dsnv[i].setgioitinh(tmp2);
                            break;
                        case 3:
                            System.out.print("\nNhap dia chi moi: ");
                            String tmp3 = sc.nextLine();
                            dsnv[i].setdiachi(tmp3);
                            break;
                        case 4:
                            System.out.print("\nNhap so dien thoai moi: ");
                            String tmp4 = sc.nextLine();
                            dsnv[i].setsdt(tmp4);
                            break;
                        case 5:{
                            System.out.print("\nNhap muc luong moi: ");
                            int tmp5 = sc.nextInt(); sc.nextLine();
                            dsnv[i].setluong(tmp5);
                        }
                        case 0:
                            break;
                        default:{
                            System.out.println("\nLua chon khong hop le\n");
                            break;
                        }
                    }
                System.out.println("\n>-----------------------------<");
                }while(chon != 0);
                break;
            }
    }
}

class QuanLyNV {
    DSNhanVien ds = new DSNhanVien();
    Scanner sc = new Scanner(System.in);



    public void menu(){
        ds.nhap();
        int chon;
        do{
            System.out.println("\n>Menu-------------------------<");
            System.out.println("1-Them nhan vien");
            System.out.println("2-Sua nhan vien");
            System.out.println("3-Xoa nhan vien");
            System.out.println("4-Tim kiem nhan vien");
            System.out.println("5-Xuat danh sach nhan vien");
            System.out.println("0-Thoat");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextInt(); sc.nextLine();
            switch(chon){
                case 1:
                    ds.them();
                    break;
                case 2:
                    ds.sua();
                    break;
                case 3:
                    ds.xoa();
                    break;
                case 4:
                    ds.timkiem();
                    break;
                case 5:
                    ds.xuat();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nLua cho khong hop le\n");
                    break;
            }
            System.out.println("\n>-----------------------------<");
        }while(chon != 0);
    }
}

class DSHK {
    public static void main(String[] args){
        QuanLyNV ql1 = new QuanLyNV();
        ql1.menu();
    }
}
