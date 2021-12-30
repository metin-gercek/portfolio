/*
    Demo : Creating Objects

    ** Define the Employee constructor that takes name and salary.

    ** Create the function that calculates the total salary and total tax amount received so far in the year.
       tax brackets
         ** 20% tax up to 20,000
         ** 25% tax up to 30,000
         ** 27% tax after 30,000
    ** 
*/

function Employee(name,salary){

    if (!(this instanceof Employee)){
        return new Employee(name,salary);
    }
    this.name = name;
    this.salary = salary;
}

Employee.prototype.calculateSalary = function(){
    var month = new Date().getMonth()+1;
    var tax = 0;
    var total=this.salary*month;    

    if (total<=20000){
        tax = total*0.2;
    }else if(total >20000 && total<=30000){
        tax = total * 0.25;
    }else{
        tax = total * 0.3;
    }

    return {
        tax : tax,
        paid : total - tax 
    }
}

var emp1 = Employee('Ahmet',3000);
var emp1_salary = emp1.calculateSalary();

console.log(`Employee named ${emp1.name}  received a salary of €${emp1_salary.paid} with a tax deduction of €${emp1_salary.tax} in total`);
console.log(emp1_salary);


var emp2 = new Employee('Matti',4000);
var emp2_salary = emp2.calculateSalary();

console.log(`Employee named ${emp2.name}  received a salary of €${emp2_salary.paid} with a tax deduction of €${emp2_salary.tax} in total`);
console.log(emp2_salary);