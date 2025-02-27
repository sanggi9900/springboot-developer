package org.example.이론;

public class f_spring_container {

    // 스프링 컨테이너 & 빈

    // 1. 스프링 컨테이너
    // : 애플리케이션 내에서 객체(빈)의 생명 주기와 설정을 관리
    // : 애플리케이션을 구성하는 빈들을 생성, 조립, 관리
    //   > 제어의 역전(IoC)을 실현
    //   > 의존성 주입(DI)를 지원

    // 2. 빈(Bean)
    // : 스프링 컨테이너가 관리하는 객체를 의미
    // : 개발자에 의해 명시적으로 정의 | 스프링에 의해 자동으로 감지되어 관리
    // > 주로 서비스, 리포지토리, 컨트롤러 등의 역활을 수행하는 컴포넌트로 사용

    // cf) 빈의 경우 클래스 이름의 첫 글자를 소문자로 바꿔 관리
    // : Book 클래스의 경우 Book으로 저장되어 관리
    // : BookStore 클래스 - bookStore 빈으로 저장되어 관리

    // +) 빈 선언 방법
    // XML 파일 사용, 애너테이션 사용(@Component, @Service, @Repository 등)
    // , 자바 설정 클래스에서 @Bean 애너테이션 사용
}
// 관점 지향 프로그래밍 (AOP: Aspect Oriented Programming)
// : 프로그램밍에 대한 관심을 관심 기준으로 모듈화하는 것
// : 애플리케이션의 핵심 로직과 '공통적인 관심사'를 분리하여 관리하는 방법
// : 모듈화를 지향
// > 로그, 보안, 트랜잭션 관리와 같은 '공통적인 관심사'를 핵심 비즈니스 로직과
//      분리하여 유지보수성과 코드 가독성을 향상

// === 이식 가능한 서비스 추상화 (PSA : Portable Service Abstraction)
// : 특정 기술에 의존하지 않고  다향한 환경에서도 동일하게 동작할 수 있는 스프링의 추상화
// > 어떤 기술을 사용하든 일관된 방식으로 DB에 접근하도록 인터페이스를 지원
//  : JDBC, JPA 등 어떤한 DB 접근 방식이든
