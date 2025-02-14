< DBCP 셋팅 >

1. server.xml 
   <Resource name="jdbc/TestDB" auth="Container" type="javax.sql.DataSource"
	   maxTotal="100" maxIdle="30" maxWaitMillis="10000"
	   username="scott" password="tiger" driverClassName="org.mariadb.jdbc.Driver"
	   url="jdbc:mariadb://127.0.0.1:3306/java_schema"/>

2. web.xml 
  <resource-ref>
      <description>DB Connection</description>
      <res-ref-name>jdbc/TestDB</res-ref-name>
      <res-type>javax.sql.DataSource</res-type>
      <res-auth>Container</res-auth>
  </resource-ref>

3. dbcp_test.jsp
  <%@ page contentType="text/html;charset=utf-8" 
	import="javax.naming.*, javax.sql.DataSource, java.sql.Connection"%>

  <%
	Context initContext = new InitialContext();
	Context envContext  = (Context)initContext.lookup("java:/comp/env");
	DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
	Connection con = ds.getConnection();
  %>

  생성된 MariaDB의 con: <%=con%>

4. index.jsp 
  `<a href="dbcp_test.jsp">DBCP테스트</a><br>`
  