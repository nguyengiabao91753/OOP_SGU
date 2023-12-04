import java.util.*;
import java.io.*;
class DSKhachHang implements crud {
    private khachHang[] dskh;
    private int n;
    Scanner sc = new Scanner(System.in);



    public DSKhachHang(){
        dskh = new khachHang[0];
        n = 0;
    }
    public DSKhachHang(khachHang[] ds, int nn){
        dskh = Arrays.copyOf(ds,nn);
        n = nn;
    }

    public khachHang[] getDskh() {
        return dskh;
    }
    public void setDskh(khachHang[] dskh) {
        this.dskh = dskh;
    }


    public void nhap(){
        System.out.println("Nhap so luong khach hang: ");
        n = sc.nextInt(); sc.nextLine();
        dskh = new khachHang[n];
        for(int i = 0; i < n; i++){
            System.out.println("\nNhap thong tin khach hang thu " + (i+1) + ": ");
            dskh[i] = new khachHang();
            dskh[i].nhap();
            dskh[i].setMakh("kh" + (i+1));
        }
    }


    String[][] words = new String[100][];
    int k;
    public void docFile(){
        try{
            k = 0;
            File fin = new File("dataDSNguoi.txt");
        
            Scanner myReader = new Scanner(fin);

            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                words[k] = data.split(",");
                if(Integer.parseInt(words[k][0]) == 0){
                    dskh = Arrays.copyOf(dskh,n+1);
                    dskh[n] = new khachHang();

                    dskh[n].setMakh(words[k][1]);
                    dskh[n].setHoTen(words[k][2]);
                    dskh[n].setGioiTinh(words[k][3]);
                    dskh[n].setDiaChi(words[k][4]);
                    dskh[n].setSdt(words[k][5]);
                    dskh[n].setStatus(words[k][6]);

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
            for(khachHang kh : dskh){
                myWriter.write("0," + kh.getMakh() + "," + kh.getHoTen() + "," + kh.getGioiTinh() + "," + kh.getDiaChi() + ","
                              + kh.getSdt() + "," + kh.getStatus() + "\n");
            }
            for(int i = 0; i < k; i++){
                if(Integer.parseInt(words[i][0]) == 1){
                    myWriter.write("1," + words[i][1] + "," + words[i][2] + "," + words[i][3] + "," + words[i][4] + ","
                                  + words[i][5] + "," + words[i][6] + "," + words[i][7] + "\n");
                }
            }
            myWriter.close();
            
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



    public void xuat(){
        int dem = 0;
        for(int i = 0; i < n; i++)
            if(dskh[i].getStatus().equals("show")){
                System.out.println("\n\nThong tin khach hang thu " + (dem+1) + ":");
                dskh[i].xuat();
                dem++;
            }
    }



    public void tim(){
        System.out.println("\n\nNhap ma khach hang can tim: ");
        String tmp = sc.nextLine();
        tim(tmp);
    }
    public void tim(String ma){
        for(int i = 0; i < n; i++)
            if( dskh[i].getMakh().equals(ma) ){
                dskh[i].xuat();
                break;
            }
    }



    public void them(){
        dskh = Arrays.copyOf(dskh,n+1);
        dskh[n] = new khachHang();
        dskh[n].setMakh("kh" + (n+1));
        System.out.println("\n\nNhap thong tin khach hang duoc them: ");
        dskh[n].nhap();
        n++;
    }

    public void them(khachHang kh){
        dskh = Arrays.copyOf(dskh,n+1);
        dskh[n] = kh;
        dskh[n].setMakh("kh" + (n+1));
        n++;
    }



    public void xoa(){
        System.out.println("\n\nNhap ma khach hang can xoa: ");
        String tmp = sc.nextLine();
        xoa(tmp);
    }
    public void xoa(String ma){
        for(int i = 0; i < n; i++){
            if( dskh[i].getMakh().equals(ma) ){
                dskh[i].setStatus("hidden");
                n--;
                break;
            }
        }
    }



    public void sua(){
        System.out.println("\n\nNhap ma khach hang can sua: ");
        String tmp = sc.nextLine();
        sua(tmp);
    }
    public void sua(String ma){
        for(int i = 0; i < n; i++)
            if( dskh[i].getMakh().equals(ma) ){
                int chon;
                do{
                    System.out.println("\n>-----------------------------<");
                    System.out.println("Chon thong tin muon sua:");
                    System.out.println("1-Ho ten");
                    System.out.println("2-Gioi tinh");
                    System.out.println("3-Dia chi");
                    System.out.println("4-So dien thoai");
                    System.out.println("0-Tro ve trang truoc");
                    System.out.print("Nhap lua chon: ");
                    chon = sc.nextInt(); sc.nextLine();
                    switch(chon){
                        case 1:
                            System.out.print("\n\nNhap ho ten moi: ");
                            String tmp1 = sc.nextLine();
                            dskh[i].setHoTen(tmp1);
                            break;
                        case 2:
                            System.out.print("\n\nNhap gioi tinh moi: ");
                            String tmp2 = sc.nextLine();
                            dskh[i].setGioiTinh(tmp2);
                            break;
                        case 3:
                            System.out.print("\n\nNhap dia chi moi: ");
                            String tmp3 = sc.nextLine();
                            dskh[i].setDiaChi(tmp3);
                            break;
                        case 4:
                            System.out.print("\n\nNhap so dien thoai moi: ");
                            String tmp4 = sc.nextLine();
                            dskh[i].setSdt(tmp4);
                            break;
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