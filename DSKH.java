import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
class khachHang extends nguoi {
    private String maKH;


    
    public khachHang(){
        maKH = "";
    }
    public khachHang(String maKH, String hoTen, String gioiTinh, String diaChi, String sdt){
        super(hoTen,gioiTinh,diaChi,sdt);
        this.maKH = maKH;
    }



    public void nhap(){
        System.out.print("Nhap ma khach hang: ");
        maKH = sc.nextLine();
        super.nhap();
    }

    @Override public void xuat(){
        System.out.println("Ma khach hang: " + maKH);
        System.out.println("Ho ten khach hang: " + hoTen);
        System.out.println("Gioi tinh: " + gioiTinh);
        System.out.println("Dia chi: " + diaChi);
        System.out.println("So dien thoai: " + sdt);
    }



    public String getMaKH(){
        return maKH;
    }
    public void setMaKH(String maKH){
        this.maKH = maKH;
    }



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
        this.sdt=sdt;
    }
}



class DSKhachHang {
    khachHang[] dskh;
    int n;
    Scanner sc = new Scanner(System.in);



    public DSKhachHang(){
        dskh = new khachHang[0];
        n = 0;
    }
    public DSKhachHang(khachHang[] ds, int nn){
        dskh = Arrays.copyOf(ds,nn);
        n = nn;
    }



    public void nhap(){
        /* 
        System.out.println("Nhap so luong khach hang: ");
        n = sc.nextInt(); sc.nextLine();
        dskh = new khachHang[n];
        for(int i=0; i<n; i++){
            System.out.println("\nNhap thong tin khach hang thu " + (i+1) + ": ");
            dskh[i] = new khachHang();
            dskh[i].nhap();
        }
        */
        try{
            File fin = new File("dataDSNguoi.txt");
        
            Scanner myReader = new Scanner(fin);

            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                String[] words = data.split(",");

                if(Integer.parseInt(words[0]) == 0){
                    dskh = Arrays.copyOf(dskh,n+1);
                    dskh[n] = new khachHang();

                    dskh[n].setMaKH(words[1]);
                    dskh[n].setHoTen(words[2]);
                    dskh[n].setGioiTinh(words[3]);
                    dskh[n].setDiaChi(words[4]);
                    dskh[n].setSdt(words[5]);

                    n++;
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }
    public void xuat(){
        for(int i=0; i<n; i++){
            System.out.println("\n\nThong tin khach hang thu " + (i+1) + ":");
            dskh[i].xuat();
        }
    }



    public void timKiem(){
        System.out.println("\n\nNhap ma khach hang can tim: ");
        String tmp = sc.nextLine();
        timKiem(tmp);
    }
    public void timKiem(String ma){
        for(int i = 0; i < n; i++)
            if( dskh[i].getMaKH().equals(ma) ){
                dskh[i].xuat();
                break;
            }
    }



    public void them(){
        dskh = Arrays.copyOf(dskh,n+1);
        dskh[n] = new khachHang();
        System.out.println("\n\nNhap thong tin khach hang duoc them: ");
        dskh[n].nhap();
        n++;
    }



    public void xoa(){
        System.out.println("\n\nNhap ma khach hang can xoa: ");
        String tmp = sc.nextLine();
        xoa(tmp);
    }
    public void xoa(String ma){
        for(int i = 0; i < n; i++){
            if( dskh[i].getMaKH().equals(ma) ){
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
        System.out.println("\n\nNhap ma khach hang can sua: ");
        String tmp = sc.nextLine();
        sua(tmp);
    }
    public void sua(String ma){
        for(int i = 0; i < n; i++)
            if( dskh[i].getMaKH().equals(ma) ){
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
                            System.out.print("\n\nNhap ho ten moi: ");
                            String tmp1 = sc.nextLine();
                            dskh[i].setHoTen(tmp1);
                            break;
                        case 2:
                            System.out.print("\n\nNhap gioi tinh moi: ");
                            String tmp2 = sc.nextLine();
                            dskh[i].setGioiTinh(tmp2);
                            break;
                        case 3:
                            System.out.print("\n\nNhap dia chi moi: ");
                            String tmp3 = sc.nextLine();
                            dskh[i].setDiaChi(tmp3);
                            break;
                        case 4:
                            System.out.print("\n\nNhap so dien thoai moi: ");
                            String tmp4 = sc.nextLine();
                            dskh[i].setSdt(tmp4);
                            break;
                        case 0:
                            break;
                        default:{
                            System.out.println("\n\nLua chon khong hop le\n");
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
                    ds.timKiem();
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

class DSKH {
    public static void main(String[] args) throws FileNotFoundException {
        QuanLyKH ql1 = new QuanLyKH();
        ql1.menu();
    }
}
