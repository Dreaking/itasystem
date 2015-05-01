var itaApps = angular.module('itaApp', ['ui.router','ngAnimate-animate.css','itaApp.Services','itaApp.Controllers','itaApp.directive']);
itaApps.constant('ACCESS_LEVELS',{
  pub:0,
  user:1
})
.constant('MENU_SELECT',{
  index:0,
  product:1,
  dowload:2,
  location:3,
  myhome:4
});
itaApps.config(function($stateProvider,$locationProvider,$urlRouterProvider,$animateProvider,ACCESS_LEVELS,MENU_SELECT) {
    $animateProvider.classNameFilter(/\-animation/);
    $stateProvider.state('index',{
      url:'/index',
      templateUrl:'tpls/iTA_index.html'
    })
    .state('login',{
      url:'/login',
      replace:true,
      templateUrl:'tpls/iTA_login.html',
      controller:'LoginController',
      access_levels:ACCESS_LEVELS.pub,
      menu_select:MENU_SELECT.index
    })
    .state('register',{
      url:'/register',
      replace:true,
      templateUrl:'tpls/iTA_register.html',
      controller:'RegisterController',
      access_levels:ACCESS_LEVELS.pub,
      menu_select:MENU_SELECT.index
    })
    .state('index.myhome',{
      url:"/myhome",
      replace:true,
      templateUrl:'tpls/iTA_userbox.html',
      access_levels:ACCESS_LEVELS.user,
      menu_select:MENU_SELECT.myhome
    })
    .state('index.location',{
        url:'/location',
        replace:true,
        templateUrl:'tpls/iTA_location.html',
        controller:'checkLogged',
        access_levels:ACCESS_LEVELS.user,
        menu_select:MENU_SELECT.location
    })
    .state('index.home',{
        url:'/home',
        replace:true,
        templateUrl:'tpls/iTA_home.html',
        controller:'checkLogged',
        access_levels:ACCESS_LEVELS.pub,
        menu_select:MENU_SELECT.index
    })
    .state('index.product',{
        url:'/product',
        replace:true,
        templateUrl:'tpls/iTA_product.html',
        controller:'checkLogged',
        access_levels:ACCESS_LEVELS.pub,
        menu_select:MENU_SELECT.product
    })
    .state('index.myhome.myapp',{
        url:'/myapp',
        replace:true,
        templateUrl:'tpls/iTA_myapp.html',
        onEnter:findWeather,
        controller:'checkLogged',
        access_levels:ACCESS_LEVELS.user,
        menu_select:MENU_SELECT.myhome
    })
    .state('index.myhome.myinfo',{
        url:'/myinfo',
        replace:true,
        templateUrl:'tpls/iTA_myinfo.html',
        controller:'checkLogged',
        access_levels:ACCESS_LEVELS.user,
        menu_select:MENU_SELECT.myhome
    })
    .state('index.myhome.change',{
        url:'/change',
        replace:true,
        templateUrl:'tpls/iTA_changepsw.html',
        controller:'checkLogged',
        access_levels:ACCESS_LEVELS.user,
        menu_select:MENU_SELECT.myhome
    })
    // $locationProvider.html5Mode(true).hashPrefix('!');
    $urlRouterProvider.otherwise('index/home');
});
function init() {
var getlocationurl="UserLocation.action"; 
//初始化地图对象，加载地图
////初始化加载地图时，若center及level属性缺省，地图默认显示用户当前城市范围
var map = new AMap.Map('mapContainer', {
    resizeEnable: true,
    view: new AMap.View2D({
        resizeEnable: true,
        center:new AMap.LngLat(113.393712,23.05079),//地图中心点
        zoom:12//地图显示的缩放级别
    }),
    keyboardEnable:false
});
//地图中添加地图操作ToolBar插件
map.plugin(['AMap.ToolBar'],function(){
   //设置地位标记为自定义标记
   var toolBar = new AMap.ToolBar();
   map.addControl(toolBar);
});
setTimeout(function(){$.get(getlocationurl,{},function(data){
          var json=JSON.parse(data);
          var mask=document.getElementsByClassName("mapMask");
          if(json.tip="loadsuccess"){
           mask[0].style.display="none";
           locating(json.locations[0].longitude,json.locations[0].latitude);
          }
          else{
             mask[0].innerHtml="定位失败";
          }  
    })},300); 
function locating(x,y){
    var Position=new AMap.LngLat(x,y);
        var marker = new AMap.Marker({  
            //复杂图标
            icon: new AMap.Icon({    
                    //图标大小
                    size:new AMap.Size(28,28),
                    //大图地址
                    image:"imgs/fixed-position-baidu.png"
                }),
            offset : {
            x : -12,
            y : -12
        },
            //在地图上添加点
            position:Position
        });
        var circle = new AMap.Circle({ 
           center:Position,// 圆心位置
           radius:100, //半径
           strokeColor: "rgba(8, 103, 247, 1)", //线颜色
           strokeOpacity: 1, //线透明度
           strokeWeight: 3, //线粗细度
           fillColor: "rgba(8, 103, 247, 0.88)", //填充颜色
           fillOpacity: 0.35//填充透明度
           }); 
        setTimeout(function(){
          circle.setMap(map);
          marker.setMap(map);
          map.setZoomAndCenter(17,Position); 
        },1000);      
    };
}
function loadScript() {
  var script = document.createElement("script");
  script.type = "text/javascript";
  script.src = "http://webapi.amap.com/maps?v=1.3&key=a25dfd5879c85513173d9345979f685a&callback=init";
  document.body.appendChild(script);
}
function findWeather() {
        var cityUrl = 'http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js';
        $.getScript(cityUrl, function(script, textStatus, jqXHR) {
            var citytq = remote_ip_info.city ;// 获取城市
            var url = "http://php.weather.sina.com.cn/iframe/index/w_cl.php?code=js&city=" + citytq + "&day=0&dfc=3";
            $.ajax({
                url : url,
                dataType : "script",
                scriptCharset : "gbk",
                success : function(data) {
                    var _w = window.SWther.w[citytq][0];
                    var weather='<div class="weather_info"><span>'+_w.s1+'</span><em>当前天气</em></div><div class="weather_info"><span>'+ _w.t1 + "℃～" + _w.t2 + "℃"+'</span><em>温度</em></div><div class="weather_info fl"><span>'+_w.d1 + _w.p1 + "级"+'</span><em>风力大小</em></div>';
                    if(new Date().getHours() > 17||new Date().getHours()<7){
                        $(".weather_icon").css("background-positionY","-521px");
                    }
                    $("#weather_info").html(weather);
                }
            });
        });
    }
    function menuSelect(ele) {
        var nav = document.getElementById("nav");
        var select = nav.getElementsByTagName("li");
        var movetag = document.getElementById("header_bt");
        var timer = null;
        var that=select[ele];
        var header=document.getElementById("header");
        header.style.position="relative";
        document.getElementsByTagName("html")[0].style.overflowY="auto";
        if($("#body"))
          $(document).unbind("mousewheel DOMMouseScroll MozMousePixelScroll");
        if(ele==0)
        {
          header.style.position="fixed";
          document.getElementsByTagName("html")[0].style.overflowY="hidden";
        }
        that.className = "nav_select";
        movehere(that,movetag);
        for (var i = 0, len = select.length; i < len; i++) {
            select[i].onmouseover = function () {
                movehere(this, movetag);
            }
            select[i].onmouseout = function () {
                movehere(that, movetag);
            }
            select[i].onclick = function () {
                that = this;
                for (var j = 0; j < len; j++) {
                    select[j].className = "";
                }
                that.className = "nav_select";
            }
        }
        function movehere(from, to) {
            clearInterval(timer);
            timer = setInterval(function () {
                if (from.offsetLeft != to.offsetLeft) {
                    var speed = (from.offsetLeft - to.offsetLeft) > 0 ? Math.ceil((from.offsetLeft - to.offsetLeft) / 10) : Math.floor((from.offsetLeft - to.offsetLeft) / 10);
                    var widthspeed = (from.offsetWidth - to.offsetWidth) > 0 ? Math.ceil((from.offsetWidth - to.offsetWidth) / 10) : Math.floor((from.offsetWidth - to.offsetWidth) / 10);
                    to.style.left = to.offsetLeft + speed + "px";
                    to.style.width = to.offsetWidth + widthspeed + "px";
                } else {
                    clearInterval(timer);
                }
            }, 10);
        }
    }
