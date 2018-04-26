package com.example.esteban.text_appcompat.bl;

import com.example.esteban.text_appcompat.domain.Usuario
import java.util.*

/**
 * Created by _Adrian_Prendas_ on 18/04/2018.
 */
class UsuarioBL: BaseBL<Int, Usuario> {

    override fun create(obj: Usuario): Usuario {
        hashTable[obj.id] = obj
        return obj
    }

    override fun read(key: Int): Usuario? {
        return hashTable[key]
    }

    override fun readAll(): List<Usuario> {
        return ArrayList(hashTable.values)
    }

    override fun update(obj: Usuario): Usuario? {
        hashTable[obj.id]?.let{
            hashTable[it.id] = obj
        }
        return hashTable[obj.id]
    }

    override fun delete(key: Int): Usuario?{
        return hashTable.remove(key)
    }

    init{
        hashTable[813156487] = Usuario(813156487,"Angel","Ruiz", "arquitecto",88888888,"persona1","angel.ruiz@una.ac.cr","Cartago" )
        hashTable[908069482] = Usuario(908069482,"Carlos","Asencio","chofer",99999999,"persona2","carlos.asencio@una.ac.cr","San Jose")
        hashTable[118510669] = Usuario(118510669, "Emiliano ", "Sepulbeda","deportista", 77777777,"persona3","emiliano.sepulbeda.troche@una.ac.cr", "Heredia")
        hashTable[494658212] = Usuario(494658212, "Santino ", "Paredo","abogado", 66666666,"persona4","santino.peredo.dongu@una.ac.cr", "Limon")
        hashTable[673424513] = Usuario(673424513, "Tomas ", "Velasco","plomero", 55555555,"persona5","tomas.velasco.clemente@una.ac.cr", "Alajuela")
        hashTable[876415060] = Usuario(876415060, "Benjamin", "Covos","psicologo", 44444444,"persona6","benjamin.covos.brusiaga@una.ac.cr", "Puntarenas")
        hashTable[984357664] = Usuario(984357664, "Maria", "Mancilla","abogada", 33333333,"persona7","gael.mancilla.moia@una.ac.cr", "San Carlos")
        hashTable[964465378] = Usuario(964465378, "Ana", "Canchola","arquitecta", 22222222,"persona8","emmanuel.canchola.espejo@una.ac.cr", "Perez Zeledon")
        hashTable[769438762] = Usuario(769438762, "Karol", "Montecillo","profesora", 11111111,"persona9","dylan.montecillo.balderas@una.ac.cr", "Uruca")
        hashTable[368377663] = Usuario(368377663, "Emiliano", "Aguado","albañil", 12121212,"persona10","emiliano.aguado.sifuentes@una.ac.cr", "Tibas")
        hashTable[304830405] = Usuario(304830405, "Esteban", "Montero","usuario", 34343434,"esteban","esteban.montero.fonseca@est.una.ac.cr", "Cartago")
        hashTable[114830575] = Usuario(114830575, "Kevin", "Calderon","DBA", 56565656,"kevin","kevin.calderon.rodriguez@est.una.ac.cr", "San Jose")
        hashTable[604140420] = Usuario(604140420, "Adrian", "Prendas","hacker", 78787878,"adrian","adrian.prendas.araya@est.una.ac.cr", "Heredia")
        hashTable[0] = Usuario(0,"admin","admin","admin",98765432,"admin","admin","Las Vegas")
    }
    private object Holder { val INSTANCE = UsuarioBL() }
    companion object {
        val hashTable = Hashtable<Int, Usuario>()
        val instance : UsuarioBL by lazy{ Holder.INSTANCE }
        var session = 0
    }
}
