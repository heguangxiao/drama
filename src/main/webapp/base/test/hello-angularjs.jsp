<%-- 
    Document   : hello-angularjs
    Created on : Dec 15, 2020, 11:41:17 AM
    Author     : HTC-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="<c:url value='/js/angular.min.js' />"></script>
        <script src="<c:url value='/controller/hello-angularjs.js'/>"></script>
        <title>Hello AngularJS</title>
    </head>
    <body>
        <div ng-app="myApp" ng-controller="myCtrl">
            <h3>Calculator:</h3>
            <p>Variable 1: <input ng-model = "variable1"> </p>
            <p>Variable 2: <input ng-model = "variable2"> </p>

            <button ng-click = "setOperatorSum()">+</button>
            <button ng-click = "setOperatorMinus()">-</button>

            <p style="color:blue">{{variable1}} {{ operator }} {{variable2}}</p>

            <button ng-click = "calculate()"> = </button>
            <p>Result: <b style="color:red">{{ result }}</b></p>
                        
            <hr/>
                        
            <h3>Directive E (Element):</h3>
 
            <hello-world></hello-world>
            
            <hr/>
            
            <h3>Enter your name:</h3>
            <p><input ng-model = "fullName"/></p>
            <p>Your Name: {{fullName}}</p>
            
            <hr/>
            
            <h3>Filters: uppercase/lowercase</h3>
 
            <p>Origin String: {{ greeting }}</p>
            <p>Uppercase: {{ greeting | uppercase }}</p>
            <p>Lowercase: {{ greeting | lowercase }}</p>
            
            <hr/>
            
            <h3>Filter: number</h3>
 
            <p><b>Origin Number:</b> {{ revenueAmount }}</p>

            <p><b>Default Number Format:</b> {{ revenueAmount | number }}</p>

            <p><b>Format with 2 decimal places:</b> {{ revenueAmount | number : 2 }}</p>
            
            <hr/>
                        
            <p><b>revenueAmountStr:</b> {{ revenueAmountStr }}</p>
            
            <hr/>
            
            <h3>Filter: currency</h3>
            Enter Amount:
            <input type="number" ng-model="myAmount" />

            <p>
               <b ng-non-bindable>{{ myAmount | currency }}</b>:
               <span>{{ myAmount | currency }}</span>
            </p>
            <p>
               <b ng-non-bindable>{{ myAmount | currency : '$' : 2 }}</b>:
               <span>{{ myAmount | currency : '$' : 2 }}</span>
            </p>
            <p>
               <b ng-non-bindable>{{ myAmount | currency : '€' : 1 }}</b>:
               <span>{{ myAmount | currency : '€' : 1 }}</span>
            </p>
            
            <hr/>
            
             <h3>Filter: date</h3>
 
            <p>
               <!-- $scope.myDate = new Date() -->
               <b ng-non-bindable>{{ myDate | date: 'yyyy-MM-dd HH:mm'}}</b>:
               <span>{{ myDate | date: 'yyyy-MM-dd HH:mm'}}</span>
            </p>

            <p>
               <b ng-non-bindable>{{1288323623006 | date:'medium'}}</b>:
               <span>{{1288323623006 | date:'medium'}}</span>
            </p>
            <p>
               <b ng-non-bindable>{{1288323623006 | date:'yyyy-MM-dd HH:mm:ss Z'}}</b>:
               <span>{{1288323623006 | date:'yyyy-MM-dd HH:mm:ss Z'}}</span>
            </p>
            <p>
               <b ng-non-bindable>{{1288323623006 | date:'MM/dd/yyyy @ h:mma'}}</b>:
               <span>{{'1288323623006' | date:'MM/dd/yyyy @ h:mma'}}</span>
            </p>
            <p>
               <b ng-non-bindable>{{1288323623006 | date:"MM/dd/yyyy 'at' h:mma"}}</b>:
               <span>{{'1288323623006' | date:"MM/dd/yyyy 'at' h:mma"}}</span>
            </p>
            
            <hr/>
            
            <h3>Filter: json</h3>
 
            <p>
               <b ng-non-bindable>{{ department | json : 5 }}</b>:
               <pre>{{ department | json  : 5}}</pre>
            </p>

            <p>
               <b ng-non-bindable>{{ department | json }}</b>:
               <pre>{{ department | json }}</pre>
            </p>
            
            <hr/>
            
            <h3>Filter: limitTo</h3>
 
            <p>
               Limit {{anArray}} to:
               <input type="number" step="1" ng-model="arrayLimit">
            </p>
            <b>Output Array: {{ anArray | limitTo: arrayLimit }}</b>
            <p>
               Limit {{aString}} to:
               <input type="number" step="1" ng-model="stringLimit">
            </p>
            <b>Output String: {{ aString | limitTo: stringLimit }}</b>
            <p>
               Limit {{aNumber}} to:
               <input type="number" step="1" ng-model="numberLimit">
            </p>
            <b>Output Number: {{ aNumber | limitTo: numberLimit }}</b>

            <hr/>
            
        </div>
   </body>
    </body>
</html>
