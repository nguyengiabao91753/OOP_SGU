class khachHang extends nguoi {
    private String makh;


    
    public khachHang(){
        makh = "";
    }
    public khachHang(String makh, String hoTen, String gioiTinh, String diaChi, String sdt, String status){
        super(hoTen,gioiTinh,diaChi,sdt,status);
        this.makh = makh;
    }



    @Override public void xuat(){
        System.out.println("Ma khach hang: " + makh);
        System.out.println("Ho ten khach hang: " + hoTen);
        System.out.println("Gioi tinh: " + gioiTinh);
        System.out.println("Dia chi: " + diaChi);
        System.out.println("So dien thoai: " + sdt);
    }



    public String getMakh(){
        return makh;
    }
    public void setMakh(String makh){
        this.makh = makh;
    }
}