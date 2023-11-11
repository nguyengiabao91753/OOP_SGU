
import java.io.*;
import java.util.*;

public class ve {
    private String ma_ve;
    private int gia;
    private String trangthai;
    hanhkhach hanhkhach;
    chuyenbay chuyenbay;

    public ve() {
        ma_ve = "";
        gia = 0;
        trangthai = "";
        hanhkhach = new hanhkhach();
        chuyenbay = new chuyenbay();
    }

    public ve(String ma_ve, int gia, String trangthai, hanhkhach hanhkhach, chuyenbay chuyenbay) {
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

    public void nhap() {
        Scanner nhap = new Scanner(System.in);
        System.out.println("Nhập Mã vé:");
        ma_ve = nhap.nextLine();
        System.out.println("Nhập giá vé:");
        gia = nhap.nextInt();
        nhap.nextLine();
        hanhkhach.nhap();
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

class quanly_ve {
    private List<ve> danhsachve = new ArrayList<>();

    // private ve[] danhsachve1 = new ve[];
    public void them(ve ve) {
        danhsachve.add(ve);
    }

    public void sua(String ma_ve, ve vemoi) {
        for (ve ve : danhsachve) {
            if (ve.getMa_ve().equals(ma_ve)) {
                danhsachve.remove(ve);
                danhsachve.add(vemoi);
                break;
            }
        }
    }

    public void xoa(String ma_ve) {
        for (ve ve : danhsachve) {
            if (ve.getMa_ve().equals(ma_ve)) {
                danhsachve.remove(ve);
                break;
            }
        }
    }

    public List<ve> getDanhsachve() {
        return danhsachve;
    }

    public void tim(String ma_ve) {
        for (ve ve : danhsachve) {
            if (ve.getMa_ve().equals(ma_ve)) {
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

    public void ghifile(ve ve) throws Exception {
        try {
            File file = new File("ve.txt");

            FileWriter fw = new FileWriter(file, true);
            
            fw.write("\n"+ve.getMa_ve() + "," + ve.getGia() + "," + ve.getHanhkhach().getmaHK() + ","
                    + ve.getChuyenbay().getmachuyenbay() + "," + ve.getTrangthai());

            fw.close();
            System.out.println("ghi file thanh cong");
        } catch (IOException ioe) {
            System.out.println("Exception occurred:");
            ioe.printStackTrace();
        }
    }

    public void docfile() throws Exception{
        File file = new File("ve.txt");
        BufferedReader fr = new BufferedReader(new FileReader(file));
        try{
            String line = fr.readLine();
            while (line != null){
                String[] arr = line.split(",");
                for(int i=0;i<arr.length;i++){
                    System.out.println(arr[i]);
                }
                line = fr.readLine();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

class hienthiquanlyve {
    public static void main(String[] args) throws Exception {
        quanly_ve quanly_ve = new quanly_ve();
        quanly_ve.docfile();
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