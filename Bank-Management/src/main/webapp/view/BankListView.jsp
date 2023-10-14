<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@page isELIgnored="false"%>
<c:url var="addUrl" value="/ctl/bank" />

<c:url var="addSearch" value="/ctl/bank/search" />

<c:url var="editUrl" value="/ctl/bank?id=" />
	<sf:form action="/Bank-Management/ctl/bank/search" method="post" modelAttribute="form">
		<div class="container">
			<div class="row">
				<center>
					<h3>Bank Report</h3>
				</center>


					<sf:input type="hidden" path="pageNo" />
					<sf:input type="hidden" path="pageSize" />

					<sf:input type="hidden" path="listsize" />
					<sf:input type="hidden" path="total" />
					<sf:input type="hidden" path="pagenosize" />
				<hr>
				<div class="col-md-12">

					<div class="table-responsive">

						<table class="table table-bordred table-striped">
							<tr>
								 <s:bind path="name">
								<th>Name</th>
								<td><sf:input path="${status.expression}"
									class="input-md  textinput textInput form-control"
									maxlength="30" placeholder="Enter Name"
									style="margin-bottom: 10px" />
									</td>
									</s:bind>
								<th></th>
								<s:bind path="shortCode">
								<th>Short Code</th>
								<td><sf:input path="${status.expression}"
									class="input-md  textinput textInput form-control"
									maxlength="30" placeholder="Enter Short Code"
									style="margin-bottom: 10px" /></td>
									</s:bind>
								<td><input type="submit"
									class="btn btn-primary btn btn-info" name="operation"
									value="Search"></td>
							</tr>
						</table>
						<center>
							 <b><%@include file="BusinessMessage.jsp"%></b>
						</center>
						<table id="mytable" class="table table-bordred table-striped">


							<thead>
								<tr>
									<th>Select</th>
									<th>Bank Name</th>
									<th>Short Code</th>
									<th>IFSC Code</th>
									<th>Description</th>
									<th>Action</th>
									
									
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${list}" var="bk" varStatus="bki">
								<tr>
									<td><input type="checkbox" class="case"
										name="ids" value="${bk.id}"></td>
									<td>${bk.name}</td>
									<td>${bk.shortCode}</td>
									<td>${bk.IFSECode}</td>
									<td>${bk.description}</td>
									<td><a class="btn btn-primary" href="${editUrl} ${bk.id}">Edit</a></td>
								</tr>
								</c:forEach>
							</tbody>

						</table>

						<div class="clearfix"></div>
						<ul class="pagination pull-right">
							<li><input type="submit" name="operation"
								class="btn btn-primary btn btn-info"
								value="Previous"
								<c:if test="${form.pageNo == 1}">disabled="disabled"</c:if>></li>
								
								<li><input type="submit" name="operation"
								class="btn btn-primary btn btn-info"
								value="Delete"
								<c:if test="${listsize== 0}">disabled="disabled"</c:if>></li>
								
								
								<li><input type="submit" name="operation"
								class="btn btn-primary btn btn-info"
								value="New"
								></li>
							
						
							
							<li><input type="submit" name="operation"
								class="btn btn-primary btn btn-info"
								value="Next"
								<c:if test="${total == pagenosize  || listsize < pageSize   }">disabled="disabled"</c:if>></li>
						</ul>

					</div>

				</div>
			</div>
		</div>
	</sf:form>
