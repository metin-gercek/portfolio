var right, life;
var guess, count = 0;
var number = Math.floor((Math.random()*10)+1);
life = Number(prompt('How many times will you guess?'));
right = life;

while(right>0) {
    right--;
    count++;
    guess = Number(prompt('Enter a number:'));

    if(number == guess) {
        console.log(`Well Done! You guessed ${count}. time`);

        console.log(`Point: ${100 - (100/life)*(count-1)}`);
        break;
    } else if (number > guess) {
        console.log('go up!');
    } else {
        console.log('go down!');
    }

    if(right==0) {
        console.log('No rights left! Number is: '+number);
    }

}