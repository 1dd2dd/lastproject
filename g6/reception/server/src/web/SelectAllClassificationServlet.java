package web;

import bean.Classification;
import com.google.gson.Gson;
import dao.ClassificationDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/SelectAllClassificationServlet")
public class SelectAllClassificationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ClassificationDao classificationDao = new ClassificationDao();
            List<Classification> classifications = classificationDao.selectallclassification();
            PrintWriter writer = response.getWriter();
            writer.println(new Gson().toJson(classifications));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
