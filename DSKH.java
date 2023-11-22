import java.util.*;
class khachhang extends nguoi {
    private String maKH;
    Scanner sc = new Scanner(System.in);


    
    public khachhang(){
        maKH = "";
        hoten = "";
        gioitinh = "";
        diachi = "";
        sdt = "";
    }
    public khachhang(String maKH, String hoten, String gioitinh, String diachi, String sdt){
        super(hoten,gioitinh,diachi,sdt);
        this.maKH = maKH;
    }



    public void nhap(){
        System.out.print("Nhap ma khach hang: ");
        maKH = sc.nextLine();
        super.nhap();
    }
    @Override public void xuat(){
        System.out.println("Ma khach hang: " + maKH);
        System.out.println("Ho ten khach hang: " + hoten);
        System.out.println("Gioi tinh: " + gioitinh);
        System.out.println("Dia chi: " + diachi);
        System.out.println("So dien thoai: " + sdt);
    }



    public String getmaKH(){
        return maKH;
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



class DSKhachHang {
    khachhang[] dskh;
    int n;
    Scanner sc = new Scanner(System.in);



    public DSKhachHang(){
        dskh = new khachhang[0];
        n = 0;
    }
    public DSKhachHang(khachhang[] ds, int nn){
        dskh = Arrays.copyOf(ds,nn);
        n = nn;
    }



    public void nhap(){
        System.out.println("Nhap so luong khach hang: ");
        n = sc.nextInt(); sc.nextLine();
        dskh = new khachhang[n];
        for(int i=0; i<n; i++){
            System.out.println("\nNhap thong tin khach hang thu " + (i+1) + ": ");
            dskh[i] = new khachhang();
            dskh[i].nhap();
        }
    }
    public void xuat(){
        for(int i=0; i<n; i++){
            System.out.println("\nThong tin khach hang thu " + (i+1) + ":");
            dskh[i].xuat();
        }
    }



    public void timkiem(){
        System.out.println("\nNhap ma khach hang can tim: ");
        String tmp = sc.nextLine();
        timkiem(tmp);
    }
    public void timkiem(String ma){
        for(int i = 0; i < n; i++)
            if( dskh[i].getmaKH().equals(ma) ){
                dskh[i].xuat();
                break;
            }
    }



    public void them(){
        dskh = Arrays.copyOf(dskh,n+1);
        dskh[n] = new khachhang();
        System.out.println("\nNhap thong tin khach hang duoc them: ");
        dskh[n].nhap();
        n++;
    }



    public void xoa(){
        System.out.println("\nNhap ma khach hang can xoa: ");
        String tmp = sc.nextLine();
        xoa(tmp);
    }
    public void xoa(String ma){
        for(int i = 0; i < n; i++){
            if( dskh[i].getmaKH().equals(ma) ){
                for(int j=i; j<n-1; j++){
                    dskh[j] = dskh[j+1];
                }
                dskh = Arrays.copyOf(dskh,n-1);
                n--;
                break;
            }
        }
    }



    public void sua(){
        System.out.println("\nNhap ma khach hang can sua: ");
        String tmp = sc.nextLine();
        sua(tmp);
    }
    public void sua(String ma){
        for(int i = 0; i < n; i++)
            if( dskh[i].getmaKH().equals(ma) ){
                int chon;
                do{
                    System.out.println("\n>-----------------------------<");
                    System.out.println("Chon thong tin muon sua:");
                    System.out.println("1-Ho ten");
                    System.out.println("2-Gioi tinh");
                    System.out.println("3-Dia chi");
                    System.out.println("4-So dien thoai");
                    System.out.println("0-Tro ve trang truoc");
                    System.out.print("Nhap lua chon: ");
                    chon = sc.nextInt(); sc.nextLine();
                    switch(chon){
                        case 1:
                            System.out.print("\nNhap ho ten moi: ");
                            String tmp1 = sc.nextLine();
                            dskh[i].sethoten(tmp1);
                            break;
                        case 2:
                            System.out.print("\nNhap gioi tinh moi: ");
                            String tmp2 = sc.nextLine();
                            dskh[i].setgioitinh(tmp2);
                            break;
                        case 3:
                            System.out.print("\nNhap dia chi moi: ");
                            String tmp3 = sc.nextLine();
                            dskh[i].setdiachi(tmp3);
                            break;
                        case 4:
                            System.out.print("\nNhap so dien thoai moi: ");
                            String tmp4 = sc.nextLine();
                            dskh[i].setsdt(tmp4);
                            break;
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

class QuanLyKH {
    DSKhachHang ds = new DSKhachHang();
    Scanner sc = new Scanner(System.in);



    public void menu(){
        ds.nhap();
        int chon;
        do{
            System.out.println("\n>Menu-------------------------<");
            System.out.println("1-Them khach hang");
            System.out.println("2-Sua khach hang");
            System.out.println("3-Xoa khach hang");
            System.out.println("4-Tim kiem khach hang");
            System.out.println("5-Xuat danh sach khach hang");
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
        QuanLyKH ql1 = new QuanLyKH();
        ql1.menu();
    }
}
