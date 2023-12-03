class nhanVien extends nguoi {
    private String manv;
    private int luong;


    public nhanVien(){
        manv = "";
        luong = 0;
        status = "show";
    }
    public nhanVien(String manv, String hoTen, String gioiTinh, String diaChi, String sdt, int luong, String status){
        super(hoTen,gioiTinh,diaChi,sdt,status);
        this.manv = manv;
        this.luong = luong;
        this.status = status;
    }



    public void nhap(){
        super.nhap();
        System.out.print("Nhap muc luong: ");
        luong = sc.nextInt(); sc.nextLine();
    }

    @Override public void xuat(){
        System.out.println("Ma nhan vien: " + manv);
        System.out.println("Ho ten nhan vien: " + hoTen);
        System.out.println("Gioi tinh: " + gioiTinh);
        System.out.println("Dia chi: " + diaChi);
        System.out.println("So dien thoai: " + sdt);
        System.out.println("Luong: " + luong);
    }



    public String getManv(){
        return manv;
    }
    public void setManv(String manv){
        this.manv = manv;
    }



    public int getLuong(){
        return luong;
    }
    public void setLuong(int luong){
        this.luong = luong;
    }
}