package w3e8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.DienThoai;
import dto.NhaCungCap;
import dto.DienThoaiNCC;

/**
 * Servlet implementation class DanhSachDienthoaiServlet
 */
@WebServlet("/DanhSachDienThoaiServlet")
public class DanhSachDienthoaiServlet extends HttpServlet {
	DanhSachDienThoaiQuanLy ql = new DanhSachDienThoaiQuanLy();

	public DanhSachDienthoaiServlet() {
		super();
// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		if (action != null) {
			if (action.equalsIgnoreCase("Them")) {
				System.out.println(ql.layMaNCC());
				request.setAttribute("dsNCC", ql.layMaNCC());
				getServletContext().getRequestDispatcher("/DienThoaiForm.jsp").forward(request, response);
				return;
			} else if (action.equalsIgnoreCase("Luu")) {
				String maDT = request.getParameter("maDT");
				String tenDT = request.getParameter("tenDT");
				String cauHinh = request.getParameter("cauHinh");
				String maNCC = request.getParameter("maNCC");
				String namSX = request.getParameter("namSX");
				DienThoai dt = new DienThoai(maDT, tenDT, namSX, cauHinh, maNCC);
				System.out.println(dt);
				themMoi(dt);
				request.setAttribute("dt", dt);
				getServletContext().getRequestDispatcher("/KetQua.jsp").forward(request, response);
				return;
			}
		}
		List<DienThoaiNCC> ds = layThongTin();
		request.setAttribute("ds", ds);
		getServletContext().getRequestDispatcher("/DanhSachDienThoaiNCC.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// TODO Auto-generated method stub
		doGet(request, response);
	}

	public List<DienThoai> laySPTheoMa(String maNCC) {
		List<DienThoai> ds = ql.laySPTheoMa(maNCC);
		return ds;
	}

	public List<DienThoaiNCC> layThongTin() {
		List<DienThoaiNCC> ds = new ArrayList<DienThoaiNCC>();
		List<NhaCungCap> dsNCC = ql.layMaNCC();
		for (NhaCungCap nhaCungCap : dsNCC) {
			String maNCC = nhaCungCap.getMancc();
			String tenNCC = nhaCungCap.getMancc();
			List<DienThoai> dsDienThoai = laySPTheoMa(maNCC);
			ds.add(new DienThoaiNCC(maNCC, tenNCC, dsDienThoai));
		}
		return ds;
	}

	public void themMoi(DienThoai dt) {
		ql.themDienThoai(dt);
	}

	public void xoaSP() {
	}
}