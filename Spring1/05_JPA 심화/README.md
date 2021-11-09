## JPA 심화

### CRUD
#### CRUD란? 정보관리의 기본 기능
👉🏻 생성 (Create)  

👉🏻 조회 (Read)

👉🏻 변경 (Update)

👉🏻 삭제 (Delete)

<br>
<br>

#### 데이터 저장하기 (Create) & 조회하기 (Read)
- Repository의 save와 findAll 등을 이용

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

#### 데이터 변경하기(Update)
<img src = https://user-images.githubusercontent.com/74857364/140794917-4cf746ef-89fd-4310-84ed-956748bd24c3.png width="60%">

<br>
<br>

#### 데이터 삭제하기(delete)
<img src = https://user-images.githubusercontent.com/74857364/140804410-d4a108e8-73a4-4315-92d8-0394dc779dcb.png width="50%">

<br>
                    
사실 `?` 가 나오는 이유는 유동적인 값이기 때문이다.            
값이 상황에 따라 1이 될수도 있고 2가 될수도 있고 계속 바뀔 수 있는 값이다.        
고정된 값이 아니다.           
          
사용자가 바뀌거나 DB에 데이터가 많거나 이유는 많다.     
lecture 클래스의 id가 1부터 시작할 수도 있고 10부터 시작할 수도 있다.          
                    
변할 수 있는 부분에는 `?` 가 다 들어간다.                    
여기서는 조건만 변해서 `?` 한 것이다.                               
그래서 쿼리를 실행하기 전에는 어떤 값이 들어오는지 몰라서 ? 로 표시하는 것이다.      

<br>
<br>

##### H2 실행화면
![image](https://user-images.githubusercontent.com/74857364/140805230-2e7dbb74-a456-498e-83c5-8d2c785f51e0.png)

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

