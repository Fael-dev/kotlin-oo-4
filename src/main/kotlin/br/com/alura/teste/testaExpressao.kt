package br.com.alura.br.com.alura.teste

import java.lang.NumberFormatException

fun testaExpressa() {
    try {
        10/0
    } catch (e: ArithmeticException) {
        println("A ArithmeticException foi pegada.")
        println(e)
    }
    val entrada: String = "1.9"
    val valor: Double? = try {
        entrada.toDouble()
    } catch (e: NumberFormatException) {
        println("Problema na conversão")
//        println(e.message)
//        println(e.stackTrace)
//        println(e.cause)
        e.printStackTrace()
        null
    }

    val valorComTaxa: Double? = if (valor != null) {
        valor + 1.0
    } else {
        null
    }

    if (valorComTaxa != null) {
        println("Valor recebido: $valorComTaxa")
    } else {
        println("Valor inválido")
    }
}