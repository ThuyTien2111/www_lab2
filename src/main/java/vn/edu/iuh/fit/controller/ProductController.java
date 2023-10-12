package vn.edu.iuh.fit.controller;

import vn.edu.iuh.fit.frontEndModel.OrderModel;
import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.service.OrderService;
import vn.edu.iuh.fit.service.ProductService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet("/productsControll")
public class ProductController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
           Object actObject= req.getParameter("action");
           if(actObject!=null){
               String action=actObject.toString();
               if(action.equals("addOrder")){
                   OrderModel orderModel=new OrderModel();
                   orderModel.insertProductToOrder(req, resp);
                   orderModel.updateCart(req, resp);
               }
               else if(action.equals("caclPrice")){
                   OrderModel orderModel= new OrderModel();
                   orderModel.calcPriceOfCart(req, resp);
               }
           } else{
               resp.sendRedirect("index.jsp");
           }
       }catch (Exception e) {
           throw new RuntimeException(e);
       }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Object actObject = req.getParameter("action");
            if (actObject != null) {
                String action = actObject.toString();
                if(action.equals("addOrder")){
                    OrderModel orderModel=new OrderModel();
                    orderModel.insertProductToOrder(req, resp);
                    orderModel.updateCart(req, resp);
                }
                else if(action.equals("caclPrice")){
                    OrderModel orderModel= new OrderModel();
                    orderModel.calcPriceOfCart(req, resp);
                }
            } else {
                resp.sendRedirect("index.jsp");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
