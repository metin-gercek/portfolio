var myCar = {
    make: 'Ford',
    model: 'Mustang',
    year: 1969
};

function showProps(obj, objName) {
    var result = ``;
    for (var i in obj) {
      // obj.hasOwnProperty() is used to filter out properties from the object's prototype chain
      if (obj.hasOwnProperty(i)) {
        result += `${objName}.${i} = ${obj[i]}\n`;
      }
    }
    return result;
}

function Car(make, model, year) {
  this.make = make;
  this.model = model;
  this.year = year;
}
function Person(name, age, sex) {
  this.name = name;
  this.age = age;
  this.sex = sex;
}
function Car(make, model, year, owner) {
  this.make = make;
  this.model = model;
  this.year = year;
  this.owner = owner;
}

var newCar = new Car('Eagle', 'Talon TSi', 1993);
var kenscar = new Car('Nissan', '300ZX', 1992);
var vpgscar = new Car('Mazda', 'Miata', 1990);
var rand = new Person('Rand McKinnon', 33, 'M');
var ken = new Person('Ken Jones', 39, 'M');
var car1 = new Car('Eagle', 'Talon TSi', 1993, rand);
var car2 = new Car('Nissan', '300ZX', 1992, ken);

console.log(myCar);
console.log(typeof myCar);
console.log(showProps(myCar, "myCar"));
console.log(myCar["make"]);
console.log(car1);
console.log(car1.owner.name);
console.log(car2.owner.age);