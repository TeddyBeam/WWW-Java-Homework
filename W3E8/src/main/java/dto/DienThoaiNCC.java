package dto;

import java.util.List;

public class DienThoaiNCC {
	public String MaNCC;
	public String TenNCC;
	public List<DienThoai> dsDienThoai;

	public String getMaNCC() {
		return MaNCC;
	}

	public void setMaNCC(String maNCC) {
		MaNCC = maNCC;
	}

	public String getTenNCC() {
		return TenNCC;
	}

	public void setTenNCC(String tenNCC) {
		TenNCC = tenNCC;
	}

	public List<DienThoai> getDsDienThoai() {
		return dsDienThoai;
	}

	public void setDsDienThoai(List<DienThoai> dsDienThoai) {
		this.dsDienThoai = dsDienThoai;
	}

	public DienThoaiNCC(String maNCC, String tenNCC, List<DienThoai> dsDienThoai) {
		super();
		MaNCC = maNCC;
		TenNCC = tenNCC;
		this.dsDienThoai = dsDienThoai;
	}

	public DienThoaiNCC() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DienThoaiNCC [MaNCC=" + MaNCC + ", TenNCC=" + TenNCC + ", dsDienThoai=" + dsDienThoai + "]";
	}

}
