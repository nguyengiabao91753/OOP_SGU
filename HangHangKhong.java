import java.util.ArrayList;
import java.util.Scanner;

public class HangHangKhong {
    private String tenHang;
    private String maHang;

    public HangHangKhong(String tenHang, String maHang) {
        this.tenHang = tenHang;
        this.maHang = maHang;
    }

    public void nhap() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên hãng hàng không: ");
        tenHang = input.nextLine();
        System.out.println("Nhập mã hãng hàng không: ");
        maHang = input.nextLine();
    }

    public void xuat() {
        System.out.printf("Tên hãng hàng không: %s\n", tenHang);
        System.out.printf("Mã hãng hàng không: %s\n", maHang);
    }

    public String getTenHang() {
        return tenHang;
    }

    public String getMaHang() {
        return maHang;
    }
}

class QuanLyHangHangKhong {
    private ArrayList<HangHangKhong> danhSachHang;

    public QuanLyHangHangKhong() {
        this.danhSachHang = new ArrayList<>();
    }

    public void themHangHangKhong(HangHangKhong hang) {
        danhSachHang.add(hang);
    }

    public void hienThiMenu() {
        System.out.println("----- Menu Quản Lý Hãng Hàng Không -----");
        System.out.println("1. Hiển thị danh sách hãng hàng không");
        System.out.println("2. Thêm hãng hàng không mới");
        System.out.println("3. Xóa hãng hàng không");
        System.out.println("0. Thoát");
    }

    public void hienThiDanhSachHang() {
        System.out.println("----- Danh Sách Hãng Hàng Không -----");
        for (HangHangKhong hang : danhSachHang) {
            System.out.println(hang.getTenHang());
        }
    }

    public void them() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên hãng hàng không mới: ");
        String tenHang = scanner.nextLine();
        System.out.print("Nhập mã hãng hàng không mới: ");
        String maHang = scanner.nextLine();
        HangHangKhong hangMoi = new HangHangKhong(tenHang, maHang);
        themHangHangKhong(hangMoi);
        System.out.println("Hãng hàng không mới đã được thêm: " + tenHang);
    }

    public void xoa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên hãng hàng không cần xóa: ");
        String tenHang = scanner.nextLine();
        HangHangKhong hangXoa = timHang(tenHang);
        if (hangXoa != null) {
            danhSachHang.remove(hangXoa);
            System.out.println("Hãng hàng không đã được xóa: " + tenHang);
        } else {
            System.out.println("Không tìm thấy hãng hàng không có tên: " + tenHang);
        }
    }

    private HangHangKhong timHang(String ten) {
        for (HangHangKhong hang : danhSachHang) {
            if (hang.getTenHang().equalsIgnoreCase(ten)) {
                return hang;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        QuanLyHangHangKhong quanLy = new QuanLyHangHangKhong();
        Scanner scanner = new Scanner(System.in);

        int luaChon;
        do {
            quanLy.hienThiMenu();
            System.out.println("----- Menu Quản Lý Hãng Hàng Không -----");
            System.out.println("1. Hiển thị danh sách hãng hàng không");
            System.out.println("2. Thêm hãng hàng không mới");
            System.out.println("3. Xóa hãng hàng không");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChon = scanner.nextInt();

            switch (luaChon) {
                case 1:
                    quanLy.hienThiDanhSachHang();
                    break;
                case 2:
                    quanLy.them();
                    break;
                case 3:
                    quanLy.xoa();
                    break;
                case 0:
                    System.out.println("Thoát khỏi chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại.");
                    break;
            }

        } while (luaChon != 0);
    }
}