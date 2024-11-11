package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.NhaCungCap;


public class DAO_NhaCungCap  {
	public DAO_NhaCungCap() {

	}
	//	
	public ArrayList<NhaCungCap> getAllNCC(){
		ArrayList<NhaCungCap> dsNCC = new ArrayList<NhaCungCap>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from NhaCungCap";
			Statement sta = con.createStatement();

			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				String maNCC = rs.getString("MANCC");
				String tenNCC = rs.getString("TENNCC");
				String soDienThoai = rs.getString("SDT");
				String diaChi = rs.getString("DIACHI");
				String email = rs.getString("EMAIL");

				NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, soDienThoai, diaChi, email);
				dsNCC.add(ncc);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsNCC;
	}

	public NhaCungCap getNhaCungCap(String maNcc){
		NhaCungCap ncc = null;;
		PreparedStatement sta = null;
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "select * from NhaCungCap where MANCC = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, maNcc);
			ResultSet rs = sta.executeQuery();
			while(rs.next()){
				String maNCC = rs.getString("MANCC");
				String tenNCC = rs.getString("TENNCC");
				String soDienThoai = rs.getString("SDT");
				String diaChi = rs.getString("DIACHI");
				String email = rs.getString("EMAIL");

				ncc = new NhaCungCap(maNCC, tenNCC, soDienThoai, diaChi, email);

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return ncc;
	}
	//themNCC

	public boolean themNCC(NhaCungCap ncc) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "insert into NhaCungCap values (?,?,?,?,?) ";
			sta = con.prepareStatement(sql);

			sta.setString(1, ncc.getMaNCC());
			sta.setString(2, ncc.getTenNCC());
			sta.setString(3, ncc.getSoDienThoai());
			sta.setString(4, ncc.getDiaChi());
			sta.setString(5, ncc.getEmail());
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

	public boolean suaNCC(NhaCungCap ncc) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "update NhaCungCap set TENNCC = ?,SDT= ?, DIACHI = ?, EMAIL = ? where MANCC = ? ";
			sta = con.prepareStatement(sql);


			sta.setString(1, ncc.getTenNCC());
			sta.setString(2, ncc.getSoDienThoai());
			sta.setString(3, ncc.getDiaChi());
			sta.setString(4, ncc.getEmail());
			sta.setString(5, ncc.getMaNCC());
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

	public boolean xoa(String maNCC) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "delete from NhaCungCap where MANCC = ?";
			sta = con.prepareStatement(sql);

			sta.setString(1, maNCC);
			n = sta.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public NhaCungCap getNhaCungCapByName(String name){


		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NhaCungCap where TENNCC = ?";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				NhaCungCap e_NhaCungCap = new NhaCungCap();
				e_NhaCungCap.setMaNCC(rs.getString(1));
				e_NhaCungCap.setTenNCC(rs.getString(2));
				e_NhaCungCap.setSoDienThoai(rs.getString(3));
				e_NhaCungCap.setDiaChi(rs.getString(4));
				e_NhaCungCap.setEmail(rs.getString(5));

				return e_NhaCungCap;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public ArrayList<NhaCungCap> getNhaCungCapTheoTen(String name) {
		ArrayList<NhaCungCap> listNCC = new ArrayList<>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "SELECT * FROM NhaCungCap WHERE TENNCC LIKE ?";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setString(1, "%" + name + "%");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				NhaCungCap e_NhaCungCap = new NhaCungCap();
				e_NhaCungCap.setMaNCC(rs.getString(1));
				e_NhaCungCap.setTenNCC(rs.getString(2));
				e_NhaCungCap.setSoDienThoai(rs.getString(3));
				e_NhaCungCap.setDiaChi(rs.getString(4));
				e_NhaCungCap.setEmail(rs.getString(5));

				listNCC.add(e_NhaCungCap);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return listNCC;
	}

	public ArrayList<NhaCungCap> timTheoTieuChi(String ma, String sdt) {
		ArrayList<NhaCungCap> dsNcc = new ArrayList<>();
		PreparedStatement sta = null;

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			StringBuilder sql = new StringBuilder("SELECT * FROM NhaCungCap WHERE 1=1");

			if (!ma.isEmpty()) {
				sql.append(" AND MANCC = ?");
			}    

			if (!sdt.isEmpty()) {
				sql.append(" AND SDT = ?");
			} 	

			sta = con.prepareStatement(sql.toString());

			int parameterIndex = 1;
			if (!ma.isEmpty()) {
				sta.setString(parameterIndex++, ma);
			}

			if (!sdt.isEmpty()) {
				sta.setString(parameterIndex++, sdt);
			}

			ResultSet rs = sta.executeQuery();

			while (rs.next()) {
				String maNCC = rs.getString("MANCC");
				String tenNCC = rs.getString("TENNCC");
				String sDT = rs.getString("SDT");
				String diaChi = rs.getString("DIACHI");
				String email = rs.getString("EMAIL");

				NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC,sDT, diaChi, email);
				dsNcc.add(ncc);
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
		return dsNcc;
	}

}
