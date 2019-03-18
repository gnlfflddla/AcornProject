<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="utf-8">
    <title>map</title>
    
</head>
<body>
<br><br><br>
<div id="map" style="width:50%;height:350px;"></div>
<p>
    <input type="checkbox" id="chkTerrain" onclick="setOverlayMapTypeId()" /> 지형정보
    <input type="checkbox" id="chkTraffic" onclick="setOverlayMapTypeId()" /> 교통정보       
    <input type="checkbox" id="chkBicycle" onclick="setOverlayMapTypeId()" /> 자전거도로
    <input type="checkbox" id="chkUseDistrict" onclick="setOverlayMapTypeId()" /> 지적편집도
</p>


    
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=43987149e1d0e347ac4c82fd3bb05865"></script>

<script>

var mapContainer = document.getElementById('map');

mapOption = { 
        center: new daum.maps.LatLng(37.499403, 127.029003), // 지도의 중심좌표
        level: 2 // 지도의 확대 레벨
    };

var map = new daum.maps.Map(mapContainer, mapOption); 

var mapTypeControl = new daum.maps.MapTypeControl();


map.addControl(mapTypeControl, daum.maps.ControlPosition.TOPRIGHT);

var zoomControl = new daum.maps.ZoomControl();
map.addControl(zoomControl, daum.maps.ControlPosition.RIGHT);

var markerPosition  = new daum.maps.LatLng(37.499403, 127.029003); 

var marker = new daum.maps.Marker({
    position: markerPosition
});

marker.setMap(map);

var mapTypes = {
	    terrain : daum.maps.MapTypeId.TERRAIN,    
	    traffic :  daum.maps.MapTypeId.TRAFFIC,
	    bicycle : daum.maps.MapTypeId.BICYCLE,
	    useDistrict : daum.maps.MapTypeId.USE_DISTRICT
	};

	function setOverlayMapTypeId() {
	    var chkTerrain = document.getElementById('chkTerrain'),  
	        chkTraffic = document.getElementById('chkTraffic'),
	        chkBicycle = document.getElementById('chkBicycle'),
	        chkUseDistrict = document.getElementById('chkUseDistrict');
	    
	    for (var type in mapTypes) {
	        map.removeOverlayMapTypeId(mapTypes[type]);    
	    }

	    if (chkUseDistrict.checked) {
	        map.addOverlayMapTypeId(mapTypes.useDistrict);    
	    }
	    
	    if (chkTerrain.checked) {
	        map.addOverlayMapTypeId(mapTypes.terrain);    
	    }
	    
	    if (chkTraffic.checked) {
	        map.addOverlayMapTypeId(mapTypes.traffic);    
	    }
	    
	    if (chkBicycle.checked) {
	        map.addOverlayMapTypeId(mapTypes.bicycle);    
	    }
	    
	}  

function getInfo() {
    var center = map.getCenter(); 
    
    var level = map.getLevel();
    
    var mapTypeId = map.getMapTypeId(); 
    
    var bounds = map.getBounds();
    
    var swLatLng = bounds.getSouthWest(); 
    
    var neLatLng = bounds.getNorthEast(); 
    
    var boundsStr = bounds.toString();
    
    var message = 'ì§ë ì¤ì¬ì¢íë ìë ' + center.getLat() + ', <br>';
    message += 'ê²½ë ' + center.getLng() + ' ì´ê³  <br>';
    message += 'ì§ë ë ë²¨ì ' + level + ' ìëë¤ <br> <br>';
    message += 'ì§ë íìì ' + mapTypeId + ' ì´ê³  <br> ';
    message += 'ì§ëì ë¨ììª½ ì¢íë ' + swLatLng.getLat() + ', ' + swLatLng.getLng() + ' ì´ê³  <br>';
    message += 'ë¶ëìª½ ì¢íë ' + neLatLng.getLat() + ', ' + neLatLng.getLng() + ' ìëë¤';
    
}


</script>
</body>
</html>