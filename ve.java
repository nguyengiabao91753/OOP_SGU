
import java.io.*;
import java.util.*;

public class ve {
    private String ma_ve;
    private int gia;
    private String trangthai;
    private khachHang hanhkhach;
    private chuyenbay chuyenbay;

    public ve() {
        ma_ve = "";
        gia = 0;
        trangthai = "";
        hanhkhach = new khachHang();
        chuyenbay = new chuyenbay();
    }

    public ve(String ma_ve, int gia, String trangthai, khachHang hanhkhach, chuyenbay chuyenbay) {
        this.ma_ve = ma_ve;
        this.gia = gia;
        this.trangthai = trangthai;
        this.hanhkhach = hanhkhach;
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

    public khachHang getHanhkhach() {
        return hanhkhach;
    }

    public void setHanhkhach(khachHang hanhkhach) {
        this.hanhkhach = hanhkhach;
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
        System.out.println("Nhập mã hành khách: ");
        hanhkhach.nhap();
        System.out.println("Nhập mã chuyến bay: ");
        chuyenbay.nhap();
        System.out.println("Nhập trạng thái thanh toán (chưa thanh toán/đã thanh toán):");
        trangthai = nhap.nextLine();

    }

    public void xuat() {
        System.out.println(">---------------------------<");
        System.out.println("    Mã vé: " + ma_ve);
        System.out.println("    Hành khách: ");
        getHanhkhach().xuat();
        System.out.println("\n    Chuyến bay: ");
        getChuyenbay().xuat();
        System.out.println("\n    Gía: " + gia);
        System.out.println("    Trạng thái: " + trangthai);
    }
}

class quanly_ve implements crud {
    private List<ve> danhsachve = new ArrayList<>();
    Scanner nhap = new Scanner(System.in);

    // private ve[] danhsachve1 = new ve[];
    public void them() {
        ve ve = new ve();
        ve.nhap();
        danhsachve.add(ve);
    }

    public void them(ve ve){
        danhsachve.add(ve);
    }

    public void sua() {
        ve vemoi = new ve();
        String ma_sua;
        System.out.println("Nhập mã cần chỉnh sửa");
        ma_sua = nhap.nextLine();
        System.out.println("Nhập vé mới để sửa");
        vemoi.nhap();
        for (ve ve : danhsachve) {
            if (ve.getMa_ve().equals(ma_sua)) {
                danhsachve.remove(ve);
                danhsachve.add(vemoi);
                break;
            }
        }
    }

    public void xoa() {
        String ma_xoa;
        System.out.println("Nhap mã vé muốn xóa");
        ma_xoa = nhap.nextLine();
        for (ve ve : danhsachve) {
            if (ve.getMa_ve().equals(ma_xoa)) {
                danhsachve.remove(ve);
                break;
            }
        }
    }

    public List<ve> getDanhsachve() {
        return danhsachve;
    }

    public void tim() {
        String ma_tim;
        System.out.println("Nhập mã vé cần tìm");
        ma_tim = nhap.nextLine();
        for (ve ve : danhsachve) {
            if (ve.getMa_ve().equals(ma_tim)) {
                ve.xuat();
                break;
            }
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
            fw.write(ve.getMa_ve() + "," + ve.getGia() + "," + ve.getHanhkhach().getMaKH() + ","
                    + ve.getChuyenbay().getmachuyenbay() + "," + ve.getTrangthai() + "\n");
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
            while (line != null) {
                String[] arr = line.split(",");
                ve ve = new ve();
                for (int i = 0; i < arr.length; i++) {
                    
                    switch (i) {
                        case 0:
                            ve.setMa_ve(arr[0]);
                            break;
                        case 1:
                            int gia = Integer.parseInt(arr[1]);
                            ve.setGia(gia);
                            break;
                        case 4:
                            ve.setTrangthai(arr[4]);
                            break;
                        default:
                            break;
                    }
 
                }
                danhsachve.add(ve);

                line = fr.readLine();
  
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