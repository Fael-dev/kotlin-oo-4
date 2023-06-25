package br.com.alura.modelo

import br.com.alura.modelo.Conta

class ContaPoupanca(
    titular: Cliente,
    numero: Int
): Conta(
    titular = titular,
    numero = numero
) {
    override fun sacar(saque: Double) {
        if(this.saldo >= saque) {
            this.saldo -= saque
            println("Saque realizado no valor de R$ ${saque}, saldo atual de R$ ${this.saldo}")
        } else {
            println("Saldo na conta insuficiente: R$ ${this.saldo}")
        }
    }
}