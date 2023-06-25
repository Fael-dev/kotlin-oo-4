package br.com.alura.teste

import br.com.alura.modelo.Endereco

fun testaAny () {
    val endereco = Endereco(
        logradouro = "Rua teste",
        numero = 200,
        cep = "00000-111"
    )
    val enderecoNovo = Endereco(
        bairro = "Teste",
        logradouro = "Rua bem ali",
        cep = "00000-000"
    )

    println(endereco.equals(enderecoNovo))

    println(endereco.hashCode())
    println(enderecoNovo.hashCode())

    println(endereco)
    println(enderecoNovo)

    println("${endereco.javaClass}@${
        Integer.toHexString(endereco.hashCode())}")
}

fun imprime(valor: Any): Any {
    println(valor)
    return valor
}