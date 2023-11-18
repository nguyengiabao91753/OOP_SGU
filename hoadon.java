import java.util.*;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class hoadon {
    private String maHD;
    private quanly_ve quanly_ve;
    private String ngaytao;
    Scanner nhap = new Scanner(System.in);
    public hoadon() {
        quanly_ve = new quanly_ve();
        ngaytao = "";
        maHD="";
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

    public void nhapma(){
        System.out.println("Nhập mã hóa đơn: ");
        maHD = nhap.nextLine();
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
    Scanner nhap = new Scanner(System.in);
    public Map<String, hoadon> getQuanly_hoadon() {
        return quanly_hoadon;
    }
    public void setQuanly_hoadon(Map<String, hoadon> quanly_hoadon) {
        this.quanly_hoadon = quanly_hoadon;
    }
    public void them(){};

    public void them(String name, ve ve) {
        if (!quanly_hoadon.containsKey(name)) {
            hoadon hoadonmoi = new hoadon();
            hoadonmoi.nhapma();
            hoadonmoi.themhoadon(ve);
            quanly_hoadon.put(name, hoadonmoi);
        }else{
            hoadon hoadon = quanly_hoadon.get(name);
            hoadon.themhoadon(ve);
        }
    }

    public void sua(){
        System.out.println("Nhập tên khách hàng: ");
        String name = nhap.nextLine();
        if(quanly_hoadon.containsKey(name)){
            hoadon suahoadon = quanly_hoadon.get(name);
            suahoadon.getQuanly_ve().sua();
        }
    }

    public void xoa(){
        System.out.println("Nhập tên khách hàng: ");
        String name = nhap.nextLine();
        if(quanly_hoadon.containsKey(name)){
            hoadon xoahoadon = quanly_hoadon.get(name);
            xoahoadon.getQuanly_ve().xoa();
        }
    }

    public void tim(){
        System.out.println("Nhập tên khách hàng: ");
        String name = nhap.nextLine();
        if(quanly_hoadon.containsKey(name)){
            hoadon hoadon = quanly_hoadon.get(name);
            System.out.println("Hóa đơn của khách hàng: "+name);
            hoadon.getQuanly_ve().xuat();
            System.out.println("Ngày tạo: "+ hoadon.getNgaytao());
        }
    }

    public void xuat(){
       
        for (String name : quanly_hoadon.keySet()) {
            hoadon hoadon = quanly_hoadon.get(name);
             System.out.println("Hóa đơn của khách hàng: "+name);
            hoadon.getQuanly_ve().xuat();
            System.out.println("Ngày tạo: "+ hoadon.getNgaytao());
        }
    }

    public void ghifile(){

    }
}

class Main {
    public static void main(String[] args) {
        
    }
}
