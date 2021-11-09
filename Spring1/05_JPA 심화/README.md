## JPA 심화

### CRUD
#### CRUD란? 정보관리의 기본 기능
👉🏻 생성 (Create)  

👉🏻 조회 (Read)

👉🏻 변경 (Update)

👉🏻 삭제 (Delete)

<br>
<br>
<br>

#### 데이터 저장하기 (Create) & 조회하기 (Read)
- Repository의 save와 findAll 등을 이용

<br>
<br>
<br>

#### Service 의 개념
- 스프링의 구조는 3가지 영역으로 나눌 수 있다.    

1. **Controller** : 가장 바깥 부분, 요청/응답을 처리함.

2. **Service** : 중간 부분, 실제 중요한 작동이 많이 일어나는 부분

3. **Repo** : 가장 안쪽 부분, DB와 맞닿아 있음.

** Update는 Service 부분에 작성한다.   

<br>
<br>
<br>

#### 데이터 변경하기(Update)
<img src = https://user-images.githubusercontent.com/74857364/140794917-4cf746ef-89fd-4310-84ed-956748bd24c3.png width="60%">

<br>
<br>
<br>

#### 데이터 삭제하기(delete)
<img src = https://user-images.githubusercontent.com/74857364/140804410-d4a108e8-73a4-4315-92d8-0394dc779dcb.png width="50%">

<br>

##### where id=?   
 `?` 가 나오는 이유는 유동적인 값이기 때문이다.            
 
값이 상황에 따라 1이 될수도 있고 2가 될수도 있고 계속 바뀔 수 있는 값이다. (고정된 값이 아니다.)

<br>
          
사용자가 바뀌거나 DB에 데이터가 많거나 이유는 많다.     

lecture 클래스의 id가 1부터 시작할 수도 있고 10부터 시작할 수도 있다.          

<br>
                    
변할 수 있는 부분에는 `?` 가 다 들어간다.                  

여기서는 조건만 변해서 `?` 한 것이다.                         

그래서 쿼리를 실행하기 전에는 어떤 값이 들어오는지 몰라서 `?` 로 표시하는 것이다.      

<br>
<br>
<br>

