package br.com.alura

import br.com.alura.modelo.Endereco

fun main() {
    var endereco: Endereco? = Endereco(logradouro = "teste")
     endereco?.let {
        println(it.logradouro)
        val tamanhoComplemento: Int = it.complemento?.length ?: 0
        println(tamanhoComplemento)
     }

    teste("")
    teste(1)
}

fun teste(valor: Any) {
    val numero: Int? = valor as? Int
    println(numero)
}

// Throwable possui 2 classes filhas -> É uma classe JAVA:
// Error -> O programador não consegue lidar, pois é um erro da VM, ex:
// fun teste() { // -> loop infinito causado pela recursividade
//     return teste()
// }
// Exception -> O programador pode lidar, ex:
// 10/0 // -> Divisão por zero

// Recursos do NullSafe
// println(endereco?.logradouro?.length)
// endereco?.let {en: Endereco ->
//    println(en.logradouro)
// }
// endereco.let {en: Endereco? ->
//    println(en?.logradouro)
// }
// endereco.let {
//    println(it?.logradouro)
// }
// endereco?.let {
//    println(it.logradouro)
// }