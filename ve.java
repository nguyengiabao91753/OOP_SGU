
import java.io.*;
import java.util.*;

public class ve {
    private String ma_ve;
    private int gia;
    private String trangthai;
    private khachHang khachHang;
    private chuyenbay chuyenbay;

    public ve() {
        ma_ve = "";
        gia = 0;
        trangthai = "";
        khachHang = new khachHang();
        chuyenbay = new chuyenbay();
    }

    public ve(String ma_ve, int gia, String trangthai, khachHang khachHang, chuyenbay chuyenbay) {
        this.ma_ve = ma_ve;
        this.gia = gia;
        this.trangthai = trangthai;
        this.khachHang = khachHang;
        this.chuyenbay = chuyenbay;
    }

    public String getMa_ve() {
        return ma_ve;
    }

    public void setMa_ve(String ma_ve) {
        this.ma_ve = ma_ve;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public khachHang getkhachHang() {
        return khachHang;
    }

    public void setkhachHang(khachHang khachHang) {
        this.khachHang = khachHang;
    }

    public chuyenbay getChuyenbay() {
        return chuyenbay;
    }

    public void setChuyenbay(chuyenbay chuyenbay) {
        this.chuyenbay = chuyenbay;
    }

    public void nhap() {
        Scanner nhap = new Scanner(System.in);
        System.out.println("Nhập Mã vé:");
        ma_ve = nhap.nextLine();
        System.out.println("Nhập giá vé:");
        gia = nhap.nextInt();
        nhap.nextLine();
        khachHang.nhap();
        System.out.println("Nhập mã chuyến bay: ");
        String macb = nhap.nextLine();
        chuyenbay.setMachuyenbay(macb);
        System.out.println("Nhập trạng thái thanh toán (chưa thanh toán/đã thanh toán):");
        trangthai = nhap.nextLine();

    }

    public void xuat() {
        System.out.println(">---------------------------<");
        System.out.println("    Mã vé: " + ma_ve);
        System.out.println("    Hành khách: ");
        getkhachHang().xuat();
        System.out.println("\n    Chuyến bay: ");
        getChuyenbay().xuat();
        System.out.println("\n    Gía: " + gia);
        System.out.println("    Trạng thái: " + trangthai);
    }
}

class quanly_ve implements crud {
    private List<ve> danhsachve;
    Scanner nhap = new Scanner(System.in);

    public quanly_ve() {
        danhsachve = new ArrayList<>();
    }

    public quanly_ve(List<ve> danhsachve) {
        this.danhsachve = danhsachve;
    }

    static int checkmachuyenbay(ve vemoi) throws Exception {
        String macb = vemoi.getChuyenbay().getMachuyenbay();
        DSCB dscb = new DSCB();
        dscb.docfile();
        for (chuyenbay chuyenbay : dscb.getDanhsachchuyenbay()) {
            if (chuyenbay != null && chuyenbay.getMachuyenbay() != null && macb.equals(chuyenbay.getMachuyenbay())) {
                vemoi.setChuyenbay(chuyenbay);
                return 1;
            }
        }
        return 0;
    }

    static int checkkhachhang(ve vemoi, DSKhachHang dskh) throws Exception {
        String makh = vemoi.getkhachHang().getMaKH();

        for (khachHang khachHang : dskh.getDskh()) {
            if (khachHang.getMaKH().equals(makh) && khachHang != vemoi.getkhachHang()) {
                return 1; // ->nhập lại mã->thêm khách hàng mới vào dskh
            } else if (khachHang == vemoi.getkhachHang()) {
                return 0; // ->thì ok
            }
        }
        return 2; // th: ko trùng mã,ko trùng thông tin nào -> thêm kh mới vào dskh
    }

