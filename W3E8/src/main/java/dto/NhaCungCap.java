package dto;

public class NhaCungCap {
	public String Mancc;
	public String Tennhacc;
	public String Diachi;
	public String Sodienthoai;

	public String getMancc() {
		return Mancc;
	}

	public void setMancc(String mancc) {
		Mancc = mancc;
	}

	public String getTennhacc() {
		return Tennhacc;
	}

	public void setTennhacc(String tennhacc) {
		Tennhacc = tennhacc;
	}

	public String getDiachi() {
		return Diachi;
	}

	public void setDiachi(String diachi) {
		Diachi = diachi;
	}

	public String getSodienthoai() {
		return Sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		Sodienthoai = sodienthoai;
	}

	public NhaCungCap(String mancc, String tennhacc, String diachi, String sodienthoai) {
		super();
		Mancc = mancc;
		Tennhacc = tennhacc;
		Diachi = diachi;
		Sodienthoai = sodienthoai;
	}

	public NhaCungCap() {
		super();
		// TODO Auto-generated constructor stub
	}
}
