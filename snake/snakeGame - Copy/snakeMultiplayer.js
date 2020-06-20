
const cvs=document.getElementById("snake");
const ctx=cvs.getContext("2d");
document.write("<style>body{zoom:50%;}</style>");

const box =32;



const ground= new Image();
ground.src="img/groundModelat.png";


const foodImg= new Image();
foodImg.src="img/food.png";

const JalapenosImg= new Image();
JalapenosImg.src="img/ardeiIute.png";

const MarVerdeImg= new Image();
MarVerdeImg.src="img/marVerde.png";

const CiupercaImg= new Image();
CiupercaImg.src="img/ciuperca.png";

const BananaImg= new Image();
BananaImg.src="img/banana.png";

const PepeneImg= new Image();
PepeneImg.src="img/pepene.png";

//load audio files
const dead=new Audio();
const eat=new Audio();
const up=new Audio();
const left=new Audio();
const right=new Audio();
const down=new Audio();

dead.src="audio/dead.mp3"
eat.src="audio/eat.mp3"
up.src="audio/up.mp3"
right.src="audio/right.mp3"
left.src="audio/left.mp3"
down.src="audio/down.mp3"

//create the snake

let snake=[];

snake[0]={
	x: 9 * box,
	y: 10 * box
}
let snake2=[];

snake2[0]={
	x: 29 * box,
	y: 29 * box
}


// create the food

let food={
	x:Math.floor(Math.random()*17+1)*box,
	y:Math.floor(Math.random()*15+3)*box
}
let pepene={
	x:Math.floor(Math.random()*17+1)*box,
	y:Math.floor(Math.random()*15+3)*box
}
let jalapenos={
	x:Math.floor(Math.random()*17+1)*box,
	y:Math.floor(Math.random()*15+3)*box
}
let ciuperca={
	x:Math.floor(Math.random()*17+1)*box,
	y:Math.floor(Math.random()*15+3)*box
}
let banana={
	x:Math.floor(Math.random()*17+1)*box,
	y:Math.floor(Math.random()*15+3)*box
}
let marVerde={
	x:Math.floor(Math.random()*17+1)*box,
	y:Math.floor(Math.random()*15+3)*box
}

//create the score var
let contt=0;
let contt2=0;

//control snake
let d;
let de;
let snake1_mancat_banana=false;
let snake2_mancat_banana=false;

let last_x_snake1;
let last_y_snake1;
let last_x_snake2;
let last_y_snake2;


let antiBug=false;
let antiBug2=false;

let snake1_mancat_ciuperca=false;
let snake2_mancat_ciuperca=false;

let ciuperca_exista=false;
let contorCiuperca=0;

function CiupercaExista(){
	ciuperca_exista=true;
}
 
document.addEventListener("keydown", direction)
function direction(event){
let key = event.keyCode;
	console.log(snake2_mancat_ciuperca);
	console.log(snake1_mancat_ciuperca);
	if(snake2_mancat_ciuperca==false){
		if(antiBug == false){	
				if(key== 37 && d != "RIGHT"){
				d="LEFT";
				left.play();
				antiBug=true;
			}else if(key == 38 && d!="DOWN"){
				d="UP";
				up.play();
				antiBug=true;
			}else if(key == 39 && d!="LEFT"){
				d="RIGHT";
				right.play();
				antiBug=true;
			}else if(key == 40 && d!="UP"){
				d="DOWN";
				down.play();
				antiBug=true;
			}
		}
	}else{
		if(antiBug == false){	
				if(key== 39 && d != "RIGHT"){
				d="LEFT";
				left.play();
				antiBug=true;
			}else if(key == 40 && d!="DOWN"){
				d="UP";
				up.play();
				antiBug=true;
			}else if(key == 37 & d!="LEFT"){
				d="RIGHT";
				right.play();
				antiBug=true;
			}else if(key == 38 && d!="UP"){
				d="DOWN";
				down.play();
				antiBug=true;
			}
		}
	}
	if(snake1_mancat_ciuperca==false){
		if(antiBug2 == false){
			if(key== 65 && de != "RIGHT"){
				de="LEFT";
				left.play();
				antiBug2=true;
			}else if(key == 87 && de!="DOWN"){
				de="UP";
				up.play();
				antiBug2=true;
			}else if(key == 68 && de!="LEFT"){
				de="RIGHT";
				right.play();
				antiBug2=true;
			}else if(key == 83 && de!="UP"){
				de="DOWN";
				down.play();
				antiBug2=true;
			}
		}
	}else{
		if(antiBug2 == false){
			if(key== 68 && de != "RIGHT"){
				de="LEFT";
				left.play();
				antiBug2=true;
			}else if(key == 83 && de!="DOWN"){
				de="UP";
				up.play();
				antiBug2=true;
			}else if(key == 65 && de!="LEFT"){
				de="RIGHT";
				right.play();
				antiBug2=true;
			}else if(key == 87 && de!="UP"){
				de="DOWN";
				down.play();
				antiBug2=true;
			}
		}
	}

}
//check collision function
function collision(head,array){
	for(let i=0;i<array.length;i++){
		if(head.x==array[i].x && head.y==array[i].y){
		return true;
		}
	}
	return false;
}
function collision2(head,head2){
	
		if(head.x==head2.x && head.y==head2.y){
			return true;
		}
	return false;
}
function collision3(head,x,y){
	
		if(head.x==x && head.y==y){
			return true;
		}
	return false;
}




