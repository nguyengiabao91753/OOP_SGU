import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class hoadon {
    private String maHD;
    private ve ve;
    private String ngaytao;
    private String maNV;
    Scanner nhap = new Scanner(System.in);
    public hoadon() {
        ve = new ve();
        ngaytao = "";
        maHD="";
        maNV="";
    }

    public ve getVe() {
        return ve;
    }
    public void setVe(ve ve) {
        this.ve = ve;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }
    public String getMaNV() {
        return maNV;
    }
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    public String getMaHD() {
        return maHD;
    }
    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }
    public void themhoadon() {
        System.out.println("Nhập mã hóa đơn: ");
        maHD = nhap.nextLine();
        
        System.out.println("Nhập mã nhân viên: ");
        maNV = nhap.nextLine();
            if (ve.getTrangthai().equals("da thanh toan")) {
                LocalDateTime ngayTao = LocalDateTime.now(); // Lấy thời gian thực tế
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                ngaytao  = ngayTao.format(formatter);
            }
        
    }
    public void xuat(){
        System.out.println("Mã hóa đơn: "+maHD);
        System.out.println("Mã nhân viên: "+ maNV);
        ve.xuat();
        System.out.println("Ngày tạo: "+ngaytao);
    }
}

class quanly_hoadon implements crud {
    // Map<String, hoadon> quanly_hoadon;
    List<hoadon> quanly_hoadon;
    Scanner nhap = new Scanner(System.in);
    public quanly_hoadon(){
        quanly_hoadon = new ArrayList<>();
    }
    public void them(){};

    public void them(ve ve) {
        hoadon hoadon = new hoadon();
        hoadon.setVe(ve);
        hoadon.themhoadon();
        String ma = hoadon.getMaHD();
        for (hoadon duyet : quanly_hoadon) {
            while(duyet.getMaHD().equals(ma)){
                System.out.println("Mã hóa đơn đã tồn tại! Vui lòng nhập lại ");
                ma = nhap.nextLine();
                hoadon.setMaHD(ma);
            }
        }
        quanly_hoadon.add(hoadon);
       
    }

    public void sua(){
        System.out.println("Nhập mã hóa đơn: ");
        String ma = nhap.nextLine();
        hoadon hoadonmoi = new hoadon();
        for (hoadon hoadon : quanly_hoadon) {
            if(hoadon.getMaHD().equals(ma)){
                hoadonmoi.setVe(hoadon.getVe());
                hoadonmoi.themhoadon();
                quanly_hoadon.remove(hoadon);
                quanly_hoadon.add(hoadonmoi);
            }
        }
    }

    public void xoa(){
        System.out.println("Nhập mã hóa đơn: ");
        String ma = nhap.nextLine();
        for (hoadon hoadon : quanly_hoadon) {
            if(hoadon.getMaHD().equals(ma)){
                quanly_hoadon.remove(hoadon);
            }
        }
    }

    public void tim(){
        System.out.println("Nhập mã hóa đơn: ");
        String ma = nhap.nextLine();
        for (hoadon hoadon : quanly_hoadon) {
            if(hoadon.getMaHD().equals(ma)){
                hoadon.xuat();
            }
        }
    }

    public void xuat(){
       for (hoadon hoadon : quanly_hoadon) {
            hoadon.xuat();
       }
    }

    public void ghifile() throws Exception{
        try{
        FileWriter fw = new FileWriter("hoadon.txt");
        for (hoadon hoadon : quanly_hoadon) {
            fw.write(hoadon.getMaHD()+","+hoadon.getMaNV()+","+hoadon.getVe().getMa_ve()+","+hoadon.getNgaytao());
        }
        fw.close();
        System.out.println("Ghi file thành công");
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public void docfile() throws Exception{
        File file = new File("hoadon.txt");
        BufferedReader fr = new BufferedReader(new FileReader(file));
        try{
            String line = fr.readLine();
            int c=0;
            while(line != null){
                hoadon hoadon = new hoadon();
                String[] arr = line.split(",");
                for(int i =0; i< arr.length;i++){
                    c=0;
                    switch (i) {
                        case 0:
                            hoadon.setMaHD(arr[i]);
                            c++;
                            break;
                        case 1:
                            hoadon.setMaNV(arr[i]);
                            c++;
                            break;
                        case 2:
                            quanly_ve quanly_ve = new quanly_ve();
                            quanly_ve.docfile();
                            for (ve ve : quanly_ve.getDanhsachve()) {
                                if(ve.getMa_ve().equals(arr[i])){
                                    hoadon.setVe(ve);
                                }
                            }
                            c++;
                            break;
                        case 3:
                            hoadon.setNgaytao(arr[i]);
                            c++;
                            break;
                        default:
                            break;
                    }
                }
                if(c==4){
                    quanly_hoadon.add(hoadon);
                }
                line = fr.readLine();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        quanly_hoadon quanly_hoadon = new quanly_hoadon();
        quanly_hoadon.docfile();
        quanly_hoadon.xuat();
    }
}
