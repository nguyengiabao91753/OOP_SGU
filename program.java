import java.util.Scanner;

public class program {
    static Scanner inp = new Scanner(System.in);
    public static void main(String[] args) {
        int chay = 1;
        int luachon;
        int again = 1;
        Scanner nhap = new Scanner(System.in);
        quanly_ve danhsachve = new quanly_ve();
        do {
            System.out.println("Chủ đề: Quản lý bán vé máy bay ");
            System.out.println("    1. Quản lý Hành khách");
            System.out.println("    2. Quản lý nhân viên");
            System.out.println("    3. Quản lý Tài khoản");
            System.out.println("    4. Quản lý Chuyến bay");
            System.out.println("    5. Quản lý Vé");
            System.out.println("    6. Quản lý Chỗ ngồi");
            System.out.println("    7. Quản lý Hãng hàng không");
            System.out.println("    8. Quản lý Giỏ hàng");
            System.out.println("    9. Quản lý Hóa đơn");
            System.out.println("    10. Quản lý Danh sách chuyến bay");
            System.out.println("    11. Thoát");
            System.out.println(">---------------------------------------<");
            System.out.println("Nhập lựa chọn");
            int chon = inp.nextInt();
            if (chon < 1 && chon > 11) {
                System.out.println("Lựa chọn không hợp lệ\nXin mời chọn lại");
                continue;
            }
            switch (chon) {
                case 1:
                    System.out.println("Quản lý Hành khách:");
                    int chon1;
                    DSHK dshk = new DSHK();
                    do{
                        System.out.println(">Menu-------------------------<");
                        System.out.println("1.Khoi tao mot danh sach moi.");
                        System.out.println("2.Xuat danh sach hanh khach.");
                        System.out.println("3.Them hanh khach vao danh sach.");
                        System.out.println("4.Xoa hanh khach khoi danh sach theo ma.");
                        System.out.println("0.Tro lai trang truoc.");
                        System.out.println("Hay nhap lua chon.");
                        chon1 = inp.nextInt();
                        switch(chon1){
                            case 1:
                                dshk.nhap();
                                break;
                            case 2:
                                dshk.xuat();
                                break;
                            case 3:
                                dshk.them();
                                break;
                            case 4:
                                dshk.xoa();
                                break;
                            case 0: break;
                            default:
                                System.out.println("Lua cho khong hop le\n");
                                break;
                        }
                    }while(chon1 != 0);
                    break;
                case 2:
                    System.out.println("Quản lý nhân viên:");
                    int chon2;
                    DSNV dsnv = new DSNV();
                    do{
                        System.out.println(">Menu-------------------------<");
                        System.out.println("1.Khoi tao mot danh sach moi.");
                        System.out.println("2.Xuat danh sach nhan vien.");
                        System.out.println("3.Them nhan vien vao danh sach.");
                        System.out.println("4.Xoa nhan vien khoi danh sach theo ma.");
                        System.out.println("0.Tro lai trang truoc.");
                        System.out.println("Hay nhap lua chon.");
                        chon2 = inp.nextInt();
                        switch(chon2){
                            case 1:
                                dsnv.nhap();
                                break;
                            case 2:
                                dsnv.xuat();
                                break;
                            case 3:
                                dsnv.them();
                                break;
                            case 4:
                                dsnv.xoa();
                                break;
                            case 0: break;
                            default:
                                System.out.println("Lua cho khong hop le\n");
                                break;
                        }
                    }while(chon2 != 0);
                    break;
                case 4:            
                    System.out.println("Quản lý Chuyến bay");
                    DSCB tmp=new DSCB();
                    tmp.quanlyDSCB();
                    break;
                case 5:
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
                        luachon = nhap.nextInt();
                        if (luachon >= 1 && luachon <= 6) {
                            switch (luachon) {
                                case 1:
                                    ve ve = new ve();
                                    ve.nhap();
                                    danhsachve.them(ve);
                                    break;
                                case 2:
                                    ve vemoi = new ve();
                                    String ma_sua;
                                    System.out.println("Nhập mã vé cần chỉnh sửa");
                                    ma_sua = nhap.nextLine();
                                    System.out.println("Nhập vé mới để sửa");
                                    vemoi.nhap();
                                    danhsachve.sua(ma_sua, vemoi);
                                    break;
                                case 3:
                                    String ma_xoa;
                                    System.out.println("Nhap mã vé muốn xóa");
                                    ma_xoa = nhap.nextLine();
                                    danhsachve.xoa(ma_xoa);
                                    break;
                                case 4:
                                    String ma_tim;
                                    System.out.println("Nhập mã vé cần tìm");
                                    ma_tim = nhap.nextLine();
                                    danhsachve.tim(ma_tim);
                                    break;
                                case 5:
                                    danhsachve.xuat();
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
                    again=1;
                    quanly_giohang quanly_giohang = new quanly_giohang();
                    for (ve ve : danhsachve.getDanhsachve()) {
                        quanly_giohang.them(ve.getHanhkhach().gethoten(), ve );
                    }
                    while (again == 1) {
                        System.out.println("    Quản lý giỏ hàng");
                        System.out.println(">---------------------------<");
                        System.out.println("    1. Sửa giỏ hàng");
                        System.out.println("    2. Xóa vé trong giỏ hàng");
                        System.out.println("    3. Tìm giỏ hàng theo tên khách hàng");
                        System.out.println("    4. Xuất toàn bộ giỏ hàng");
                        System.out.println(">---------------------------<");

                        System.out.println("Nhập lựa chọn:");
                        luachon = nhap.nextInt();
                        if (luachon >= 1 && luachon <= 4) {
                            switch (luachon) {
                                case 1:
                                    System.out.println("Nhập tên khách hàng: ");
                                    String name = nhap.nextLine();
                                    System.out.println("Nhập số thứ tự vé muốn xóa: ");
                                    String maso = nhap.nextLine();
                                    System.out.println("Nhập vé mới: ");
                                    ve vemoi = new ve();
                                    vemoi.nhap();
                                    quanly_giohang.sua(name, maso, vemoi);
                                    break;
                                case 2:
                                    
                                    break;
                                case 3:
                                    String ma_xoa;
                                    System.out.println("Nhap mã vé muốn xóa");
                                    ma_xoa = nhap.nextLine();
                                    danhsachve.xoa(ma_xoa);
                                    break;
                                case 4:
                                    String ma_tim;
                                    System.out.println("Nhập mã vé cần tìm");
                                    ma_tim = nhap.nextLine();
                                    danhsachve.tim(ma_tim);
                                    break;
                                case 5:
                                    danhsachve.xuat();
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
                case 11:
                    chay = 0;
                    break;
                default:
                    break;
            }
        } while (chay == 1);


        nhap.close();
    }


}
