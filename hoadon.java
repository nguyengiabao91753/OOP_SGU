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
        maHD = "";
        maNV = "";
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
            ngaytao = ngayTao.format(formatter);
        }

    }

    public void xuat() {
        System.out.println("Mã hóa đơn: " + maHD);
        System.out.println("Mã nhân viên: " + maNV);
        ve.xuat();
        System.out.println("Ngày tạo: " + ngaytao);
    }
}

class quanly_hoadon implements crud {
    // Map<String, hoadon> quanly_hoadon;
    List<hoadon> quanly_hoadon;
    Scanner nhap = new Scanner(System.in);

    public quanly_hoadon() {
        quanly_hoadon = new ArrayList<>();
    }

    public List<hoadon> getQuanly_hoadon() {
        return quanly_hoadon;
    }

    public void them() {
    };

    static int checkmanv(List<hoadon> quanly_hoadon, hoadon hoadon) throws Exception {
        String manv = hoadon.getMaNV();
        DSNhanVien dsnv = new DSNhanVien();
        for (nhanVien nhanVien : dsnv.getDsnv()) {
            if (manv.equals(nhanVien.getMaNV())) {
                return 1;
            }
        }
        return 0;
    }

    public void them(ve ve) throws Exception {
        hoadon hoadon = new hoadon();
        hoadon.setVe(ve);
        hoadon.themhoadon();
        // check mã hóa đơn
        String ma = hoadon.getMaHD();
        for (hoadon duyet : quanly_hoadon) {
            while (duyet.getMaHD().equals(ma)) {
                System.out.println("Mã hóa đơn đã tồn tại! Vui lòng nhập lại ");
                ma = nhap.nextLine();
                hoadon.setMaHD(ma);
            }
        }
        // check mã nhân viên
        while (checkmanv(quanly_hoadon, hoadon) == 0) {
            System.out.println("Mã nhân viên không tồn tại! Vui lòng nhập lại mã nhân viên: ");
            ma = nhap.nextLine();
            hoadon.setMaNV(ma);
        }

        quanly_hoadon.add(hoadon);

    }

    public void sua() throws Exception {
        System.out.println("Nhập mã hóa đơn: ");
        String ma = nhap.nextLine();
        hoadon hoadonmoi = new hoadon();
        int co=0;
        for (hoadon hoadon : quanly_hoadon) {
            if (hoadon.getMaHD().equals(ma)) {
        
                hoadonmoi.setVe(hoadon.getVe());
                hoadonmoi.themhoadon();
                hoadonmoi.setVe(hoadon.getVe());
                hoadonmoi.setNgaytao(hoadon.getNgaytao());

                // check mã hóa đơn
                String mamoi = hoadonmoi.getMaHD();
                for (hoadon duyet : quanly_hoadon) {
                    while (duyet.getMaHD().equals(mamoi)) {
                        System.out.println("Mã hóa đơn đã tồn tại! Vui lòng nhập lại ");
                        mamoi = nhap.nextLine();
                        hoadonmoi.setMaHD(mamoi);
                    }
                }
                // check mã nhân viên
                while (checkmanv(quanly_hoadon, hoadonmoi) == 0) {
                    System.out.println("Mã nhân viên không tồn tại! Vui lòng nhập lại mã nhân viên: ");
                    mamoi = nhap.nextLine();
                    hoadonmoi.setMaNV(mamoi);
                }

                quanly_hoadon.remove(hoadon);
                quanly_hoadon.add(hoadonmoi);
                co=1;
                break;
            }

        }
        if(co==0){
            System.out.println("Mã hóa đơn không tồn tại! ");
        }
        
    }

    public void xoa() {
        System.out.println("Nhập mã hóa đơn: ");
        String ma = nhap.nextLine();
        int co=0;
        for (hoadon hoadon : quanly_hoadon) {
            if (hoadon.getMaHD().equals(ma)) {
                quanly_hoadon.remove(hoadon);
                co=1;
                break;
            }
        }

        if(co==0){
            System.out.println("Mã hóa đơn không tồn tại! ");
        }
    }

    public void tim() {
        System.out.println("Nhập mã hóa đơn: ");
        String ma = nhap.nextLine();
        int co=0;
        for (hoadon hoadon : quanly_hoadon) {
            if (hoadon.getMaHD().equals(ma)) {
                hoadon.xuat();
                co=1;
                break;
            }
        }

        if(co==0){
            System.out.println("Mã hóa đơn không tồn tại! ");
        }
    }

    public void xuat() {
        for (hoadon hoadon : quanly_hoadon) {
            hoadon.xuat();
        }
    }

