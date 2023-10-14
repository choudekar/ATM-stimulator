<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@page isELIgnored="false"%>
<div class="container">    
            
    <div id="signupbox" style=" margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Change Password</div>
               <b><%@include file="BusinessMessage.jsp"%></b>
            </div>  
            <div class="panel-body" >
               <sf:form action="/Bank-Management/ctl/changepassword" method="post" modelAttribute="form">
			
                   <s:bind path="oldPassword">
                   <div  class="form-group required"> 
                            <label  class="control-label col-md-4  requiredField">Old Password<span class="asteriskField">*</span> </label> 
                            <div class="controls col-md-8 "> 
                               <sf:input type="password" path="${status.expression}"
									class="input-md textinput textInput form-control"
									placeholder="Enter Old Password" style="margin-bottom: 10px" />
								<font color="red"> <sf:errors path="${status.expression}"
										cssClass="help-block" /></font>
                            </div>
                        </div> 
                        </s:bind>
                   
                        <s:bind path="newPassword">
                		   <div  class="form-group required"> 
                            <label  class="control-label col-md-4  requiredField">New Password<span class="asteriskField">*</span> </label> 
                            <div class="controls col-md-8 "> 
                               <sf:input type="password" path="${status.expression}"
									class="input-md textinput textInput form-control"
									placeholder="Enter New Password" style="margin-bottom: 10px" />
								<font color="red"> <sf:errors path="${status.expression}"
										cssClass="help-block" /></font>
                            </div>
                        </div> 
                        </s:bind>
                          <s:bind path="confirmPassword">
                		   <div  class="form-group required"> 
                            <label  class="control-label col-md-4  requiredField">Confirm Password<span class="asteriskField">*</span> </label> 
                            <div class="controls col-md-8 "> 
                               <sf:input type="password" path="${status.expression}"
									class="input-md textinput textInput form-control"
									placeholder="Enter Confirm Password" style="margin-bottom: 10px" />
								<font color="red"> <sf:errors path="${status.expression}"
										cssClass="help-block" /></font>
                            </div>
                        </div> 
                        </s:bind>

                        <div class="form-group"> 
                            <div class="aab controls col-md-4 "></div>
                            <div class="controls col-md-8 ">
                                <input type="submit" name="operation" value="Save" class="btn btn-primary btn btn-info"  />
                                or <input type="submit" name="operation" value="Reset" class="btn btn btn-primary"  />
                            </div>
                        </div> 
                            
                    </sf:form>
               
            </div>
        </div>
    </div> 
</div>
    