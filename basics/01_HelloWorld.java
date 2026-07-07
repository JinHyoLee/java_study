/**
 * 01 — 개발환경 구축 & Hello World
 *
 * [JVM] Java Virtual Machine — .class 바이트코드를 OS별로 실행
 * [JDK] Java Development Kit — javac(컴파일러) + java(실행기) + 라이브러리
 * [JRE] Java Runtime Environment — 실행만 (JDK에 포함)
 *
 * 설치 확인:
 *   java -version
 *   javac -version
 *
 * 컴파일 & 실행:
 *   javac 01_HelloWorld.java
 *   java HelloWorld
 *
 * 파일명은 01_ 접두사(학습 순서), 클래스명은 HelloWorld.
 * public 클래스는 파일명과 같아야 하고, 숫자로 시작할 수 없어서 public을 붙이지 않습니다.
 */
class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}