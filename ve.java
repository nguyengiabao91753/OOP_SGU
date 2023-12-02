import java.io.*;
import java.util.*;

public class ve {
    private String ma_ve;
    private int gia;
    private String trangthai;
    private khachHang khachHang;
    private chuyenbay chuyenbay;
    private String status;

    public ve() {
        ma_ve = "";
        gia = 0;
        trangthai = "";
        khachHang = new khachHang();
        chuyenbay = new chuyenbay();
        status = "show";
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public void nhap() {
        Scanner nhap = new Scanner(System.in);
        // System.out.println("Nhập Mã vé:");
        // ma_ve = nhap.nextLine();
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



class hienthiquanlyve {
    public static void main(String[] args) throws Exception {
        quanly_ve quanly_ve = new quanly_ve();

        quanly_ve.docfile();
        // quanly_ve.xuat();
        // for (ve ve : quanly_ve.getDsve_daydu()) {
        //     ve.xuat();
        // }
        // System.out.println(quanly_ve.getDanhsachve().size());
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