    public void ghifile() throws Exception {
        try {
            FileWriter fw = new FileWriter("hoadon.txt");
            for (hoadon hoadon : quanly_hoadon) {
                fw.write(hoadon.getMaHD() + "," + hoadon.getMaNV() + "," + hoadon.getVe().getMa_ve() + ","
                        + hoadon.getNgaytao());
            }
            fw.close();
            System.out.println("Ghi file thành công");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void docfile() throws Exception {
        File file = new File("hoadon.txt");
        BufferedReader fr = new BufferedReader(new FileReader(file));
        try {
            String line = fr.readLine();
            int c = 0;
            while (line != null) {
                hoadon hoadon = new hoadon();
                String[] arr = line.split(",");
                for (int i = 0; i < arr.length; i++) {

                    switch (i) {
                        case 0:
                            hoadon.setMaHD(arr[i]);

                            break;
                        case 1:
                            hoadon.setMaNV(arr[i]);

                            break;
                        case 2:
                            quanly_ve quanly_ve = new quanly_ve();
                            quanly_ve.docfile();
                            for (ve ve : quanly_ve.getDanhsachve()) {
                                if (ve.getMa_ve().equals(arr[i])) {
                                    hoadon.setVe(ve);
                                }
                            }

                            break;
                        case 3:
                            hoadon.setNgaytao(arr[i]);

                            break;
                        default:
                            break;
                    }
                }

                quanly_hoadon.add(hoadon);

                line = fr.readLine();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void thongke() throws Exception {
        quanly_hoadon quanly_hoadon = new quanly_hoadon();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        quanly_hoadon.docfile();
        int[] a = new int[1000];
        int i = 0, t = 0;
        // truyền năm vào mảng
        for (hoadon hoadon : quanly_hoadon.getQuanly_hoadon()) {
            LocalDateTime date = LocalDateTime.parse(hoadon.getNgaytao(), formatter);
            int nam = date.getYear();
            for (int j = 0; j < 1000; j++) {
                t = 0;
                if (a[j] == nam) {
                    t = 1;
                }
            }
            if (t == 0) {
                a[i] = nam;
                i++;
            }
        }
        // sắp xếp mảng tăng dần
        for (int x = 0; x < 1000 - 1; x++) {

            for (int z = x + 1; z < 1000; z++) {
                if (a[z] < a[x] && a[z] != 0 && a[x] != 0) {
                    int tmp = a[x];
                    a[x] = a[z];
                    a[z] = tmp;
                }
            }

        }
        // Thống kê
        for (int j = 0; j < i; j++) {
            int sum = 0;
            System.out.println("Năm " + a[j] + ": ");
            for (hoadon hoadon : quanly_hoadon.getQuanly_hoadon()) {
                if (hoadon.getNgaytao().contains(String.valueOf(a[j]))) {
                    sum += hoadon.getVe().getGia();
                }
            }
            System.out.println("    Tổng doanh thu: " + sum);
        }

    }
}

class Main {
    public static void main(String[] args) throws Exception {
        quanly_hoadon quanlyhoadon = new quanly_hoadon();
        quanlyhoadon.docfile();
        quanlyhoadon.xuat();
        // quanly_hoadon.thongke();
        // quanly_hoadon quanly_hoadon = new quanly_hoadon();
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy
        // HH:mm:ss");
        // quanly_hoadon.docfile();
        // quanly_hoadon.xuat();
        // int[] a = new int[1000];
        // int i=0, t=0;
        // //truyền năm vào mảng
        // for (hoadon hoadon : quanly_hoadon.getQuanly_hoadon()) {
        // LocalDateTime date = LocalDateTime.parse(hoadon.getNgaytao(), formatter);
        // int nam = date.getYear() + 1900;
        // for(int j =0; j<1000;j++){
        // t = 0;
        // if(a[j] == nam){
        // t=1;
        // }
        // }
        // if(t==0){
        // a[i] = nam;
        // i++;
        // }
        // }
        // quanly_hoadon.xuat();
        // //sắp xếp mảng tăng dần
        // for(int x=0;x<1000-1;x++){
        // for(int z = x+1; z<1000;z++){
        // if(a[z] < a[x]){
        // int tmp = a[x];
        // a[x] = a[z];
        // a[z] = tmp;
        // }
        // }
        // }
        // //Thống kê
        // for(int j =0; j<i;j++){
        // int sum=0;
        // System.out.println("Năm "+a[j]+": ");
        // for (hoadon hoadon : quanly_hoadon.getQuanly_hoadon()) {
        // if (hoadon.getNgaytao().contains(String.valueOf(a[j]))) {
        // sum+= hoadon.getVe().getGia();
        // }
        // }
        // System.out.println(" Tổng doanh thu: "+sum);
        // }
    }
}
