## Day 4

## 오늘 수업에서 기대하는 점

- Repository 를 어떻게 관리하고, Repository 의존성에 대한 테스트 코드를 어떻게 짤 것인지 기대하고 있다,

## 오늘의 키워드

- 상품 목록 API (UI)
- 상품 목록 확인 (Application)
- 상품 목록 도메인 (Domain)
- Repository
- JPA
- Spring Data JPA
- Object-Object Mapping

## 1. 상품 목록 API (UI)

- Mock 을 좀 더 자세하게 사용하고자 UI 레이어 먼저 진행.

    GET /products
    ProductController

- DTO ←→ Domain model
- 애플리케이션에서 쓰여진 도메인 객체들을(Domain model) 외부에서 사용할 수 있는 데이터(DTO)로 변형 해주어야 한다.

## 2. 상품 목록 확인

- Controller
    - 어떤 API를 사용하는지 알 수 있다
- Application
    - 무슨 기능을 가지고 있는지 알 수 있다

## Service

- 애플리케이션이 어떤 역할을 하는지 볼 수 있다.
- DB 트랜잭션에 대한 범위를 지정해준다.

## Repository

- 전역적인 접근을 위해 Collection 같은 객체
- 객체의 영속화와 접근 책임을 Repository에 위임
- DB와 관련된 영속화를 Repository가 한다.
- DAO
    - DB를 추상화 하는 것
    - Repository는 DB를 넘어서서 객체들을 어디에 담아둘 것인가. 바라보는 시각이 달라진다.
- Repository는 기존의 패턴들을 포함한다
    - DAO
        - 데이터 액세스를 추상화
    - Data Mapper (vs Active Record)

## 생성자 주입 vs Autowired

- 컨트롤러 테스트를 위해서는 스프링을 이용하기 때문에 객체 주입을 스프링에 넘긴다.
    - Autowired로 하여도 무방하다
- 서비스단의 테스트를 위해서는 직접 의존성에 대한 주입을 해주어야 한다. (new로 인스턴스 생성) 이 경우에 Autowired를 사용하면 인스턴스 주입이 불가능하다. (스프링을 사용하여 테스트 하는 것이 아니기 때문에)

## Domain 객체

- Entity
    - 상태관리
    - Identifier ⇒ 동일성, 연속성
    - 3번 게시글은 아무리 수정해도 3번 게시글이다
- Value Object
    - 초창기의 VO와 완전히 개념이 다르다.
    - Primitive Type이 아닌 Custom Type
    - 동등함 비교
    - 기존의 VO는 DTO와 비슷한 개념으로 사용
    - 레이어 간의 데이터를 주고받을 때 DTO사용
    - Immutable (setter가 없음)
        - Dollar dollar; dollar.increase(3); ⇒ 불가능.
        - Dollar dollar = Dollar.of(4).plus(Dollar.of(5));
- Service
    - 상태 없음
    - 어느 객체가 책임을 가져야 할지 모호할 때 사용.
    - 상태를 직접적으로 가지지 않음
    - Application 레이어의 Service 이에 해당한다.
- Aggregate (Root Entity)
    - 엔티티가 다른 엔티티를 가지는 경우
    - Aggregate마다 Repository를 가진다.
- Factory
    - Factory 객체를 따로 둔다. 객체 생성에 대한 책임
- Repository

## JPA

- 대표적으로 Hibernate ORM을 사용한다.
- ORM (Object Relational Mapping)
    - Relational → 테이블
    - Pair → Columns의 관계를 Relational이라 부른다.
- DB랑 무관하게 객체지향 설계에 집중 할 수 있다.
- JPA를 쓴다는 것은 사실상 Hiberante ORM을 사용하는 것이다.
- 쿼리를 직접 짜지 않는다. (ORM을 쓰는 가장 큰 이유)
- 쿼리를 어떻게 최적화 할 것인가에 대해서는 JPA를 공부하면 도움이 된다.

## Spring Data JPA

- 를 사용하면 직접 구현을 하지 않아도 JPA 구현체를 사용할 수 있다.

## H2

- 인메모리 데이터베이스
- 프로그램을 종료하면 데이터가 날아간다.
- SQL Lite를 사용할 수 있다.

## YAML

- XML을 대체하기 위한 것

## test 환경변수

- Run/Debug Configuration에서 직접 설정
- 테스트에 선언
    - 스프링 써서 돌리는 테스트의 경우에만 사용
- SPRING_ACTIVE_PROFILES=test ./gradlew test

1. 테스트 클래스에 Annotation 추가@ActiveProfiles("test")

환경 변수로 설정# Linux, Mac 등SPRING_ACTIVE_PROFILES=test ./gradlew testexport SPRING_ACTIVE_PROFILES=test./gradlew test# Windowsset SPRING_ACTIVE_PROFILES=testgradlew.bat test

## 소감

- 아샬님은 지식이 방대하신 것 같다

## 오늘 수업에서 좋았던

- Entity, Repository 에 대한 개념을 익힐 수 있어서 좋았다.

## 오늘 수업에서 아쉬웠던 점

- 말씀 해주시는 것들이 많은데 다 이해하고 가져가지 못하는 것 같아 아쉽다.

요즘 트렌드 React (WebFlux)

코틀린
