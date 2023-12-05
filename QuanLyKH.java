import java.util.*;
//import java.io.*;
class QuanLyKH {
    Scanner sc = new Scanner(System.in);


    public void menu(DSKhachHang dsKhachHang) throws Exception {
        int chon;
        do{
            System.out.println("\n>Menu-------------------------<");
            System.out.println("1 - Tao danh sach khach hang moi");
            System.out.println("2 - Them khach hang");
            System.out.println("3 - Sua khach hang");
            System.out.println("4 - Xoa khach hang");
            System.out.println("5 - Tim kiem khach hang");
            System.out.println("6 - Xuat danh sach khach hang");
            System.out.println("0 - Thoat");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextInt(); sc.nextLine();
            switch(chon){
                case 1:
                    dsKhachHang.nhap();
                    break;
                case 2:
                    dsKhachHang.them();
                    break;
                case 3:
                    dsKhachHang.sua();
                    break;
                case 4:
                    dsKhachHang.xoa();
                    break;
                case 5:
                    dsKhachHang.tim();
                    break;
                case 6:
                    dsKhachHang.xuat();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nLua cho khong hop le\n");
            }
            System.out.println("\n>-----------------------------<");
        }while(chon != 0);
    }
}
/*
class DSKH {
    public static void main(String[] args) throws FileNotFoundException, Exception {
        QuanLyKH ql1 = new QuanLyKH();
        ql1.menu();
    }
}
*/