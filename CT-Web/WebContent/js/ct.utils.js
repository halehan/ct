

function parseLocation(location) {
	
	var regex = /[?&]([^=#]+)=([^&#]*)/g,
	location,
	params = {},
	match;
	while(match = regex.exec(location)) {
	params[match[1]] = match[2];
	}
	
	console.log(params);
    
    return params;
}

   