//draw eventhing to the canvas


let start=false;
let start1=false;

let banana_exista=false;
let contorBanana=0;

function BananaExista(){
	banana_exista=true;
}


function draw(){
ctx.drawImage(ground,0,0);
	
	for(let i=0;i<snake.length;i++){
		ctx.fillStyle= ( i == 0 )? "green" : "white";
		ctx.fillRect(snake[i].x,snake[i].y,box,box);
		
		ctx.strokeStyle="red";
		ctx.strokeRect(snake[i].x,snake[i].y,box,box);
	}
	
	for(let i=0;i<snake2.length;i++){
		ctx.fillStyle= ( i == 0 )? "red" : "grey";
		ctx.fillRect(snake2[i].x,snake2[i].y,box,box);
		
		ctx.strokeStyle="green";
		ctx.strokeRect(snake2[i].x,snake2[i].y,box,box);
	}
		if((food.x != snake[0].x && food.y != snake[0].y) || (food.x != snake2[0].x && food.y != snake2[0].y) || (food.x != banana.x && food.y !=banana.y)){
			ctx.drawImage(foodImg,food.x,food.y);
		}else{
		food={
				x:Math.floor(Math.random()*37+1)*box,
				y:Math.floor(Math.random()*35+3)*box
			}
	}		
		if(banana_exista==true && (banana.x!=food.x && banana.y!=food.y)){
			ctx.drawImage(BananaImg,banana.x,banana.y);
		}else{
			banana={
				x:Math.floor(Math.random()*37+1)*box,
				y:Math.floor(Math.random()*35+3)*box
			}
		}
		
		if(ciuperca_exista==true && (ciuperca.x!=food.x && ciuperca.y!=food.y) &&(ciuperca.x!=banana.x && ciuperca.y!=banana.y)){
			ctx.drawImage(CiupercaImg,ciuperca.x,ciuperca.y);
		}else{
			ciuperca={
				x:Math.floor(Math.random()*37+1)*box,
				y:Math.floor(Math.random()*35+3)*box
			}
		}
		
		
		
		//old head position 
		let snakeX= snake[0].x;
		let snakeY= snake[0].y;
		
		let snake2X=snake2[0].x;
		let snake2Y=snake2[0].y;
		
    
		last_x_snake1=snake[0].x;
		last_y_snake1=snake[0].y;
    
    
        last_x_snake2=snake2[0].x;
		last_y_snake2=snake2[0].y;
    
        //trece prin perete
		
		
		
		
		//which direction
		if(snake2_mancat_banana==false){	
			if( d == "LEFT") snakeX -= box;
			if( d == "UP") snakeY -= box;
			if( d == "RIGHT") snakeX += box;
			if( d == "DOWN") snakeY += box;
			
		}else{
			contorBanana--;
            
		}
    
		
		if(snake1_mancat_banana==false){
			if( de == "LEFT") snake2X -= box;
			if( de == "UP") snake2Y -= box;
			if( de == "RIGHT") snake2X += box;
			if( de == "DOWN") snake2Y += box;
		}else{
			contorBanana--;
		}
    if(contt>0)
        contt--;
    if(contt2>0)
        contt2--;
		
		if(contorBanana==0){
			snake1_mancat_banana=false;
			snake2_mancat_banana=false;
		}
		
		if(contorCiuperca>0)
			contorCiuperca--;
			
		if(contorCiuperca==0){
			snake1_mancat_ciuperca=false;
			snake2_mancat_ciuperca=false;
		}
		
		
		//if the snake eats the food
    if(contt==0)
		if(snakeX== food.x && snakeY ==food.y){
			
			eat.play();
			food={
				x:Math.floor(Math.random()*37+1)*box,
				y:Math.floor(Math.random()*35+3)*box
			}
			// we don't remove the tail
			antiBug=false;
		} else{//daca mananca banana
			if(snakeX== banana.x && snakeY ==banana.y){
				
				eat.play();
				
				banana={
					x:Math.floor(Math.random()*37+1)*box,
					y:Math.floor(Math.random()*35+3)*box
				}
				
				banana_exista=false;
				snake1_mancat_banana=true;
				
                contorBanana=15;
                contt2=17;
				
				
				
			}else{
				if(snakeX== ciuperca.x && snakeY ==ciuperca.y){
					eat.play();
				
				ciuperca={
					x:Math.floor(Math.random()*37+1)*box,
					y:Math.floor(Math.random()*35+3)*box
				}
					snake1_mancat_ciuperca=true;
					ciuperca_exista=false;
					contorCiuperca=40;
				}else{
					//remove the tail
                    if(snake2_mancat_banana==false)
					snake.pop();
					antiBug=false;
					}
			}
		}
		
		if(snake2X== food.x && snake2Y ==food.y){
			
			eat.play();
			food={
				x:Math.floor(Math.random()*37+1)*box,
				y:Math.floor(Math.random()*35+3)*box
			}
			// we don't remove the tail
			antiBug2=false;
		} 
		else{//daca mananca banana
			if(snake2X== banana.x && snake2Y ==banana.y){
				
				eat.play();
				
				banana={
					x:Math.floor(Math.random()*37+1)*box,
					y:Math.floor(Math.random()*35+3)*box
				}
				banana_exista=false;
				snake2_mancat_banana=true;
				contorBanana=15;
                contt=17;
				
			}else{
				if(snake2X== ciuperca.x && snake2Y ==ciuperca.y){
					eat.play();
				
				ciuperca={
					x:Math.floor(Math.random()*37+1)*box,
					y:Math.floor(Math.random()*35+3)*box
				}
					snake2_mancat_ciuperca=true;
					ciuperca_exista=false;
					contorCiuperca=40;
				}else{
					//remove the tail
                    if(snake1_mancat_banana==false)
					snake2.pop();
					antiBug2=false;
					}
				}
		}
				
		
		
		
		
		//add new Head
    
		let newHead = {
			x: snakeX,
			y: snakeY
		}
        
        if(contt==0)
		if(collision(newHead,snake)){
			clearInterval(game);
			dead.play();
			console.log("s-a mancat snake 1 singur");
		}
    
		let newHead2 = {
			x: snake2X,
			y: snake2Y
		}
        
        
        if(contt2==0)
		if(collision(newHead2,snake2)){
			clearInterval(game);
			dead.play();
			console.log("s-a mancat snake 2 singur");
		}
    
		if(collision(newHead2,snake)){
			clearInterval(game);
			dead.play();
			console.log("castiga snake 1");
		}
		if(collision(newHead,snake2)){
			clearInterval(game);
			dead.play();
			console.log("castiga snake 2");
		}
		if(collision2(newHead,newHead2)){
			clearInterval(game);
			dead.play();
			console.log("e remiza");
		}
		if(collision3(newHead,last_x_snake2,last_y_snake2)){
			clearInterval(game);
			dead.play();
			console.log("e remiza");
		}
		if(collision3(newHead2,last_x_snake1,last_y_snake1)){
			clearInterval(game);
			dead.play();
			console.log("e remiza");
		}
		if(snakeX < box || snakeX > 38 * box || snakeY<3*box
		|| snakeY > 38*box ){
			clearInterval(game);
			dead.play();
		}	
		if(snake2X < box || snake2X > 38 * box || snake2Y<3*box
		|| snake2Y > 38*box ){
			clearInterval(game);
			dead.play();
		}	
		
		
		
		//game over 
		
    
    
		
          
           
    
        if(contt<2 ){
        snake.unshift(newHead);
        }
    
         if(contt2<2){
        snake2.unshift(newHead2);
            
         }
    


}

//call draw function every 100 ms
let game = setInterval(draw,100);

if(snake1_mancat_banana==false && snake2_mancat_banana==false)
		setInterval(BananaExista,1000);
if(snake1_mancat_ciuperca==false && snake2_mancat_banana==false)
		setInterval(CiupercaExista,1000);