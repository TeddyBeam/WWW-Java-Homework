package dto;

public class DienThoai {
	public String Madt;
	public String Tendt;
	public String Namsanxuat;
	public String Cauhinh;
	public String Mancc;

	public String getMadt() {
		return Madt;
	}

	public void setMadt(String madt) {
		Madt = madt;
	}

	public String getTendt() {
		return Tendt;
	}

	public void setTendt(String tendt) {
		Tendt = tendt;
	}

	public String getNamsanxuat() {
		return Namsanxuat;
	}

	public void setNamsanxuat(String namsanxuat) {
		Namsanxuat = namsanxuat;
	}

	public String getCauhinh() {
		return Cauhinh;
	}

	public void setCauhinh(String cauhinh) {
		Cauhinh = cauhinh;
	}

	public String getMancc() {
		return Mancc;
	}

	public void setMancc(String mancc) {
		Mancc = mancc;
	}

	public DienThoai(String madt, String tendt, String namsanxuat, String cauhinh, String mancc) {
		super();
		Madt = madt;
		Tendt = tendt;
		Namsanxuat = namsanxuat;
		Cauhinh = cauhinh;
		Mancc = mancc;
	}

	public DienThoai() {
		super();
		// TODO Auto-generated constructor stub
	}
}
