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

    public void them(ve vemoi) {
        vegiohang.them(vemoi);
        
    }

    public double tinhtien(quanly_ve vegiohang){
        tongtien=0;
        for (ve ve : vegiohang.getDanhsachve()) {
            soluong++;
            if(ve.getTrangthai().equals("chua thanh toan")){
                tongtien+=ve.getGia();
            }
        }
        return tongtien;
    }

}

class quanly_giohang implements crud {
    private Map<String, giohang> quanlygiohang = new HashMap<>();

    public void them(String name, ve ve) {
        if (!quanlygiohang.containsKey(name)) {
            giohang giohangmoi = new giohang();
            giohangmoi.them(ve);
            quanlygiohang.put(name, giohangmoi);
        } else {
            giohang giohang = quanlygiohang.get(name);
            giohang.them(ve);
        }
    }

    public void sua(String name, String maso, ve ve){
        if(quanlygiohang.containsKey(name)){
            giohang giohang = quanlygiohang.get(name);
            giohang.getVegiohang().sua(maso,ve);
        }
    }

    public void xoa(String name, String maso){
        if(quanlygiohang.containsKey(name)){
            giohang giohang = quanlygiohang.get(name);
            giohang.getVegiohang().xoa(maso);
        }
    }

    public void tim(String name) {
        giohang giohang = quanlygiohang.get(name);
        System.out.println("Giỏ hàng của khách hàng: "+ name);
        giohang.getVegiohang().xuat();
        System.out.println("<>---------------------------------<>");
        System.out.println("Tổng tiền: " + giohang.tinhtien(giohang.getVegiohang()));
    }

    public void xuat(){
        
        for (String name : quanlygiohang.keySet()) {
            giohang giohang = quanlygiohang.get(name);
            giohang.getVegiohang().xuat();
        }
    }
}

class hienthi_giohang{
    public static void main(String[] args) {
        quanly_giohang quanly_giohang = new quanly_giohang();
        ve ve1 = new ve();
        ve ve2 = new ve();
        ve1.nhap();
        ve2.nhap();
        quanly_giohang.them("Gia Bao", ve1);
        quanly_giohang.them("Gia Bao", ve2);
        quanly_giohang.tim("Gia Bao");

        quanly_giohang.xoa("Gia Bao", "111");
        
        quanly_giohang.tim("Gia Bao");


    }
}