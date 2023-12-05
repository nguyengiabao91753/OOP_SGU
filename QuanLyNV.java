import java.util.*;
class QuanLyNV {
    DSNhanVien ds = new DSNhanVien();
    Scanner sc = new Scanner(System.in);



    public void menu(DSNhanVien dsNhanVien){
        int chon;
        dsNhanVien.docFile();
        do{
            System.out.println("\n>Menu-------------------------<");
            System.out.println("1 - Tao danh sach nhan vien moi");
            System.out.println("2 - Them nhan vien");
            System.out.println("3 - Sua nhan vien");
            System.out.println("4 - Xoa nhan vien");
            System.out.println("5 - Tim kiem nhan vien");
            System.out.println("6 - Xuat danh sach nhan vien");
            System.out.println("7 - Tai len danh sach tu File");
            System.out.println("8 - Ghi du lieu vao File");
            System.out.println("0 - Thoat");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextInt(); sc.nextLine();
            switch(chon){
                case 1:
                    dsNhanVien.nhap();
                    break;
                case 2:
                    dsNhanVien.them();
                    break;
                case 3:
                    dsNhanVien.sua();
                    break;
                case 4:
                    dsNhanVien.xoa();
                    break;
                case 5:
                    dsNhanVien.tim();
                    break;
                case 6:
                    dsNhanVien.xuat();
                    break;
                case 7:
                    dsNhanVien.docFile();
                    break;
                case 8:
                    dsNhanVien.ghiFile();
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