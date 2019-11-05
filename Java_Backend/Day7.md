## Day 7

## 오늘 수업에서 기대하는 점

- 인증/인가, Spring Security

## 오늘 수업 내용

- Access Token
    - 인증/인가
- JWT
- Spring Security

## 궁금한 점

- Dozer를 사용할 때, DTO와 1대1 대응이 되지 않는 경우에는 어떻데 하는가 ?

## Access Token

- 인증(Authentication) — 토큰 발급
    - 로그인 할 때마다 토큰 받는 경우
    - API 사용을 위한 토큰 최초 1회 발급
- 인가(Authorization) — 토큰 확인

## JWT (Json Web Tokens)

[JWT.IO](https://jwt.io/)

[Gain control over your JWTs](https://www.jsonwebtoken.io/)

- 기본 세션을 사용하면, 세션을 발급 받아 세션 id를 사용한다.
- 최근에는 세션 id를 암호화해서 쿠키에 넣는다.
- JWT 앞부분은 암호화, 뒷부분은 signature
    - signature은 조작이 안 됐음을 보장해준다.

## Hash md5

- 비밀번호 암호화 (단방향, 복호화 불가능)
- passwordEncoder.encode
- passwordEncoder.matches
    - Password ⇒ Hash Value와 비교
    - 암호화된 비밀번호와 동일한지 체크

## Spring Security

- 기본 설정으로 무조건 인증을 하도록 되어 있다.

## Q.

- 수업 중에 Spring Security 설정에서 해제한 것들은 실제로 서버 운영할 때도 필요 없는 것인가 ?
    - 참고
        - MDN CORS, CSRF
- 세션을 따로 사용하지 않는 이유는 ?
    - JWT를 사용하면 세션키를 JWT에서 관리하고, 세선 스토어가 따로 필요하지 않다. 쿠키는 프론트엔드에서 관리한다.
    - JWT를 사용하여 세션에 대한 검증을 따로 하지 않아도 된다.
- JWT 토큰의 수명 설정은 보통 어떻게 하는가 ?
    - 아예 설정하지 않거나, 1년으로 잡는다.
    - 아샬님의 경우에는 Redis에 JWT 토큰 정보를 저장해둔다.

## 회고

- 소감
    - 새로운 걸 배웠다.
- 좋았던 점
    - JWT에 대해 알 수 있어서 좋았다.
- 아쉬웠던 점
    - Spring Security에 대해 잘 알고 있지 못했던 점이 아쉽다.
