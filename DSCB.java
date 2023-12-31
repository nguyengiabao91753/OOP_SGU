import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

// import javafx.stage.Window;

public class DSCB implements crud {
    int sochuyenbay;
    chuyenbay[] danhsachchuyenbay;

    public DSCB() {
        sochuyenbay = 0;
        danhsachchuyenbay = new chuyenbay[1000];
    }

    public DSCB(int sochuyenbay, chuyenbay[] danhsachchuyenbay) {
        this.sochuyenbay = sochuyenbay;
        this.danhsachchuyenbay = danhsachchuyenbay;
    }

    public chuyenbay[] getDanhsachchuyenbay() {
        return danhsachchuyenbay;
    }

    public void setDanhsachchuyenbay(chuyenbay[] danhsachchuyenbay) {
        this.danhsachchuyenbay = danhsachchuyenbay;
    }

    public void nhap() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số lượng chuyến bay:");
        sochuyenbay = input.nextInt();
        for (int i = 0; i < sochuyenbay; i++) {
            danhsachchuyenbay[i] = new chuyenbay(i+1);
            danhsachchuyenbay[i].nhap();
        }
    }

    public void xuat() {
        for (int i = 0; i < sochuyenbay; i++) {
            danhsachchuyenbay[i].xuat();
        }
    }

    public void them() throws Exception {
        danhsachchuyenbay = Arrays.copyOf(danhsachchuyenbay, sochuyenbay + 1);
        danhsachchuyenbay[sochuyenbay] = new chuyenbay(sochuyenbay+1);
        danhsachchuyenbay[sochuyenbay].nhap();
        sochuyenbay++;
    }

    public void sua() throws Exception {
        String mabay;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập mã chuyến bay cần thay đổi: ");
        boolean flag=true;
        mabay = input.nextLine();
        for (int i = 0; i < sochuyenbay; i++) {
            if (danhsachchuyenbay[i].getMachuyenbay().equals(mabay) && danhsachchuyenbay[i].getStatus().equals("show")) {
                danhsachchuyenbay[i].nhap();
                flag=false;
                break;
            }
        }
        if(flag){
            System.out.println("Không tìm thấy mã chuyến bay cần chỉnh sửa.");
        }
    }

    public void tim() {
        String mabay;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập mã chuyến bay cần tìm: ");
        boolean flag=true;
        mabay = input.nextLine();
        for (int i = 0; i < sochuyenbay; i++) {
            if (danhsachchuyenbay[i].getMachuyenbay().equals(mabay) && danhsachchuyenbay[i].getStatus().equals("show")) {
                danhsachchuyenbay[i].xuat();
                flag=false;
                break;
            }
        }
        if(flag){
            System.out.println("Không tìm thấy mã chuyến bay cần tìm.");
        }
        
    }

    public void xoa() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập mã chuyến bay cần xóa: ");
        String ma = input.nextLine();
        boolean flag = true;
        for (int i = 0; i < sochuyenbay; i++) {
            if (danhsachchuyenbay[i].getMachuyenbay().equals(ma)) {
                System.out.println("Thuc hien xoa chuyen bay:");
                danhsachchuyenbay[i].xuat();
                danhsachchuyenbay[i].setStatus("hidden");
                flag= false;
                break;
            }

        }
        if (flag) {
            System.out.println("Không tìm thấy mã chuyến bay cần xóa vui lòng kiểm tra lại!");
        }
    }
    public void xoa(String ma){
         for (int i = 0; i < sochuyenbay; i++) {
            if (danhsachchuyenbay[i].getMachuyenbay().equals(ma)) {
                System.out.println("Thuc hien xoa chuyen bay:");
                danhsachchuyenbay[i].xuat();
                danhsachchuyenbay[i].setStatus("hidden");
                
                break;
            }

        }
    }
    public void docfile() throws Exception {
        QuanLyHangHangKhong newQuan = new QuanLyHangHangKhong();
        newQuan.docFile();
        try {
            BufferedReader sc = new BufferedReader(new FileReader("dataDSCB.txt"));
            String line = sc.readLine();
            sochuyenbay = 0;
            while (line != null) {
                boolean flag = true;
                String[] arr = line.split(",");
                danhsachchuyenbay[sochuyenbay] = new chuyenbay();
                danhsachchuyenbay[sochuyenbay].setMachuyenbay(arr[0]);
                for (HangHangKhong tmp : newQuan.getDanhSachHang()) {
                    if (arr[1].equals(tmp.getMaHang())) {
                        danhsachchuyenbay[sochuyenbay].setHang(tmp);
                        flag = true;
                        break;
                    }
                }
                danhsachchuyenbay[sochuyenbay].setThoigiankhoihanh(arr[2]);
                danhsachchuyenbay[sochuyenbay].setDiemxuatphat(arr[3]);
                danhsachchuyenbay[sochuyenbay].setDiemden(arr[4]);
                danhsachchuyenbay[sochuyenbay].setSoghe(Integer.parseInt(arr[5]));
                danhsachchuyenbay[sochuyenbay].setStatus(arr[6]);
                sochuyenbay++;
                line = sc.readLine();
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ghifile() throws Exception {
        try {
            FileWriter fw = new FileWriter("dataDSCB.txt");
            for (int i = 0; i < sochuyenbay; i++) {
                fw.write(danhsachchuyenbay[i].getMachuyenbay() + ","
                        + danhsachchuyenbay[i].getHang().getMaHang() + ","
                        + danhsachchuyenbay[i].getThoigiankhoihanh() + ","
                        + danhsachchuyenbay[i].getDiemxuatphat() + "," + danhsachchuyenbay[i].getDiemden()
                        + "," + danhsachchuyenbay[i].getSoghe()
                        +","+ danhsachchuyenbay[i].getStatus()
                        + "\n");
            }
            // fw.write("chào mừng đến với thế giới thần tiên.");

            fw.close();
        }

        catch (Exception ex) {
            // TODO: handle exception
            System.out.println(ex);
        }
        // System.out.println("Du lieu chuyen bay da duoc lay thanh cong!");
    }

    public void quanlyDSCB(QuanLyHangHangKhong dshhk) throws Exception {
        int flag;
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("-------->Menu quản lý chuyến bay--------<");
            // System.out.println("    1.Khởi tạo một danh sách chuyến bay.");
            System.out.println("    1.Xuất danh sách chuyến bay ra màn hình.");
            System.out.println("    2.Thêm chuyến bay vào danh sách.");
            System.out.println("    3.Xóa chuyến bay theo mã số chuyến.");
            System.out.println("    4.Chỉnh sửa thông tin chuyến bay.");
            System.out.println("    5.Tìm kiếm chuyến bay.");
            // System.out.println(" 7.Lưu dữ liệu.");
            // System.out.println(" 8.Quản lý hãng hàng không.");
            System.out.println("    0.Quay lại trang chính.");
            System.out.println("Hãy nhập lựa chọn của bạn!");
            flag = input.nextInt();
            if (flag > 5 || flag < 0) {
                System.out.println("Lựa chọn của bạn không hợp lệ,vui lòng nhập lại!");
                continue;
            }
            if (flag == 0) {
                break;
            }
            switch (flag) {
                case 1:
                    System.out.println("Xuất danh sách chuyến bay.");
                    for(HangHangKhong tmp: dshhk.getDanhSachHang()){
                        System.out.println(">----------------------------------<");
                        System.out.println("Hãng hãng không: "+tmp.getTenHang());
                        for(int i=0;i<sochuyenbay;i++){
                           
                            if(tmp.getMaHang().equals(danhsachchuyenbay[i].getHang().getMaHang())){
                                danhsachchuyenbay[i].xuat();
                                System.out.println("");
                            }
                        }
                        // System.out.println(tmp.getMaHang());
                    }
                    break;
                case 2:
                    them();
                    break;
                case 3:
                    xoa();
                    break;
                case 4:
                    sua();
                    break;
                case 5:
                    tim();
                    break;
                    
            }
        }
    }
}
