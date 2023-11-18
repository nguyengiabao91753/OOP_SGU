import java.util.*;
class hanhkhach extends nguoi {
    private String maHK;
    Scanner sc = new Scanner(System.in);


    
    public hanhkhach(){
        maHK = "";
        hoten = "";
        gioitinh = "";
        diachi = "";
        sdt = "";
    }
    public hanhkhach(String maHK, String hoten, String gioitinh, String diachi, String sdt){
        super(hoten,gioitinh,diachi,sdt);
        this.maHK = maHK;
    }



    public void nhap(){
        System.out.print("Nhap ma hanh khach: ");
        maHK = sc.nextLine();
        super.nhap();
    }
    @Override public void xuat(){
        System.out.println("Ma hanh khach: " + maHK);
        System.out.println("Ho ten hanh khach: " + hoten);
        System.out.println("Gioi tinh: " + gioitinh);
        System.out.println("Dia chi: " + diachi);
        System.out.println("So dien thoai: " + sdt);
    }



    public String getmaHK(){
        return maHK;
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



class DSHanhKhach {
    hanhkhach[] dshk;
    int n;
    Scanner sc = new Scanner(System.in);



    public DSHanhKhach(){
        dshk = new hanhkhach[0];
        n = 0;
    }
    public DSHanhKhach(hanhkhach[] ds, int nn){
        dshk = Arrays.copyOf(ds,nn);
        n = nn;
    }



    public void nhap(){
        System.out.println("Nhap so luong hanh khach: ");
        n = sc.nextInt(); sc.nextLine();
        dshk = new hanhkhach[n];
        for(int i=0; i<n; i++){
            System.out.println("\nNhap thong tin hanh khach thu " + (i+1) + ": ");
            dshk[i] = new hanhkhach();
            dshk[i].nhap();
        }
    }
    public void xuat(){
        for(int i=0; i<n; i++){
            System.out.println("\nThong tin hanh khach thu " + (i+1) + ":");
            dshk[i].xuat();
        }
    }



    public void timkiem(){
        System.out.println("\nNhap ma hanh khach can tim: ");
        String tmp = sc.nextLine();
        timkiem(tmp);
    }
    public void timkiem(String ma){
        for(int i = 0; i < n; i++)
            if( dshk[i].getmaHK().equals(ma) ){
                dshk[i].xuat();
                break;
            }
    }



    public void them(){
        dshk = Arrays.copyOf(dshk,n+1);
        dshk[n] = new hanhkhach();
        System.out.println("\nNhap thong tin hanh khach duoc them: ");
        dshk[n].nhap();
        n++;
    }



    public void xoa(){
        System.out.println("\nNhap ma hanh khach can xoa: ");
        String tmp = sc.nextLine();
        xoa(tmp);
    }
    public void xoa(String ma){
        for(int i = 0; i < n; i++){
            if( dshk[i].getmaHK().equals(ma) ){
                for(int j=i; j<n-1; j++){
                    dshk[j] = dshk[j+1];
                }
                dshk = Arrays.copyOf(dshk,n-1);
                n--;
                break;
            }
        }
    }



    public void sua(){
        System.out.println("\nNhap ma hanh khach can sua: ");
        String tmp = sc.nextLine();
        sua(tmp);
    }
    public void sua(String ma){
        for(int i = 0; i < n; i++)
            if( dshk[i].getmaHK().equals(ma) ){
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
                            dshk[i].sethoten(tmp1);
                            break;
                        case 2:
                            System.out.print("\nNhap gioi tinh moi: ");
                            String tmp2 = sc.nextLine();
                            dshk[i].setgioitinh(tmp2);
                            break;
                        case 3:
                            System.out.print("\nNhap dia chi moi: ");
                            String tmp3 = sc.nextLine();
                            dshk[i].setdiachi(tmp3);
                            break;
                        case 4:
                            System.out.print("\nNhap so dien thoai moi: ");
                            String tmp4 = sc.nextLine();
                            dshk[i].setsdt(tmp4);
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

class QuanLyHK {
    DSHanhKhach ds = new DSHanhKhach();
    Scanner sc = new Scanner(System.in);



    public void menu(){
        ds.nhap();
        int chon;
        do{
            System.out.println("\n>Menu-------------------------<");
            System.out.println("1-Them hanh khach");
            System.out.println("2-Sua hanh khach");
            System.out.println("3-Xoa hanh khach");
            System.out.println("4-Tim kiem hanh khach");
            System.out.println("5-Xuat danh sach hanh khach");
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
        QuanLyHK ql1 = new QuanLyHK();
        ql1.menu();
    }
}
