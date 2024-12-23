**2024-11-28**

## JDK - Java Development Kit
8 -> server
17 -> server + client(Android)

**< 다운로드 >**  
(1) 구글 검색어: JDK 17 download  
[https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)(2) 구글 검색어: jdk 17 api documentation  
[https://www.oracle.com/java/technologies/javase-jdk17-doc-downloads.html](https://www.oracle.com/java/technologies/javase-jdk17-doc-downloads.html)

**< 개발환경 설정 >**
(1) JDK(Java Development Kit) 다운/설치
- D:\KSW\java\jdk-17.0.12

(2) 환경변수
-  JAVA_HOME => D:\KSW\java\jdk-17.0.12
- Path => D:\KSW\java\jdk-17.0.12\bin
- classpath => .

  확인) CMD에서 검증
  java
  javac
  java -version
  javac -version

(3) jdk-17.0.13_doc-all.zip 압축 풀기
- docs\index.html 즐겨찾기: 'SE17'

< java >
- SE(Standard Edition)
- EE(Enterprise Edition)
- ME(Micro Edition)

(4) Editer  
    - Editplus(5) Hello.java 작성/실행  
   class Hello  
   {  
public static void main(String[] args)  
{  
System.out.println("형수의 첫번째 자바앱^^");  
}  
  }  > javac Hello.java  
  > java Hello
  
< 실행 원리 >
(1) 작성(.java) -> 컴파일러(javac.exe) -> 클래스파일(.class)  
    > javac Hello.java //컴파일  
    > java Hello //실행
(2) .java ( for Human )  -> .class ( for JVM )
	cf) JVM ( Java Virtual Machine )

< 실행되는 클래스 ( 인입점) >  
public static void main(String[] args) {}  
  '가 있으면 그 클래스는 실행이되는 클래스가 됨!'

< 주석( Comment ) >  
(1) 1라인  
    //  
(2) N라인  
    /*  
        1라인  
        2라인  
        ..  
    */  
(3) 문서화  
    /**  
        1라인  
        2라인  
        ..  
    */