    public void them() throws Exception {
        ve vemoi = new ve();
        vemoi.nhap();
        // check khach hang
        DSKhachHang dskh = new DSKhachHang();
        dskh.docFile();
        

        if (checkkhachhang(vemoi, dskh) == 1) {
            while (checkkhachhang(vemoi, dskh) == 1) {
                System.out.println("Mã khách hàng đã tồn tại! Vui lòng nhập lại");
                String makh = nhap.nextLine();
                vemoi.getkhachHang().setMaKH(makh);
            }
            dskh.them(vemoi.getkhachHang());
            dskh.ghiFile();
        } else if (checkkhachhang(vemoi, dskh) == 2) {
            dskh.them(vemoi.getkhachHang());
            dskh.ghiFile();
            
        }
        // check mã vé
        String ma = vemoi.getMa_ve();
        for (ve ve : danhsachve) {
            while (ve.getMa_ve().equals(ma)) {
                System.out.println("Mã vé đã tồn tại! Vui lòng nhập lại mã vé");
                ma = nhap.nextLine();
                vemoi.setMa_ve(ma);
            }
        }

        // check chuyến bay
        while (checkmachuyenbay(vemoi) == 0) {
            System.out.println("Mã chuyến bay không tồn tại! Vui lòng nhập lại mã chuyến bay: ");
            ma = nhap.nextLine();
            vemoi.getChuyenbay().setMachuyenbay(ma);
        }

        danhsachve.add(vemoi);
    }

    public void them(ve ve) {
        danhsachve.add(ve);
    }

    public void sua() throws Exception {
        ve vemoi = new ve();
        String ma_sua;
        System.out.println("Nhập mã cần chỉnh sửa");
        ma_sua = nhap.nextLine();
        int co = 0;
        for (ve ve : danhsachve) {
            if (ve.getMa_ve().equals(ma_sua)) {
                System.out.println("Nhập vé mới để sửa");
                vemoi.nhap();

                // check mã vé
                String ma = vemoi.getMa_ve();
                for (ve kiemve : danhsachve) {
                    while (kiemve.getMa_ve().equals(ma)) {
                        System.out.println("Mã vé đã tồn tại! Vui lòng nhập lại mã vé");
                        ma = nhap.nextLine();
                        vemoi.setMa_ve(ma);
                    }
                }

                // check chuyến bay
                while (checkmachuyenbay(vemoi) == 0) {
                    System.out.println("Mã chuyến bay không tồn tại! Vui lòng nhập lại mã chuyến bay: ");
                    ma = nhap.nextLine();
                    vemoi.getChuyenbay().setMachuyenbay(ma);
                }

                danhsachve.remove(ve);
                danhsachve.add(vemoi);
                co = 1;
                break;
            }
        }
        if (co == 0) {
            System.out.println("Mã vé không tồn tại! ");
        }
    }

    public void xoa() {
        String ma_xoa;
        System.out.println("Nhap mã vé muốn xóa");
        ma_xoa = nhap.nextLine();
        int co = 0;
        for (ve ve : danhsachve) {
            if (ve.getMa_ve().equals(ma_xoa)) {
                danhsachve.remove(ve);
                co = 1;
                break;
            }
        }
        if (co == 0) {
            System.out.println("Mã vé không tồn tại! ");
        }
    }

    public List<ve> getDanhsachve() {
        return danhsachve;
    }

    public void tim() {
        String ma_tim;
        System.out.println("Nhập mã vé cần tìm");
        ma_tim = nhap.nextLine();
        int co = 0;
        for (ve ve : danhsachve) {
            if (ve.getMa_ve().equals(ma_tim)) {
                ve.xuat();
                co = 1;
                break;
            }
        }
        if (co == 0) {
            System.out.println("Mã vé không  tồn tại! ");
        }
    }

    public void xuat() {
        for (ve ve : danhsachve) {
            ve.xuat();

        }
    }

    public void ghifile() throws Exception {
        try {
            FileWriter fw = new FileWriter("ve.txt");
            for (ve ve : danhsachve) {
                fw.write(ve.getMa_ve() + "," + ve.getGia() + "," + ve.getkhachHang().getMaKH() + ","
                        + ve.getChuyenbay().getMachuyenbay() + "," + ve.getTrangthai() + "\n");
            }
            fw.close();
            System.out.println("ghi file thanh cong");
        } catch (IOException ioe) {
            System.out.println("Exception occurred:");
            ioe.printStackTrace();
        }
    }

