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
import entity.ChatLieu;
import entity.KhuyenMai;
import entity.KichCo;

import entity.LoaiQuanAo;
import entity.MauSac;
import entity.NhaCungCap;
import entity.QuanAo;

import entity.ThuongHieu;



public class DAO_QuanAo  {

	public DAO_QuanAo() {
		super();
	}

	public ArrayList<QuanAo> getAllQuanAo() {

		DAO_MauSac dao_mauSac = new DAO_MauSac();
		DAO_ThuongHieu dao_thuongHieu = new DAO_ThuongHieu();
		DAO_ChatLieu dao_chatLieu = new DAO_ChatLieu();
		DAO_KichCo dao_kichCo = new DAO_KichCo();
		DAO_LoaiQuanAo dao_loaiQuanAo = new DAO_LoaiQuanAo();
		DAO_NhaCungCap dao_nhaCungCap = new DAO_NhaCungCap();
		DAO_KhuyenMai dao_khuyenMai = new DAO_KhuyenMai();

		ArrayList<QuanAo> dsQuanAo = new ArrayList<QuanAo>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from QuanAo";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				String maQuanAo = rs.getString("MAQUANAO");
				String tenQuanAo = rs.getString("TENQUANAO");
				String hinhAnh = rs.getString("HINHANH");
				String maMauSac = rs.getString("MAMAUSAC");
				MauSac e_MauSac = dao_mauSac.getMauSac(maMauSac);
				int soLuong = rs.getInt("SOLUONG");
				String maThuongHieu = rs.getString("MATHUONGHIEU");
				ThuongHieu e_ThuongHieu = dao_thuongHieu.getThuongHieu(maThuongHieu);    
				String maChatLieu = rs.getString("MACHATLIEU");
				ChatLieu e_ChatLieu = dao_chatLieu.getChatLieu(maChatLieu);
				String maKichCo = rs.getString("MAKICHCO");
				KichCo e_KichCo = dao_kichCo.getKichCo(maKichCo);
				String maLoaiQuanAo = rs.getString("MALOAI");
				LoaiQuanAo e_LoaiQuanAo= dao_loaiQuanAo.getLoai(maLoaiQuanAo);
				String maNhaCungCap = rs.getString("MANCC");
				NhaCungCap e_NhaCungCap = dao_nhaCungCap.getNhaCungCap(maNhaCungCap);
				Double donGiaBan = rs.getDouble("DONGIABAN");
				String maKhuyenMai = rs.getString("MAKM");
				KhuyenMai e_KhuyenMai = dao_khuyenMai.getKhuyenMai(maKhuyenMai);
				QuanAo e_QuanAo = new QuanAo(maQuanAo, tenQuanAo, hinhAnh, e_MauSac, soLuong, e_ThuongHieu, e_ChatLieu, e_KichCo, e_LoaiQuanAo, e_NhaCungCap, donGiaBan, e_KhuyenMai);
				dsQuanAo.add(e_QuanAo);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return dsQuanAo;
	}

