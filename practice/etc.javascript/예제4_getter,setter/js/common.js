 'use strict'

/*
접근자 프로퍼티엔 설명자 value와 writable가 없는 대신에 get과 set이라는 함수가 있습니다.

따라서 접근자 프로퍼티는 다음과 같은 설명자를 갖습니다.

get – 인수가 없는 함수로, 프로퍼티를 읽을 때 동작함
set – 인수가 하나인 함수로, 프로퍼티에 값을 쓸 때 호출됨
enumerable – 데이터 프로퍼티와 동일함
configurable – 데이터 프로퍼티와 동일

프로퍼티는 접근자 프로퍼티(get/set 메서드를 가짐)나 데이터 프로퍼티(value를 가짐) 중
 한 종류에만 속하고 둘 다에 속할 수 없다는 점을 항상 유의하시기 바랍니다.
*/

 class User{
     constructor(name, age, local){
        this.name = name;
        this.age = age;
        this.local = local;
     }
     introduce(){
         alert(`안녕하세요 ${this.local}에 사는 ${this.age}살, ${this.name}입니다.`);
     }
     get age(){
         return this.age;
     }
     set age(value){
        this._age = value < 0 ? 0 : value; 
    }
 } 
 let intro = new User("홍길동", 20,"대구");