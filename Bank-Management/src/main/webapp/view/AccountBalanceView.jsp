<%@page import="in.co.online.bank.mgt.dto.UserDTO"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@page isELIgnored="false"%>
<div class="container">    
    <div id="signupbox" style=" margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Account Balance</div>
            </div>  
            <div class="panel-body" >
            <sf:form action="" method="post" modelAttribute="form">
                        <div  class="form-group required">
                            <div class="controls col-md-8 ">
                               <p>Your Account Balance is ${form.amount}/-</p>
                            </div>
                        </div>
                        </sf:form>
  
            </div>
        </div>
    </div> 
</div>
