import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

// import javafx.stage.Window;

public class DSCB {
    int sochuyenbay;
    chuyenbay[] danhsachchuyenbay;
    public DSCB(){
        sochuyenbay=0;
        danhsachchuyenbay=new chuyenbay[1000];
    }
    public DSCB(int sochuyenbay,chuyenbay[] danhsachchuyenbay){
        this.sochuyenbay=sochuyenbay;
        this.danhsachchuyenbay=danhsachchuyenbay;
    }
    public void nhap(){
        Scanner input=new Scanner(System.in);
        System.out.println("Nhập số lượng chuyến bay:");
        sochuyenbay=input.nextInt();
        for(int i=0;i<sochuyenbay;i++){
            danhsachchuyenbay[i]=new chuyenbay();
            danhsachchuyenbay[i].nhap();
        }
    }
    public void xuat(){
        for(int i=0;i<sochuyenbay;i++){
            danhsachchuyenbay[i].xuat();
        }
    }
    public void them(){
        danhsachchuyenbay=Arrays.copyOf(danhsachchuyenbay, sochuyenbay+1);
        danhsachchuyenbay[sochuyenbay]=new chuyenbay();
        danhsachchuyenbay[sochuyenbay].nhap();
        sochuyenbay++;
    }
    public void xoa(){
        danhsachchuyenbay=Arrays.copyOf(danhsachchuyenbay,sochuyenbay-1);
        sochuyenbay--;
    }
    public void xoa(String ma){
        int flag=0;
        for(int i=0;i<sochuyenbay;i++){
            if(danhsachchuyenbay[i].getMachuyenbay().equals(ma)){
                System.out.println("Thuc hien xoa chuyen bay:");
                danhsachchuyenbay[i].xuat();
                for(int j=i;j<sochuyenbay;j++){
                    danhsachchuyenbay[j]=danhsachchuyenbay[j+1];
                }
                flag=1;
                sochuyenbay--;
                break;
            }
            
        }
        if(flag==0){
            System.out.println("Không tìm thấy mã chuyến bay cần xóa vui lòng kiểm tra lại!");
        }
    }
    public void quanlyDSCB(){
        int flag;
        while(true){
            Scanner input=new Scanner(System.in);
            System.out.println("-------->Menu quản lý chuyến bay--------<");
            System.out.println("    1.Khởi tạo một danh sách chuyến bay.");
            System.out.println("    2.Xuất danh sách chuyến bay ra màn hình.");
            System.out.println("    3.Thêm chuyến bay vào danh sách.");
            System.out.println("    4.Xóa phần tử cuối cùng của danh sách.");
            System.out.println("    5.Xóa chuyến bay theo mã số chuyến.");
            System.out.println("    6.Đọc dữ liệu chuyến bay từ File ra mảng.");
            System.out.println("    7.Lưu dữ liệu.");
            System.out.println("    0.Quay lại trang chính.");
            System.out.println("Hãy nhập lựa chọn của bạn!");
            flag=input.nextInt();
            if(flag>7 || flag<0){
                System.out.println("Lựa chọn của bạn không hợp lệ,vui lòng nhập lại!");
                continue;
            }
            if(flag==0){
                break;
            }
            switch(flag){
                case 1:
                    System.out.println("Bạn có chắc khởi tạo, danh sách sẽ được khởi tạo từ đầu. Ấn 'co' để tiếp tục hoặc phím bất kỳ để thoát.");
                    input.nextLine();
                    String flag1=input.nextLine();
                    if(flag1.equals("co")){
                        sochuyenbay=0;
                        danhsachchuyenbay=new chuyenbay[1000];
                        nhap();
                    }
                    break;
                case 2:
                    System.out.println("Xuất danh sách chuyến bay.");
                    xuat();
                    break;
                case 3:
                    them();
                    break;
                case 4:
                    xoa();
                    break;
                case 5:
                    System.out.println("Nhập mã số chuyến bay cần xóa: ");
                    input.nextLine();
                    String cmp=input.nextLine();
                    xoa(cmp);
                    break;
                case 6:
                    
                    try {
                        BufferedReader sc= new BufferedReader(new FileReader("dataDSCB.txt"));
                        String line=sc.readLine();
                        sochuyenbay=0;
                        while (line!=null) {
                            String[] arr=line.split(",");
                            danhsachchuyenbay[sochuyenbay] =new chuyenbay();
                            danhsachchuyenbay[sochuyenbay].setMachuyenbay(arr[0]);
                            danhsachchuyenbay[sochuyenbay].setThoigiankhoihanh(arr[1]);
                            danhsachchuyenbay[sochuyenbay].setDiemxuatphat(arr[2]);
                            danhsachchuyenbay[sochuyenbay].setDiemden(arr[3]);
                            danhsachchuyenbay[sochuyenbay].setSoghe(Integer.parseInt(arr[4]));
                            sochuyenbay++;
                            line=sc.readLine();
                        }
                        sc.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    try {
                        FileWriter fw=new FileWriter("dataDSCB.txt");
                        for (int i=0;i<sochuyenbay;i++) {
                            fw.write(danhsachchuyenbay[i].getMachuyenbay()+","+danhsachchuyenbay[i].getThoigiankhoihanh()+","+danhsachchuyenbay[i].getDiemxuatphat()+","+danhsachchuyenbay[i].getDiemden()+","+danhsachchuyenbay[i].getSoghe()+"\n");
                        }
                        // fw.write("chào mừng đến với thế giới thần tiên.");

                        fw.close();
                        }
                        
                    catch (Exception ex) {
                        // TODO: handle exception
                        System.out.println(ex);
                    }
                    // System.out.println("Du lieu chuyen bay da duoc lay thanh cong!");
                    break;
            }
        }
    }
}

    
