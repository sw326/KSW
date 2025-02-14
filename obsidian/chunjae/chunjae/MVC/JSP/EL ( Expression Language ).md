
1) 모양 ${}
2) 내용
	1) 객체의 속성값
	2) 배열 객체
	3) 컬렉션 객체
	4) Map 객체
	   
3) EL의 디폴트 객체들 (11개)
	1) param
	   paramValues
	   
	2) header
	   headerValues
	   
	3) pageContext : 'EL에서 JSP의 디폴트 객체 접근시 사용'
	   
	4) pageScope
	   requestScope
	   sessionScope
	   applicationScope
	   
	5) cookie
	   
	6) initParam : 'ServletContext에 대한 initParam 참조'
	   
	   DD 정의 : web.xml
	   ```
	   <context-param>
		   <param-name>siteName</param-name>
		   <param-value>Soo Site</param-value>
	   </contet-param>
	   ```
	   
4) EL 연산자
	1) 산술
	   ex) +, -, `*`, / 와  div, %와 mod
	   
	   cf1) /와 div 사용시 0으로 나눌 수 있음 ( Infinity )
	   cf2) %와 mod 사용시 0으로 나눌 수 없음 ( 오류 )
	   
	2) 논리
	   ex) &&와 and, ||와 or, !와 not
	   
	3) 관계
	   ex) `==`와 eq, !=와 ne, <와 lt, >와 gt, <=와 le, >=와 ge
	   
	4) empty: 비어있거나 null인 경우 true 리턴
	   
	   cf1) jsp의 변수(멤버/지역)는 EL에서 인식하지 못함
	   cf2) 정의되지 않은 변수/값(null)일 경우 표현처리
		   - case1) 공백처리 (ex: ${str})
		   - case2) 0으로 처리 (ex: ${str+10} )
		   - case3) false 처리 (ex: ${true and str} )
		     
5) EL Function