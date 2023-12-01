import java.util.*;
import java.io.*;
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



class DSNhanVien implements crud {
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
        System.out.print("Nhap so luong nhan vien: ");
        n = sc.nextInt(); sc.nextLine();
        dsnv = new nhanVien[n];
        for(int i = 0; i < n; i++){
            System.out.println("Nhap thong tin nhan vien thu " + (i+1) + ": ");
            dsnv[i] = new nhanVien();
            dsnv[i].nhap();
        }
    }


    String[][] words = new String[100][];
    int k;
    public void docFile(){
        try{
            dsnv = new nhanVien[0];
            n = 0; k = 0;
            File fin = new File("dataDSNguoi.txt");
        
            Scanner myReader = new Scanner(fin);

            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                words[k] = data.split(",");
                if(Integer.parseInt(words[k][0]) == 1){
                    dsnv = Arrays.copyOf(dsnv,n+1);
                    dsnv[n] = new nhanVien();

                    dsnv[n].setMaNV(words[k][1]);
                    dsnv[n].setHoTen(words[k][2]);
                    dsnv[n].setGioiTinh(words[k][3]);
                    dsnv[n].setDiaChi(words[k][4]);
                    dsnv[n].setSdt(words[k][5]);
                    dsnv[n].setLuong(Integer.parseInt(words[k][6]));

                    n++;
                }
                k++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



    public void ghiFile(){
        try{
            FileWriter myWriter = new FileWriter("dataDSNguoi.txt");
            for(nhanVien nv : dsnv){
                myWriter.write("1," + nv.getMaNV() + "," + nv.getHoTen() + "," + nv.getGioiTinh() + "," + nv.getDiaChi() + ","
                              + nv.getSdt() + "," + nv.getLuong() + "\n");
            }
            for(int i = 0; i < k; i++){
                if(Integer.parseInt(words[i][0]) == 0){
                    myWriter.write("0," + words[i][1] + "," + words[i][2] + "," + words[i][3] + "," + words[i][4] + ","
                                  + words[i][5] + "\n");
                }
            }
            myWriter.close();
            System.out.println("\n\nGhi File thanh cong");
        }
        catch (IOException e) {
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



    public void tim(){
        System.out.println("\n\nNhap ma nhan vien can tim: ");
        String tmp = sc.nextLine();
        tim(tmp);
    }
    public void tim(String ma){
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
        int chon;
        do{
            System.out.println("\n>Menu-------------------------<");
            System.out.println("1 - Tao danh sach nhan vien moi");
            System.out.println("2 - Them nhan vien");
            System.out.println("3 - Sua nhan vien");
            System.out.println("4 - Xoa nhan vien");
            System.out.println("5 - Tim kiem nhan vien");
            System.out.println("6 - Xuat danh sach nhan vien");
            System.out.println("7 - Tai len danh sach tu File");
            System.out.println("8 - Ghi du lieu vao File");
            System.out.println("0 - Thoat");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextInt(); sc.nextLine();
            switch(chon){
                case 1:
                    ds.nhap();
                    break;
                case 2:
                    ds.them();
                    break;
                case 3:
                    ds.sua();
                    break;
                case 4:
                    ds.xoa();
                    break;
                case 5:
                    ds.tim();
                    break;
                case 6:
                    ds.xuat();
                    break;
                case 7:
                    ds.docFile();
                    break;
                case 8:
                    ds.ghiFile();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\n\nLua cho khong hop le\n");
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
