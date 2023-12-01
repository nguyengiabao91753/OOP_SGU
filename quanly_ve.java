import java.io.*;
import java.util.*;
class quanly_ve implements crud {
    private List<ve> danhsachve;
    private List<ve> dsve_daydu;
    Scanner nhap = new Scanner(System.in);

    public quanly_ve() {
        danhsachve = new ArrayList<>();
        dsve_daydu = new ArrayList<>();
        
    }

    public quanly_ve(List<ve> danhsachve) {
        this.danhsachve = danhsachve;
    }
    public List<ve> getDsve_daydu() {
        return dsve_daydu;
    }

    static int checkmachuyenbay(ve vemoi) throws Exception {
        String macb = vemoi.getChuyenbay().getMachuyenbay();
        DSCB dscb = new DSCB();
        dscb.docfile();
        for (chuyenbay chuyenbay : dscb.getDanhsachchuyenbay()) {
            if (chuyenbay != null && chuyenbay.getMachuyenbay() != null && macb.equals(chuyenbay.getMachuyenbay())) {
                vemoi.setChuyenbay(chuyenbay);
                return 1;
            }
        }
        return 0;
    }

    static int checkkhachhang(ve vemoi, DSKhachHang dskh) throws Exception {
        String makh = vemoi.getkhachHang().getMakh();

        for (khachHang khachHang : dskh.getDskh()) {
            if (khachHang.getMakh().equals(makh) && khachHang != vemoi.getkhachHang()) {
                return 1; // ->nhập lại mã->thêm khách hàng mới vào dskh
            } else if (khachHang == vemoi.getkhachHang()) {
                return 0; // ->thì ok
            }
        }
        return 2; // th: ko trùng mã,ko trùng thông tin nào -> thêm kh mới vào dskh
    }

    public void them() throws Exception {
        ve vemoi = new ve();
        vemoi.nhap();
        // set khach hang
        DSKhachHang dskh = new DSKhachHang();
        dskh.docFile();
        dskh.them(vemoi.getkhachHang());

        // if (checkkhachhang(vemoi, dskh) == 1) {
        //     while (checkkhachhang(vemoi, dskh) == 1) {
        //         System.out.println("Mã khách hàng đã tồn tại! Vui lòng nhập lại");
        //         String makh = nhap.nextLine();
        //         vemoi.getkhachHang().setMakh(makh);
        //     }
        //     dskh.them(vemoi.getkhachHang());
        //     dskh.ghiFile();
        // } else if (checkkhachhang(vemoi, dskh) == 2) {
        //     dskh.them(vemoi.getkhachHang());
        //     dskh.ghiFile();
            
        // }
        // Set mã vé
        String ma = "ve"+ (danhsachve.size()+1);
        vemoi.setMa_ve(ma);
        // String ma = vemoi.getMa_ve();
        // for (ve ve : danhsachve) {
        //     while (ve.getMa_ve().equals(ma)) {
        //         System.out.println("Mã vé đã tồn tại! Vui lòng nhập lại mã vé");
        //         ma = nhap.nextLine();
        //         vemoi.setMa_ve(ma);
        //     }
        // }

        // check chuyến bay
        while (checkmachuyenbay(vemoi) == 0) {
            System.out.println("Mã chuyến bay không tồn tại! Vui lòng nhập lại mã chuyến bay: ");
            ma = nhap.nextLine();
            vemoi.getChuyenbay().setMachuyenbay(ma);
        }

        danhsachve.add(vemoi);
    }

    public void them(ve ve) {
        danhsachve.add(ve);
    }

    public void sua() throws Exception {
        ve vemoi = new ve();
        String ma_sua;
        System.out.println("Nhập mã cần chỉnh sửa");
        ma_sua = nhap.nextLine();
        int co = 0;
        for (ve ve : danhsachve) {
            if (ve.getMa_ve().equals(ma_sua)) {
                System.out.println("Nhập vé mới để sửa");
                vemoi.nhap();

                // check chuyến bay
                while (checkmachuyenbay(vemoi) == 0) {
                    System.out.println("Mã chuyến bay không tồn tại! Vui lòng nhập lại mã chuyến bay: ");
                    String ma = nhap.nextLine();
                    vemoi.getChuyenbay().setMachuyenbay(ma);
                }

                danhsachve.remove(ve);
                danhsachve.add(vemoi);
                co = 1;
                break;
            }
        }
        if (co == 0) {
            System.out.println("Mã vé không tồn tại! ");
        }
    }


