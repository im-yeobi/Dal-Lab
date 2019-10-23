## Day 1

2019.10.15 (화)



### 아키텍처

- 여러개의 레이어로 구분
- 왜 레이어를 나누는지 익히고자 한다.
- 레이어가 없으면 어떤 부분이 불편한지 느껴보고, 스프링을 사용해서 이를 개선하는 작업을 할 것이다.
- 타임리프, JSP/JSTL과 같은 프론트는 일체 하지 않고 오로지 백엔드만 다룬다.



### 자바는 컴파일을 해야하기 때문에 관리를 해줘야 한다.

- 앤트 → maven → gradle
- gradle을 계속 사용할 것이다. gradle은 dsl이다. 안드로이드 공식 빌드 도구이다.



### 자바9 이상을 권장한다.

- 최근 9, 11을 사용한다.
- 11부터는 var 사용 가능하다.
- 집에 가서 오픈 JDK 11 다운받기

### https://start.spring.io

- spring initializer 기능

### Spring Boot 프로젝트 활용

- 복잡한 설정들을 단순화 할 수 있다.
- version 2.1.9 사용
- 가장 큰 차이는 spring security



### gradle

- groovy 기반의 빌드 도구
- dsl



### Initializer 이용해서 프로젝트 생성

- [cattoy.dallab.com](http://cattoy.dallab.com) 이라는 url ⇒ 패키지에서는 반대로 com.dallab.cattoy
- War — War로 묶어서 톰캣에 띄우는 방식으로 예전에 사용. 현재는 Jar를 활용하는 추세이다.

⇒ 여기까지가 gradle 설정

- 의존성 
  - Spring Web (자바 표준)
  - Spring Data Jpa (자바 표준)
  - DevTools 
    - 소스 변경 시 자동으로 반영해준다. 재실행 필요없다.
  - lombok 
    - 어노테이션 활용. getter/setter 자동 생성해준다.
- IntelliJ import



### 프로젝트 보는 방식

- Project — 프로젝트 전체 보기
- Packages — 패키지만 보인다. main / test



### 프로젝트 실행 해보기

- Runner : cmd + ','
- Gradle 로 실행
- lombok 플러그인 설치
- annotation processors on



### Controller 생성

- @RestController
- @GetMapping
- hello를 반환하는 API를 하나 생성
- 실행하였으나 JPA 때문에 오류남.(데이터베이스 설정이 되어있지 않음) ⇒ H2 내장 데이터베이스 사용 예정



### JSON (Javascript Object Notation)

- JSON 형식으로 응답해주는 API를 만들 것이다.

- { "message": "hello, world" }

- 자바의 배열은 메모리에 들어가 연속되는 것이 아니고, 모두 객체로 존재한다.

- XML 에서 확장된 것이 JSON. XML을 활용하면 트리구조를 만드는 데 유리하다.

- JSON 형식은 JS 형식과 완전히 똑같다.

- JSON  관련 프로그램. 

  - Gson ⇒ Google에서 만듦
  - Jackson ⇒ Spring에서는 기본적으로 제공 `spring-boot-starter-web에 기본적으로 포함되어 있다.`

- DTO (Data Transfer Object) 

  - Greeting DTO로 구현

  

### Back-end 란

- 사용자에게 보여지는 뷰가 아닌 실제 비즈니스 로직들이 존재하는 곳.

- UI(FE) — Logic(BE) — DB ⇒ 3Tier 구조

- UI 

  - Binary File, Text File

  

### HTTP / Web

- 네트워크

  - LAN (랜)
  - WAN (완)
  - 네트워크들끼리 연결 (Internet)
  - 라우터 : 어떻게 연결할 것인가

- 현재 HTTP3 까지. 적용은 안 되어 있음.

- HTTP1을 기준으로 설명

  - TCP/IP — 인터넷 프로토콜 
    - TCP 특징 — 서로 연결을 한다.
    - listener(서버) / accept <= connect(클라이언트)
    - request / response
    - stateless / connectionless

- 서버 응답코드

  - 100번대 — 정보
  - 200번대 — 성공 (201 : Created)
  - 300번대 — 리다이렉트
  - 400번대 — Clinet 오류 (404 Not Found)
  - 500번대 — Server 오류 (Internal Server Error)

- 로이필 (HTTP) 창시자

  - REST 제안 
    - HATEOS 알아보기
    - URL / URI 
      - URI가 더 큰 개념으로 사용된다.
      - 자원의 위치를 나타낸다.
    - 자원에 대해서 CRUD만 하면 된다. 
      - 복수형 (Collection) 
        - Read — List
        - Create — new element
      - 단수형 
        - Read
        - Update
        - Delete - DELETE
      - CRUD 
        - READ — GET
        - Create — POST
        - Update — PUT(전부다), PATCH(부분만)
    - REST에서는 API에 대한 응답으로 하이퍼링크를 추가하는 것을 권장한다. (e.g. List를 요청하는 API에 대한 응답에 개별 자원을 사용할 수 있는 링크를 Response에 담아서 보낸다.)
    - GET, POST 등의 메소드 타입을 따르는 것은 관례이다. 개발자들 사이에서 정해진 규칙. 따르지 않으면 문제가 되는 것은 아니나 정해진 규칙을 따르는 것을 권장한다.
    - Login 
      - Create 
        - Session 생성을 위해
    - Logout 
      - Delete

- 문제들을 해결하기 위한 것들을 도메인이라고 한다.

  - 도메인 안에는 도메인 객체들이 존재한다.

  

### API

- 다양한 API가 존재한다. 비즈니스 별로 많은 API 존재 

  - /products-list
  - /products-detail

  

### 프로그래밍의 세계

- 웹에 대한 세계 
  - GET/products
  - POST/orders
  - GET/orders
  - `API 설계`
- 도메인에 대한 세계 
  - 상품, 장바구니, 주문 등...
  - `도메인 설계`
  - 만약 고양이 shop 을 만든다고 하면 어떤 것들이 필요할지 고민을 해보자 !

⇒ 각각을 이해하는 것이 다르다.

⇒ Back-end를 만들 때 웹과 도메인을 모두 만들어야 한다.



## Tip

- Webflux — node와 같은 반응형
- 크롬 개발자 도구의 네트워크를 자주 봐라. 
  - Headers가 핵심 
    - Request / Response
    - Request URL : 요청 url
    - request Method : GET, POST, PATCH, DELETE 등... 요청 메소드
- SOAP
- Micro Service 
  - REST
  - message broker
- DSL