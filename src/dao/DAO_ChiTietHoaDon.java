package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.QuanAo;


public class DAO_ChiTietHoaDon {
	private DAO_QuanAo dao_QuanAo = new DAO_QuanAo();
	private DAO_HoaDon dao_HoaDon = new DAO_HoaDon();
	private DAO_NhanVien dao_NhanVien = new DAO_NhanVien();
	private DAO_KhachHang dao_KhachHang = new DAO_KhachHang();
	public DAO_ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArrayList<ChiTietHoaDon> getAllCTHDByHoaDon(HoaDon e_HoaDon){
        ArrayList<ChiTietHoaDon>listChiTietHoaDon = new ArrayList<>();
        try {
        	Connection con = ConnectDB.getInstance().getConnection();		            
            
            String sql = "Select * from ChiTietHoaDon where MAHD = ?";
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setString(1, e_HoaDon.getMaHD());
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                QuanAo e_QuanAo = dao_QuanAo.TimKiemQuanAoTheoMa(rs.getString(2));
                
                int soLuong = rs.getInt(3);
                double thanhTien = rs.getDouble(4);
                
                ChiTietHoaDon CTHD = new ChiTietHoaDon(e_HoaDon, e_QuanAo, soLuong, thanhTien);
                listChiTietHoaDon.add(CTHD);
            }
        } catch (SQLException ex) {
        	ex.printStackTrace();
        	}
        return listChiTietHoaDon;
    }

    public int deleteCTHD(HoaDon hd){
        
        
        try {
        	Connection con = ConnectDB.getInstance().getConnection();		            
            
            String sql = "Delete from ChiTietHoaDon where MAHD = ?";
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setString(1, hd.getMaHD());
            
            return stmt.executeUpdate();
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
        return -1;
    }
    public ArrayList<ChiTietHoaDon> getCTHDById(String id){
     
       ArrayList<ChiTietHoaDon> listCTHD = new ArrayList<ChiTietHoaDon>();

        try {
        	Connection con = ConnectDB.getInstance().getConnection();		            
            
            String sql = "select * from ChiTietHoaDon where MAHD = ?";
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            HoaDon e_HoaDon = dao_HoaDon.getHoaDonById(id);
            while(rs.next()){
               QuanAo e_QuanAo = dao_QuanAo.TimKiemQuanAoTheoMa(rs.getString(2));
               int soLuong = rs.getInt(3);
               double thanhTien = rs.getDouble(4);
               ChiTietHoaDon e_ChiTietHoaDon = new ChiTietHoaDon(e_HoaDon, e_QuanAo, soLuong, thanhTien);     
               listCTHD.add(e_ChiTietHoaDon);
            }
            return listCTHD;
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
        return null;
    }


    public int addChiTietHoaDon(ChiTietHoaDon e_ChiTietHoaDon){
        
        try {
        	Connection con = ConnectDB.getInstance().getConnection();		            
            
            String sql = "insert into ChiTietHoaDon values (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setString(1, e_ChiTietHoaDon.getHoaDon().getMaHD());
            stmt.setString(2, e_ChiTietHoaDon.getQuanAo().getMaQuanAo());
            stmt.setInt(3, e_ChiTietHoaDon.getSoLuong());
            stmt.setDouble(4, e_ChiTietHoaDon.getDonGia());

            return stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            }
        return -1;
    }
    
    public ArrayList<QuanAo>thongKeDanhSachQuanAoVoiSoLuongBanDuoc(){
        ArrayList<QuanAo> listQuanAo = new ArrayList<>();
        
        try {
        	Connection con = ConnectDB.getInstance().getConnection();		            
            
            String sql = "SELECT        QuanAo.MAQUANAO,  sum(ChiTietHoaDon.SOLUONG) as SoLuongBan, sum(ChiTietHoaDon.DONGIA) as doanhThu\n" +
"                        FROM            QuanAo INNER JOIN ChiTietHoaDon ON QuanAo.MAQUANAO = ChiTietHoaDon.MAQUANAO\n" +
"                         group by  QuanAo.maSP";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                QuanAo qa = dao_QuanAo.TimKiemQuanAoTheoMa(rs.getString(1));
                qa.setSoLuong(rs.getInt(2));
                qa.setDonGiaBan(rs.getDouble(3));
                listQuanAo.add(qa);
            }
        } catch (SQLException ex) {
         ex.printStackTrace();
         }
        return listQuanAo;
    }
    
    public ArrayList<QuanAo>thongKeDanhSachQuanAoVoiSoLuongBanDuoc(String mauSac, String phanLoai, String kichThuoc){
        ArrayList<QuanAo> listQuanAo = new ArrayList<>();
        
        try {
        	Connection con = ConnectDB.getInstance().getConnection();		            
            
            String sql = "SELECT        QuanAo.MAQUANAO,  sum(ChiTietHoaDon.SOLUONG) as SoLuongBan, sum(ChiTietHoaDon.DONGIA) as doanhThu "
                    + "FROM            ChiTietHoaDon INNER JOIN QuanAo ON ChiTietHoaDon.MAQUANAO = QuanAo.MAQUANAO INNER JOIN KichCo ON QuanAo.MAKICHCO = KichCo.MAKICHCO INNER JOIN MauSac ON QuanAo.MAMAUSAC = MauSac.MAMAUSAC INNER JOIN LOAIQUANAO ON QuanAo.MALOAI = LoaiQuanAo.MALOAI "
                    + "where		KichCo.KICHCO like ? and MauSac.MAUSAC like ? and LoaiQuanAo.LOAI like ? "
                    + "group by  QuanAo.MAQUANAO";
            
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setString(1, "%"+kichThuoc+"%");
            stmt.setString(2, "%"+mauSac+"%");
            stmt.setString(3, "%"+phanLoai+"%");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                QuanAo qa = dao_QuanAo.TimKiemQuanAoTheoMa(rs.getString(1));
                qa.setSoLuong(rs.getInt(2));
                qa.setDonGiaBan(rs.getDouble(3));
                listQuanAo.add(qa);
            }
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
        return listQuanAo;
    }
    
    
    public ArrayList<QuanAo>thongKeDanhSachQuanAoVoiSoLuongBanDuoc(String mauSac, String phanLoai, String kichThuoc, String tuNgay, String denNgay){
        ArrayList<QuanAo> listQuanAo = new ArrayList<>();
       
        try {
        	Connection con = ConnectDB.getInstance().getConnection();		            
            
            String sql = "SELECT	QuanAo.MAQUANAO,  sum(ChiTietHoaDon.SOLUONG) as SoLuongBan, sum(ChiTietHoaDon.DONGIA) as doanhThu \n" +
"                            FROM            ChiTietHoaDon INNER JOIN\n" +
"                                                     HoaDon ON ChiTietHoaDon.MAHD = HoaDon.MAHD INNER JOIN\n" +
"                                                     QuanAo ON ChiTietHoaDon.MAQUANAO = QuanAo.MAQUANAO INNER JOIN\n" +
"                                                     KichCo ON QuanAo.MAKICHCO = KichCo.MAKICHCO INNER JOIN\n" +
"                                                     MauSac ON QuanAo.MAMAUSAC = MauSac.MAMAUSAC INNER JOIN\n" +
"                                                     LoaiQuanAo ON QuanAo.MALOAI = LoaiQuanAo.MALOAI\n" +
"                            where			KichCo.KICHCO like ? and MauSac.MAUSAC like ? \n" +
"                          and LoaiQuanAo.LOAI like ? and HoaDon.NGAYLAPHD >= ? and HoaDon.NGAYLAPHD <= ? \n" +
"                          group by QuanAo.MAQUANAO";
            
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setString(1, "%"+kichThuoc+"%");
            stmt.setString(2, "%"+mauSac+"%");
            stmt.setString(3, "%"+phanLoai+"%");
            stmt.setString(4, tuNgay);
            stmt.setString(5, denNgay);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
            	QuanAo qa = dao_QuanAo.TimKiemQuanAoTheoMa(rs.getString(1));
                qa.setSoLuong(rs.getInt(2));
                qa.setDonGiaBan(rs.getDouble(3));
                listQuanAo.add(qa);
            }
        } catch (SQLException ex) {
         }
        return listQuanAo;
    }
    
    
    public ArrayList<HoaDon>danhSachHoaDonTheoQuanAo(String maSP, String tuNgay, String denNgay){
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        
        try {
        	Connection con = ConnectDB.getInstance().getConnection();		            
            
            String sql = "SELECT			HoaDon.MAHD, HoaDon.MAKH, HoaDon.MANV, HoaDon.NGAYLAPHD\n" +
"                            FROM            ChiTietHoaDon INNER JOIN\n" +
"                                                    HoaDon ON ChiTietHoaDon.MAHD = HoaDon.MAHD INNER JOIN\n" +
"                                                    QuanAo ON ChiTietHoaDon.MAQUANAO = QuanAo.MAQUANAO INNER JOIN\n" +
"                                                    KichCo ON QuanAo.MAKICHCO = KichCo.MAKICHCO INNER JOIN\n" +
"                                                     MauSac ON QuanAo.MAMAUSAC = MauSac.MAMAUSAC INNER JOIN\n" +
"                                                     LoaiQuanAo ON QuanAo.MALOAI = LoaiQuanAo.MALOAI\n" +
"     where                      HoaDon.NGAYLAPHD >= ? and HoaDon.NGAYLAPHD <= ? and QuanAo.MAQUANAO = ?";
            
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setString(1, tuNgay);
            stmt.setString(2, denNgay);
            stmt.setString(3, maSP);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString(1));
                KhachHang kh = dao_KhachHang.getTheoMaKH(rs.getString(2));
                hd.setKhachHang(kh);
                NhanVien nv = dao_NhanVien.getTheoMaNV(rs.getString(3));
                hd.setNhanVien(nv);
                hd.setNgayLapHD(rs.getDate(4));
                listHoaDon.add(hd);
            }
        } catch (SQLException ex) {
        	ex.printStackTrace(); 
        }
        return listHoaDon;
    }
    
     public ArrayList<HoaDon>danhSachHoaDonTheoQuanAo(String maSP){
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        
        try {
        	Connection con = ConnectDB.getInstance().getConnection();		            
            
            String sql = "SELECT			HoaDon.MAHD, HoaDon.MAKH, HoaDon.MANV, HoaDon.NGAYLAPHD\n" +
"                            FROM            ChiTietHoaDon INNER JOIN\n" +
"                                                    HoaDon ON ChiTietHoaDon.MAHD = HoaDon.MAHD INNER JOIN\n" +
"                                                    QuanAo ON ChiTietHoaDon.MAQUANAO = QuanAo.MAQUANAO INNER JOIN\n" +
"                                                    KichCo ON QuanAo.MAKICHCO = KichCo.MAKICHCO INNER JOIN\n" +
"                                                     MauSac ON QuanAo.MAMAUSAC = MauSac.MAMAUSAC INNER JOIN\n" +
"                                                     LoaiQuanAo ON QuanAo.MALOAI = LoaiQuanAo.MALOAI\n" +
"     where                       QuanAo.maSP = ?";
            
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setString(1, maSP);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString(1));
                KhachHang kh = dao_KhachHang.getTheoMaKH(rs.getString(2));
                hd.setKhachHang(kh);
                NhanVien nv = dao_NhanVien.getTheoMaNV(rs.getString(3));
                hd.setNhanVien(nv);
                hd.setNgayLapHD(rs.getDate(4));
                listHoaDon.add(hd);
            }
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
        return listHoaDon;
    }
     
    public double getTongDoanhThu() throws SQLException{
    	ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();		            
      
        String sql = "SELECT        sum(DONGIA)\n" +
                     "FROM            ChiTietHoaDon";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                return rs.getDouble(1);
            }
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
        return 0;
    }
    
    public double tongTienHoaDon(String maHD) throws SQLException{
    	Connection con = ConnectDB.getInstance().getConnection();		            
        
        String sql  = "select ChiTietHoaDon.MAHD,  tongTien = sum(ChiTietHoaDon.DONGIA) \n" +
                        "from ChiTietHoaDon \n" +
                        "where MAHD = ?\n" +
                        "group by ChiTietHoaDon.MAHD";
        
        try {
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setString(1, maHD);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                return rs.getDouble(2);
            }
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
        return -1;
    }
    
    public ArrayList<Object[]> joinWithHD() {
        ArrayList<Object[]> resultList = new ArrayList<>();
        try {
            Connection con = ConnectDB.getInstance().getConnection();
            String sql = "SELECT c.MAHD, kh.TENKH, nv.TENNV, h.NGAYLAPHD, qa.TENQUANAO, c.SOLUONG, c.DONGIA, l.LOAI, ms.MAUSAC, th.THUONGHIEU, kc.KICHCO, " +
                    "SUM(c.SOLUONG * c.DONGIA) AS TONGTIEN " +
                    "FROM ChiTietHoaDon c " +
                    "JOIN HoaDon h ON c.MAHD = h.MAHD " +
                    "JOIN KhachHang kh ON h.MAKH = kh.MAKH " +
                    "JOIN NhanVien nv ON h.MANV = nv.MANV " +
                    "JOIN QuanAo qa ON c.MAQUANAO = qa.MAQUANAO " +
                    "JOIN LoaiQuanAo l ON qa.MALOAI = l.MALOAI " +
                    "JOIN MauSac ms ON qa.MAMAUSAC = ms.MAMAUSAC " +
                    "JOIN KichCo kc ON qa.MAKICHCO = kc.MAKICHCO " +
                    "JOIN ThuongHieu th ON qa.MATHUONGHIEU = th.MATHUONGHIEU " +
                    "GROUP BY c.MAHD, kh.TENKH, nv.TENNV, h.NGAYLAPHD, qa.TENQUANAO, c.SOLUONG, c.DONGIA, l.LOAI, ms.MAUSAC, th.THUONGHIEU, kc.KICHCO";

            Statement sta = con.createStatement();
            ResultSet rs = sta.executeQuery(sql);

            while (rs.next()) {
                Object obj[] = new Object[15];
                obj[0] = rs.getString(1);
                obj[1] = rs.getString(2);
                obj[2] = rs.getString(3);
                obj[3] = rs.getDate(4);
                obj[4] = rs.getString(5);
                obj[5] = rs.getInt(6);
                obj[6] = rs.getDouble(7);
                obj[7] = rs.getString(8);
                obj[8] = rs.getString(9);
                obj[9] = rs.getString(10);
                obj[10] = rs.getString(11);
                obj[11] = rs.getDouble(12);
                resultList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }
    public ArrayList<Object[]> ThongKeDoanhThu() {
        ArrayList<Object[]> resultList = new ArrayList<>();
        try {
            Connection con = ConnectDB.getInstance().getConnection();
            String sql = "SELECT c.MAHD, nv.TENNV, kh.TENKH, h.NGAYLAPHD,\r\n"
            		+ "       SUM(c.SOLUONG * c.DONGIA) AS TONGTIEN " +
                    "FROM ChiTietHoaDon c\r\n"
                    + "JOIN HoaDon h ON c.MAHD = h.MAHD\r\n"
                    + "JOIN KhachHang kh ON h.MAKH = kh.MAKH\r\n"
                    + "JOIN NhanVien nv ON h.MANV = nv.MANV\r\n"
                    + "GROUP BY c.MAHD, nv.TENNV, kh.TENKH, h.NGAYLAPHD ";
    

            Statement sta = con.createStatement();
            ResultSet rs = sta.executeQuery(sql);

            while (rs.next()) {
            	Object[] obj = new Object[6];  // Update size to 6
                obj[0] = rs.getString(1);
                obj[1] = rs.getString(2);
                obj[2] = rs.getString(3);
                obj[3] = rs.getDate(4);
                obj[4] = rs.getDouble(5);  // Update column index to 5
                resultList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}

