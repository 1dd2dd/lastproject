package mv.webyonhu.Yonhugeren;

import mv.daoyonhu.YonhuGerenDao;
import mv.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/kanbjt")
public class YonkanBjt extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        int id2 = Integer.parseInt(id);
        try {
            YonhuGerenDao yonhuGerenDao = new YonhuGerenDao();
            String bjtp = yonhuGerenDao.getmybjtp(id2);

            PrintWriter writer = resp.getWriter();
            writer.print(ResultVO.ok(bjtp).toJSON());
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("-1");
        }


    }


}
