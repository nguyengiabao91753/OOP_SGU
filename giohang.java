import java.util.*;
public class giohang {
    ve[] ve;
    private int soluong;
    private double tongtien;

    public giohang(){
        ve = new ve[1000];
        soluong=0;
        tongtien=0;
    }

    public giohang(ve[] ve, int soluong, double tongtien){
        this.ve = ve;
        this.soluong = soluong;
        this.tongtien = tongtien;
    }

    public ve[] getVe() {
        return ve;
    }
    public void setVe(ve[] ve) {
        this.ve = ve;
    }

    public int getSoluong() {
        return soluong;
    }
    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getTongtien() {
        return tongtien;
    }
    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    // public void nhap(){
    //     Scanner nhap = new Scanner(System.in);
    //     ve.nhap();
    //     System.out.println("Nhap so luong");
    //     soluong = nhap.nextInt(); 
    //     tongtien = soluong* ve.getGia();
    //     System.out.println("Tong tien: "+tongtien);
    // }
}

class quanly_giohang{
    List<giohang> danhsachgiohang = new ArrayList<>();
    
}