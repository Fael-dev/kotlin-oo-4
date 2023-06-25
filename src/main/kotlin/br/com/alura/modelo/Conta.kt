package br.com.alura.modelo
import br.com.alura.br.com.alura.exception.FalhaAutenticacaoException
import br.com.alura.exception.SaldoInsuficienteException

// Construtor primário: class modelo.Conta {}
// Definir parametros no construtor primário: class modelo.Conta(titular: String, numero: Int, saldo: Double) {}
// Definir as propriedades no construtor primário: class modelo.Conta(var titular: String, var numero: Int, var saldo: Double) {}
// init {
//      //Executa alguma coisa durante inicialização do construtor da classe.
//    }

abstract class Conta (var titular: Cliente, var numero: Int = 0): Autenticavel {
    // Outra forma de delegar diretamente o método autenticacao:
    // Ao invés de : Autenticavel usaria : Autenticavel by titular
    // Porém os valores de Autenticacao devem ser todos do tipo VAL, pois não podem ser modificados depois de definidos
    var saldo = 0.0
        protected set
    companion object {
        var total = 0
            private set
    }

    init {
        total++
    }

    override fun autenticacao(senha: Int): Boolean { // Sobrepondo o método autenticacao e delegando para o titular
        return this.titular.autenticacao(senha)
    }

    fun depositar(deposito: Double) {
        if (deposito > 0.0) {
            this.saldo += deposito
            println("Depositando R$ ${deposito} na conta do ${this.titular.nome}...\nSaldo anterior: R$ ${this.saldo - deposito}\n" +
                    "Saldo atual: R\$ ${this.saldo}")
        }
    }

    abstract fun sacar(saque: Double)

    fun transferir(transferencia: Double, destino: Conta, senha: Int) {
        if (this.saldo < transferencia) {
            throw SaldoInsuficienteException("O saldo é insuficiente, saldo atual: ${this.saldo}, valor da transferência: $transferencia")
        }

        if (!autenticacao(senha)) {
            throw FalhaAutenticacaoException()
        }

        this.saldo -= transferencia
        destino.depositar(transferencia)
    }
}