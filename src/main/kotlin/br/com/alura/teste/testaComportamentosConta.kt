package br.com.alura.teste

import br.com.alura.br.com.alura.exception.FalhaAutenticacaoException
import br.com.alura.exception.SaldoInsuficienteException
import br.com.alura.modelo.ContaCorrente
import br.com.alura.modelo.ContaPoupanca
import br.com.alura.modelo.Cliente
fun testaComportamentosConta() {
    // Pode se declarar assim também sem seguir a ordem dos parametros, utilizando labels:
    // val conta1 = modelo.Conta(titular = "Rafael", numero = 1000)
    // val conta1 = modelo.Conta(numero = 1000, titular = "Rafael")
    val cliente1 = Cliente("Rafael", "000.000.000-00", 1001)
    val conta1 = ContaCorrente(cliente1, 1000)
    println("Conta 1, titular: ${conta1.titular}")
    println("Conta 1, número: ${conta1.numero}")
    println("Conta 1, saldo: ${conta1.saldo}")
    conta1.depositar(25.0)
    conta1.sacar(18.0)
    println("")

    val cliente2 = Cliente("Leonan", "000.000.000-01", 1002)
    val conta2 = ContaPoupanca(cliente2, 1001)
    try {
        conta1.transferir(1.0, conta2, 12345)
        println("Transferência realizada da conta ${conta1.titular.nome} para a conta ${conta2.titular.nome}, no valor de R$ 1,00")
    } catch (e: SaldoInsuficienteException) {
        println("Não foi possível realizar a transferência da conta ${conta1.titular.nome} para a conta ${conta2.titular.nome}")
        println(e.printStackTrace())
    } catch (e: FalhaAutenticacaoException) {
        println("Falha na transferência")
        println("Falha na autenticação")
        e.printStackTrace()
    } catch (e: Exception) {
        println("Erro desconhecido")
        println(e.printStackTrace())
    }
}