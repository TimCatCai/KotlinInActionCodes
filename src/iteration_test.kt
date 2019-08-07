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

//    // 02 迭代map中的元素
//    iterateMap()
      // 03 使用 ‘in’ 判读集合区间成员
    val testChar  = 'c'
    println("$testChar is letter: ${isLetter('c')}")
    println("$testChar is not digit: ${isNotDigit('c')}")
    println(recognize('!'))
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

// 2.4.2 使用“in"来检查集合和区间成员
// 底层并未有特殊的处理： 同样是比较区间中的第一个及最后一个元素，不过是将其封装在区间类中
fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) =  c !in '0'..'9'
// in 与 ！in 适用于when中
fun recognize(c: Char) = when (c){
    in 'a'..'z' -> "It's a letter"
    in '1'..'9' -> "It's a digit"
    else        -> "I don't know"
}

// 2.5 kotlin 中的异常
// 1. kotlin 中不区分unchecked and checked exception, 可以处理异常也可以不处理异常
// throw 是一个表达式
// 没有throws子句，函数签名不抛出异常
// try catch 是一个表达式，可以将其赋值给变量，对于多语句场景，同样是最后一个语句的值为返回值

// summary
1. 函数
        a. fun(fun关键字) max函数名(a: Int参数列表): Int返回值列表{
            函数体
        }
        b. 函数体书写方法
            1> 函数体写在括号中： 代码块体(不能省略返回值类型及return语句)
            2> 直接返回一个表达式： 表达式体（若返回值的类型是显式的，可以省略返回值
        c.
2. 变量
        a. 关键字（var（可变引用）, val（不可变引用，相当于Java中的final关键字，指向的对象是可变的）) a(变量名称)：Int(变量类型，可省略，省略时必须初始化)
