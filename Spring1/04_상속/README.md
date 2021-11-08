## 생성일자, 수정일자
### 상속이란?
"클래스의 상속"이라는 개념. "이미 만들어둔거 가져다 쓰자!" 라고 선언하는 것

<br>

##### Tutor extends Person 과 같이 쓸 수 있다.
```java
class Person {
    private String name;
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Tutor extends Person {
	private String address;
	// Person 클래스를 상속했기 때문에,
	// name 멤버변수와 getName() 메소드를 가지고 있습니다.
}
```
<br>

##### 테스트
```java
public class Prac {
    public static void main(String[] args) {
        Tutor tutor = new Tutor();
        tutor.setName("홍길동");
        System.out.println(tutor.getName());
    }
}
```

<br>

👉🏻 DB 기본 중의 기본은, "생성일자"와 "수정일자"를 필드로 가지는 것이다.

<br>

##### `http://localhost:8080/h2-console` 접속해서 확인해보기

![image](https://user-images.githubusercontent.com/74857364/140781824-cce01778-ceab-4238-b348-13327e7d9eff.png)



