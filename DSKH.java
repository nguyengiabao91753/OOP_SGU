import java.util.*;
import java.io.*;
class khachHang extends nguoi {
    private String makh;


    
    public khachHang(){
        makh = "";
    }
    public khachHang(String makh, String hoTen, String gioiTinh, String diaChi, String sdt){
        super(hoTen,gioiTinh,diaChi,sdt);
        this.makh = makh;
    }



    public void nhap(){
        super.nhap();
    }

    @Override public void xuat(){
        System.out.println("Ma khach hang: " + makh);
        System.out.println("Ho ten khach hang: " + hoTen);
        System.out.println("Gioi tinh: " + gioiTinh);
        System.out.println("Dia chi: " + diaChi);
        System.out.println("So dien thoai: " + sdt);
    }



    public String getMakh(){
        return makh;
    }
    public void setMakh(String makh){
        this.makh = makh;
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



class DSkhachHang implements crud {
    private khachHang[] dskh;
    private int n;
    Scanner sc = new Scanner(System.in);



    public DSkhachHang(){
        dskh = new khachHang[0];
        n = 0;
    }
    public DSkhachHang(khachHang[] ds, int nn){
        dskh = Arrays.copyOf(ds,nn);
        n = nn;
    }

    public khachHang[] getDskh() {
        return dskh;
    }
    public void setDskh(khachHang[] dskh) {
        this.dskh = dskh;
    }


    public void nhap(){
        System.out.println("Nhap so luong khach hang: ");
        n = sc.nextInt(); sc.nextLine();
        dskh = new khachHang[n];
        for(int i=0; i<n; i++){
            System.out.println("\nNhap thong tin khach hang thu " + (i+1) + ": ");
            dskh[i] = new khachHang();
            dskh[i].nhap();
            dskh[i].setMakh("kh"+(i+1));
        }
    }


    String[][] words = new String[100][];
    int k;
    public void docFile(){
        try{
            k = 0;
            File fin = new File("dataDSNguoi.txt");
        
            Scanner myReader = new Scanner(fin);

            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                words[k] = data.split(",");
                if(Integer.parseInt(words[k][0]) == 0){
                    dskh = Arrays.copyOf(dskh,n+1);
                    dskh[n] = new khachHang();

                    dskh[n].setMakh(words[k][1]);
                    dskh[n].setHoTen(words[k][2]);
                    dskh[n].setGioiTinh(words[k][3]);
                    dskh[n].setDiaChi(words[k][4]);
                    dskh[n].setSdt(words[k][5]);

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
            for(khachHang kh : dskh){
                myWriter.write("0," + kh.getMakh() + "," + kh.getHoTen() + "," + kh.getGioiTinh() + "," + kh.getDiaChi() + ","
                              + kh.getSdt() + "\n");
            }
            for(int i = 0; i < k; i++){
                if(Integer.parseInt(words[i][0]) == 1){
                    myWriter.write("1," + words[i][1] + "," + words[i][2] + "," + words[i][3] + "," + words[i][4] + ","
                                  + words[i][5] + "," + words[i][6] + "\n");
                }
            }
            myWriter.close();
            
        }
        catch (IOException e) {
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



    public void tim(){
        System.out.println("\n\nNhap ma khach hang can tim: ");
        String tmp = sc.nextLine();
        tim(tmp);
    }
    public void tim(String ma){
        for(int i = 0; i < n; i++)
            if( dskh[i].getMakh().equals(ma) ){
                dskh[i].xuat();
                break;
            }
    }



    public void them(){
        dskh = Arrays.copyOf(dskh,n+1);
        dskh[n] = new khachHang();
        dskh[n].setMakh("kh"+(n+1));
        System.out.println("\n\nNhap thong tin khach hang duoc them: ");
        dskh[n].nhap();
        n++;
    }

    public void them(khachHang khachHang){
        dskh = Arrays.copyOf(dskh,n+1);
        dskh[n] =khachHang;
        dskh[n].setMakh("kh"+(n+1));
        n++;
    }



    public void xoa(){
        System.out.println("\n\nNhap ma khach hang can xoa: ");
        String tmp = sc.nextLine();
        xoa(tmp);
    }
    public void xoa(String ma){
        for(int i = 0; i < n; i++){
            if( dskh[i].getMakh().equals(ma) ){
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
            if( dskh[i].getMakh().equals(ma) ){
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

class QuanLykh {
    DSkhachHang ds = new DSkhachHang();
    Scanner sc = new Scanner(System.in);


    public void menu(){
        int chon;
        ds.docFile();
        do{
            System.out.println("\n>Menu-------------------------<");
            System.out.println("1 - Tao danh sach khach hang moi");
            System.out.println("2 - Them khach hang");
            System.out.println("3 - Sua khach hang");
            System.out.println("4 - Xoa khach hang");
            System.out.println("5 - Tim kiem khach hang");
            System.out.println("6 - Xuat danh sach khach hang");
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
                case 0:
                    break;
                default:
                    System.out.println("\nLua cho khong hop le\n");
            }
            System.out.println("\n>-----------------------------<");
        }while(chon != 0);
        ds.ghiFile();
    }
}

class DSkh {
    public static void main(String[] args) throws FileNotFoundException {
        QuanLykh ql1 = new QuanLykh();
        ql1.menu();
        
    }
}
