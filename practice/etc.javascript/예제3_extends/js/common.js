 'use strict'
/*
class Test{
    constructor(num){
        this.num = num;
    }
    popupFunc(){
        alert('this is popup');
    }
}

let testBox = new Test("hi");
console.log(testBox.num);
console.log(testBox.popupFunc());
*/
//------------------------------------------------------------------------------------
class Shape{
    static circleRate = 3.14;
    constructor(width, height, color){
        this.width = width;
        this.height = height;
        this.color = color;
    }
    inputDraw(a, b){
        console.log(`${a}:${b}`);
    }
    draw(){
        console.log("도형그리기");
    }
    getArea(){
        console.log(`${this.width}`)
    }
}

let triClass = new Shape(10,20,'blur');

class Rectangle extends Shape{}
class Triangle extends Shape{
    draw(){
        console.log("삼각형 그리기")
        super.draw(); // 오버라이딩 시 해당함수내에서 부모함수 불러오기
    }
    getArea(){
        console.log(`삼각형의 넓이:`+(this.width * this.height) /2);
    }
}
// triClass.getArea();
// console.log(shapebox.width);
// console.log(shapebox.height);
// console.log(shapebox.color);
// shapebox.inputDraw(25, 10);
// shapebox.draw();
// shapebox.getArea();

//-----------------------------------------------------------------------------------------------------------
class Round {
    constructor(width, height, color){
        this.width = width;
        this.height = height;
        this.color = color;
    }
    round(){
        console.log("원형도형 그리기")
    }
}

let rect = new Rectangle(5, 8, 'red');
let trian = new Triangle(5, 8, 'blue');
let round = new Round(5, 8, 'yellow');

rect.getArea();
console.log(rect.width + rect.height);
console.log(rect.color);
trian.getArea();
console.log(trian.width + rect.width);
console.log(rect.color + trian.color);
