package com.mano.location;

import com.spatial4j.core.context.SpatialContext;
import com.spatial4j.core.distance.DistanceUtils;
import com.spatial4j.core.io.GeohashUtils;

public class LocationTest {

	public static void main(String[] args) {

		// double lon = 116.312528, lat = 39.983733;// 移动设备经纬度
		// int radius = 1;// 千米
		//
		// SpatialContext geo = SpatialContext.GEO;
		// Rectangle rectangle = geo.getDistCalc().calcBoxByDistFromPt(
		// geo.makePoint(lon, lat), radius * DistanceUtils.KM_TO_DEG, geo,
		// null);
		// System.out.println(rectangle.getMinX() + "-" +
		// rectangle.getMaxX());// 经度范围
		// System.out.println(rectangle.getMinY() + "-" +
		// rectangle.getMaxY());// 纬度范围

		// 移动设备经纬度
		double lon1 = 116.3125333347639, lat1 = 39.98355521792821;
		// 商户经纬度
		double lon2 = 116.312528, lat2 = 39.983733;

		SpatialContext geo = SpatialContext.GEO;
		double distance = geo.calcDistance(geo.makePoint(lon1, lat1),
				geo.makePoint(lon2, lat2))
				* DistanceUtils.DEG_TO_KM;
		System.out.println(distance);// KM

		System.out.println(GeohashUtils.encodeLatLon(lat2, lon2));

	}

}
