var itaAppDirectives=angular.module('itaApp.directive',[]);
// 密码一致性验证指令
itaAppDirectives.directive('pwCheck', [function () {
     return {
         require: 'ngModel',
         link: function (scope, elem, attrs, ctrl) {
             var firstPassword = '#' + attrs.pwCheck;
             elem.add(firstPassword).on('keyup', function () {
                 scope.$apply(function () {
                     var v = elem.val()===$(firstPassword).val();
                     ctrl.$setValidity('matchPsw', v);
                 });
             });
         }
     }
 }]);
// 自动对焦指令
itaAppDirectives.directive('autoFocusWhen', ['$log','$timeout', function($log, $timeout) {
      return {
          restrict: 'A',
          scope: {
              autoFocusWhen: '='
          },
          link: function(scope, element) {
              scope.$watch('autoFocusWhen', function(newValue) {
                  if (newValue) {
                     $timeout(function(){
                         element[0].focus();
                     })
                  }
              });

              element.on('blur', function() {
                  scope.$apply(function() {
                      scope.autoFocusWhen = false;
                  })
              })
          }
        }
}]);