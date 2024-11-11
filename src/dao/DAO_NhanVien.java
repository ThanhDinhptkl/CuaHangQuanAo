package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhanVien;


public class DAO_NhanVien  {
	public DAO_NhanVien() {

	}

	public ArrayList<NhanVien> getAllNhanVien(){
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from NhanVien";
			Statement sta = con.createStatement();

			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				String maNV = rs.getString("MANV");
				String tenNV = rs.getString("TENNV");
				Date ngaySinh = rs.getDate("NGAYSINH");
				boolean gioiTinh = rs.getBoolean("GIOITINH");
				String sDT = rs.getString("SDT");
				String diaChi = rs.getString("DIACHI");
				String email = rs.getString("EMAIL");

				NhanVien nv = new NhanVien(maNV, tenNV, ngaySinh, gioiTinh, sDT, diaChi, email);
				dsNV.add(nv);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsNV;
	}
	//tim kiem theo maNV

	public NhanVien getTheoMaNV(String maNv) {
		NhanVien nv = null;
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NhanVien where MANV = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, maNv);
			ResultSet rs = sta.executeQuery();
			while(rs.next()) {
				String maNV = rs.getString("MANV");
				String tenNV = rs.getString("TENNV");
				Date ngaySinh = rs.getDate("NGAYSINH");
				boolean gioiTinh = rs.getBoolean("GIOITINH");
				String sDT = rs.getString("SDT");
				String diaChi = rs.getString("DIACHI");
				String email = rs.getString("EMAIL");

				nv = new NhanVien(maNV, tenNV, ngaySinh, gioiTinh, sDT, diaChi, email);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return nv;
	}
	//tim kiem theo tenNV

	public NhanVien getTheoTenNV(String tenNv) {
		NhanVien nv = null;
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NhanVien where TENNV = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, tenNv);
			ResultSet rs = sta.executeQuery();
			while(rs.next()) {
				String maNV = rs.getString("MANV");
				String tenNV = rs.getString("TENNV");
				Date ngaySinh = rs.getDate("NGAYSINH");
				boolean gioiTinh = rs.getBoolean("GIOITINH");
				String sDT = rs.getString("SDT");
				String diaChi = rs.getString("DIACHI");
				String email = rs.getString("EMAIL");

				nv = new NhanVien(maNV, tenNV, ngaySinh, gioiTinh, sDT, diaChi, email);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return nv;
	}
	//tim kiem theo sDT
	public NhanVien getTheoSDT(String sdt) {
		NhanVien nv = null;
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NhanVien where SDT = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, sdt);
			ResultSet rs = sta.executeQuery();
			while(rs.next()) {
				String maNV = rs.getString("MANV");
				String tenNV = rs.getString("TENNV");
				Date ngaySinh = rs.getDate("NGAYSINH");
				boolean gioiTinh = rs.getBoolean("GIOITINH");
				String sDT = rs.getString("SDT");
				String diaChi = rs.getString("DIACHI");
				String email = rs.getString("EMAIL");

				nv = new NhanVien(maNV, tenNV, ngaySinh, gioiTinh, sDT, diaChi, email);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return nv;
	}
	// Trong DAO
	public ArrayList<NhanVien> timTheoTieuChi(String ma, String ten, String sdt) {
		ArrayList<NhanVien> dsNV = new ArrayList<>();
		PreparedStatement sta = null;

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM NhanVien WHERE 1=1");

			if (!ma.isEmpty()) {
				sqlBuilder.append(" AND MANV = ?");
			}

			if (!ten.isEmpty()) {
				sqlBuilder.append(" AND TENNV = ?");
			}

			if (!sdt.isEmpty()) {
				sqlBuilder.append(" AND SDT = ?");
			}

			sta = con.prepareStatement(sqlBuilder.toString());

			int parameterIndex = 1;
			if (!ma.isEmpty()) {
				sta.setString(parameterIndex++, ma);
			}

			if (!ten.isEmpty()) {
				sta.setString(parameterIndex++, ten);
			}

			if (!sdt.isEmpty()) {
				sta.setString(parameterIndex++, sdt);
			}

			ResultSet rs = sta.executeQuery();

			while (rs.next()) {
				String maNV = rs.getString("MANV");
				String tenNV = rs.getString("TENNV");
				Date ngaySinh = rs.getDate("NGAYSINH");
				boolean gioiTinh = rs.getBoolean("GIOITINH");
				String sDT = rs.getString("SDT");
				String diaChi = rs.getString("DIACHI");
				String email = rs.getString("EMAIL");

				NhanVien nv = new NhanVien(maNV, tenNV, ngaySinh, gioiTinh, sDT, diaChi, email);
				dsNV.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sta != null) {
					sta.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dsNV;
	}

	//themNV

	public boolean themNV(NhanVien nv) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "insert into NhanVien values (?,?,?,?,?,?,?) ";
			sta = con.prepareStatement(sql);

			sta.setString(1, nv.getMaNV());
			sta.setString(2, nv.getTenNV());
			Date ngaySinhSql = new Date(nv.getNgaySinh().getTime());
			sta.setDate(3, ngaySinhSql);
			//			sta.setDate(3, (Date) nv.getNgaySinh());
			sta.setBoolean(4, nv.isGioiTinh());
			sta.setString(5, nv.getsDT());
			sta.setString(6, nv.getDiaChi());
			sta.setString(7, nv.getEmail());
			n = sta.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	//suaNV

	public boolean suaNV(NhanVien nv) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "update NhanVien set TENNV = ?,NGAYSINH= ?, GIOITINH = ?, SDT =?, DIACHI = ?, EMAIL = ? where MANV = ? ";
			sta = con.prepareStatement(sql);


			sta.setString(1, nv.getTenNV());
			java.util.Date utilDate = nv.getNgaySinh();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			sta.setDate(2, sqlDate);
			//			sta.setDate(2, (Date) nv.getNgaySinh());
			sta.setBoolean(3, nv.isGioiTinh());
			sta.setString(4, nv.getsDT());
			sta.setString(5, nv.getDiaChi());
			sta.setString(6, nv.getEmail());
			sta.setString(7, nv.getMaNV());
			n = sta.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	//xoaNV

	public boolean xoa(String maNv) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "delete from NhanVien where MANV = ?";
			sta = con.prepareStatement(sql);

			sta.setString(1, maNv);
			n = sta.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}

}
