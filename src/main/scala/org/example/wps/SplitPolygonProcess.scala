package org.example.wps

import org.geotools.process.factory.{
  DescribeParameter, DescribeProcess, DescribeResult }
import org.geotools.process.gs.GSProcess

import com.vividsolutions.jts.geom.Geometry

@DescribeProcess(title = "splitPolygon",
   description = "Splits a Polygon (which may contain holes) by a LineString")
class SplitPolygonProcess extends GSProcess {
  @throws(classOf[Exception])
  @DescribeResult(name = "result", description = "The collection of result polygons")
  def execute(
    @DescribeParameter(name = "polygon",
       description = "The polygon to be split")
    poly: Geometry,
    @DescribeParameter(name = "line",
       description = "The line to split by")
    line: Geometry): Geometry 
  = PolygonTools.splitPolygon(poly, line);
}
