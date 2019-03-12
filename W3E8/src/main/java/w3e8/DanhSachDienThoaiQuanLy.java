package w3e8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.DienThoai;
import dto.NhaCungCap;

public class DanhSachDienThoaiQuanLy {
	public Connection con = null;

	public void ConnectToDB() {
		String user = "sa";
		String password = "lydongcanh";
		String url = "jdbc:sqlserver://localhost:1433;databasename=W3E8Database";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<DienThoai> laySPTheoMa(String maNCC) {
		String sql = "select * from DIENTHOAI where MANCC='" + maNCC + "'";
		List<DienThoai> ds = new ArrayList<DienThoai>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String maDT = rs.getString(1);
				String tenDT = rs.getString(2);
				String cauHinh = rs.getString(4);
				String namsx = rs.getString(3);

				ds.add(new DienThoai(maDT, tenDT, namsx, cauHinh, maNCC));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	public List<NhaCungCap> layMaNCC() {
		String sql = "select MANCC,TENNHACC FROM NHACUNGCAP";
		List<NhaCungCap> ds = new ArrayList<NhaCungCap>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String maNCC = rs.getString(1);
				String tenNCC = rs.getString(2);
				String diaChi = rs.getString(3);
				String Sodienthoai = rs.getString(4);
				ds.add(new NhaCungCap(maNCC, tenNCC, diaChi, Sodienthoai));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	public void themDienThoai(DienThoai dt) {
		String sql = "insert into DIENTHOAI values(?,?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, dt.getMadt());
			st.setString(2, dt.getTendt());
			st.setString(3, dt.getNamsanxuat());
			st.setString(4, dt.getCauhinh());
			st.setString(5, dt.getMancc());
			st.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void xoaDienThoai(String madt) {
		try {
			String sql = "delete from DIENTHOAI where MADT=?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, madt);
			pre.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
