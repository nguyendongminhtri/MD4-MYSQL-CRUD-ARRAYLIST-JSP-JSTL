package rikkei.academy.controller;

import rikkei.academy.model.Customer;
import rikkei.academy.service.CustomerServiceIMPL;
import rikkei.academy.service.ICustomerService;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(value = "/customer")
public class CustomerController extends HttpServlet {
    private ICustomerService customerService = new CustomerServiceIMPL();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("---> CALL doGet");
        String action = request.getParameter("action");
        System.out.println("action ---> " + action);
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "detail":
                formDetailCustomer(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "delete":
                showFormDelete(request, response);
                break;
            default:
                getListCustomer(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----> Call doPost");
        String action = req.getParameter("action");
        System.out.println("action ---> " + action);
        switch (action) {
            case "create":
                actionCreate(req, resp);
                break;
            case "edit":
                actionEdit(req, resp);
                break;
            case "delete":
                actionDelete(req,resp);
                break;
        }
    }

    private void getListCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.findAll();
        request.setAttribute("listCustomers", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void actionCreate(HttpServletRequest request, HttpServletResponse response) {
        int id = customerService.findAll().get(customerService.findAll().size() - 1).getId() + 1;
        String name = request.getParameter("ten");
        System.out.println("id ===" + id);
        System.out.println("name ---> " + name);
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, name, email, address);
        customerService.save(customer);
        request.setAttribute("validate", "create success!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void formDetailCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("id --->" + id);
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/customer/detail.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/customer/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void actionEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher;
        Customer customer = customerService.findById(id);
        System.out.println("customer ===> " + customer);
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("WEB-INF/error/error.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        String name = request.getParameter("ten");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String validate = "";
        String success = "";
        if (name.equals(customer.getName()) && email.equals(customer.getEmail()) && address.equals(customer.getAddress())) {
            validate = "The customer is existed!";
        } else if (name.equals("")) {
            validate = "The name is required!";
        } else if (address.equals("")) {
            validate = "The address is required!";
        } else if (email.equals("")) {
            validate = "The email is required!";
        } else {
            success = "Edit success!";
            request.setAttribute("success", success);
            Customer customer1 = new Customer(id, name, email, address);
            customerService.save(customer1);
        }
        request.setAttribute("validate", validate);
        dispatcher = request.getRequestDispatcher("WEB-INF/customer/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //DELETE
    public void showFormDelete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher;
        Customer customer = customerService.findById(id);
        System.out.println("customer ===> " + customer);
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("WEB-INF/error/error.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        request.setAttribute("customer", customer);
        dispatcher = request.getRequestDispatcher("WEB-INF/customer/delete.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void actionDelete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("id =--->"+id);
        RequestDispatcher dispatcher;
        Customer customer = customerService.findById(id);
        System.out.println("customer ===> " + customer);
        customerService.deleteById(id);
        request.setAttribute("delete", "Delete success!");
         dispatcher = request.getRequestDispatcher("WEB-INF/customer/delete.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}