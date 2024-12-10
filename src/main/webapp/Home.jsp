<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f8f9fa;
    }
    .container {
        display: flex;
        flex-wrap: wrap;
        gap: 20px;
        justify-content: center;
        padding: 20px;
    }
    .card {
        border: 1px solid #ddd;
        border-radius: 8px;
        width: 300px;
        color: #333;
        overflow: hidden;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        transition: transform 0.2s, box-shadow 0.2s;
    }
    .card:nth-child(odd) {
        background-color: #e3f2fd; /* Light Blue */
    }
    .card:nth-child(even) {
        background-color: #fce4ec; /* Light Pink */
    }
    .card:hover {
        transform: translateY(-5px);
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
    }
    .card-header {
        font-size: 1.2rem;
        font-weight: bold;
        padding: 10px;
        text-align: center;
        color: #fff;
    }
    .card:nth-child(odd) .card-header {
        background-color: #1565c0; /* Dark Blue */
    }
    .card:nth-child(even) .card-header {
        background-color: #ad1457; /* Dark Pink */
    }
    .card-body {
        padding: 15px;
        font-size: 0.9rem;
    }
    .card-body p {
        margin: 8px 0;
    }
    .card-body strong {
        color: #555;
    }
</style>
</head>
<body>
    <h1 style="text-align:center;">Welcome <%=((User)session.getAttribute("user")).getUserName() %></h1>
    <div class="container">
        <%
        List<Product> products=(ArrayList<Product>)session.getAttribute("productList");
        for(Product product:products){
        %>
        <div class="card">
            <div class="card-header">
                <%= product.getPname() %>
            </div>
            <div class="card-body">
                <p><strong>Price:</strong> $<%=product.getPrice() %></p>
                <p><strong>Rating:</strong> <%=product.getRatings() %> / 5</p>
                <p><strong>Description:</strong> <%=product.getDescription() %></p>
            </div>
        </div>
        <%
        }
        %>
    </div>
</body>
</html>
