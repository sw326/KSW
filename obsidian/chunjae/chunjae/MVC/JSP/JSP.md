< JSP 구성요소 >
1) JSP elements 
   <1> 지시어 ( Directive Element )
       < %@ page %>
   <2> 스크립팅 원소( Scripting Elements )
       <%! %> : 선언( Declaration ) 
	   <%  %> : 스크립트렛( Scriptlet )
	   <%= %> : 식( Expression )
   <3> JSP Action ( JSP 표준태그 )
       <jsp:XXX />
   <4> JSTL 
       < %@ taglib %>
	   <c:XXX ></c:XXX>
   <5> EL
       ${}
   //<6> CTL

2) Fixed Template Data (HTML)

< JSP 디폴트 객체들 >
JSP문서에서 객체를 생성하지않고도 <% %>에서 사용 가능한 객체 

<1> out ( JspWriter )
<2> response ( HttpServletResponse )
<3> request ( HttpServletRequest )
<4> session ( HttpSession )
<5> application ( ServletContext )
<6> page ( Object )
<7> pageContext ( PageContext )
<8> config ( ServletConfig )
<9> exception  ( Throwable )

< JSP 주석 >
1) <!-- 내용 --> 
2) // 라인1 
   /* 라인1
      라인2.. */
3) <%-- 내용 --%>

Connection pool
DBCP
hikariCP