    public void xoa() {
        String ma_xoa;
        System.out.println("Nhap mã vé muốn xóa");
        ma_xoa = nhap.nextLine();
        xoa(ma_xoa);
    }
    public void xoa(String ma_xoa) {
        int co = 0;
        for (ve ve : danhsachve) {
            if (ve.getMa_ve().equals(ma_xoa)) {
                ve.setStatus("hidden");
                co = 1;
                break;
            }
        }
        if (co == 0) {
            System.out.println("Mã vé không tồn tại! ");
        }
    }


    public void xoa_Makh(String ma_xoa){
        for (ve ve : danhsachve) 
            if (ve.getkhachHang().getMakh().equals(ma_xoa)) {
                ve.setStatus("hidden");
                break;
            }
    }


    public List<ve> getDanhsachve() {
        return danhsachve;
    }

    public void tim() {
        String ma_tim;
        System.out.println("Nhập mã vé cần tìm");
        ma_tim = nhap.nextLine();
        int co = 0;
        for (ve ve : danhsachve) {
            if (ve.getMa_ve().equals(ma_tim)) {
                ve.xuat();
                co = 1;
                break;
            }
        }
        if (co == 0) {
            System.out.println("Mã vé không  tồn tại! ");
        }
    }

    public void xuat() {
        for (ve ve : danhsachve) 
            if(ve.getStatus() == "show")
                ve.xuat();
    }

    public void ghifile() throws Exception {
        try {
            FileWriter fw = new FileWriter("ve.txt");
            for (ve ve : danhsachve) {
                fw.write(ve.getMa_ve() + "," + ve.getGia() + "," + ve.getkhachHang().getMakh() + ","
                        + ve.getChuyenbay().getMachuyenbay() + "," + ve.getTrangthai() +","+ve.getStatus()+"\n");
            }
            fw.close();
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
            int c = 0;
            while (line != null) {
                String[] arr = line.split(",");
                ve ve = new ve();
                for (int i = 0; i < arr.length; i++) {

                    switch (i) {
                        case 0:
                            ve.setMa_ve(arr[i]);
                            c++;
                            break;
                        case 1:
                            int gia = Integer.parseInt(arr[i]);
                            ve.setGia(gia);
                            c++;
                            break;
                        case 2:
                            DSKhachHang dsKhachHang = new DSKhachHang();
                            dsKhachHang.docFile();

                            for (khachHang khachHang : dsKhachHang.getDskh()) {
                                if (khachHang.getMakh().equals(arr[i])) {
                                    ve.setkhachHang(khachHang);
                                    c++;
                                    break;
                                }
                            }

                            break;
                        case 3:
                            DSCB dscb = new DSCB();
                            dscb.docfile();

                            for (chuyenbay chuyenbay : dscb.getDanhsachchuyenbay()) {
                                if (chuyenbay != null && chuyenbay.getMachuyenbay() != null
                                        && chuyenbay.getMachuyenbay().equals(arr[i])) {
                                    ve.setChuyenbay(chuyenbay);
                                    c++;
                                    break;
                                }
                            }
                            break;
                        case 4:
                            ve.setTrangthai(arr[i]);
                            c++;
                            break;
                        case 5:
                            if(arr[i].equals("show")){
                                ve.setStatus(arr[i]);
                                c++;
                            }
                            break;
                        default:
                            break;
                    }

                }
                if (c == 6) {
                    danhsachve.add(ve);
                }
                if(ve.getStatus().equals("show") || ve.getStatus().equals("hidden")){
                    dsve_daydu.add(ve);
                }
                line = fr.readLine();
                c = 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
