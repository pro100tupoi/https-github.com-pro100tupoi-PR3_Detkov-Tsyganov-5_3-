data class Point(val x: Double, val y: Double) {
    fun distanceTo(other: Point): Double {
        return Math.sqrt(Math.pow(x - other.x, 2.0) + Math.pow(y - other.y, 2.0))
    }

    override fun toString(): String {
        return "Point(x=$x, y=$y)"
    }
}
