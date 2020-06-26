package example.codegym;

import example.codegym.model.HocVienCodeGym;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DisplayNameServlet", urlPatterns = "/displayName")
public class DisplayNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("tenHocVien");

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("Tên người dùng là:");
        out.println("<h1>" + name + " post </h1>");
        out.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("tenHocVien");

//        PrintWriter out = response.getWriter();
//        out.println("<html>");
//        out.println("Tên người dùng là:");
//        out.println("<h1>" + name + " get </h1>");
//        out.println("</html>");

        //tHANH tien
//        String resultName = "Thanh Tien";
//        request.setAttribute("tenChuanHoa", resultName);

        List<HocVienCodeGym> listOfHocVien = new ArrayList<>();
        listOfHocVien.add(new HocVienCodeGym("Tien", "1998"));
        listOfHocVien.add(new HocVienCodeGym("Toan", "2000"));
        listOfHocVien.add(new HocVienCodeGym("Hung", "1991"));

        request.setAttribute("danhSachHocVien", listOfHocVien);
        request.getRequestDispatcher("/result.jsp").forward(request, response);

    }
}
