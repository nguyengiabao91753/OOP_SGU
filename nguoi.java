abstract class nguoi {
    Scanner sc = new Scanner(System.in);
    protected String hoten, gioitinh, diachi, sdt;



    public nguoi(){
    }
    public nguoi(String hoten, String gioitinh, String diachi, String sdt){
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.sdt = sdt;
    }


    
    public void nhap(){
        System.out.println("Nhap ho ten: ");
        hoten = sc.nextLine();
        System.out.println("Nhap gioi tinh: ");
        gioitinh = sc.nextLine();
        System.out.println("Nhap dia chi: ");
        diachi = sc.nextLine();
        System.out.println("Nhap so dien thoai: ");
        sdt = sc.nextLine();
    }
    public abstract void xuat();
}
