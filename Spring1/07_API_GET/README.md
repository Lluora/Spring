### API - GET
#### 배울 부분
<img src = https://user-images.githubusercontent.com/74857364/140905220-002455d7-2f11-4692-9460-7d15638594b8.png width="60%">

<br>
<br>

### API란?
**클라이언트 - 서버 간의 약속**

클라이언트가 정한대로 서버에게 요청(***Request***)을 보내면, 서버가 요구사항을 처리하여 응답(***Response***)을 반환

<br>
<br>

### REST
REST란, 주소에 명사, 요청 방식에 동사를 사용함으로써 의도를 명확히 드러냄을 의미

여기에 쓰이는 동사는 JPA 시간에 배운 CRUD를 지칭

A에 대해 생성(POST)/조회(GET)/수정(PUT)/삭제(DELETE) 요청을 하는 것

<details><summary>예시</summary>
<br>
  
  - GET /courses
→ 강의 전체 목록 조회 요청
- GET /courses/1
→ ID가 1번인 녀석 조회 요청
- POST /courses 
→ 강의 생성 요청
- PUT /courses/3 
→ ID가 3번인 녀석 수정 요청
- DELETE /courses/2 
→ ID 2번인 녀석 삭제 요청
</details>  
  
<br>
<br>

##### 에러 발생

![image](https://user-images.githubusercontent.com/74857364/140904954-a2cb76bd-c3ec-4b8d-8bb4-f5877754ecc4.png)

<br>

알고보니 IntelliJ 파일을 여러 개 띄워놔서 생긴 오류였다.

<br>
<br>

#### API - GET 실행결과
![image](https://user-images.githubusercontent.com/74857364/140905142-a3e6626f-47ed-4fc4-9f8d-8007223db1d5.png)


<br>
<br>

다음 페이지 [08_API_POST&PUT](https://github.com/Lluora/Spring/tree/main/Spring1/08_API_POST%26PUT)

