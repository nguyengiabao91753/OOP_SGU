import java.util.*;
import java.io.*;
class DSNhanVien implements crud {
    nhanVien[] dsnv;
    int n;
    Scanner sc = new Scanner(System.in);



    public DSNhanVien(){
        dsnv = new nhanVien[0];
        n = 0;
    }
    public DSNhanVien(nhanVien[] ds, int nn){
        dsnv = Arrays.copyOf(ds,nn);
        n = nn;
    }

    public nhanVien[] getDsnv() {
        return dsnv;
    }


    public void nhap(){
        System.out.print("Nhap so luong nhan vien: ");
        n = sc.nextInt(); sc.nextLine();
        dsnv = new nhanVien[n];
        for(int i = 0; i < n; i++){
            System.out.println("Nhap thong tin nhan vien thu " + (i+1) + ": ");
            dsnv[i] = new nhanVien();
            dsnv[i].nhap();
            dsnv[i].setManv("nv" + (i+1));
        }
    }


    String[][] words = new String[100][];
    int k;
    public void docFile(){
        try{
            dsnv = new nhanVien[0];
            n = 0; k = 0;
            File fin = new File("dataDSNguoi.txt");
        
            Scanner myReader = new Scanner(fin);

            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                words[k] = data.split(",");
                if(Integer.parseInt(words[k][0]) == 1){
                    dsnv = Arrays.copyOf(dsnv,n+1);
                    dsnv[n] = new nhanVien();

                    dsnv[n].setManv(words[k][1]);
                    dsnv[n].setHoTen(words[k][2]);
                    dsnv[n].setGioiTinh(words[k][3]);
                    dsnv[n].setDiaChi(words[k][4]);
                    dsnv[n].setSdt(words[k][5]);
                    dsnv[n].setLuong(Integer.parseInt(words[k][6]));
                    dsnv[n].setStatus(words[k][7]);

                    n++;
                }
                k++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



    public void ghiFile(){
        try{
            FileWriter myWriter = new FileWriter("dataDSNguoi.txt");
            for(nhanVien nv : dsnv){
                myWriter.write("1," + nv.getManv() + "," + nv.getHoTen() + "," + nv.getGioiTinh() + "," + nv.getDiaChi() + ","
                              + nv.getSdt() + "," + nv.getLuong() + "," + nv.getStatus() + "\n");
            }
            for(int i = 0; i < k; i++){
                if(Integer.parseInt(words[i][0]) == 0){
                    myWriter.write("0," + words[i][1] + "," + words[i][2] + "," + words[i][3] + "," + words[i][4] + ","
                                  + words[i][5] + "," + words[i][6] + "\n");
                }
            }
            myWriter.close();
            System.out.println("\n\nGhi File thanh cong");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



    public void xuat(){
        int dem = 0;
        for(int i=0; i<n; i++)
            if(dsnv[i].getStatus().equals("show")){
                System.out.println("\n\nThong tin nhan vien thu " + (dem+1) + ":");
                dsnv[i].xuat();
                dem++;
            }
    }



    public void them(){
        dsnv = Arrays.copyOf(dsnv,n+1);
        dsnv[n] = new nhanVien();
        dsnv[n].setManv("nv" + (n+1));
        System.out.println("\n\nNhap thong tin nhan vien duoc them: ");
        dsnv[n].nhap();
        n++;
    }

    public void them(nhanVien nv){
        dsnv = Arrays.copyOf(dsnv,n+1);
        dsnv[n] = nv;
        dsnv[n].setManv("nv" + (n+1));
        n++;
    }


    public void tim(){
        System.out.println("\n\nNhap ma nhan vien can tim: ");
        String tmp = sc.nextLine();
        tim(tmp);
    }
    public void tim(String ma){
        for(int i = 0; i < n; i++)
            if( dsnv[i].getManv().equals(ma) ){
                dsnv[i].xuat();
                break;
            }
    }



    public void xoa(){
        System.out.println("\n\nNhap ma nhan vien can xoa: ");
        String tmp = sc.nextLine();
        xoa(tmp);
    }
    public void xoa(String ma){
        for(int i = 0; i < n; i++){
            if( dsnv[i].getManv().equals(ma) ){
                dsnv[i].setStatus("hidden");
                n--;
                break;
            }
        }
    }



    public void sua(){
        System.out.println("\n\nNhap ma nhan vien can sua: ");
        String tmp = sc.nextLine();
        sua(tmp);
    }
    public void sua(String ma){
        for(int i = 0; i < n; i++)
            if( dsnv[i].getManv().equals(ma) ){
                int chon;
                do{
                    System.out.println("\n>-----------------------------<");
                    System.out.println("Chon thong tin muon sua:");
                    System.out.println("1-Ho ten");
                    System.out.println("2-Gioi tinh");
                    System.out.println("3-Dia chi");
                    System.out.println("4-So dien thoai");
                    System.out.println("5-Luong");
                    System.out.println("0-Tro ve trang truoc");
                    System.out.print("Nhap lua chon: ");
                    chon = sc.nextInt(); sc.nextLine();
                    switch(chon){
                        case 1:
                            System.out.print("\n\nNhap ho ten moi: ");
                            String tmp1 = sc.nextLine();
                            dsnv[i].setHoTen(tmp1);
                            break;
                        case 2:
                            System.out.print("\n\nNhap gioi tinh moi: ");
                            String tmp2 = sc.nextLine();
                            dsnv[i].setGioiTinh(tmp2);
                            break;
                        case 3:
                            System.out.print("\n\nNhap dia chi moi: ");
                            String tmp3 = sc.nextLine();
                            dsnv[i].setDiaChi(tmp3);
                            break;
                        case 4:
                            System.out.print("\n\nNhap so dien thoai moi: ");
                            String tmp4 = sc.nextLine();
                            dsnv[i].setSdt(tmp4);
                            break;
                        case 5:{
                            System.out.print("\n\nNhap muc luong moi: ");
                            int tmp5 = sc.nextInt(); sc.nextLine();
                            dsnv[i].setLuong(tmp5);
                        }
                        case 0:
                            break;
                        default:{
                            System.out.println("\n\nLua chon khong hop le\n");
                            break;
                        }
                    }
                System.out.println("\n>-----------------------------<");
                }while(chon != 0);
                break;
            }
    }
}