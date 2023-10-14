<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@page isELIgnored="false"%>
<div class="container">    
            
    <div id="signupbox" style=" margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">My Profile</div>
                 <b><%@include file="BusinessMessage.jsp"%></b>
            </div>  
            <div class="panel-body" >
             <sf:form action="/Bank-Management/ctl/profile" method="post" modelAttribute="form">
                   
                   <sf:hidden path="id"/>
                      
                      
                       	<s:bind path="firstName">
						<div class="form-group required">
							<label class="control-label col-md-4  requiredField">First
								Name<span class="asteriskField">*</span>
							</label>
							<div class="controls col-md-8 ">
								<sf:input path="${status.expression}"
									class="input-md  textinput textInput form-control"
									maxlength="30" placeholder="Enter First Name"
									style="margin-bottom: 10px" />
								<font color="red"><sf:errors path="${status.expression}"
										cssClass="help-block" /></font>
							</div>
						</div>
					</s:bind>
                        <s:bind path="lastName">
						<div class="form-group required">
							<label class="control-label col-md-4  requiredField">Last
								Name<span class="asteriskField">*</span>
							</label>
							<div class="controls col-md-8 ">
								<sf:input path="${status.expression}"
									class="input-md  textinput textInput form-control"
									maxlength="30" placeholder="Enter last Name"
									style="margin-bottom: 10px" />
								<font color="red"><sf:errors path="${status.expression}"
										cssClass="help-block" /></font>
							</div>
						</div>
					</s:bind>
                        <s:bind path="login">
						<div class="form-group required">
							<label class="control-label col-md-4  requiredField">Login
								Id<span class="asteriskField">*</span>
							</label>
							<div class="controls col-md-8 ">
								<sf:input path="${status.expression}"
									class="input-md  textinput textInput form-control"
									maxlength="30" placeholder="Enter Login Id"
									style="margin-bottom: 10px" />
								<font color="red"><sf:errors path="${status.expression}"
										cssClass="help-block" /></font>
							</div>
						</div>
					</s:bind>
                       
                        
                      
                        
                       <hr>
                       <s:bind path="dob">
						<div class="form-group required">
							<label class="control-label col-md-4  requiredField">Date
								Of Birth<span class="asteriskField">*</span>
							</label>
							<div class="controls col-md-8 ">
								<sf:input path="${status.expression}"
									class="input-md  textinput textInput form-control"
									maxlength="30" placeholder="Enter Date Of birth"
									style="margin-bottom: 10px" />
								<font color="red"><sf:errors path="${status.expression}"
										cssClass="help-block" /></font>
							</div>
						</div>
					</s:bind>
                      <s:bind path="mobileNo">
						<div class="form-group required">
							<label class="control-label col-md-4  requiredField">Mobile
								No.<span class="asteriskField">*</span>
							</label>
							<div class="controls col-md-8 ">
								<sf:input path="${status.expression}"
									class="input-md  textinput textInput form-control"
									maxlength="30" placeholder="Enter Mobile No"
									style="margin-bottom: 10px" />
								<font color="red"><sf:errors path="${status.expression}"
										cssClass="help-block" /></font>
							</div>
						</div>
					</s:bind>
                        
                       <s:bind path="gender">
					<div id="div_id_email" class="form-group required">
						<label class="control-label col-md-4  requiredField">Gender<span
							class="asteriskField">*</span>
						</label>
						<div class="controls col-md-8 ">
							<sf:select style="margin-bottom: 10px" class="form-control" path="${status.expression}">
														<sf:option value="" label="Select" />
														<sf:options items="${gender}" />
													</sf:select>
							<font color="red"><sf:errors path="${status.expression}"
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
    