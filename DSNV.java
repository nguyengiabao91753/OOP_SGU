import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
class nhanVien extends nguoi {
    private String maNV;
    private int luong;


    public nhanVien(){
        maNV = "";
        luong = 0;
    }
    public nhanVien(String maNV, String hoTen, String gioiTinh, String diaChi, String sdt, int luong){
        super(hoTen,gioiTinh,diaChi,sdt);
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
        System.out.println("Ho ten nhan vien: " + hoTen);
        System.out.println("Gioi tinh: " + gioiTinh);
        System.out.println("Dia chi: " + diaChi);
        System.out.println("So dien thoai: " + sdt);
        System.out.println("Luong: " + luong);
    }



    public String getMaNV(){
        return maNV;
    }
    public void setMaNV(String maNV){
        this.maNV = maNV;
    }



    public int getLuong(){
        return luong;
    }
    public void setLuong(int luong){
        this.luong = luong;
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



class DSNhanVien {
    nhanVien[] dsnv;
    int n;
    Scanner sc = new Scanner(System.in);



    public DSNhanVien(){
        dsnv = new nhanVien[0];
        n = 0;
    }
    public DSNhanVien(nhanVien[] ds, int nn){
        dsnv = Arrays.copyOf(ds,nn);
        n = nn;
    }

    public nhanVien[] getDsnv() {
        return dsnv;
    }


    public void nhap(){
        /*
        System.out.print("Nhap so luong nhan vien: ");
        n = sc.nextInt(); sc.nextLine();
        dsnv = new nhanVien[n];
        for(int i = 0; i < n; i++){
            System.out.println("Nhap thong tin nhan vien thu " + (i+1) + ": ");
            dsnv[i] = new nhanVien();
            dsnv[i].nhap();
        }
        */
        try{
            File fin = new File("dataDSNguoi.txt");
        
            Scanner myReader = new Scanner(fin);

            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                String[] words = data.split(",");

                if(Integer.parseInt(words[0]) == 1){
                    dsnv = Arrays.copyOf(dsnv,n+1);
                    dsnv[n] = new nhanVien();

                    dsnv[n].setMaNV(words[1]);
                    dsnv[n].setHoTen(words[2]);
                    dsnv[n].setGioiTinh(words[3]);
                    dsnv[n].setDiaChi(words[4]);
                    dsnv[n].setSdt(words[5]);
                    dsnv[n].setLuong(Integer.parseInt(words[6]));

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
            System.out.println("\n\nThong tin nhan vien thu " + (i+1) + ":");
            dsnv[i].xuat();
        }
    }



    public void them(){
        dsnv = Arrays.copyOf(dsnv,n+1);
        dsnv[n] = new nhanVien();
        System.out.println("\n\nNhap thong tin nhan vien duoc them: ");
        dsnv[n].nhap();
        n++;
    }



    public void timKiem(){
        System.out.println("\n\nNhap ma nhan vien can tim: ");
        String tmp = sc.nextLine();
        timKiem(tmp);
    }
    public void timKiem(String ma){
        for(int i = 0; i < n; i++)
            if( dsnv[i].getMaNV().equals(ma) ){
                dsnv[i].xuat();
                break;
            }
    }



    public void xoa(){
        System.out.println("\n\nNhap ma nhan vien can xoa: ");
        String tmp = sc.nextLine();
        xoa(tmp);
    }
    public void xoa(String ma){
        for(int i = 0; i < n; i++){
            if( dsnv[i].getMaNV().equals(ma) ){
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
        System.out.println("\n\nNhap ma nhan vien can sua: ");
        String tmp = sc.nextLine();
        sua(tmp);
    }
    public void sua(String ma){
        for(int i = 0; i < n; i++)
            if( dsnv[i].getMaNV().equals(ma) ){
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
                            System.out.print("\n\nNhap ho ten moi: ");
                            String tmp1 = sc.nextLine();
                            dsnv[i].setHoTen(tmp1);
                            break;
                        case 2:
                            System.out.print("\n\nNhap gioi tinh moi: ");
                            String tmp2 = sc.nextLine();
                            dsnv[i].setGioiTinh(tmp2);
                            break;
                        case 3:
                            System.out.print("\n\nNhap dia chi moi: ");
                            String tmp3 = sc.nextLine();
                            dsnv[i].setDiaChi(tmp3);
                            break;
                        case 4:
                            System.out.print("\n\nNhap so dien thoai moi: ");
                            String tmp4 = sc.nextLine();
                            dsnv[i].setSdt(tmp4);
                            break;
                        case 5:{
                            System.out.print("\n\nNhap muc luong moi: ");
                            int tmp5 = sc.nextInt(); sc.nextLine();
                            dsnv[i].setLuong(tmp5);
                        }
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
                    ds.timKiem();
                    break;
                case 5:
                    ds.xuat();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\n\nLua cho khong hop le\n");
                    break;
            }
            System.out.println("\n>-----------------------------<");
        }while(chon != 0);
    }
}

class DSNV {
    public static void main(String[] args){
        QuanLyNV ql1 = new QuanLyNV();
        ql1.menu();
    }
}
