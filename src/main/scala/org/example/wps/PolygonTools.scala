package org.example.wps

import collection.JavaConverters._
import java.util.{ Collection, List }

import com.vividsolutions.jts.geom.{
  Geometry, GeometryFactory, Polygon }
import com.vividsolutions.jts.geom.util.LineStringExtracter;
import com.vividsolutions.jts.operation.polygonize.Polygonizer;

object PolygonTools {
  def polygonize(geometry: Geometry): Geometry = {
    val lines = 
      LineStringExtracter.getLines(geometry).asInstanceOf[List[Geometry]]
    val polygonizer = new Polygonizer()
    polygonizer.add(lines)
    val polys = polygonizer.getPolygons.asInstanceOf[Collection[Geometry]]
    val polyArray = polys.asScala.toArray
    geometry.getFactory().createGeometryCollection(polyArray)
  }
  
  def splitPolygon(poly: Geometry, line: Geometry): Geometry = {
    val nodedLineWork = poly.getBoundary().union(line)
    val polys = polygonize(nodedLineWork)
    val output = 
      (0 until polys.getNumGeometries)
        .map { polys.getGeometryN(_).asInstanceOf[Polygon] }
        .filter { cand => poly.contains(cand.getInteriorPoint()) }
    poly.getFactory().createGeometryCollection(output.toArray)
  }
}
