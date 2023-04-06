enum class Jogada {
    X,
    O,
}

enum class Coordenada {
    A1,
    B1,
    C1,
    A2,
    B2,
    C2,
    A3,
    B3,
    C3,
}

class Tabuleiro {
    private val quadrados: MutableMap<Coordenada, Jogada> = mutableMapOf()

    fun marcar(jogada: Jogada, coordenada: Coordenada): Boolean {
        if (estaMarcado(coordenada)) return false

        quadrados[coordenada] = jogada

        return true
    }

    fun estaMarcado(coordenada: Coordenada): Boolean {
        return quadrados[coordenada] != null
    }

    @Suppress("kotlin:S125")
    @OptIn(ExperimentalStdlibApi::class)
    fun deuVelha(): Boolean {
        return Coordenada.entries.all { quadrados[it] != null }
//        val coordenadas = Coordenada.entries
//
//        var isFull = true
//        for (coordenada in coordenadas) {
//            isFull = isFull && quadrados[coordenada] != null
//        }
//
//        return isFull
    }

    fun alguemGanhou(): Jogada? {
        TODO()
    }


    override fun toString(): String {
        return """ 
         A B C
       1 ${formatGrid(quadrados[Coordenada.A1])} ${formatGrid(quadrados[Coordenada.B1])} ${formatGrid(quadrados[Coordenada.C1])}
       2 ${formatGrid(quadrados[Coordenada.A2])} ${formatGrid(quadrados[Coordenada.B2])} ${formatGrid(quadrados[Coordenada.C2])}
       3 ${formatGrid(quadrados[Coordenada.A3])} ${formatGrid(quadrados[Coordenada.B3])} ${formatGrid(quadrados[Coordenada.C3])}
               """
    }


}


fun main() {
    val tabuleiro = Tabuleiro()

    tabuleiro.marcar(Jogada.X, Coordenada.A2)
    tabuleiro.marcar(Jogada.O, Coordenada.B2)

    println(tabuleiro.toString())
}


fun formatGrid(jogada: Jogada?): String {
    return jogada?.name ?: "-"
}
