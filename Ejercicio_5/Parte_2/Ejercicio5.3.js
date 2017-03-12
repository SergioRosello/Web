var Animal = (function(name, age){
	var animal = function(name, eyeColor){
		this.name = name;
		this.eyeColor = eyeColor;
	}


	Animal(string name, String eyeColor){
		this.name = name;
		this.eyeColor = eyeColor;
	}

	String getName(){

	}

	String getEyeColor(){

	}

	String toString(){

	}
};


var Padawan = (function() {
    var padawan = function(name, age) {
        this.name = name;
        this.age = age;
    };

    padawan.prototype.skill = function() {
        return this.age.toString().length;
    };

    padawan.prototype.forceAttuned = function() {
        return false;
    };

    return padawan;
}());