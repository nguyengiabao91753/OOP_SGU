import java.util.Scanner;

public class program {
    static Scanner inp = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        int chay = 1;
        int luachon;
        int again = 1;
        DSCB tmp = new DSCB();
        tmp.docfile();
        DSKhachHang dsKhachHang = new DSKhachHang();
        dsKhachHang.docFile();
        DSNhanVien dsNhanVien = new DSNhanVien();
        dsNhanVien.docFile();

        quanly_ve danhsachve = new quanly_ve();
        danhsachve.docfile(tmp,dsKhachHang);
        quanly_hoadon quanlyhoadon = new quanly_hoadon();
        quanlyhoadon.docfile(danhsachve);
        QuanLyUser quanLyuser = new QuanLyUser();
        quanLyuser.docFile();
        
        QuanLyHangHangKhong quanLyhhk = new QuanLyHangHangKhong();
        quanLyhhk.docFile();

        Scanner nhap = new Scanner(System.in);
        do {
            System.out.println("------Quản lý bán vé máy bay------");
            System.out.println("    1. Quản lý khách hàng");
            System.out.println("    2. Quản lý nhân viên");
            System.out.println("    3. Quản lý Tài khoản");
            System.out.println("    4. Quản lý Chuyến bay");
            System.out.println("    5. Quản lý Vé");
            System.out.println("    6. Quản lý Hãng hàng không");
            System.out.println("    7. Quản lý Hóa đơn");
            System.out.println("    8. Thống kê doanh thu");
            System.out.println("    0. Thoát");
            System.out.println(">---------------------------------------<");
            System.out.println("Nhập lựa chọn");
            int chon = inp.nextInt();
            if (chon < 1 && chon > 11) {
                System.out.println("Lựa chọn không hợp lệ\nXin mời chọn lại");
                continue;
            }
            switch (chon) {
                case 1:
                    System.out.println("Quản lý khách hàng:");
                    QuanLyKH qlkh = new QuanLyKH();
                    qlkh.menu(dsKhachHang);
                    break; 
                case 2:
                    System.out.println("Quản lý nhân viên:");
                    QuanLyNV qlnv = new QuanLyNV();
                    qlnv.menu(dsNhanVien);
                    break;
                case 3:

                    do {
                        quanLyuser.hienThiMenu();
                        System.out.print("Nhập lựa chọn của bạn: ");
                        luachon = inp.nextInt();
                        inp.nextLine();

                        switch (luachon) {
                            case 1:
                                quanLyuser.xuat();
                                break;
                            case 2:
                                quanLyuser.them();
                                break;
                            case 3:
                                quanLyuser.sua();
                                break;
                            case 4:
                                quanLyuser.xoa();
                                break;
                            case 5:
                                quanLyuser.tim();
                                break;
                            case 0:
                                System.out.println("Thoát khỏi chương trình.");
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại.");
                                break;
                        }
                    } while (luachon != 0);

                    break;
                case 4:

                    System.out.println("Quản lý Chuyến bay");
                    tmp.quanlyDSCB(quanLyhhk);
                    break;
                case 5:

                    while (again == 1) {
                        System.out.println("    Quản lý vé chuyến bay");
                        System.out.println(">---------------------------<");
                        System.out.println("    1. Thêm vé");
                        System.out.println("    2. Cập nhật vé");
                        System.out.println("    3. Xóa vé");
                        System.out.println("    4. Tìm vé theo mã vé");
                        System.out.println("    5. Xuất toàn bộ vé");
                        System.out.println("    6. Thoát");
                        System.out.println(">---------------------------<");

                        System.out.println("Nhập lựa chọn:");
                        luachon = nhap.nextInt();
                        if (luachon >= 1 && luachon <= 6) {
                            switch (luachon) {
                                case 1:

                                    danhsachve.them(dsKhachHang,quanlyhoadon);
                                    break;
                                case 2:
                                    danhsachve.sua(quanlyhoadon);
                                    break;
                                case 3:

                                    danhsachve.xoa();
                                    break;
                                case 4:
                                    danhsachve.tim();
                                    break;
                                case 5:
                                    danhsachve.xuat();
                                    break;
                                case 6:
                                    break;
                                default:
                                    break;
                            }
                        } else {
                            System.out.println("Lựa chọn không hợp lệ!\nXin hãy chọn lại");
                        }

                        System.out.println("Bạn có muốn chọn lại?  1: Có / 2: Không");
                        again = nhap.nextInt();
                    }
                    
                    break;
                case 6:

                    do {
                        quanLyhhk.hienThiMenu();
                        System.out.print("Nhập lựa chọn của bạn: ");
                        luachon = inp.nextInt();
                        inp.nextLine();

                        switch (luachon) {
                            case 1:
                                quanLyhhk.xuat();
                                break;
                            case 2:
                                quanLyhhk.them();
                                break;
                            case 3:
                                quanLyhhk.xoa(tmp);
                                break;
                            case 4:
                                quanLyhhk.sua();
                                break;
                            case 5:
                                quanLyhhk.tim();
                                break;
                            case 0:
                                System.out.println("Thoát khỏi chương trình.");
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại.");
                                break;
                        }

                    } while (luachon != 0);
                    
                    break; 
                case 7:

                    again = 1;
                    while (again == 1) {
                        System.out.println("    Quản lý hóa đơn");
                        System.out.println(">---------------------------<");
                        System.out.println("    1. Sửa hóa đơn");
                        System.out.println("    2. Xóa hóa đơn");
                        System.out.println("    3. Tìm hóa đơn theo tên khách hàng");
                        System.out.println("    4. Xuất toàn bộ hóa đơn");
                        System.out.println("    5. Thoát");
                        System.out.println(">---------------------------<");

                        System.out.println("Nhập lựa chọn:");
                        luachon = nhap.nextInt();
                        if (luachon >= 1 && luachon <= 5) {
                            switch (luachon) {
                                case 1:

                                    quanlyhoadon.sua();
                                    break;
                                case 2:
                                    quanlyhoadon.xoa();
                                    break;
                                case 3:
                                    quanlyhoadon.tim();
                                    break;
                                case 4:
                                    quanlyhoadon.xuat();
                                    break;
                                default:
                                    break;
                            }
                        } else {
                            System.out.println("Lựa chọn không hợp lệ!\nXin hãy chọn lại");
                        }

                        System.out.println("Bạn có muốn chọn lại?  1: Có / 2: Không");
                        again = nhap.nextInt();
                    }
                    
                    break;
                case 8:
                    try {
                        quanly_hoadon.thongke(quanlyhoadon);
                        System.out.println("\n");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;             
                default:
                    chay=0;
                    break;
            }
        } while (chay == 1);
        tmp.ghifile();
        quanLyuser.ghiFile();
        quanlyhoadon.ghifile();
        quanLyhhk.ghiFile();
        danhsachve.ghifile();
        dsKhachHang.ghiFile();
        dsNhanVien.ghiFile();
        nhap.close();
    }

}
