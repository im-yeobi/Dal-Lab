## Day 8
마지막 날

## 기대하는 점

- 오늘이 마지막인데 어떻게 마무리 할지

## Authorization

- JWT로 Access Token 생성하여 반환한다.
- BasicAuthenticationFilter
    - 필터 설정
- AbstractAuthenticationToken
    - 확장하여 UserAuthentication 객체 생성하여 관리한다.
- @EnableGlobalMethodSecurity(prePostEnabled = true)
    - @PreAuthorize("isAuthenticated()")
        - 컨트롤러 메소드 위에 애노테이션 정의해주면 해당 API에 대해서는 인증을 검증한다.
        - 인증 있어야만 API 사용 가능하다.

## Filter

- 필터를 이용해서 Access Token을 검증한다.

## Front 붙이기

- npm init
- npx serve, npm live-server
- axios 의존성 추가
- webpack

## Build

- 단독실행
    - ./gradlew bootRun
    - 실제로는 Jar 파일을 넘겨준다. ./gradlew bootJar
    - Spring Boot는 기본적으로 내장 톰캣이 있음
    - java -jar {빌드파일}

## Docker

- 컨테이너 기술
- docker-compose
    - 환경변수
