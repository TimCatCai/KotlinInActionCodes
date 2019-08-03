import java.lang.IllegalArgumentException
import java.util.*

fun main(args: Array<String>) {
//    // 01
//    // 递增区间, 区间为全闭区间（包含边界值）, 步长step必须是正数
//    for(i in 1..100 step 1){
//        print(fizzBuzz(i))
//    }
//    println()
//
//    // 递减区间,区间为全闭区间（包含边界值）,同样的step必须是正数
//    for(i in 100 downTo 1 step 2){
//        print(fizzBuzz(i))
//    }
//    println()
//
//    // 半开半闭区间, 可以是递增也可以是递减, 同样的step必须是正数
//    for(i in 100 until 1 step 2){
//        print(fizzBuzz(i))
//    }
//    println()

    iterateMap()
}


interface Expr
class Num(val num: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int = when (e) {
    is Num -> e.num
    is Sum -> eval(e.left) + eval(e.right)
    else -> throw IllegalArgumentException("dirty argument")
}

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz"
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun iterateMap() {
    // 创建tree map
    val binaryMap = TreeMap<Char, String>()

    for (c in 'A'..'F') {
        // 同过方括号来添加、访问、修改值，而不需要同过put和get来完成
        // toBinaryString将整形值转为二进制数字
        binaryMap[c] = Integer.toBinaryString(c.toInt())
    }
    // 展开语法, 允许for循环展开迭代的集合中的元素, 并把值存储在独立的变量中
    for ((letter, binaryValue) in binaryMap) {
        println("$letter = $binaryValue")
    }

    // 可以用这种展开语法在迭代集合的同时跟踪当前元素的下标
    val aList = arrayListOf<String>("00", "01", "10", "11")
    for((index, element) in aList.withIndex()){
        println("$index : $element")
    }

}