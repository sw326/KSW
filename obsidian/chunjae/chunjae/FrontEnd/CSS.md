1. CSS  
	(1) selectors
		- universal -> * 
		- type -> Tag
		- id -> #
		- class -> .
		- state -> :
		- attribute -> []
		  예) input[type="text"]

		#참고) 우선순위 ( <div class="cvalue" id="ivalue">가</div> ) 
			div{ //3
				border: 3px solid red;
			}
			.cvalue{ //2
				border: 3px solid green;
			}
			#ivalue{ //1
				border: 3px solid blue;
			}
		
	(2) API
		https://developer.mozilla.org/ko/docs/Learn/Getting_started_with_the_web/CSS_basics
		게임) flukeout.github.io

		#참고) <link href="index.css" rel="stylesheet"/>

	(3) 'display' ( inline || inline-block || block || flex || grid || none )
		1) HTML
			<1> Emmet
				div{$}*3
				span{$}*3

			<2> 결과 
				<div>1</div>
				<div>2</div>
				<div>3</div>
				<span>1</span><span>2</span><span>3</span>

		2) CSS
			div, span {
				width: 80px;
				height: 80px;
				background-color: yellow;
				padding: 10px;
				margin: 20px;
			}
			div{
				background-color: red;
				display: inline-block;
			}
			span{
				background-color: green;
				display: block;
			}
			
		    #참고) CSS 박스 모델

	(4) 'display: flex'
		1) 'box속성' 테스트
			<1> Emmet
				div.container>div.item.item${$}*10
				+ 탭 

			<2> 결과 
				<div class="container">
					<div class="item item1">1</div>
					<div class="item item2">2</div>
					<div class="item item3">3</div>
					<div class="item item4">4</div>
					<div class="item item5">5</div>
					<div class="item item6">6</div>
					<div class="item item7">7</div>
					<div class="item item8">8</div>
					<div class="item item9">9</div>
					<div class="item item10">10</div>
				</div>
			
			<3> 주요 box 속성들 
				- display: flex;

				- flex-direction: row || row-reverse || column || column-reverse
				- flex-wrap: nowrap || wrap || wrap-reverse
				- /*flex-flow: column nowrap; */ 위 2가지 속성을 한꺼번에 셋팅 

				- justify-content: flex-start || flex-end || center || space-around || space-evenly ||space-between
				- align-items: baseline || center 
				- text-align: left || center || right

			<4> 테스트
				.container{
					background: yellow;
					height: 100vh;
					display: flex;
					flex-direction: row;
					flex-wrap: nowrap;
					/* flex-flow: row nowrap; */

					justify-content: space-between;
					align-items: baseline;
					text-align: right;
				}  
				.item{
					width: 40px;
					height: 40px;
					border: 1px solid black;
				}
				.item1{
					background: #ef9a9a;
				}
				.item3{
					background: #ce93d8;
				}
				.item2{
					background: #f48fb1;
				}
				.item4{
					background: #b39ddb;
				}
				.item5{
					background: #90caf9;
				}
				.item6{
					background: #a5d6a7;
				}
				.item7{
					background: #e6ee9c;
				}
				.item8{
					background: #fff59d;
				}
				.item9{
					background: #ffcc80;
				}
				.item10{
					background: #ffab91;
				}

		2) 'item속성' 테스트( '비율배치' )
			<1> Emmet 
				div.container>div.item.item${$}*3
				+ 탭

			<2> 결과
				<div class="containter">
					<div class="item item1">1</div>
					<div class="item item2">2</div>
					<div class="item item3">3</div>
				</div>
			
			<3> 주요 item 속성들
				- order: 숫자 //배치순서
				- flex-grow: 숫자 //늘어날때 비율
				- flex-shrink: 숫자	//줄어들때 비율 
				- flex-basis: auto || 숫자% //비율배치(늘거나 줄때도 유지) 
				- flex: 2 2 auto // grow, shrink, basis 를 한번에
				- align-self: flex-start || flex-end || center //자신만 따로 

			<4> 테스트
				.containter {
					background: yellow;
					height: 100vh;
					display: flex;
				}
				.item {
					width: 40px;
					height: 40px;
					border: 1px solid black;
				}
				.item1{
					background-color: #ef9a9a;
					/* flex-grow: 0.5;
					flex-shrink: 2;
					flex-basis: 60%; */
					flex: 0.5 2 60%;
					align-self: center;
				}
				.item2{
					background: #f48fb1;
					flex-grow: 1;
					flex-shrink: 1;
					flex-basis: 30%;
				}
				.item3{
					background: #ce93d8;
					flex-basis: 10%;
				}

	(5) 'display: grid' 
		1) 테스트1
			<1> Emmet
				div.container>div.item.item${Item$}*10
				+ 탭	

			<2> 결과 
				<div class="container">
					<div class="item item1">Item1</div>
					<div class="item item2">Item2</div>
					<div class="item item3">Item3</div>
					<div class="item item4">Item4</div>
					<div class="item item5">Item5</div>
					<div class="item item6">Item6</div>
					<div class="item item7">Item7</div>
					<div class="item item8">Item8</div>
					<div class="item item9">Item9</div>
					<div class="item item10">Item10</div>
				</div>

			<3> CSS 
				.container{
					display: grid;
					/* grid-template-columns: repeat(5, 100px);  
					grid-template-columns: repeat(5, 10%);   
					grid-template-columns: 1fr 2fr 1fr; */
					grid-template-columns: repeat(5, 1fr);

					/* grid-auto-rows: 150px; 
					grid-template-rows: 100px 200px repeat(3, 100px);*/
					grid-auto-rows: minmax(150px, auto); /*내용이 길 경우 자동 사이즈*/
					/* column-gap: 10px;
					row-gap: 10px; */
					gap: 10px; /*column과 rows에 모두*/
					padding: 10px; /*contrainer의 패딩*/
					/* background-color: yellow;  */
				}
				.item{
					border: 1px solid black;
					font-size: 1.2rem;
					font-weight: bold;
					display: flex;
					justify-content: center;
				}
				.item2{
					/* grid-column-start: 2;
					grid-column-end: 4; */
					grid-column: 2/4; /*한꺼번에 셋팅:  col border의 2~4번째까지 차지함 */ 

					/* grid-row-start: 1;
					grid-row-end: 3; */
					grid-row: 1/3; /*한꺼번에 셋팅: row border의 1~3번째까지 차지함*/
				}
				
		2) 테스트2
			<1> HTML