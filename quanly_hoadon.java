import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class quanly_hoadon implements crud {
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
        dsnv.docFile();
        for (nhanVien nhanVien : dsnv.getDsnv()) {
            if ( nhanVien!=null && nhanVien.getManv()!= null && manv.equals(nhanVien.getManv())) {
                return 1;
            }
        }
        return 0;
    }

    public void them(ve ve) throws Exception {
        hoadon hoadon = new hoadon();
        hoadon.setVe(ve);
        hoadon.themhoadon();
        // SET mã hóa đơn
        String ma  = "hd"+ (quanly_hoadon.size()+1);
        hoadon.setMaHD(ma);
        // String ma = hoadon.getMaHD();
        // for (hoadon duyet : quanly_hoadon) {
        //     while (duyet.getMaHD().equals(ma)) {
        //         System.out.println("Mã hóa đơn đã tồn tại! Vui lòng nhập lại ");
        //         ma = nhap.nextLine();
        //         hoadon.setMaHD(ma);
        //     }
        // }
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
                            c++;
                            break;
                        case 1:
                            hoadon.setMaNV(arr[i]);
                            c++;
                            break;
                        case 2:
                            quanly_ve quanly_ve = new quanly_ve();
                            quanly_ve.docfile();
                            for (ve ve : quanly_ve.getDsve_daydu()) {
                                if (ve.getMa_ve().equals(arr[i])) {
                                    hoadon.setVe(ve);
                                    c++;
                                }
                            }
                            
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
                c=0;
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
