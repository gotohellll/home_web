/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.102
 * Generated at: 2025-04-22 14:40:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp._04_005fboard_005fex_005fclass;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import board_ex.model.*;
import board_ex.service.*;
import java.util.List;

public final class BoardList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(7);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("board_ex.service");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("board_ex.model");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(2);
    _jspx_imports_classes.add("java.util.List");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
  //웹브라우저가 게시글 목록을 캐싱할 경우 새로운 글이 추가되더라도 새글이 목록에 안 보일 수 있기 때문에 설정
	response.setHeader("Pragma","No-cache");		// HTTP 1.0 version
	response.setHeader("Cache-Control","no-cache");	// HTTP 1.1 version
	response.setHeader("Cache-Control","no-store"); // 일부 파이어폭스 버스 관련
	response.setDateHeader("Expires", 1L);			// 현재 시간 이전으로 만료일을 지정함으로써 응답결과가 캐쉬되지 않도록 설정

      out.write("\r\n");
      out.write("\r\n");

// 전체 메세지 레코드 검색

ListArticleService service = ListArticleService.getInstance();
 
String pNum = request.getParameter("page");

int totalPageCount = service.getTotalCount();

List <BoardVO> mList =  service.getArticleList(pNum);

      out.write("\r\n");
      out.write("\r\n");
      out.write("<HTML>\r\n");
      out.write("<head><title> 게시글 목록 </title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<BODY>\r\n");
      out.write("\r\n");
      out.write("	<h3> 게시판 목록 </h3>\r\n");
      out.write("	\r\n");
      out.write("	<table border=\"1\" bordercolor=\"darkblue\">\r\n");
      out.write("	<tr>\r\n");
      out.write("		<td> 글번호 </td>\r\n");
      out.write("		<td> 제 목 </td>\r\n");
      out.write("		<td> 작성자 </td>\r\n");
      out.write("		<td> 작성일 </td>\r\n");
      out.write("		<td> 조회수 </td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	\r\n");
      out.write("	");
 if( mList.isEmpty() ) { 
      out.write("\r\n");
      out.write("		<tr><td colspan=\"5\"> 등록된 게시물이 없습니다. </td></tr>\r\n");
      out.write("	");
 } else { 
      out.write("\r\n");
      out.write("	<!-- *************** -->\r\n");
      out.write("	<!--  여기에 목록 출력하기  -->\r\n");
      out.write("	");
 for( BoardVO vo : mList){
      out.write("\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td>");
      out.print(vo.getSeq());
      out.write("</td>\r\n");
      out.write("			<td><a href=\"BoardView.jsp?seq=");
      out.print(vo.getSeq());
      out.write('"');
      out.write('>');
      out.print(vo.getTitle());
      out.write("</a></td>\r\n");
      out.write("			<td>");
      out.print(vo.getWriter());
      out.write("</td>\r\n");
      out.write("			<td>");
      out.print(vo.getRegdate());
      out.write("</td>\r\n");
      out.write("			<td>");
      out.print(vo.getCnt());
      out.write("</td>		\r\n");
      out.write("		</tr>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	");
 } //end of for 
      out.write('\r');
      out.write('\n');
      out.write('	');
 }  
      out.write("\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td colspan=\"5\">\r\n");
      out.write("				<a href=\"BoardInputForm.jsp\">글쓰기</a>\r\n");
      out.write("			</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("	</table>\r\n");
      out.write("	");
 for(int i=1; i<=totalPageCount; i++) {
      out.write("\r\n");
      out.write("		<a href='BoardList.jsp?page=");
      out.print(i);
      out.write('\'');
      out.write('>');
      out.write('[');
      out.print( i );
      out.write("]</a>\r\n");
      out.write("	");
} //end of for 
      out.write("\r\n");
      out.write("</BODY>\r\n");
      out.write("</HTML>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
