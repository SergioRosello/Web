function Animal(name, eyeColor) {
	this.name = name;
	this.eyeColor = eyeColor;
};

function Cat(){
	Animal.call(this, name, eyeColor);

};

function Dog(){
	Animal.call(this, name, eyeColor);

};

Animal.prototype.getName = function(){
	return this.name;
};

Animal.prototype.getEyeColor = function(){
	return this.eyeColor;
};

Animal.prototype.toString = function() {
	return this.name + " " + this.eyeColor;
};

Cat.prototype.speak = function() {
	return "meow";
};

Dog.prototype.speak = function() {
	return "woof";
};


window.onload = function(){
	var cat = new Cat("Siro", "brown");
	var dog = new Dog("Niza", "brown");

	cat.toString();
	dog.toString();

	cat.speak();
	dog.speak();
}
