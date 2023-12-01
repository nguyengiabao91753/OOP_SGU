import java.io.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

interface IXuat {
    void xuat();
}

class HangHangKhong implements IXuat {
    private String tenHang;
    private String maHang;

    public HangHangKhong(String tenHang, String maHang) {
        this.tenHang = tenHang;
        this.maHang = maHang;
    }
    public HangHangKhong(){
        tenHang=" ";
        maHang=" ";
    }
    public void nhap() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên hãng hàng không: ");
        tenHang = input.nextLine();
        System.out.println("Nhập mã hãng hàng không: ");
        maHang = input.nextLine();
    }

    public void xuat() {
        System.out.printf("Mã hãng hàng không: %s\n", maHang);
        System.out.printf("Tên hãng hàng không: %s\n", tenHang);
    }

    public String getTenHang() {
        return tenHang;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }
}

class QuanLyHangHangKhong implements crud {
    private ArrayList<HangHangKhong> danhSachHang;

    public QuanLyHangHangKhong() {
        this.danhSachHang = new ArrayList<>();
    }

    public void themHangHangKhong(HangHangKhong hang) {
        danhSachHang.add(hang);
    }
    public ArrayList<HangHangKhong> getDanhSachHang() {
        return danhSachHang;
    }
    public void hienThiMenu() {
        System.out.println("----- Menu Quản Lý Hãng Hàng Không -----");
        System.out.println("1. Hiển thị danh sách hãng hàng không");
        System.out.println("2. Thêm hãng hàng không mới");
        System.out.println("3. Xóa hãng hàng không");
        System.out.println("4. Sửa thông tin hãng hàng không");
        System.out.println("5. Tìm kiếm hãng hàng không");
        System.out.println("6. Đọc danh sách hãng hàng không từ file");
        System.out.println("7. Ghi danh sách hãng hàng không vào file");
        System.out.println("0. Thoát");
    }

    public void xuat() {
        System.out.println("----- Danh Sách Hãng Hàng Không -----");
        for (IXuat hang : danhSachHang) {
            hang.xuat();
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

    public void sua() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên hãng hàng không cần sửa: ");
        String tenHang = scanner.nextLine();
        HangHangKhong hangCanSua = timHang(tenHang);

        if (hangCanSua != null) {
            System.out.println("Nhập thông tin mới cho hãng hàng không:");
            System.out.print("Nhập tên mới: ");
            String tenMoi = scanner.nextLine();
            System.out.print("Nhập mã mới: ");
            String maMoi = scanner.nextLine();
            hangCanSua.setTenHang(tenMoi);
            hangCanSua.setMaHang(maMoi);

            System.out.println("Hãng hàng không đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy hãng hàng không có tên: " + tenHang);
        }
    }

    public void tim() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên hãng hàng không cần tìm kiếm: ");
        String tenHang = scanner.nextLine();

        HangHangKhong hangKetQua = timHang(tenHang);

        if (hangKetQua != null) {
            System.out.println("Thông tin của hãng hàng không:");
            hangKetQua.xuat();
        } else {
            System.out.println("Không tìm thấy hãng hàng không có tên: " + tenHang);
        }
    }

    public void docFile()  {
    String tenFile = "HHK.txt";
    try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 2) {
                HangHangKhong hang = new HangHangKhong(parts[0], parts[1]);
                themHangHangKhong(hang);
            } else {
                System.out.println("Dữ liệu không hợp lệ: " + line);
            }
        }
    } catch (FileNotFoundException e) {
        System.out.println("File không tồn tại: " + e.getMessage());
    } catch (IOException e) {
        System.out.println("Lỗi khi đọc file: " + e.getMessage());
    }
}

public void ghiFile()  {
    String tenFile = "HHK.txt";
    try (FileWriter bw = new FileWriter(tenFile)) {
        for (HangHangKhong hang : danhSachHang) {
            bw.write(hang.getTenHang() + "," + hang.getMaHang());
            bw.write(System.lineSeparator());
        }
    } catch (IOException e) {
        System.out.println("Lỗi khi ghi file: " + e.getMessage());
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

    public static void main(String[] args) throws Exception {
        QuanLyHangHangKhong quanLy = new QuanLyHangHangKhong();
        Scanner scanner = new Scanner(System.in);

        int luaChon;
        do {
            quanLy.hienThiMenu();
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChon = scanner.nextInt();
            scanner.nextLine();

            switch (luaChon) {
                case 1:
                    quanLy.xuat();
                    break;
                case 2:
                    quanLy.them();
                    break;
                case 3:
                    quanLy.xoa();
                    break;
                case 4:
                    quanLy.sua();
                    break;
                case 5:
                    quanLy.tim();
                    break;
                case 6:
                    quanLy.docFile();
                    break;
                case 7:
                    quanLy.ghiFile();
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
