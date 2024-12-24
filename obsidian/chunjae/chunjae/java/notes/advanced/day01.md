
## < Advenced >
IO: input & output
Network: 
GUI
JDBC


# < IO ( Input Output ) >
![[Pasted image 20241218103230.png]]
1) 스트림(Stream): '데이터의 흐름'
   Data Source(근원지) ----> Data Destination(목적지)
   
2) 스트림 특징
	1) FIFO ( First In First Out )
	2) 지연성
	3) 단방향성
	4) 유연성
	   BufferedReader br = BufferedReader(new InputStreamReader(System.in))
	   
	   InputStream is = System.in; // 근본
	   InputStreamReader isr = new InputStreamReader(is); // 다리
	   BufferedReader br = BufferedReader(isr); // 목적
	   
3) 표준 입력 / 표준 출력
   키보드( System.in ) ---> 모니터( System.out )
   
4) 구분
	1) 전송 단위
		1. 바이트 스트림 ( 1byte stram )
		   ex) XXXStream
		2. 문자 스트림 ( 2 byte stram )
		   ex) XXXReader, XXXWriter
		   
	2) 입출력
		1. 입력
		   ex) XXXInputStream, XXXReader
		2. 출력
		   ex) XXXOutputStream, XXXWriter
		   
	3) 특성
		1. 근본( Node Stream ): '근원지' || '목적지'와 직접 연결된 스트림
		   ex) FileInputStream, FileOutputStream, ...
		2. 다리( Bridge Stream ): 1byte 스트림을 2byte스트림으로 변경
		   ex) InputStreamReader, OutputStreamWriter
		3. 목적( Filter Stream ): '원하는 목적' 기능을 가진 스트림
		   ex) BufferedReader, PrintWriter, ...
		   
5) 주요 스트림
	1) InputStream / OutputStream // 조상(바이트)스트림
	   ex) day01/A.java
	2) FileInputStream / FileOutputStream // 파일 
	   ex) day01/B.java
	3) BufferedInputStream / BufferedOutputStream // 버퍼 강화
	   ex) day01/C.java
	4) DataInputStream / DataOutputStream // 기본형 + 유니코드
	   ex) day01/D.java
	5) Reader / Writer // 조상(문자)
	6) FileReader / FileWriter
	7) InputStreamReader / OutputStreamReader
	   ex) day01/E.java
	8) BufferedReader / PrintWriter
	   ex) day01/F.java

