<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../includes/header.jsp"%>
<script type="text/javascript">
    $(document).ready(function() {
        var formObj = $("form");
        
        $('button').on("click", function(e) {
           
        	e.preventDefault();

	            // 버튼의 데이터 속성에서 operation 값을 가져온다.
            var operation = $(this).data("oper");
            console.log(operation);

            if (operation === 'remove') {
                formObj.attr("action", "/board/remove");
                
            } else if (operation === 'list') {
                // 페이지 이동을 위해 window.location 사용합니다.
             	 formObj.attr("action", "/board/list").attr("method", "get");
             	formObj.empty();
                return;
            }

            formObj.submit();
        });
    });
</script>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Modify Page</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">


			<div class="panel-heading">Board Modify Page</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
			
				<form action="/board/modify" method="post" role="form">
					<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum }"/>'>
					<input type="hidden" name="amount" value='<c:out value="${cri.amount }"/>'>
					
				<div class="form-group">
					<label>Bno</label><input class="form-control" name='bno'
						value='<c:out value="${board.bno }" />' readonly="readonly">
				</div>
				<div class="form-group">
					<label>Title</label><input class="form-control" name='title'
						value='<c:out value="${board.title }" />'>
				</div>

				<div class="form-group">
					<label>Text area</label>
					<textarea rows="3" class="form-control" name='content'>
									<c:out value="${board.content }" />
								</textarea>
				</div>

				<div class="form-group">
					<label>Writer</label><input class="form-control" name='writer'
						value='<c:out value="${board.writer }" />' readonly="readonly">
				</div>

				<div class="form-group">
					<label>RegDate</label> <input class="form-control" name='regDate'
						value='<fmt:formatDate pattern = "yyyy/MM/dd" value = "${board.regDate}" />'
						readonly="readonly">
				</div>

				<div class="form-group">
					<label>Update Date</label> <input class="form-control"
						name='updatedate'
						value='<fmt:formatDate pattern = "yyyy/MM/dd" value = "${board.updatedate}" />'
						readonly="readonly">
				</div>

				<button type="submit" data-oper='modify' class="btn btn-default">modify</button>
				<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
				<button type="submit" data-oper='list' class="btn btn-info">List</button>
					
					
				</form>

			</div>
			<!-- /.table-responsive -->
		</div>
		<!-- /.panel-body -->
	</div>
	<!-- /.panel -->
</div>
<!-- /.col-lg-6 -->



<%@include file="../includes/footer.jsp"%>