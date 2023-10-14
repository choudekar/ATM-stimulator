<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@page isELIgnored="false"%>


<c:url var="forget" value="/login/ForgetPassword"/>
<div class="container">    
   
    <div id="signupbox" style=" margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Login</div>
                 <b><%@include file="BusinessMessage.jsp"%></b> 
            </div>  
            <div class="panel-body" >
               <sf:form action="/Bank-Management/login" method="post" modelAttribute="form">
            
                      
                         <s:bind path="login">
                        <div  class="form-group required">
                            <label  class="control-label col-md-4  requiredField">Login Id<span class="asteriskField">*</span> </label>
                            <div class="controls col-md-8 ">
                                <sf:input path="${status.expression}" class="input-md  textinput textInput form-control"  maxlength="30" placeholder="Enter Login Id" style="margin-bottom: 10px" />
                           		<font  color="red"><sf:errors path="${status.expression}" class="help-block" /></font>
                            </div>
                        </div>
                       </s:bind>
                        <s:bind path="password">
                        <div  class="form-group required">
                            <label  class="control-label col-md-4  requiredField">Password<span class="asteriskField">*</span> </label>
                            <div class="controls col-md-8 "> 
                                 <sf:input type="password" path="${status.expression}"
									class="input-md textinput textInput form-control"  placeholder="Enter Password" style="margin-bottom: 10px"  />
                                <font
                        color="red"> <sf:errors path="${status.expression}" cssClass="help-block" /></font>
                            </div>
                        </div>
                       </s:bind>
                       
                        <div class="form-group"> 
                            <div class="aab controls col-md-4 "></div>
                            <div class="controls col-md-8 ">
                                 <input type="submit" name="operation" value="SignIn" class="btn btn-primary btn btn-info"  />  or <input type="submit" name="operation" value="SignUp" class="btn btn btn-primary"  />
                            </div>
                        </div> 
                            
                    </sf:form>

                
            </div>
        </div>
    </div> 
</div>
