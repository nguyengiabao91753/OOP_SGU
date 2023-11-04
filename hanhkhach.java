class hanhkhach extends nguoi {
    private String maHK;
    Scanner sc = new Scanner(System.in);


    
    public hanhkhach(){
        maHK = "";
        hoten = "";
        gioitinh = "";
        diachi = "";
        sdt = "";
    }
    public hanhkhach(String maHK, String hoten, String gioitinh, String diachi, String sdt){
        super(hoten,gioitinh,diachi,sdt);
        this.maHK = maHK;
    }



    public void nhap(){
        System.out.println("Nhap ma hanh khach: ");
        maHK = sc.nextLine();
        super.nhap();
    }
    @Override public void xuat(){
        System.out.println("hanh khach {" + maHK + ", " + hoten + ", " + gioitinh + ", " + diachi + ", " + sdt +"}");
    }



    public String getmaHK(){
        return maHK;
    }
    public void setmaHK(String maHK){
        this.maHK = maHK;
    }



    public String gethoten(){
        return hoten;
    }
    public void sethoten(String hoten){
        this.hoten = hoten;
    }



    public String getgioitinh(){
        return gioitinh;
    }
    public void setgioitinh(String gioitinh){
        this.gioitinh = gioitinh;
    }



    public String getdiachi(){
        return diachi;
    }
    public void setdiachi(String diachi){
        this.diachi = diachi;
    }



    public String getsdt(){
        return sdt;
    }
    public void setsdt(String sdt){
        this.sdt=sdt;
    }
}