	public ArrayList<QuanAo> getAllQuanAo(String maQuanAo, String tenQuanAo, String loaiQuanAo, String mauSac, String kichCo) {
		DAO_MauSac dao_mauSac = new DAO_MauSac();
		DAO_ThuongHieu dao_thuongHieu = new DAO_ThuongHieu();
		DAO_ChatLieu dao_chatLieu = new DAO_ChatLieu();
		DAO_KichCo dao_kichCo = new DAO_KichCo();
		DAO_LoaiQuanAo dao_loaiQuanAo = new DAO_LoaiQuanAo();
		DAO_NhaCungCap dao_nhaCungCap = new DAO_NhaCungCap();
		DAO_KhuyenMai dao_khuyenMai = new DAO_KhuyenMai();
		ArrayList<QuanAo> dsQuanAo = new ArrayList<QuanAo>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql= "SELECT       QuanAo.*\n" +
					"FROM            KichCo INNER JOIN\n" +
					"                         QuanAo ON KichCo.maKichCo = QuanAo.maKichCo INNER JOIN\n" +
					"                         MauSac ON QuanAo.maMauSac = MauSac.maMauSac INNER JOIN\n" +
					"                         LoaiQuanAo ON QuanAo.maLoai = LoaiQuanAo.maLoai\n" +
					"where		QuanAo.MAQUANAO like ? and KichCo.KICHCO like ? and LoaiQuanAo.LOAI like ? and MauSac.MAUSAC like ? and QuanAo.TENQUANAO like ?";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%"+maQuanAo+"%");
			stmt.setString(2,  "%"+kichCo +"%");
			stmt.setString(3, "%" +loaiQuanAo+ "%");
			stmt.setString(4,  "%"+mauSac +"%");
			stmt.setString(5, "%" + tenQuanAo +"%");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maQA = rs.getString("MAQUANAO");
				String tenQA = rs.getString("TENQUANAO");
				String hinhAnh = rs.getString("HINHANH");

				String maMauSac = rs.getString("MAMAUSAC");
				MauSac mauSAc = dao_mauSac.getMauSac(maMauSac);

				int soLuong = rs.getInt("SOLUONG");

				String maThuongHieu = rs.getString("MATHUONGHIEU");
				ThuongHieu e_ThuongHieu = dao_thuongHieu.getThuongHieu(maThuongHieu);

				String maChatLieu = rs.getString("MACHATLIEU");
				ChatLieu e_ChatLieu = dao_chatLieu.getChatLieu(maChatLieu);

				String maKichCo = rs.getString("MAKICHCO");
				KichCo kichCO = dao_kichCo.getKichCo(maKichCo);

				String maLoaiQuanAo = rs.getString("MALOAI");
				LoaiQuanAo loaiQA = dao_loaiQuanAo.getLoai(maLoaiQuanAo);

				String maNhaCungCap = rs.getString("MANCC");
				NhaCungCap e_NhaCungCap = dao_nhaCungCap.getNhaCungCap(maNhaCungCap);

				Double donGiaBan = rs.getDouble("DONGIABAN");

				String maKhuyenMai = rs.getString("MAKM");
				KhuyenMai e_KhuyenMai = dao_khuyenMai.getKhuyenMai(maKhuyenMai);

				QuanAo e_QuanAo = new QuanAo(maQA, tenQA, hinhAnh, mauSAc, soLuong, e_ThuongHieu, e_ChatLieu, kichCO, loaiQA, e_NhaCungCap, donGiaBan, e_KhuyenMai); 
				dsQuanAo.add(e_QuanAo);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return dsQuanAo;
	}

	public QuanAo TimKiemQuanAoTheoMa(String ma) {
		QuanAo e_QuanAo = null;
		PreparedStatement ps = null;
		DAO_MauSac dao_mauSac = new DAO_MauSac();
		DAO_ThuongHieu dao_thuongHieu = new DAO_ThuongHieu();
		DAO_ChatLieu dao_chatLieu = new DAO_ChatLieu();
		DAO_KichCo dao_kichCo = new DAO_KichCo();
		DAO_LoaiQuanAo dao_loaiQuanAo = new DAO_LoaiQuanAo();
		DAO_NhaCungCap dao_nhaCungCap = new DAO_NhaCungCap();
		DAO_KhuyenMai dao_khuyenMai = new DAO_KhuyenMai();

		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from QuanAo where MAQUANAO = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maQA = rs.getString("MAQUANAO");
				String tenQA = rs.getString("TENQUANAO");
				String hinhAnh = rs.getString("HINHANH");

				String maMauSac = rs.getString("MAMAUSAC");
				MauSac mauSAc = dao_mauSac.getMauSac(maMauSac);

				int soLuong = rs.getInt("SOLUONG");

				String maThuongHieu = rs.getString("MATHUONGHIEU");
				ThuongHieu e_ThuongHieu = dao_thuongHieu.getThuongHieu(maThuongHieu);

				String maChatLieu = rs.getString("MACHATLIEU");
				ChatLieu e_ChatLieu = dao_chatLieu.getChatLieu(maChatLieu);

				String maKichCo = rs.getString("MAKICHCO");
				KichCo kichCO = dao_kichCo.getKichCo(maKichCo);

				String maLoaiQuanAo = rs.getString("MALOAI");
				LoaiQuanAo loaiQA = dao_loaiQuanAo.getLoai(maLoaiQuanAo);

				String maNhaCungCap = rs.getString("MANCC");
				NhaCungCap e_NhaCungCap = dao_nhaCungCap.getNhaCungCap(maNhaCungCap);

				Double donGiaBan = rs.getDouble("DONGIABAN");

				String maKhuyenMai = rs.getString("MAKM");
				KhuyenMai e_KhuyenMai = dao_khuyenMai.getKhuyenMai(maKhuyenMai);

				e_QuanAo = new QuanAo(maQA, tenQA, hinhAnh, mauSAc, soLuong, e_ThuongHieu, e_ChatLieu, kichCO, loaiQA, e_NhaCungCap, donGiaBan, e_KhuyenMai);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return e_QuanAo;
	}

