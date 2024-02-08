/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DebtDetailsDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.DebtDetail;

/**
 *
 * @author lvhn1
 */
@WebServlet(name = "DebtDetailsController", urlPatterns = {"/debt-details"})
public class DebtDetailsController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        action = action==null ? "list" : action;
        
        int debtorId = Integer.parseInt(request.getParameter("id"));
        

        switch (action) {
            case "delete":

                int debtDetailsId = Integer.parseInt(request.getParameter("debtDetailsId"));
                
                boolean success = new DebtDetailsDAO().deleteDebtDetail(debtDetailsId);
                if (success) {
                    response.sendRedirect("debt-details?id=" + debtorId + "&success");
                } else {
                    response.sendRedirect("debt-details?id=" + debtorId + "&fail");
                }

                break;
            case "list":
                List<DebtDetail> debtDetails = new DebtDetailsDAO().getDebtDetailsByDebtorId(debtorId);

                request.setAttribute("debtDetails", debtDetails);
                request.setAttribute("debtorId", debtorId);

                request.getRequestDispatcher("debt-details-list.jsp").forward(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Add debt details
        String description = request.getParameter("description");
        boolean debtType = Boolean.parseBoolean(request.getParameter("debtType"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        String image = request.getParameter("image");
        int debtorId = Integer.parseInt(request.getParameter("debtorId"));
        int interestRateId = Integer.parseInt(request.getParameter("interestRateId")); // Assuming you have interest rate

        DebtDetail debtDetail = new DebtDetail();
        debtDetail.setDescription(description);
        debtDetail.setDeptType(debtType);
        debtDetail.setAmount(amount);
        debtDetail.setImage(image);
        debtDetail.setDebtor_IdDebtor(debtorId);
        debtDetail.setInterest_rate_id(interestRateId);

        boolean success = new DebtDetailsDAO().addDebtDetail(debtDetail);

        if (success) {
            response.sendRedirect("debt-details?id=" + debtorId + "&success"); // Redirect to success page
        } else {
            response.sendRedirect("debt-details?id=" + debtorId + "&fail"); // Redirect to error page
        }
    }

}
