## Day 6

## 오늘 수업에서 기대하는 점

- request 유효성 체크와 에러를 잡으시는 방법에 대해 기대하고 있다.

## 오늘의 키워드

- 상품 CRUD
- Validation
- Error

## PATCH

- 수정 시 모든 데이터를 request에 그대로 넘긴다.
    - 전체 덮어쓰기 (PUT)
- 수정 시 변경하고자 하는 데이터만 수정한다. (PATCH)
- 정성적인 PATCH 처리
    - DTO를 Application 레이어로 보내고 싶지 않다. update메소드 안에 dto.getName(), dto.getMaker() 파라미터로 넘기는 것
    - DTO를 활용해도 되고 수정을 위한 객체를 따로 둔다. DTO에 웹에 관련된 데이터가 많은 경우가 아니면 Application 레이어로 밀어넣어도 된다.
    - Update 시에만 DTO를 Application 레이어로 전달한다.

## PATCH 고민거리

- Application 레이어에서 DTO를 받았는데, setter로 Domain까지 접근할 것인가 ?
    - 이건 결정내리기 나름이다.

JPA 에서는 update에 대한 save를 할 필요가 없다. Transactional을 걸어두면 자동으로 인식해서 커밋 처리를 한다.

## DELETE

- soft delete
    - delete flag를 사용하여 처리 true/false
    - 사용자가 회원 탈퇴를 하면, 개인 정보가 모두 삭제되어야 한다. 하지만 주문정보 등은 지우면 안 되고 특정 기간동안 살려두어야 한다. DB에서 계정 정보를 삭제하면 참조 걸려있는 경우 오류가 발생할 수 있기 때문에 여러가지를 고민해야 한다.

## JPA

- 영한님의 JPA 책을 꼭 보자

## Setter

- 뮤테이터, 억세서
- Setter 개별적으로 쓰면 엔티티를 외부 객체에서 맘대로 변경한다. 객체는 본연의 책임을 잃어버린다.
    - DTO는 의도적으로 외부에서 값을 변경하도록 만들었다
    - DTO는 다른 객체에 의해 끌려다니는 수동적인 역할.
    - 서적 도메인주도 설계 구현 ([https://book.naver.com/bookdb/book_detail.nhn?bid=10382647](https://book.naver.com/bookdb/book_detail.nhn?bid=10382647))
- setter는 외부에서 내가 너를 바꿀게 라는 의미.

## JOOQ

- java SQL Builder

## 유효성 체크

- 프론트와 백 모두 한다.
- 프론트에서도 하지만 혹시라도 해킹을 당하거나 예외 상황이 생길 수 있기 때문에 백에서도 처리를 해준다.
- 422 (Unprocessable Entity)
    - 처리할 수 없는 엔티티
- Pattern
- REGEX (Regular Expression)

## 회고

- 소감
    - 기존 알던 것들을 정리 할 수 있었다.
- 좋았던 점
    - 유효성과 예외 처리를 배울 수 있었다.
- 아쉬웠던 점
    - 수정 쪽 로직에 대해 정확히 이해하지 못 한 것 같아 아쉽다. PUT, PATCH
- 공부해야 할 점
    - 스타트업에서는 왜 Java를 쓰지 않는가 ?
    - 그렇다면 Java는 대규모 프로젝트에서는 왜 사용하는가 ?

## Mock 과 MockBean 비교하기
