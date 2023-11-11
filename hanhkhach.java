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
        System.out.println("Nhap ma hanh khach: ");
        maHK = sc.nextLine();
        super.nhap();
    }
    @Override public void xuat(){
        System.out.println("hanh khach {" + maHK + ", " + hoten + ", " + gioitinh + ", " + diachi + ", " + sdt +"}");
    }



    public String getmaHK(){
        return maHK;
    }
    public void setmaHK(String maHK){
        this.maHK = maHK;
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



class DSHK {
    hanhkhach[] dshk;
    int n;
    Scanner sc = new Scanner(System.in);




    public DSHK(){
        dshk = new hanhkhach[0];
        n = 0;
    }
    
    public DSHK(hanhkhach[] ds, int nn){
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
        for(int i=0; i<n; i++)
            dshk[i].xuat();
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
        for(int i=0; i<n; i++){
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
}