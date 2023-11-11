import java.util.*;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class hoadon {
    private quanly_ve quanly_ve;
    private String ngaytao;

    public hoadon() {
        quanly_ve = new quanly_ve();
        ngaytao = "";
    }

    public quanly_ve getQuanly_ve() {
        return quanly_ve;
    }

    public void setQuanly_ve(quanly_ve quanly_ve) {
        this.quanly_ve = quanly_ve;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public void themhoadon(ve ve) {
            if (ve.getTrangthai().equals("da thanh toan")) {
                quanly_ve.them(ve);
                LocalDateTime ngayTao = LocalDateTime.now(); // Lấy thời gian thực tế
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); // Định dạng thời gian
                ngaytao  = ngayTao.format(formatter);
            }
        
    }
}

class quanly_hoadon implements crud {
    Map<String, hoadon> quanly_hoadon = new HashMap<>();

    public Map<String, hoadon> getQuanly_hoadon() {
        return quanly_hoadon;
    }
    public void setQuanly_hoadon(Map<String, hoadon> quanly_hoadon) {
        this.quanly_hoadon = quanly_hoadon;
    }
    public void them(String name, ve ve) {
        if (!quanly_hoadon.containsKey(name)) {
            hoadon hoadonmoi = new hoadon();
            hoadonmoi.themhoadon(ve);
            quanly_hoadon.put(name, hoadonmoi);
        }else{
            hoadon hoadon = quanly_hoadon.get(name);
            hoadon.themhoadon(ve);
        }
    }

    public void sua(String name, String maso,ve ve){
        if(quanly_hoadon.containsKey(name)){
            hoadon suahoadon = quanly_hoadon.get(name);
            suahoadon.getQuanly_ve().sua(maso, ve);
        }
    }

    public void xoa(String name, String maso){
        if(quanly_hoadon.containsKey(name)){
            hoadon xoahoadon = quanly_hoadon.get(name);
            xoahoadon.getQuanly_ve().xoa(maso);
        }
    }

    public void tim(String name){
        if(quanly_hoadon.containsKey(name)){
            hoadon hoadon = quanly_hoadon.get(name);
            System.out.println("Hóa đơn của khách hàng: "+name);
            hoadon.getQuanly_ve().xuat();
        }
    }

    public void xuat(){
       
        for (String name : quanly_hoadon.keySet()) {
            hoadon hoadon = quanly_hoadon.get(name);
            hoadon.getQuanly_ve().xuat();
        }
    }

    public void laydata(){

    }
}

class Main {
    public static void main(String[] args) {
        
    }
}
