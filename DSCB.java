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
            if(danhsachchuyenbay[i].getmachuyenbay().equals(ma)){
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
            System.out.println("Khong tim thay ma chuyen bay can xoa, vui long kiem tra lai!");
        }
    }
    public void quanlyDSCB(){
        int flag;
        while(true){
            Scanner input=new Scanner(System.in);
            System.out.println(">Menu-------------------------<");
            System.out.println("1.Khoi tao mot danh sach moi.");
            System.out.println("2.Xuat danh sach chuyen bay");
            System.out.println("3.Them chuyen bay vao danh sach");
            System.out.println("4.Xoa phan tu cuoi cung danh sach.");
            System.out.println("5.Xoa chuyen bay theo ma so chuyen.");
            System.out.println("6.Luu du lieu.");
            System.out.println("7.Doc du lieu da luu.");
            System.out.println("0.Quay lai.");
            System.out.println("Hay nhap lua chon.");
            flag=input.nextInt();
            if(flag>7 || flag<0){
                System.out.println("Lua chon khong hop le, nhap lai!");
                continue;
            }
            if(flag==0){
                break;
            }
            switch(flag){
                case 1:
                    System.out.println("Co co chac muon khoi tao Danh Sach khong, danh sach se lam moi hoan toan. 'co' hoac phim bat ky.");
                    input.nextLine();
                    String flag1=input.nextLine();
                    if(flag1.equals("co")){
                        sochuyenbay=0;
                        danhsachchuyenbay=new chuyenbay[1000];
                        nhap();
                    }
                    break;
                case 2:
                    System.out.println("Xuat danh sach chuyen bay.");
                    xuat();
                    break;
                case 3:
                    them();
                    break;
                case 4:
                    xoa();
                    break;
                case 5:
                    System.out.println("Nhap ma so chuyen bay can xoa: ");
                    input.nextLine();
                    String cmp=input.nextLine();
                    xoa(cmp);
                    break;
                case 6:
                    try {
                        File fileo=new File("./dataDSCB.txt");
                        OutputStream os=new FileOutputStream(fileo); 
                        ObjectOutputStream oos=new ObjectOutputStream(os);
                        oos.writeObject(sochuyenbay);
                        for(int i=0;i<sochuyenbay;i++){
                            oos.writeObject(danhsachchuyenbay[i]);
                        }
                        oos.flush();
                        oos.close();
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    System.out.println("Du lieu da duoc luu vao file!");
                    break;
                case 7:
                    try {
                        File filei= new File("./dataDSCB.txt");
                        InputStream is=new FileInputStream(filei);
                        ObjectInputStream ois=new ObjectInputStream(is);
                        // chuyenbay tmp=new chuyenbay();
                        Object oj=new Object();
                        sochuyenbay=(int)ois.readObject();
                        for(int i=0;i<sochuyenbay;i++){
                            // tmp=(chuyenbay)ois.readObject();
                            danhsachchuyenbay[i]=new chuyenbay();
                            oj=ois.readObject();
                            danhsachchuyenbay[i]=(chuyenbay) oj;
                        }
                        ois.close();
                        // while(true){
                        //     danhsachchuyenbay[i]=new chuyenbay();
                        //     tmp=(chuyenbay)ois.readObject();
                        //     danhsachchuyenbay[i]=new chuyenbay(tmp);
                        // }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    // System.out.println("Du lieu chuyen bay da duoc lay thanh cong!");
                    System.out.println(""+sochuyenbay);
                    danhsachchuyenbay[0].xuat();
                    break;
            }
        }
    }
}

    
