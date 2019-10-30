## Day 5

## 오늘의 키워드

- Object-Object Mapping
    - [https://github.com/DozerMapper/dozer](https://github.com/DozerMapper/dozer)
    - Dozer 사용하는 가장 큰 이유
        - DTO는 전부 getter/setter가 있다.
        - Dozer를 사용하면 reflection을 이용하여 DTO < - > Entity 매핑이 가능하다.
        - 분리된 DTO, Entity에 대해서 너무 신경을 많이 쓰지 말자. 내부적으로 자동으로 변환 해주니까 !
    - modelMapper와 기능은 동일하다. 엔티티 매퍼 변환
- HTTPie
- GET, POST API 추가

## Mapper

- [https://github.com/DozerMapper/dozer](https://github.com/DozerMapper/dozer)
- DTO < - > Entity
    - 내부에 있는 Collection에 대한 변환도 자동으로 해준다
- 매핑은 너무 과하게 하지 않는 것이 좋다.
- UI 레이어에서 Mapper를 이용하여 Entity와 DTO를 매핑해준다.

## httpie

- [https://httpie.org/](https://httpie.org/)
- curl 과 비슷한 기능을 한다.
- API End Point 확인

## 상품 추가

- GET localhost:8080/products
- POST [localhost:8080/products](http://localhost:8080/products) name=낚시대 maker=달랩 price=5000

## 오늘의 Tip

- Spring Data REST
    - Repository만 만들고, End Point만 있으면 CRUD가 자동으로 생성된다. Controller를 직접 구현하지 않아도 된다.
    - [https://spring.io/guides/gs/accessing-data-rest/](https://spring.io/guides/gs/accessing-data-rest/)
    - Microservice에서 많이 사용한다.
    - Pivotal 최신 경향
        - Cloud Native, Microservice
- requests 알아보기
- 스프링에 의존하지 않고 테스트 코드를 작성해야 한다. Controller 레이어를 제외하고는 순전히 자바로 테스트 코드를 작성해야 한다. ⇒ 스프링의 철학

## 오늘의 Question

1. JPA 구현체 안에는 내부적으로 쿼리가 구현되어 있을텐데, 이것들에 대한 예외 처리는 어떤식으로 하는지 궁금합니다. (예를들면 save()를 호출하였으나, 제대로 insert가 실행되지 않고 예외가 발생하는 경우)

⇒ 에러가 납니다. Transactional로 Application Layer로 범위를 한정하고 있고, JPA와 무관하게 예외를 처리하고 싶은 곳에서 처리하면 됩니다. 대부분은 웹에서 에러에 대한 메시지를 사용자에게 보여주죠(=UI).

2. DTO와 Entity를 구분하는 가장 큰 이유를 알고 싶다.

3. Integer로 사용하는 이유는 ? 

4. Integer

- int형 primitive 타입으로 잘 사용하지 않는다. Integer를 쓰면 객체 타입으로 사용할 수 있기 때문에 null 처리를 포함한다.

## 회고

- 소감
    - 재밌었다.
- 오늘 수업에서 좋았던 점
    - 매퍼를 이용해 Entity < - > DTO 매핑하는 것을 알게 되어 좋았다.
    - Model Mapper를 사용해봤는데 새롭게 Dozer에 대해서 알게되어서 좋았다.
- 오늘 수업에서 아쉬웠던 점
    - 이전 수업에서 구현했던 부분을 잊어버렸다
