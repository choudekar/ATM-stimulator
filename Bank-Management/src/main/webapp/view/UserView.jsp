<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@page isELIgnored="false"%>
<div class="container">

	<div id="signupbox" style="margin-top: 50px"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">User Registration</div>
				<b><%@include file="BusinessMessage.jsp"%></b>
			</div>
			<div class="panel-body">
				<sf:form action="/Bank-Management/ctl/user" method="post" modelAttribute="form">
				<sf:hidden path="id"/>
					<p>Bank Detail</p>
					<hr>
					<s:bind path="bankId">
						<div id="div_id_username" class="form-group required">
							<label class="control-label col-md-4  requiredField">Bank
								Name<span class="asteriskField">*</span>
							</label>
							<div class="controls col-md-8 ">
								<sf:select style="margin-bottom: 10px" class="form-control" path="${status.expression}">
									<sf:option value="-1" label="Select" />
									<sf:options itemLabel="name" itemValue="id" items="${bank}" />
								</sf:select>
									<font color="red"><sf:errors path="${status.expression}"
										cssClass="help-block" /></font>
							</div>
						</div>
					</s:bind>

				<s:bind path="typeOfAccount">
					<div id="div_id_email" class="form-group required">
						<label class="control-label col-md-4  requiredField">Type
							Of Account<span class="asteriskField">*</span>
						</label>
						<div class="controls col-md-8 ">
							<sf:select style="margin-bottom: 10px" class="form-control" path="${status.expression}">
														<sf:option value="" label="Select" />
														<sf:options items="${type}" />
													</sf:select>
							<font color="red"><sf:errors path="${status.expression}"
										cssClass="help-block" /></font>
						</div>
					</div>
					</s:bind>
					<s:bind path="title">
						<div id="div_id_password1" class="form-group required">
							<label class="control-label col-md-4  requiredField">Title<span
								class="asteriskField">*</span></label>
							<div class="controls col-md-8 ">
								<sf:input path="${status.expression}"
									class="input-md  textinput textInput form-control"
									maxlength="30" placeholder="Enter Title"
									style="margin-bottom: 10px" />
								<font color="red"><sf:errors path="${status.expression}"
										cssClass="help-block" /></font>
							</div>
						</div>
					</s:bind>
					<s:bind path="accountName">
						<div id="div_id_password1" class="form-group required">
							<label class="control-label col-md-4  requiredField">Account
								Name<span class="asteriskField">*</span>
							</label>
							<div class="controls col-md-8 ">
								<sf:input path="${status.expression}"
									class="input-md  textinput textInput form-control"
									maxlength="30" placeholder="Enter Account Name"
									style="margin-bottom: 10px" />
								<font color="red"><sf:errors path="${status.expression}"
										cssClass="help-block" /></font>
							</div>
						</div>
					</s:bind>
					<p>User Detail</p>
					<hr>
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
					<s:bind path="password">
						<div class="form-group required">
							<label class="control-label col-md-4  requiredField">Password<span
								class="asteriskField">*</span>
							</label>
							<div class="controls col-md-8 ">
								<sf:input type="password" path="${status.expression}"
									class="input-md textinput textInput form-control"
									placeholder="Enter Password" style="margin-bottom: 10px" />
								<font color="red"> <sf:errors path="${status.expression}"
										cssClass="help-block" /></font>
							</div>
						</div>
					</s:bind>
					<s:bind path="confirmPassword">
						<div class="form-group required">
							<label class="control-label col-md-4  requiredField">Confirm
								Password<span class="asteriskField">*</span>
							</label>
							<div class="controls col-md-8 ">
								<sf:input type="password" path="${status.expression}"
									class="input-md textinput textInput form-control"
									placeholder="Enter Confirm Password" style="margin-bottom: 10px" />
								<font color="red"> <sf:errors path="${status.expression}"
										cssClass="help-block" /></font>
							</div>
						</div>
					</s:bind>
					<s:bind path="emailId">
						<div class="form-group required">
							<label class="control-label col-md-4  requiredField">Email
								Id<span class="asteriskField">*</span>
							</label>
							<div class="controls col-md-8 ">
								<sf:input path="${status.expression}"
									class="input-md  textinput textInput form-control"
									maxlength="30" placeholder="Enter Email Id"
									style="margin-bottom: 10px" />
								<font color="red"><sf:errors path="${status.expression}"
										cssClass="help-block" /></font>
							</div>
						</div>
					</s:bind>
					<p>Personal Detail</p>
					<hr>
					<s:bind path="dob">
						<div class="form-group required">
							<label class="control-label col-md-4  requiredField">Date
								Of Birth<span class="asteriskField">*</span>
							</label>
							<div class="controls col-md-8 ">
								<sf:input path="${status.expression}" id="datepicker"
									class="input-md  textinput textInput form-control"
									maxlength="30" placeholder="Enter Date Of birth (mm/dd/yyyy)"
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
					<s:bind path="fax">
						<div class="form-group required">
							<label class="control-label col-md-4  requiredField">Fax<span
								class="asteriskField">*</span>
							</label>
							<div class="controls col-md-8 ">
								<sf:input path="${status.expression}"
									class="input-md  textinput textInput form-control"
									maxlength="30" placeholder="Enter Fax No"
									style="margin-bottom: 10px" />
								<font color="red"><sf:errors path="${status.expression}"
										cssClass="help-block" /></font>
							</div>
						</div>
					</s:bind>
					<s:bind path="nationality">
						<div class="form-group required">
							<label class="control-label col-md-4  requiredField">Nationality<span
								class="asteriskField">*</span>
							</label>
							<div class="controls col-md-8 ">
								<sf:input path="${status.expression}"
									class="input-md  textinput textInput form-control"
									maxlength="30" placeholder="Enter Nationality"
									style="margin-bottom: 10px" />
								<font color="red"><sf:errors path="${status.expression}"
										cssClass="help-block" /></font>
							</div>
						</div>
					</s:bind>



					<div class="form-group">
						<div class="aab controls col-md-4 "></div>
						<div class="controls col-md-8 ">
							<input type="submit" name="operation" value="Save"
								class="btn btn-primary btn btn-info" /> or <input
								type="submit" name="operation" value="Reset"
								class="btn btn btn-primary" />
						</div>
					</div>

				</sf:form>


			</div>
		</div>
	</div>
</div>
