 'use strict'

 /*
 접근방법
 private static 메소드는 public static 메소드처럼 인스턴스가 아닌 class 로부터 호출된다.
  그리고 private static 필드처럼 class 선언문 내부에서만 접근 가능하다. 
  private 인스턴스 메소드는 private 인스턴스 필드와는 다르게 class 인스턴스로부터 접근 가능하다.
  private static 메소드는 generator, async 그리고 async generator 함수가 될 수 있다.
  private getter 와 setter 또한 가능하다.
  (generator, async, async generator,  getter, setter 접근가능)

  this 를 사용할 때 예상치 못한 동작을 발생시킬 수 있다. (이는 this binding rule 이 적용되기 때문이다.) 
 */

//private
class User{
    #idNumber = '1234'; //#(샵): private field
    constructor(name, age, local){
        this.name = name;
        this.age = age;
        this.local = local;
    }
    introduce(){
        alert(`안녕하세요 ${this.local}에 사는 ${this.age}살, ${this.name}입니다.`);
    }
}

let user1 = new User('Tom', 39, "LA");
// console.log(user1.name);
user1.introduce();
console.log(user1.#idNumber);

//------------------------------------------------------------------------------------------------------
//static
class Mobility{
    static staticField = 'static';
    constructor(kind, mName, year){
        this.kind = kind;
        this.mName = mName;
        this.year = year;
    }
}

let mobility = new Mobility('승용차', 'v3', '2022');

console.log(mobility.staticField); // 생성자 객체에서는 확인할 수 없다.
console.log(Mobility.staticField); // 출력: static
