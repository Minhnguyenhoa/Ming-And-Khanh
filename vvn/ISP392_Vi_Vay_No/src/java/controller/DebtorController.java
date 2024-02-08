/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.AccountDAO;
import dao.DebtorDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Account;
import model.Debtor;

/**
 *
 * @author lvhn1
 */
@WebServlet(name="DebtorController", urlPatterns={"/debtor"})
public class DebtorController extends HttpServlet {
    
    private static final int pageSize = 5;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Add new debtor
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        double totalDebt = 0;
        int creditorId = Integer.parseInt(request.getParameter("creditorId"));

        Debtor debtor = new Debtor();
        debtor.setName(name);
        debtor.setAddress(address);
        debtor.setPhone(phone);
        debtor.setEmail(email);
        debtor.setTotalDebt(totalDebt);
        debtor.setCreditorAccountId(creditorId);

        new DebtorDAO().addDebtor(debtor);

        response.sendRedirect(request.getContextPath() + "/debtor");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Account account = (Account) request.getSession().getAttribute("USER");
        account = new Account();
        account.setId(2);
        
        if (account == null) {
            response.sendRedirect("login");
            return;
        }
        
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "edit":
                    // Retrieve debtor details for editing
                    int debtorId = Integer.parseInt(request.getParameter("id"));
                    Debtor debtor = new DebtorDAO().getDebtorById(debtorId);
                    request.setAttribute("debtor", debtor);
                    request.getRequestDispatcher("editDebtor.jsp").forward(request, response);
                    break;
                case "delete":
                    // Delete debtor
                    int idToDelete = Integer.parseInt(request.getParameter("id"));
                    new DebtorDAO().deleteDebtor(idToDelete);
                    response.sendRedirect("debtor");
                    break;
            }
        } else {
            
            String pageString = request.getParameter("page");
            int page = pageString == null ? 1 : Integer.parseInt(pageString);
            
            List<Debtor> debtorList = new DebtorDAO().getDebtorsByCreditorId(account.getId(), pageSize, page);
            
            if (debtorList.isEmpty() && page != 1) {
                response.sendRedirect("debtor");
                return;
            }
            
            // Fetch all debtors
            request.setAttribute("debtorList", debtorList);
            request.setAttribute("page", page);
            request.setAttribute("creditorId", account.getId());
            
            request.getRequestDispatcher("debtor-list.jsp").forward(request, response);
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Update debtor
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        double totalDebt = Double.parseDouble(request.getParameter("totalDebt"));

        Debtor debtor = new Debtor();
        debtor.setId(id);
        debtor.setName(name);
        debtor.setAddress(address);
        debtor.setPhone(phone);
        debtor.setEmail(email);
        debtor.setTotalDebt(totalDebt);

        new DebtorDAO().updateDebtor(debtor);

        response.sendRedirect(request.getContextPath() + "/debtor");
    }

}
