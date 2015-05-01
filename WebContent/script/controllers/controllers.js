var itaAppCtrls=angular.module('itaApp.Controllers',[]);
itaAppCtrls.controller('LoginController',['$scope','doLoginService',function($scope,doLoginService){
window.document.onkeydown=doLoginService.SubmitOrHidden;
$scope.doLogin=function(){
     doLoginService.checklogin($scope);
 }
}]);
// 注册接口
itaAppCtrls.controller('RegisterController',['$scope','$timeout','doRegisterService',function($scope,$timeout,doRegisterService){
 window.document.onkeydown=doRegisterService.SubmitOrHidden;
 $scope.nextstep=function(){
    $scope.status++;
    if($scope.status>3){
       var tip=document.querySelector("#register_error_tip");
       tip.innerHTML="注册成功...3s后跳转到登录页";
       $timeout(function(){
        tip.innerHTML="注册成功...2s后跳转到登录页";
       },1000);
       $timeout(function(){
        tip.innerHTML="注册成功...1s后跳转到登录页";
       },2000);
       $timeout(function(){
        tip.innerHTML="注册成功...0s后跳转到登录页";
        window.location.href="#/login";       
       },3000)
    }
 }
}]);
// 验证登录状态接口
itaAppCtrls.controller('checkLogged',['$scope','$location','doLoginService',function($scope,$location,doLoginService){
    doLoginService.islogged;
    $scope.$on('$stateChangeSuccess',function(evt,toState,toParams,fromState,fromParams){
            menuSelect(toState.menu_select);
            if(toState.menu_select==0)
                loadindex();
            if(toState.menu_select==3)
                loadScript();
        });
    $scope.$on('$stateChangeStart', function(evt,toState,toParams,fromState,fromParams){
            if(toState.access_levels>0)
            {
                doLoginService.islogged();
            }
     })
}]);
// 用户信息读取
itaAppCtrls.controller('myInfoCtrl',['$scope','userService',function($scope,userService){
    userService.getUserInfo().success(function(data){
      $scope.usernumber=data.user.address;
      $scope.username=data.user.name;
    });
    $scope.userpic="imgs/userpic.jpg";
    $scope.sexselect=true;
    $scope.usersignature="这里是个性签名";
}]);
// App管理
itaAppCtrls.controller('myAppCtrl',['$scope',function($scope) {

}]);
// 更改密码
itaAppCtrls.controller('changePassword',['$scope','$location',function($scope,$location){
   $scope.user={};  
   }]);
// 编辑守护者
itaAppCtrls.controller('protectorCtrl',['$scope','userService',function($scope,userService){
    $scope.protectoredit=true;
    $scope.protector_edit_status="编辑";
    $scope.newprotector={};
    $scope.nameFocus=false;
    $scope.phoneFocus=false;
    $scope.protector_edited=false;
    userService.getUserProtector().success(function(data){
      $scope.protector=data.protectors;
    })
    $scope.editProtector=function(){
      $scope.protectoredit=!$scope.protectoredit;
      $scope.protector_edit_status=$scope.protectoredit?"编辑":"保存";
    }
    $scope.addProtector = function() {
      $scope.protector_edited=true;
      if($scope.protector_edit_addform.$valid){
      $scope.protector.push($scope.newprotector);
      $scope.newprotector={};
      }else{
        if($scope.protector_edit_addform.protectorname.$invalid)$scope.nameFocus=true;
        if(protector_edit_addform.protectorphone.$invalid)$scope.phoneFocus=true;
      }
    };

   $scope.delProtector = function(index) {
    $scope.protector.splice(index, 1);
   };

  }]);
   // 个人信息修改
   itaAppCtrls.controller('userinfoform',['$scope',function($scope){
    
   }])