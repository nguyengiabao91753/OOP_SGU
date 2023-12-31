import java.io.*;
import java.util.*;

public class QuanLyHangHangKhong implements crud {

    private ArrayList<HangHangKhong> danhSachHang;
    Scanner scanner = new Scanner(System.in);

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
        System.out.println("0. Thoát");
    }

    public void xuat() {
        System.out.println("----- Danh Sách Hãng Hàng Không -----");
        for (HangHangKhong hang : danhSachHang) {
            if(hang.getStatus().equals("show")){
                hang.xuat();
            }
        }
    }

    public void them() {

        System.out.print("Nhập tên hãng hàng không mới: ");
        String tenHang = scanner.nextLine();
        // System.out.print("Nhập mã hãng hàng không mới: ");
        String maHang = "hhk"+(danhSachHang.size() +1);

        HangHangKhong hangMoi = new HangHangKhong(tenHang, maHang);
        themHangHangKhong(hangMoi);
        System.out.println("Hãng hàng không mới đã được thêm: " + tenHang);
    }

    static String rangbuoc(String ten, DSCB dscb) {
        Scanner nhap = new Scanner(System.in);
        System.out.println(ten + " đang có chuyến bay: ");
        for (chuyenbay chuyenbay : dscb.getDanhsachchuyenbay()) {
            if ( chuyenbay!=null && chuyenbay.getHang().getTenHang().equals(ten)) {
                System.out.println(chuyenbay.getMachuyenbay());
            }
        }
        System.out.println("Bạn có chắc muốn xóa: Y/N");
        String chon = nhap.nextLine();
        if (chon.equals("Y")) {
            for (chuyenbay chuyenbay : dscb.getDanhsachchuyenbay()) {
                if (chuyenbay!=null && chuyenbay.getHang().getTenHang().equals(ten)) {
                    dscb.xoa(chuyenbay.getMachuyenbay());
                }
            }
        }
        return chon;
    }

    public void xoa(){}
    
    public void xoa(DSCB dscb) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên hãng hàng không cần xóa: ");
        String tenHang = scanner.nextLine();
        int c = 0;
        for (HangHangKhong hangHangKhong : danhSachHang) {
            if (hangHangKhong.getTenHang().equals(tenHang) && hangHangKhong.getStatus().equals("show")) {
                if (rangbuoc(tenHang, dscb).equals("Y")) {
                    hangHangKhong.setStatus("hidden");
                    System.out.println("Hãng hàng không đã được xóa: " + tenHang);
                }

            }
        }
        if (c == 0) {
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

    public void docFile() throws Exception {
        String tenFile = "HHK.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3 && parts[2].equals("show")) {
                    HangHangKhong hang = new HangHangKhong(parts[0], parts[1]);
                    themHangHangKhong(hang);
                } else {
                    System.out.println("Dữ liệu không hợp lệ: " + line);
                }
            }
            // System.out.println("Đã đọc danh sách hãng hàng không từ file.");
        } catch (FileNotFoundException e) {
            System.out.println("File không tồn tại: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }

    public void ghiFile() throws Exception {
        String tenFile = "HHK.txt";
        try (FileWriter bw = new FileWriter(tenFile)) {
            for (HangHangKhong hang : danhSachHang) {
                bw.write(hang.getTenHang() + "," + hang.getMaHang()+","+hang.getStatus());
                bw.write(System.lineSeparator());
            }
            // System.out.println("Đã ghi danh sách hãng hàng không vào file.");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    private HangHangKhong timHang(String ten) {
        for (HangHangKhong hang : danhSachHang) {
            if (hang.getTenHang().equalsIgnoreCase(ten) && hang.getStatus().equals("show")) {
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
