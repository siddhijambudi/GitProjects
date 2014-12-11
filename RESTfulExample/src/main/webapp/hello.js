function Hello($scope, $http) {
    $http.get('http://localhost:8080/RESTfulExample/rest/hello/print/json').
        success(function(data) {
            $scope.students = data;
        });
}

function Hello2($scope, $http)
{
	$scope.submit = function() {
		
		$http.post('http://localhost:8080/RESTfulExample/rest/hello/post', 
				{
					"id":$scope.id,
					"firstName":$scope.firstname,
					"lastName":$scope.lastname,
					"age":$scope.age
				}).
				success(function(data) 
				{
						$scope.student = data;
				});
		
	};
}


