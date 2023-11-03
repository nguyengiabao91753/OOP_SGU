import java.util.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
public class ve {
    private int ma_ve;
    private int gia;
    private String trangthai;
    hanhkhach hanhkhach;
    chuyenbay chuyenbay;

    public ve() {
        ma_ve = 0;
        gia = 0;
        trangthai = "";
        hanhkhach = new hanhkhach();
        chuyenbay = new chuyenbay();
    }

    public ve(int ma_ve, int gia, String trangthai, hanhkhach hanhkhach, chuyenbay chuyenbay) {
        this.ma_ve = ma_ve;
        this.gia = gia;
        this.trangthai = trangthai;
        this.hanhkhach = hanhkhach;
        this.chuyenbay = chuyenbay;
    }

    public int getMa_ve() {
        return ma_ve;
    }

    public void setMa_ve(int ma_ve) {
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

    public hanhkhach getHanhkhach() {
        return hanhkhach;
    }

    public void setHanhkhach(hanhkhach hanhkhach) {
        this.hanhkhach = hanhkhach;
    }

    public chuyenbay getChuyenbay() {
        return chuyenbay;
    }

    public void setChuyenbay(chuyenbay chuyenbay) {
        this.chuyenbay = chuyenbay;
    }

    public void nhap(){
        Scanner nhap = new Scanner(System.in);
        System.out.println("Nhập Mã vé:");
        ma_ve= nhap.nextInt();
        System.out.println("Nhập giá vé:");
        gia = nhap.nextInt();
        nhap.nextLine();
        hanhkhach.nhap();
        chuyenbay.nhap();
        System.out.println("Nhập trạng thái thanh toán (chưa thanh toán/đã thanh toán):");
        trangthai= nhap.nextLine();
        
    }
}

class quanly_ve {
    private List<ve> danhsachve = new ArrayList<>();
    // private ve[] danhsachve1 = new ve[];
    public void themve(ve ve) {
        danhsachve.add(ve);
    }

    public void suave(int ma_ve, ve vemoi) {
        for (ve ve : danhsachve) {
            if (ve.getMa_ve() == ma_ve) {
                danhsachve.remove(ve);
                danhsachve.add(vemoi);
                break;
            }
        }
    }

    public void xoave(int ma_ve) {
        for (ve ve : danhsachve) {
            if (ve.getMa_ve() == ma_ve) {
                danhsachve.remove(ve);
                break;
            }
        }
    }

    public void timve(int ma_ve){
        for (ve ve : danhsachve) {
            if(ve.getMa_ve() == ma_ve){
                System.out.println("    Mã vé: "+ve.getMa_ve());
                System.out.println("    Hành khách: ");
                System.out.println("    Chuyến bay: ");
                System.out.println("    Gía: "+ve.getGia());
                System.out.println("    Trạng thái: "+ve.getTrangthai());
                break;
            }
        }
    }

    public void xuatve(){
        for (ve ve : danhsachve) {
            System.out.println(">---------------------------<");
            System.out.println("    Mã vé: "+ve.getMa_ve());
            System.out.println("    Hành khách: ");
            System.out.println("    Chuyến bay: ");
            System.out.println("    Gía: "+ve.getGia());
            System.out.println("    Trạng thái: "+ve.getTrangthai());


        }
    }
}

class hienthiquanlyve {
    public static void main(String[] args){
        int luachon;
        int again = 1;
        quanly_ve danhsachve = new quanly_ve();
        Scanner inp = new Scanner(System.in);
        while (again == 1) {
        System.out.println("    Quản lý vé chuyến bay");
        System.out.println(">---------------------------<");
        System.out.println("    1. Thêm vé");
        System.out.println("    2. Sửa vé");
        System.out.println("    3. Xóa vé");
        System.out.println("    4. Tìm vé theo mã vé");
        System.out.println("    5. Xuất toàn bộ vé");
        System.out.println(">---------------------------<");
        
            System.out.println("Nhập lựa chọn:");
            luachon = inp.nextInt();
            if (luachon >= 1 && luachon < 6) {
                switch (luachon) {
                    case 1:
                        ve ve = new ve();
                        ve.nhap();
                        danhsachve.themve(ve);
                        break;
                    case 2:
                        ve vemoi = new ve();
                        int ma_sua;
                        System.out.println("Nhập mã vé cần chỉnh sửa");
                        ma_sua = inp.nextInt();
                        System.out.println("Nhập vé mới để sửa");
                        vemoi.nhap();
                        danhsachve.suave(ma_sua, vemoi);
                        break;
                    case 3:
                        int ma_xoa;
                        System.out.println("Nhap mã vé muốn xóa");
                        ma_xoa=inp.nextInt();
                        danhsachve.xoave(ma_xoa);
                        break;
                    case 4:
                        int ma_tim;
                        System.out.println("Nhập mã vé cần tìm");
                        ma_tim= inp.nextInt();
                        danhsachve.timve(ma_tim);
                        break;
                    case 5:
                        danhsachve.xuatve();
                    default:
                        break;
                }
            } else {
                System.out.println("Lựa chọn không hợp lệ!\nXin hãy chọn lại");
            }

            System.out.println("Bạn có muốn chọn lại?  1: Có / 2: Không");
            again = inp.nextInt();
        }
    }
}