function loadindex(){
  var windows=$(window);
  var wh = windows.height();
  var body = $('#body');
  var main = $('.main');
  var responsiveImg = $('.responsiveImg');
  var responsiveFallback = false;
  main[0].style.height=wh+'px';
  //页面加载时判断是否需要更换图片
  if(wh < 790){
    responsiveFn1();
  }
  //浏览器检测，判断是否为高级浏览器
  if(Modernizr.cssanimations){
    responsiveFallback = false;
  } else {
    responsiveFallback = true;
  }

  //onepage_scroll方法
  main.onepage_scroll({
    sectionContainer: '.page',
    responsiveFallback: responsiveFallback
  });

  //窗口改变大小切换不同的图片
  windows.resizeEnd({
    delay : 500
  }, function(){
    var wh = windows.height();
    if(wh < 790){
      responsiveFn1();
    } else {
      responsiveFn2();
    }
  });

  function responsiveFn1(){
    body.addClass('responsive-height-lt790')
    responsiveImg.each(function(){
      var dateSmall = $(this).attr('date-small');
      $(this).attr('src', dateSmall);
    });
  }
  function responsiveFn2(){
    body.removeClass('responsive-height-lt790')
    responsiveImg.each(function(){
      var dateBig = $(this).attr('date-big');
      $(this).attr('src', dateBig);
    });
  }
}