	public boolean themQuanAo(QuanAo e_QuanAo) {
		PreparedStatement ps = null;
		int n = 0;
		try {
			Connection con = ConnectDB.getInstance().getConnection();	     
			String sql = "Insert into QuanAo values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, e_QuanAo.getMaQuanAo());
			ps.setString(2, e_QuanAo.getTenQuanAo());
			ps.setString(3, e_QuanAo.getHinhAnh());
			ps.setString(4, e_QuanAo.getMauSac().getMaMauSac());      
			ps.setInt(5, e_QuanAo.getSoLuong());
			ps.setString(6, e_QuanAo.getThuongHieu().getMaThuongHieu());
			ps.setString(7, e_QuanAo.getChatLieu().getMaChatLieu());
			ps.setString(8, e_QuanAo.getKichCo().getMaKichCo());
			ps.setString(9, e_QuanAo.getLoaiQuanAo().getMaLoai());
			ps.setString(10, e_QuanAo.getNhaCungCap().getMaNCC());
			ps.setDouble(11, e_QuanAo.getDonGiaBan());
			ps.setString(12, e_QuanAo.getKhuyenMai().getMaKM());

			n= ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n >0;
	}

	public boolean suaQuanAo(QuanAo e_QuanAo) {
		PreparedStatement ps = null;
		int n = 0;
		try {
			Connection con = ConnectDB.getInstance().getConnection();	     
			String sql = "update QuanAo set TENQUANAO= ?, HINHANH= ?, MAMAUSAC= ?, SOLUONG= ?, MATHUONGHIEU= ?, MACHATLIEU= ?, MAKICHCO= ?, MALOAI= ?, MANCC= ?, DONGIABAN= ?, MAKM= ? where MAQUANAO = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, e_QuanAo.getTenQuanAo());
			ps.setString(2, e_QuanAo.getHinhAnh());
			ps.setString(3, e_QuanAo.getMauSac().getMaMauSac());      
			ps.setInt(4, e_QuanAo.getSoLuong());
			ps.setString(5, e_QuanAo.getThuongHieu().getMaThuongHieu());
			ps.setString(6, e_QuanAo.getChatLieu().getMaChatLieu());
			ps.setString(7, e_QuanAo.getKichCo().getMaKichCo());
			ps.setString(8, e_QuanAo.getLoaiQuanAo().getMaLoai());
			ps.setString(9, e_QuanAo.getNhaCungCap().getMaNCC());
			ps.setDouble(10, e_QuanAo.getDonGiaBan());
			ps.setString(11, e_QuanAo.getKhuyenMai().getMaKM()==null?null:e_QuanAo.getKhuyenMai().getMaKM() );
			ps.setString(12, e_QuanAo.getMaQuanAo());

			n= ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	public int capNhatSoLuong(QuanAo e_QuanAo){
		try {
			Connection con = ConnectDB.getInstance().getConnection();	     
			String sql  ="update QuanAo set SOLUONG = ? where MAQUANAO = ?";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setInt(1, e_QuanAo.getSoLuong());
			stmt.setString(2, e_QuanAo.getMaQuanAo());
			return stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return -1;
	}
}
