function Hello($scope, $http) {
    $http.get('http://localhost:8080/RESTfulExample/rest/hello/print/json').
        success(function(data) {
            $scope.greeting = data;
        });
}

function Hello1($scope, $http){
	$http.post('http://localhost:8080/RESTfulExample/rest/hello/post', 
			{"id":120,"firstName":"json1","lastName":"Marco12","age":190}).
	success(function(data) {
		$scope.greeting = data;
	});
}


