import java.util.*;

public class giohang {
    quanly_ve vegiohang;
    private int soluong;
    private double tongtien;

    public giohang() {
        vegiohang = new quanly_ve();
        soluong = 0;
        tongtien = 0;
    }

    public quanly_ve getVegiohang() {
        return vegiohang;
    }

    public void setVegiohang(quanly_ve vegiohang) {
        this.vegiohang = vegiohang;
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

    public void themve(ve vemoi) {
        vegiohang.themve(vemoi);
        soluong++;
        tongtien += vemoi.getGia();
    }
    // public void nhap(){
    // Scanner nhap = new Scanner(System.in);
    // ve.nhap();
    // System.out.println("Nhap so luong");
    // soluong = nhap.nextInt();
    // tongtien = soluong* ve.getGia();
    // System.out.println("Tong tien: "+tongtien);
    // }
}

class quanly_giohang {
    private Map<String, giohang> quanlygiohang = new HashMap<>();

    public void themgiohang(String name, ve ve) {
        if (!quanlygiohang.containsKey(name)) {
            giohang giohangmoi = new giohang();
            giohangmoi.themve(ve);
            quanlygiohang.put(name, giohangmoi);
        } else {
            giohang giohang = quanlygiohang.get(name);
            giohang.themve(ve);
        }
    }

    public void suagiohang(String name, int maso, ve ve){
        if(quanlygiohang.containsKey(name)){
            giohang giohang = quanlygiohang.get(name);
            giohang.getVegiohang().suave(maso-1,ve);
        }
    }

    public void xoagiohang(String name, int maso){
        if(quanlygiohang.containsKey(name)){
            giohang giohang = quanlygiohang.get(name);
            giohang.getVegiohang().xoave(maso-1);
        }
    }

    public void xuatgiohang(String name) {
        giohang giohang = quanlygiohang.get(name);
        giohang.getVegiohang().xuatve();
    }
}

class hienthi_giohang{
    public static void main(String[] args) {
        
    }
}