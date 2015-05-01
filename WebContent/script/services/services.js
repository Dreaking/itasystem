var itaServices = angular.module('itaApp.Services', []);
// 请求拦截器
itaServices.factory('getInfoError', ['$q','$location', function($q, $location) {
    var getInfoError = {
        responseError: function(response) {
            if (response.status == 404){
                $location.replace().path('/login');
            }
            return $q.reject(response);
            },
        requestError:function(response) {
            if (response.status == 404){
                $location.replace().path('/login');
            }
            return $q.reject(response);
            }
    };
    return getInfoError;
}])
.config(function($httpProvider) {
    $httpProvider.interceptors.push('getInfoError');
})
itaServices.factory('doLoginService',['$rootScope','$location','$http','$timeout',function($rootScope,$location,$http,$timeout){
var loginactionurl="Login.action",
    isloggedurl="LoginCheck.action";
return{
    SubmitOrHidden : function(evt){
    evt = window.event || evt;
    if(evt.keyCode==13){//如果取到的键值是回车
      document.querySelector("#submit_btn").click(); 
      }       
    },
    checklogin:function(scope){
        var result,timer;
        $.post(
        loginactionurl,{
            "user.email":scope.name,
            "user.pass":scope.pass
        },function(data){        
        var obj = JSON.parse(data);
        result=(obj.tip=="loginsuccess")?true:false;
        if (result) {
        $location.path('/index/myhome/myapp').replace();
        $rootScope.$apply();
        }else{
            document.querySelector(".errortip").fadeIn();
          if(timer)$timeout.cancel(timer);
          timer=$timeout(function(){
            document.querySelector(".errortip").fadeOut();
           },1000); 
          }
     })
  },
    islogged:function(){
            $.post(isloggedurl,{},function(data){
            var obj = JSON.parse(data);
            if(obj.tip!=='login'){
                $location.path('/login').replace();
                $rootScope.$apply();
                }
         })
     }
  }   
}]);
itaServices.factory('userService',['$location','$rootScope','$timeout','$http',function($location,$rootScope,$timeout,$http){
  var getInfoUrl="UserInfo.action",
      changePassWordUrl="ChangePass.action",
      getUserLocationUrl="UserLocation.action",
      updateUserInfoUrl="UpdateUser.action",
      addMemoUrl="AddMemo.action",
      updateMemoUrl="UpdateMemo.action",
      getUserProtectorUrl="UserProtector.action",
      synMemoUrl="SynMemo.action";
      return{
        getUserInfo:function(){
          return $http.get(getInfoUrl,{cache:true});
        },
        getUserProtector:function(){
          return $http.get(getUserProtectorUrl,{cache:true});
        }
      }
}]);
itaServices.factory('doRegisterService',['$location','$timeout',function($location,$timeout){
  var registerurl="Register.action";
  return{
        SubmitOrHidden : function(evt){
        evt = window.event || evt;
        if(evt.keyCode==13){//如果取到的键值是回车
          document.querySelector("#registernext").click(); 
          }       
        },
        CheckStatus:function(status){
         switch(status){          
         }
        }
  }
}])

