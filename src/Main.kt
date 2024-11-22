import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    // Ввод количества точек
    var numberOfPoints: Int
    do {
        println("Введите количество точек (больше 2):")
        numberOfPoints = scanner.nextInt()
    } while (numberOfPoints <= 2)

    val points = mutableListOf<Point>()

    // Ввод координат точек
    for (i in 1..numberOfPoints) {
        points.add(inputPoint(scanner, "точка $i"))
    }

    // Инициализация минимального и максимального расстояния
    var minDistance = Double.MAX_VALUE
    var maxDistance = Double.MIN_VALUE

    // Вычисление расстояний между всеми парами точек
    for (i in points.indices) {
        for (j in i + 1 until points.size) {
            val distance = points[i].distanceTo(points[j])
            if (distance < minDistance) minDistance = distance
            if (distance > maxDistance) maxDistance = distance
        }
    }

    // Вывод результатов
    println("Минимальное расстояние между точками: $minDistance")
    println("Максимальное расстояние между точками: $maxDistance")
}

fun inputPoint(scanner: Scanner, pointName: String): Point {
    while (true) {
        try {
            println("Введите координаты $pointName (формат: x y):")
            val input = scanner.nextLine().trim().split(" ")
            if (input.size != 2) throw IllegalArgumentException("Неверный формат ввода.")

            val x = input[0].toDouble()
            val y = input[1].toDouble()
            return Point(x, y)
        } catch (e: NumberFormatException) {
            println("Ошибка: введите числовые значения для координат.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}