    public void docfile() throws Exception {
        File file = new File("ve.txt");
        BufferedReader fr = new BufferedReader(new FileReader(file));
        try {
            String line = fr.readLine();
            int c = 0;
            while (line != null) {
                String[] arr = line.split(",");
                ve ve = new ve();
                for (int i = 0; i < arr.length; i++) {

                    switch (i) {
                        case 0:
                            ve.setMa_ve(arr[i]);
                            c++;
                            break;
                        case 1:
                            int gia = Integer.parseInt(arr[i]);
                            ve.setGia(gia);
                            c++;
                            break;
                        case 2:
                            DSKhachHang dsKhachHang = new DSKhachHang();
                            dsKhachHang.docFile();

                            for (khachHang khachHang : dsKhachHang.getDskh()) {
                                if (khachHang.getMaKH().equals(arr[i])) {
                                    ve.setkhachHang(khachHang);
                                    c++;
                                    break;
                                }
                            }

                            break;
                        case 3:
                            DSCB dscb = new DSCB();
                            dscb.docfile();

                            for (chuyenbay chuyenbay : dscb.getDanhsachchuyenbay()) {
                                if (chuyenbay != null && chuyenbay.getMachuyenbay() != null
                                        && chuyenbay.getMachuyenbay().equals(arr[i])) {
                                    ve.setChuyenbay(chuyenbay);
                                    c++;
                                    break;
                                }
                            }
                            break;
                        case 4:
                            ve.setTrangthai(arr[i]);
                            c++;
                            break;
                        default:
                            break;
                    }

                }
                if (c == 5) {
                    danhsachve.add(ve);
                }
                line = fr.readLine();
                c = 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}

class hienthiquanlyve {
    public static void main(String[] args) throws Exception {
        quanly_ve quanly_ve = new quanly_ve();

        quanly_ve.docfile();

        quanly_ve.xuat();
        // for (ve ve : quanly_ve.getDanhsachve()) {
        // if(ve.getTrangthai().equals("da thanh toan")){
        // quanly_hoadon.them(ve);
        // }
        // }
        // ve ve = new ve();
        // ve.nhap();
        // quanly_ve.them(ve);
        // quanly_ve.ghifile(ve);
        // int luachon;
        // int again = 1;
        // quanly_ve danhsachve = new quanly_ve();
        // Scanner inp = new Scanner(System.in);
        // while (again == 1) {
        // System.out.println(" Quản lý vé chuyến bay");
        // System.out.println(">---------------------------<");
        // System.out.println(" 1. Thêm vé");
        // System.out.println(" 2. Sửa vé");
        // System.out.println(" 3. Xóa vé");
        // System.out.println(" 4. Tìm vé theo mã vé");
        // System.out.println(" 5. Xuất toàn bộ vé");
        // System.out.println(">---------------------------<");

        // System.out.println("Nhập lựa chọn:");
        // luachon = inp.nextInt();
        // if (luachon >= 1 && luachon < 6) {
        // switch (luachon) {
        // case 1:
        // ve ve = new ve();
        // ve.nhap();
        // danhsachve.them(ve);
        // break;
        // case 2:
        // ve vemoi = new ve();
        // String ma_sua;
        // System.out.println("Nhập mã vé cần chỉnh sửa");
        // ma_sua = inp.nextLine();
        // System.out.println("Nhập vé mới để sửa");
        // vemoi.nhap();
        // danhsachve.sua(ma_sua, vemoi);
        // break;
        // case 3:
        // String ma_xoa;
        // System.out.println("Nhap mã vé muốn xóa");
        // ma_xoa = inp.nextLine();
        // danhsachve.xoa(ma_xoa);
        // break;
        // case 4:
        // String ma_tim;
        // System.out.println("Nhập mã vé cần tìm");
        // ma_tim = inp.nextLine();
        // danhsachve.tim(ma_tim);
        // break;
        // case 5:
        // danhsachve.xuat();
        // default:
        // break;
        // }
        // } else {
        // System.out.println("Lựa chọn không hợp lệ!\nXin hãy chọn lại");
        // }

        // System.out.println("Bạn có muốn chọn lại? 1: Có / 2: Không");
        // again = inp.nextInt();
        // }
    }
}