package br.com.alura.modelo

import br.com.alura.modelo.Funcionario

class Auxiliar(
    nome: String,
    cpf: String,
    salario: Double,
) : Funcionario(
    nome = nome,
    cpf = cpf,
    salario = salario
) {
    override val bonificacao: Double get () = salario * 0.10
}