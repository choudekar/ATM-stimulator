<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page isELIgnored="false"%>
<%@page import="in.co.online.bank.mgt.dto.UserDTO"%>
<%
    UserDTO userBean = (UserDTO) session.getAttribute("user");

    boolean userLoggedIn = userBean != null;

    String welcomeMsg = "Hi, ";

    if (userLoggedIn) {
        String role = (String) session.getAttribute("role");
        welcomeMsg += userBean.getFirstName() + " (" + role + ")";
    } else {
        welcomeMsg += "Guest";
    }

%>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="<c:url value="/welcome"/>">Online Bank Management</a>
    </div>
    <ul class="nav navbar-nav">
      <li ><a href="<c:url value="/welcome"/>">Home</a></li>
      <%if(userLoggedIn){%>
      
      <%if(userBean.getRoleId()==1){%>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Administration<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/Bank-Management/ctl/user">Add User</a></li>
          <li><a href="/Bank-Management/ctl/bank">Add Bank</a></li>
          <li><a href="/Bank-Management/ctl/bookTransaction">Add Book Transaction</a></li>
        </ul>
       </li>
         <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Report<span class="caret"></span></a>
        <ul class="dropdown-menu">
        <li><a href="/Bank-Management/ctl/user/search">User Report</a></li>
          <li><a href="/Bank-Management/ctl/fundTransfer/search">Fund Transfer Report</a></li>
          <li><a href="/Bank-Management/ctl/bank/search">Bank Report</a></li>
          <li><a href="/Bank-Management/ctl/bookTransaction/search">All Transaction Report</a></li>
        </ul>
      </li>
    
     
    </ul>
    <%}else if(userBean.getRoleId()==2){%>
    <li><a href="/Bank-Management/ctl/accountBalance">Account Balance</a></li>
    <li><a href="/Bank-Management/ctl/fundTransfer">Fund Transfer</a></li>
     <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Report<span class="caret"></span></a>
        <ul class="dropdown-menu">
          
          <li><a href="/Bank-Management/ctl/fundTransfer/search">Fund Transfer Report</a></li>
          <li><a href="/Bank-Management/ctl/bookTransaction/search">Book Transaction Report</a></li>
        </ul>
      </li>
   </ul>
    <%} %>
    <ul class="nav navbar-nav navbar-right">
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><%=welcomeMsg%><span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/Bank-Management/ctl/profile">My Profile</a></li>
          <li><a href="/Bank-Management/ctl/changepassword">Change Password</a></li>
          <li><a href="<c:url value="/login"/>">LogOut</a></li>
        </ul>
      </li>
      
   
    <%}else{%>
     
      <li><a href="<c:url value="/login"/>">Sign In</a></li>
       <li><a href="<c:url value="/signUp"/>">Sign Up</a></li>
      <li><a href="#"><%=welcomeMsg%></a></li>
      </ul>
    
    <%} %>
    
     
    
  </div>
</nav>