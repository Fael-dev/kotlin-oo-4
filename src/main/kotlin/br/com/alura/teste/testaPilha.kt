package br.com.alura.br.com.alura.teste

import br.com.alura.exception.SaldoInsuficienteException

fun funcao1(){
    println("início funcao1")
    try {
        funcao2()
    } catch (e: ClassCastException) {
        println(e.printStackTrace())
        println("A ClassCastException foi pegada.")
    }
    println("fim funcao1")
}

fun funcao2() {
    println("início funcao2")
    for (i in 1..5){
        println(i)
        val endereco = Any()
        throw SaldoInsuficienteException()
    }
    println("fim funcao2")
}