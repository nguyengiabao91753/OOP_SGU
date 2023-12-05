import java.util.*;
class QuanLyNV {
    DSNhanVien ds = new DSNhanVien();
    Scanner sc = new Scanner(System.in);



    public void menu(DSNhanVien dsNhanVien){
        int chon;
        do{
            System.out.println("\n>Menu-------------------------<");
            System.out.println("1 - Them nhan vien");
            System.out.println("2 - Sua nhan vien");
            System.out.println("3 - Xoa nhan vien");
            System.out.println("4 - Tim kiem nhan vien");
            System.out.println("5 - Xuat danh sach nhan vien");
            System.out.println("0 - Thoat");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextInt(); sc.nextLine();
            switch(chon){
                case 1:
                    dsNhanVien.them();
                    break;
                case 2:
                    dsNhanVien.sua();
                    break;
                case 3:
                    dsNhanVien.xoa();
                    break;
                case 4:
                    dsNhanVien.tim();
                    break;
                case 5:
                    dsNhanVien.xuat();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\n\nLua cho khong hop le\n");
            }
            System.out.println("\n>-----------------------------<");
        }while(chon != 0);
    }
}
/* 
class DSNV {
    public static void main(String[] args){
        QuanLyNV ql1 = new QuanLyNV();
        ql1.menu();
    }
}
*/