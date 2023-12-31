import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyUser implements crud {
    private ArrayList<user> danhSachUser = new ArrayList<>();

    public void themUser(user user) {
        danhSachUser.add(user);
    }

    public void hienThiMenu() {
        System.out.println("----- Menu Quản Lý Thông Tin User -----");
        System.out.println("1. Hiển thị danh sách người dùng");
        System.out.println("2. Thêm người dùng mới");
        System.out.println("3. Sửa thông tin người dùng");
        System.out.println("4. Xóa người dùng");
        System.out.println("5. Tìm kiếm người dùng");
        System.out.println("0. Thoát");
    }

    public void xuat() {
        System.out.println("----- Danh Sách Người Dùng -----");
        for (user xuat : danhSachUser) {
            if(xuat.getStatus().equals("show")){
                xuat.xuatThongTin();
            }
        }
    }

    public boolean ktraTaiKhoan(String newTaiKhoan) {
        for (user user : danhSachUser) {
            if (user.getTaiKhoan().equalsIgnoreCase(newTaiKhoan)) {
                return false;
            }
        }
        return true;
    }

    public void them() {
        user newUser = new user("", "");
        newUser.nhap(danhSachUser);
        themUser(newUser);
        System.out.println("Người dùng mới đã được thêm: " + newUser.getTaiKhoan());
    }

    public void sua() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tài khoản người dùng cần sửa: ");
        String taiKhoan = scanner.nextLine();
        user userCanSua = timUser(taiKhoan);

        if (userCanSua != null) {
            System.out.println("Nhập thông tin mới cho người dùng:");
            System.out.print("Nhập tài khoản mới: ");
            String taiKhoanMoi = scanner.nextLine();

            System.out.print("Bạn có muốn sửa mật khẩu? (y/n): ");
            String chonSuaMatKhau = scanner.nextLine();
            if (chonSuaMatKhau.equalsIgnoreCase("y")) {
                while (true) {
                    System.out.print("Nhập mật khẩu mới: ");
                    String matKhauMoi = scanner.nextLine();

                    System.out.print("Nhập lại mật khẩu mới: ");
                    String nhapLaiMatKhau = scanner.nextLine();

                    if (matKhauMoi.equals(nhapLaiMatKhau)) {
                        userCanSua.setMatKhau(matKhauMoi);
                        break;
                    } else {
                        System.out.println("Mật khẩu không trùng khớp. Vui lòng nhập lại.");
                    }
                }
            }

            userCanSua.setTaiKhoan(taiKhoanMoi);

            System.out.println("Người dùng đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy người dùng có tài khoản: " + taiKhoan);
        }
    }

    public void xoa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tài khoản người dùng cần xóa: ");
        String taiKhoan = scanner.nextLine();
        user userXoa = timUser(taiKhoan);
        if (userXoa != null) {
            userXoa.setStatus("hidden");
            System.out.println("Người dùng đã được xóa: " + taiKhoan);
        } else {
            System.out.println("Không tìm thấy người dùng có tài khoản: " + taiKhoan);
        }
    }

    public void tim() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tài khoản người dùng cần tìm: ");
        String taiKhoan = scanner.nextLine();
        user userTim = timUser(taiKhoan);

        if (userTim != null) {
            System.out.println("----- Thông Tin Người Dùng -----");
            userTim.xuatThongTin();
        } else {
            System.out.println("Không tìm thấy người dùng có tài khoản: " + taiKhoan);
        }
    }

    private user timUser(String taiKhoan) {
        for (user user : danhSachUser) {
            if (user.getTaiKhoan().equalsIgnoreCase(taiKhoan) && user.getStatus().equals("show")) {
                return user;
            }
        }
        return null;
    }

    public void docFile() throws Exception {
        String tenFile = "USER.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3 && parts[2].equals("show")) {
                    user user = new user(parts[0], parts[1]);
                    themUser(user);
                } else {
                    System.out.println("Dữ liệu không hợp lệ: " + line);
                }
            }
            // System.out.println("Đã đọc danh sách người dùng từ file.");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }

    public void ghiFile() throws Exception {
        String tenFile = "USER.txt";
        try (FileWriter fw = new FileWriter(tenFile)) {
            for (user user : danhSachUser) {
                fw.write(user.getTaiKhoan() + "," + user.getMatKhau()+","+user.getStatus());
                fw.write(System.lineSeparator());
            }
            // System.out.println("Đã ghi danh sách người dùng vào file.");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    //public static void main(String[] args) throws Exception {

    //}
}
