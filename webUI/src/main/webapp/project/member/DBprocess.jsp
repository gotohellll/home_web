<%@ page import="dbcom2.MemberVO" %>
<%@ page import="dbcom2.MemberDAO" %> 
<%request.setCharacterEncoding("utf-8"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		request.setCharacterEncoding("utf-8"); 
		String userid = request.getParameter("userid");
		String member_rpw = request.getParameter("member_rpw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String birth = request.getParameter("birth"); 
		String gender = request.getParameter("gender"); // M(남자) : F(여자)
		String comments = request.getParameter("comments");
		
		MemberVO vo = new MemberVO();		
		vo.setUserid(userid);
		vo.setPassword(member_rpw);
		vo.setName(name);
		vo.setEmail(email);		
		vo.setAddress(address);		
		vo.setBirth(birth);		
		vo.setGender(gender);		
		vo.setComments(comments);
		
		MemberDAO dao = new MemberDAO();
		dao.insert(vo);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
    alert("완료되었습니다!");
    location.href = "member_join.html"; // 또는 돌아갈 원래 페이지 경로
</script>
</body>
</html>