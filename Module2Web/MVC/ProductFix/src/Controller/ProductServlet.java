package Controller;

import Model.Product;
import Services.ProductService;
import Services.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet",urlPatterns = "")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
//
                String name = request.getParameter("name");
                String information = request.getParameter("information");
                double price = Double.parseDouble(request.getParameter("price"));
                String producer = request.getParameter("producer");
                int id = (int) (Math.random() * 10000);
                Product product = new Product(id,name,information,price,producer);
                this.productService.save(product);
                RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
                request.setAttribute("message", "New customer was created");
                try {
                    dispatcher.forward(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
            case "edit":
               updateProduct (request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                break;
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
    }

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "create":
                    showCreateForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    showDeleteForm(request, response);
                    break;
                case "view":
                    viewProduct(request, response);
                    break;
                default:
                    listProduct(request, response);
                    break;
            }
        }




    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = this.productService.findAll();
        request.setAttribute("productList", productList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }


    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if(product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("Product/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if(product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("abc", product);
            dispatcher = request.getRequestDispatcher("Product/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product customer = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if(customer == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("Product/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Product/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {  int id = Integer.parseInt(request.getParameter("id"));
        Product customer = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if(customer == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.productService.remove(id);
            try {
                response.sendRedirect("/");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


