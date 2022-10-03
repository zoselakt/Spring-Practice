'use strict'

function Product(name, price){
    this.name = name;
    this.price = price;
    this.getProduct = function(){
        console.log('get product');
    }
}

let pd = new Product('사과', 5000);
// console.log(pd.name); // 사과
// console.log(pd.getProduct); //함수출력
// console.log(pd.getProduct()); // get product , undefined 두개값출력
// pd.getProduct() // get product


//상속받아 출력
// function Food(name, price){
//     Product.call(this , name, price);
//     this.category = 'food';
// }

// let bread = new Food('chocobread', 5000); // 객체 상속
// console.log(bread.category);

//
function bakery (name, price){
    this.name = name;
    this.price = price;
    Product.call(this, name, price)
    this.getProduct = function(){
        alert(`bakery 카테고리에서 구매하신 상품은 ${name}이고 상품의 금액은 ${price} 원 입니다.`)
    }
}

let bake = new bakery("cheese-bread", 7000);
console.log(bake.name);
console.log(bake.price);
console.log(bake.getProduct());