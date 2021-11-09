## JPA 시작하기

<br>

##### 배울 부분
<img src = https://user-images.githubusercontent.com/74857364/140776142-717cf583-915a-4d7f-8ef3-dee51bc631be.png width="60%">

<br>

***JPA***는, SQL을 쓰지 않고 데이터를 생성, 조회, 수정, 삭제할 수 있도록 해주는 번역기이다.

<br>

#### JPA가 없다면?
https://www.baeldung.com/spring-jdbc-jdbctemplate

자바 짜다가 갑자기 SQL 짜고, 그걸 잘 맞추어 넣어야 한다.

<br>

#### JPA가 있다면?
https://spring.io/guides/gs/accessing-data-jpa/

<br>
<br>

#### Interface 란?
인터페이스는 클래스에서 멤버가 빠진, 메소드 모음집이라고 보면 된다.

<br>
<br>

### JPA 사용해보기

##### SQL이 보이도록 application.properties 세팅
```
spring.jpa.show-sql=true
```

<br>

##### 웹 콘솔 접속해서 확인해보기
###### 웹 콘솔 접속 (`http://localhost:8080/h2-console`)
```
 SELECT * FROM lecture;
```

<br>
<br>

다음 페이지 >> [04_상속](https://github.com/Lluora/Spring/tree/main/Spring1/04_%EC%83%81%EC%86%8D)

