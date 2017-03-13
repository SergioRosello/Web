function Animal(name, eyeColor) {
	this.name = name;
	this.eyeColor = eyeColor;
};

function Cat(name, eyeColor){
	Animal.call(this, name, eyeColor);

};

function Dog(name, eyeColor){
	Animal.call(this, name, eyeColor);

};

Animal.prototype.getName = function(){
	console.log(this.name);
};

Animal.prototype.getEyeColor = function(){
	console.log(this.eyeColor);
};

Animal.prototype.toString = function() {
	return this.name + " " + this.eyeColor;
};




Cat.prototype = new Animal();

Cat.prototype.speak = function() {
	return "meow";
};

Cat.prototype.toString = function(){
	return Animal.prototype.toString.call(this);
};



Dog.prototype = new Animal();

Dog.prototype.speak = function() {
	return "woof";
};

Dog.prototype.toString = function(){
	return Animal.prototype.toString.call(this);
};

window.onload = function(){
	var cat = new Cat("Siro", "brown");
	var dog = new Dog("Niza", "brown");

	console.log(cat.toString());
	console.log(dog.toString());

	console.log(cat.speak());
	console.log(dog.speak());
};
