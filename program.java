import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        int chay=1;
        do{
        Scanner nhap = new Scanner(System.in);
        System.out.println("Chủ đề: Quản lý bán vé máy bay ");
        System.out.println("    1. Quản lý Hành khách");
        System.out.println("    2. Quản lý nhân viên");
        System.out.println("    3. Quản lý Tài khoản");
        System.out.println("    4. Quản lý Chuyến bay");//Phan nay cua minh
        System.out.println("    5. Quản lý Vé");
        System.out.println("    6. Quản lý Chỗ ngồi");// phan nay cua minh
        System.out.println("    7. Quản lý Hãng hàng không");
        System.out.println("    8. Quản lý Hóa đơn");
        System.out.println("    9. Quản lý Hành khách");
        System.out.println("    10. Quản lý Danh sách chuyến bay");
        System.out.println("    11. Thoát");
        System.out.println(">---------------------------------------<");
        System.out.println("Nhập lựa chọn");
        int chon = nhap.nextInt();
        if(chon<1 && chon>11){
            System.out.println("Lựa chọn không hợp lệ\nXin mời chọn lại");
            continue;
        }
        switch (chon) {
            case 1:

                break;
            case 4: //Quản lý Chuyến bay
                DSCB tmp=new DSCB();
                tmp.quanlyDSCB();
                break;
            case 6: //Quản lý Chỗ ngồi
                break;
            case 11:
                chay=0;
                break;
            default:
                break;
        }
        }while(chay==1);
    }
}