##### H2 실행화면
![image](https://user-images.githubusercontent.com/74857364/140805230-2e7dbb74-a456-498e-83c5-8d2c785f51e0.png)

<br>
<br>
<br>

---

<br>

#### jpa 로그 보기 좋기 보기
<br>

`application.properties` 에 아래 코드를 입력하고 다시 실행해보면 로그에 찍히는 쿼리 예쁘게 들여쓰기 해주는 코드이다.

```
spring.jpa.properties.hibernate.format_sql=true
```
<br>

<img src = https://user-images.githubusercontent.com/74857364/140802391-f17118b3-3d49-48ff-9a5e-e19389b744ef.png width="50%">

<br>
<br>
<br>

이번엔 아래 옵션을 `application.properties` 에 넣어본다.

<br>

#### sql 더 자세히 보여주는 옵션
```
logging.level.org.hibernate.type.descriptor.sql=trace
```
<br>

<img src = https://user-images.githubusercontent.com/74857364/140803551-53770ad5-64bb-48cb-be87-2032809cd63a.png width="50%">

<br>
<br>
<br>

#### 이번엔 2개를 같이 넣어본다.

```
spring.jpa.properties.hibernate.format_sql=true
logging.level.org.hibernate.type.descriptor.sql=trace
```
<br>

<img src = https://user-images.githubusercontent.com/74857364/140803978-1b8341a9-9e8e-4daa-99e4-b9b0ded61eb1.png width="50%">

<br>

2개 추가하면 sql을 자세히 보여주고 이쁘게 보여주는 것이다.

<br>
<br>
<br>

---


#### 로그 분석하기

<br>

![image](https://user-images.githubusercontent.com/74857364/140805643-f34c1f08-3d48-4343-95fc-5abd7e58534e.png)

맨 마지막 코드를 보면         
`2021-11-09 03:16:50.519 TRACE 43036 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [BIGINT] - [1]`

라고 나와있다.            

<br>

이 로그의 의미는 [1] 번째 ? 에 [BIGINT] 자료형인 데이터 [1] 이 들어갔다라는 뜻이다.     

`Hibernate: delete from lecture where id=1`  이 실행 된 것이다.

<br>
<br>
<br>

#### id로 로그가 나오는 이유?

id로 로그가 나오는 이유가 뭘까??  

이름도 있고 튜터도 있고...

이것을 알려면 어떤 데이터를 유일하게 지우려면 데이터가 중복이 되면 안된다는 것을 알아야 한다.

내가 원하는 데이터를 지울려면 그 데이터를 유일하게 식별할 수 있는 기본키가 필요하다.

👉🏻 ***primary key***!

중복도 되면 안되고, 널값이 들어가면 안된다. 그래서 삭제를 할 때 기본키를 가지고 지우는 것이다.

<br>
<br>
<br>

##### 근데 id가 아닐 수도 있지 않을까?

사용자가 id 대신 다른 값을 primary로 설정하면 id 대신 다른 값으로 바뀌는 걸까? 로그에서?

<br>
<br>

###### Lecture.java
![image](https://user-images.githubusercontent.com/74857364/140910503-a712909e-1a7e-4545-894e-0e3f22c9c2b6.png)

<br>
<br>

Lecture 클래스에 id Annotation에 들어가 있다.

id 멤버변수를 `@ID` 로 설정해서 기본키로 설정된 것이다.  

<br>
<br>
<br>

##### 그럼 다른 값으로 주려면 예를 들어 전화번호라면 @phonenumber 라고 하면 되는건가??
<br>

❌ 아니다.  아래와 같이 설정한다.
```java
@id
private String phone; 
```


👉🏻 `@id` 라는 ***annotation***이 **primary key** 자체라고 보면 되는 것이다 !!

<br>
<br>
<br>

##### bigint 자료형은 int랑 다른건가?

다르다. BIGINT는 더 크고 많다.

int는 21억까지 표현이 가능해서 21억이 지나가면 표현을 못한다.

그래서 big인가보다 😆 ㅋㅋㅋㅋ

더 자세히 알고싶으면 데이터를 2개 넣고 ***delete*** 하면 새로운 결과를 확인할 수 있다.

<br>
<br>
<br>

##### 해석 
deleteall이라서 다 지워지는데 1만 있어서 log에 1만 뜬 것이다.

그래서 데이터를 2도 집어넣고 지워보면 이해가 더 갈 것이다.

delete는 다 지우는 것이기 떄문에 create를 수정해야된다.

데이터를 보니깐 데이터가 하나 생길 때 마다 id 값이 하나 증가한다.

`lectureRepository.save(new Lecture("프론트엔드의 꽃, 리액트", "임민영"));`

이 코드의 값만 바꾸면서 추가하면 된다.

<br>
<br>
<br>

---

#### Spring2Application.java

Spring2Application.java에서 delete 실행 코드에

![image](https://user-images.githubusercontent.com/74857364/140907646-a7f77f11-bb42-4dcc-b0cc-f204c85fa4f4.png)

동그라미 표시된 부분을 보면 1L이라고 적혀있다.  처음에 이게 뭔지 몰라서 리터(L)라고 읽었다..😅

<br>
<br>
<br>

LectureService 메소드 정의부분을 보면

<img src = https://user-images.githubusercontent.com/74857364/140909495-dc431e6d-3f18-442c-a871-b075a49668eb.png width="40%">
<br>
<br>

update 함수의 첫번째 파라미터 데이터 타입은 무엇일까?
👉🏻 ***LONG***

그럼 코드에서 1은 무슨형일까?
👉🏻***INT***

<br>
<br>

▷ 파라미터는 ***long*** 형을 받는데, 1은 ***int***형이니까 데이터 타입이 서로 맞지 않는다.

그래서 숫자 1에다가 **L**을 붙임으로써 숫자1을 long 형으로 바꿔준 것이다.


<br>
<br>
<br>

이 전 페이지 >> [03_JPA](https://github.com/Lluora/Spring/tree/main/Spring1/03_JPA)

다음 페이지 >> [06_Lombok, DTO](https://github.com/Lluora/Spring/tree/main/Spring1/06_Lombok%2C%20DTO)
