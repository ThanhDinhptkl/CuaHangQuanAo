package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import connectDB.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public class DAO_HoaDon {
	  private DAO_NhanVien dao_nhanVien = new DAO_NhanVien();
	    private DAO_KhachHang dao_khachHang = new DAO_KhachHang();
		public DAO_HoaDon() {
			super();
			// TODO Auto-generated constructor stub
		}
		 public ArrayList<HoaDon> getAllHoaDon() {
		        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
		        try {
		        	Connection con = ConnectDB.getInstance().getConnection();		            
		            String sql = "Select * from HoaDon where MAHD not like 'HDC%'";
		            Statement stmt = con.createStatement();
		            ResultSet rs = stmt.executeQuery(sql);
		            while (rs.next()) {
		                String maHoaDon = rs.getString(1);
		               KhachHang e_KhachHang = dao_khachHang.getTheoMaKH(rs.getString(2));
		                NhanVien e_NhanVien = dao_nhanVien.getTheoMaNV(rs.getString(3));
		                Date ngayLap = rs.getDate(4);		                 
		                HoaDon e_HoaDon = new HoaDon(maHoaDon, e_KhachHang, e_NhanVien, ngayLap);
		                listHoaDon.add(e_HoaDon);
		            }
		        } catch (SQLException ex) {
		        	ex.printStackTrace();
		        }
		        return listHoaDon;
		    }
		 public ArrayList<HoaDon> getAllHoaDon(String tenKhachHang, String tenNhanVien) {
		        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
		        try {
		        	Connection con = ConnectDB.getInstance().getConnection();		            
		            
		            String sql = "SELECT         HoaDon.*\n"
		                    + "FROM            HoaDon INNER JOIN\n"
		                    + "                         KhachHang ON HoaDon.MAKH = KhachHang.MAKH INNER JOIN\n"
		                    + "                         NhanVien ON HoaDon.MANV = NhanVien.MANV\n"
		                    + "where NhanVien.TENNV like ? and KhachHang.TENKH like ? and MAHD not like 'HDC%'";
		            PreparedStatement stmt = con.prepareCall(sql);
		            stmt.setString(1, "%" + tenNhanVien + "%");
		            stmt.setString(2, "%" + tenKhachHang + "%");

		            ResultSet rs = stmt.executeQuery();
		            while (rs.next()) {
		                String maHoaDon = rs.getString(1);
		                Date ngayLap = rs.getDate(4);
		                NhanVien e_NhanVien = dao_nhanVien.getTheoMaNV(rs.getString(3));
		                KhachHang e_KhachHang = dao_khachHang.getTheoMaKH(rs.getString(2));
		                HoaDon e_HoaDon = new HoaDon(maHoaDon, e_KhachHang, e_NhanVien, ngayLap);
		                listHoaDon.add(e_HoaDon);
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		        return listHoaDon;
		    }
		 public ArrayList<HoaDon> getAllHoaDon(String tenKhachHang, String tenNhanVien, String tuNgay, String denNgay) {
		        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
		       try {
		    	   Connection con = ConnectDB.getInstance().getConnection();		            
		            
		            String sql = "SELECT         HoaDon.*\n"
		                    + "FROM            HoaDon INNER JOIN\n"
		                    + "                         KhachHang ON HoaDon.MAKH = khachHang.MAKH INNER JOIN\n"
		                    + "                         NhanVien ON HoaDon.MANV = NhanVien.MANV\n"
		                    + "where NhanVien.TENNV like ? and KhachHang.TENKH like ? and MAHD not like 'HDC%' and NGAYLAPHD >= ? and NGAYLAPHD <= ?";
		            PreparedStatement stmt = con.prepareCall(sql);
		            stmt.setString(1, "%" + tenNhanVien + "%");
		            stmt.setString(2, "%" + tenKhachHang + "%");
		            stmt.setString(3, tuNgay);
		            stmt.setString(4, denNgay);

		            ResultSet rs = stmt.executeQuery();
		            while (rs.next()) {
		                String maHoaDon = rs.getString(1);
		                Date ngayLap = rs.getDate(4);
		                NhanVien e_NhanVien = dao_nhanVien.getTheoMaNV(rs.getString(3));
		                KhachHang e_KhachHang = dao_khachHang.getTheoMaKH(rs.getString(2));
		                HoaDon e_HoaDon = new HoaDon(maHoaDon, e_KhachHang, e_NhanVien, ngayLap);
		                listHoaDon.add(e_HoaDon);
		            }
		        } catch (SQLException ex) {
		           ex.printStackTrace();
		        }
		        return listHoaDon;
		    }
		 public ArrayList<HoaDon> getAllHoaDon(String maId) {
		        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
		         try {
		        	 Connection con = ConnectDB.getInstance().getConnection();		            
			           
		            String sql = "Select * from HoaDon where MAHD like ?";
		            PreparedStatement stmt = con.prepareCall(sql);
		            stmt.setString(1, "%" + maId + "%");
		            ResultSet rs = stmt.executeQuery();
		            while (rs.next()) {
		                String maHoaDon = rs.getString(1);
		                Date ngayLap = rs.getDate(4);
		                NhanVien e_NhanVien = dao_nhanVien.getTheoMaNV(rs.getString(3));
		                KhachHang e_KhachHang = dao_khachHang.getTheoMaKH(rs.getString(2));
		                HoaDon e_HoaDon = new HoaDon(maHoaDon, e_KhachHang, e_NhanVien, ngayLap);
		                listHoaDon.add(e_HoaDon);
		            }
		        } catch (SQLException ex) {
		        	ex.printStackTrace();
		        }
		        return listHoaDon;
		    }
		 public ArrayList<HoaDon> getAllHoaDonCho() {
		        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
		        try {
		        	Connection con = ConnectDB.getInstance().getConnection();		            			         
		            String sql = "Select * from HoaDon where MAHD like 'HDC%'";
		            Statement stmt = con.createStatement();
		            ResultSet rs = stmt.executeQuery(sql);
		            while (rs.next()) {
		                String maHoaDon = rs.getString(1);
		                Date ngayLap = rs.getDate(4);
		                NhanVien e_NhanVien = dao_nhanVien.getTheoMaNV(rs.getString(3));
		                KhachHang e_KhachHang = dao_khachHang.getTheoMaKH(rs.getString(2));
		                HoaDon e_HoaDon = new HoaDon(maHoaDon, e_KhachHang, e_NhanVien, ngayLap);
		                listHoaDon.add(e_HoaDon);
		            }
		        } catch (SQLException ex) {
		        	ex.printStackTrace();
		        }
		        return listHoaDon;
		    }
		 public ArrayList<HoaDon> getHoaDonChoBySDT(String sdt) {
		        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
		        try {
		        	Connection con = ConnectDB.getInstance().getConnection();		            			         
			           
		        	String sql = "SELECT        HoaDon.*\n"
		                    + "FROM            HoaDon INNER JOIN\n"
		                    + "                         KhachHang ON HoaDon.MAKH = KhachHang.MAKH\n"
		                    + "where KhachHang.SDT like ? and MAHD like 'HDC%'";

		            PreparedStatement stmt = con.prepareCall(sql);
		            stmt.setString(1, "%" + sdt + "%");
		            ResultSet rs = stmt.executeQuery();
		            while (rs.next()) {
		                String maHoaDon = rs.getString(1);
		                Date ngayLap = rs.getDate(4);
		                NhanVien e_NhanVien = dao_nhanVien.getTheoMaNV(rs.getString(3));
		                KhachHang e_KhachHang = dao_khachHang.getTheoMaKH(rs.getString(2));
		                HoaDon e_HoaDon = new HoaDon(maHoaDon, e_KhachHang, e_NhanVien, ngayLap);
		                listHoaDon.add(e_HoaDon);
		            }
		        } catch (Exception e) {
		        }
		        return listHoaDon;
		    }
		  public ArrayList<HoaDon> getHoaDonByDate(Date ngayBatDau, Date ngayKetThuc) {
		        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
		        
		        try {
		        	Connection con = ConnectDB.getInstance().getConnection();		            			         
				       
		            String sql = "Select * from HoaDon where NGAYLAPHD between ? and ?";
		            PreparedStatement stmt = con.prepareStatement(sql);

		            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		            String dateBatDau = sdf.format(ngayBatDau);
		            String dateNgayKetThuc = sdf.format(ngayKetThuc);

		            stmt.setString(1, dateBatDau);
		            stmt.setString(2, dateNgayKetThuc);

		            ResultSet rs = stmt.executeQuery();

		            while (rs.next()) {
		                String maHoaDon = rs.getString(1);
		                Date ngayLap = rs.getDate(4);
		                NhanVien e_NhanVien = dao_nhanVien.getTheoMaNV(rs.getString(3));
		                KhachHang e_KhachHang = dao_khachHang.getTheoMaKH(rs.getString(2));
		                HoaDon e_HoaDon = new HoaDon(maHoaDon, e_KhachHang, e_NhanVien, ngayLap);
		                System.out.println(e_HoaDon);
		                listHoaDon.add(e_HoaDon);
		            }
		        } catch (SQLException ex) {
		        	ex.printStackTrace();
		        }
		        return listHoaDon;
		    }
		  

		    public HoaDon getHoaDonById(String id) {
		        
		        try {
		        	Connection con = ConnectDB.getInstance().getConnection();		            			         			    
		            String sql = "select * from HoaDon where MAHD = ?";
		            PreparedStatement stmt = con.prepareCall(sql);
		            stmt.setString(1, id);
		            ResultSet rs = stmt.executeQuery();
		            while (rs.next()) {
		                HoaDon e_HoaDon = new HoaDon();
		                e_HoaDon.setMaHD (rs.getString(1));
		                e_HoaDon.setNgayLapHD(rs.getDate(4));

		                NhanVien e_NhanVien = dao_nhanVien.getTheoMaNV(rs.getString(3));
		                e_HoaDon.setNhanVien(e_NhanVien);

		                KhachHang e_KhachHang = dao_khachHang.getTheoMaKH(rs.getString(2));
		                e_HoaDon.setKhachHang(e_KhachHang);

		                return e_HoaDon;
		            }
		        } catch (SQLException ex) {
		        ex.printStackTrace();    
		        }
		        return null;
		    }

		    public ArrayList<HoaDon> getHoaDonByMaNV(String id) {
		        ArrayList<HoaDon> listHoaDon = new ArrayList<HoaDon>();
		        try {
		        	Connection con = ConnectDB.getInstance().getConnection();		            			         			    
		            
		            String sql = "select * from HoaDon where MANV = ?";
		            PreparedStatement stmt = con.prepareCall(sql);
		            stmt.setString(1, id);
		            ResultSet rs = stmt.executeQuery();
		            while (rs.next()) {
		                HoaDon e_HoaDon = new HoaDon();
		                e_HoaDon.setMaHD(rs.getString(1));
		                e_HoaDon.setNgayLapHD(rs.getDate(4));

		                NhanVien e_NhanVien = dao_nhanVien.getTheoMaNV(rs.getString(3));
		                e_HoaDon.setNhanVien(e_NhanVien);

		                KhachHang e_KhachHang = dao_khachHang.getTheoMaKH(rs.getString(2));
		                e_HoaDon.setKhachHang(e_KhachHang);

		                listHoaDon.add(e_HoaDon);
		            }
		        } catch (SQLException ex) {
		        	ex.printStackTrace();
		        }
		        return listHoaDon;
		    }

		    public ArrayList<HoaDon> getHoaDonByMaKH(String id) {
		        ArrayList<HoaDon> listHoaDon = new ArrayList<HoaDon>();
		        try {
		        	Connection con = ConnectDB.getInstance().getConnection();		            			         			    
		            
		            String sql = "select * from HoaDon where MAKH = ?";
		            PreparedStatement stmt = con.prepareCall(sql);
		            stmt.setString(1, id);
		            ResultSet rs = stmt.executeQuery();
		            while (rs.next()) {
		                HoaDon e_HoaDon = new HoaDon();
		                e_HoaDon.setMaHD(rs.getString(1));
		                e_HoaDon.setNgayLapHD(rs.getDate(4));

		                NhanVien e_NhanVien = dao_nhanVien.getTheoMaNV(rs.getString(3));
		                e_HoaDon.setNhanVien(e_NhanVien);

		                KhachHang e_KhachHang = dao_khachHang.getTheoMaKH(rs.getString(2));
		                e_HoaDon.setKhachHang(e_KhachHang);

		                listHoaDon.add(e_HoaDon);
		            }
		        } catch (SQLException ex) {
		        	ex.printStackTrace();
		        }
		        return listHoaDon;
		    }

		    public int deleteHoaDon(HoaDon e_HoaDon) {
		        try {
		        	Connection con = ConnectDB.getInstance().getConnection();		            			         			    
		            
		            String sql = "delete from HoaDon where MAHD = ?";
		            PreparedStatement stmt = con.prepareCall(sql);
		            stmt.setString(1, e_HoaDon.getMaHD());
		            return stmt.executeUpdate();
		        } catch (SQLException ex) {
		        	ex.printStackTrace();
		        }
		        return -1;
		    }

		    public int addHoaDon(HoaDon e_HoaDon) {
		        try {
		        	Connection con = ConnectDB.getInstance().getConnection();		            			         			    
		            
		            String sql = "insert into HoaDon(MAHD, MAKH, MANV, NGAYLAPHD) values (?, ?, ?, ?)";
		            PreparedStatement stmt = con.prepareCall(sql);
		            stmt.setString(1, e_HoaDon.getMaHD());
		            stmt.setString(2, e_HoaDon.getKhachHang().getMaKH());
		            stmt.setString(3, e_HoaDon.getNhanVien().getMaNV());
		            stmt.setDate(4, e_HoaDon.getNgayLapHD());         
		            return stmt.executeUpdate();
		        } catch (SQLException ex) {
		        	ex.printStackTrace();
		        }
		        return -1;
		    }

		    public double tongTienHoaDon(String maHoaDon) {
		        double tongTien = 0;
		        
		        try {
		        	Connection con = ConnectDB.getInstance().getConnection();		            			         			    
		            
		            String sql = "SELECT        sum(ChiTietHoaDon.DONGIA*ChiTietHoaDon.SOLUONG) as tongTien\n"
		                    + "FROM            ChiTietHoaDon INNER JOIN\n"
		                    + "                         HoaDon ON ChiTietHoaDon.MAHD = HoaDon.MAHD\n"
		                    + "where			HoaDon.MAHD = ?";
		            
//		        	String sql = "SELECT SUM(SOLUONG * DONGIA) AS TongTien\r\n"
//		        			+ "FROM ChiTietHoaDon\r\n"
//		        			+ "WHERE MAHD = ?";
		            PreparedStatement stmt = con.prepareCall(sql);
		            stmt.setString(1, maHoaDon);
		            ResultSet rs = stmt.executeQuery();
		            while (rs.next()) {
		                tongTien = rs.getDouble(1);
		                return tongTien;
		            }
		        } catch (SQLException e) {
		        	e.printStackTrace();
		        }
		        return -1;
		    }

		    public double tongTienSanPhamThuocHoaDon(String maHoaDon, String maQA) {
		        double tongTien = 0;
		        try {
		        	Connection con = ConnectDB.getInstance().getConnection();		            			         			    
		            
		            String sql = "SELECT        ChiTietHoaDon.DONGIA\n"
		                    + "FROM            ChiTietHoaDon INNER JOIN\n"
		                    + "                         HoaDon ON ChiTietHoaDon.MAHD = HoaDon.MAHD\n"
		                    + "where			HoaDon.MAHD = ? and ChiTietHoaDon.MAQUANAO = ?";
		            PreparedStatement stmt = con.prepareCall(sql);
		            stmt.setString(1, maHoaDon);
		            stmt.setString(2, maQA);
		            ResultSet rs = stmt.executeQuery();
		            while (rs.next()) {
		                tongTien = rs.getDouble(1);
		                return tongTien;
		            }
		        } catch (SQLException e) {
		        	e.printStackTrace();
		        }
		        return -1;
		    }

		    public ArrayList<Integer> getListYear() {
		        ArrayList<Integer> listYear = new ArrayList<>();
		        
		        try {
		        	Connection con = ConnectDB.getInstance().getConnection();		            			         			    
			           
		            String sql = "select Year(HoaDon.NGAYLAPHD) as YearNumber from HoaDon \n"
		                    + "group by Year(HoaDon.NGAYLAPHD)";
		            Statement stmt = con.createStatement();
		            ResultSet rs = stmt.executeQuery(sql);
		            while (rs.next()) {
		                listYear.add(rs.getInt(1));
		            }
		        } catch (SQLException ex) {
		        ex.printStackTrace(); 
		        }

		        return listYear;

		    }

		    public String getLatestHoaDon() {

		        String latestID = new String();
		       
		        try {
		        	Connection con = ConnectDB.getInstance().getConnection();		            			         			    
				       
		            String sql = "SELECT top 1 MAHD \n"
		                    + "from HoaDon\n"
		                    + "where HoaDon.NGAYLAPHD = (select top 1 HoaDon.NGAYLAPHD\n"
		                    + "					from HoaDon\n"
		                    + "					order by HoaDon.NGAYLAPHD desc)\n"
		                    + "order by MAHD desc";
		            Statement stmt = con.createStatement();
		            ResultSet rs = stmt.executeQuery(sql);
		            rs.next();
		            latestID = rs.getNString(1);
		        } catch (SQLException ex) {
		        	ex.printStackTrace();
		        }

		        return latestID;
		    }


}
