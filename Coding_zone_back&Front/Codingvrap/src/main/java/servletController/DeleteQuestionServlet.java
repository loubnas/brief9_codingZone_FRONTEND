package servletController;

import dao.DAO;
import factory.DaoFactory;
import models.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteQuestionServlet", value = "/DeleteQuestionServlet")
public class DeleteQuestionServlet extends HttpServlet {
    private DAO<Question> daoQuestion= DaoFactory.getQuestionImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.print("actionactionactionactionactionactionactionactionactionactionaction");
            String action=  request.getParameter( "action");
        int idQuestion= Integer.parseInt( request.getParameter( "id"));

        if (action.equals("delete")){
            int flag = daoQuestion.delete(idQuestion);
            response.sendRedirect("FindQuestionServlet");
      }
        else if (action.equals("edite")) {

            Question question = daoQuestion.find(idQuestion);
            request.setAttribute("question",question);

            request.getRequestDispatcher("/stuff/editeQuestion.jsp").forward(request,response);

        }





    }


}
