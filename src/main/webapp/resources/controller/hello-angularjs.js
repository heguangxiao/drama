// Create an Application named "myApp".
var app = angular.module("myApp", []);
 
// Create a Controller named "myCtrl"
app.controller("myCtrl", function($scope, $filter) {
 
    $scope.operator = "+";
 
    $scope.variable1 = 30;
    $scope.variable2 = 20;
    $scope.result = 0;
 
    $scope.setOperatorSum = function() {
        $scope.operator = "+";
    };
 
    $scope.setOperatorMinus = function() {
        $scope.operator = "-";
    };
 
    $scope.calculate = function() {
        if ($scope.operator === "+") {
            $scope.result = parseFloat($scope.variable1) + parseFloat($scope.variable2);
        } else if ($scope.operator === "-") {
            $scope.result = parseFloat($scope.variable1) - parseFloat($scope.variable2);
        }
    };
    
    //
    $scope.fullName = "Anonymous";
    
    $scope.greeting = "Hello World";
    
    $scope.revenueAmount = 20011.2345;
    
    var aNumber = 19001.2345;
 
    // Use number filter in Javascript:
    $scope.revenueAmountStr = $filter("number")(aNumber, 2);// ==> 19,001.23
    
    $scope.myAmount = 12345.678;
    
    $scope.myDate = new Date();
    
    $scope.department =  {
        id : 1,
        name: "Sales",
 
        employees : [
            {id: 1, fullName: "Tom", gender: "Male"},
            {id: 2, fullName: "Jerry", gender: "Male"}
        ]
    };
    
    $scope.anArray = [1,2,3,4,5,6,7,8,9];
    $scope.aString = "ABCDEFGHIJK";
    $scope.aNumber = 12345678;
 
    $scope.arrayLimit = 3;
    $scope.stringLimit = 3;
    $scope.numberLimit = 3;
 
});

// Create a Directvie named "helloWorld"
app.directive("helloWorld", function() {
    return {
        restrict : "E",
        template : "<h1>Hello World!</h1>"
    };
});