package ean.estructuradedatos.tallercolas

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 * <p>
 * Proyecto Taller con las Colas
 * Autor: Universidad EAN - Marzo 18, 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

import ean.collections.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/* Función que recibes una cola de palabras y
   que retorne la palabra más larga de la cola.
   La cola original no debe verse modificada. Usa una copia.
 */
fun palabraMasLarga(colaPals: IQueue<String>): String {
   var copia =colaPals.copy()
   var
    while (!copia.isEmpty)
}

/*
Escriba una función genérica que determine el tamaño de una cola.
La cola original no debe verse modificada.
*/
fun <T> tamCola(cola: IQueue<T>): Int {//la complejidad es 0(n)
    var copia=cola.copy()
    var c=0
    while (!copia.isEmpty){
        c=c+1
        copia.dequeue()
    }
    return c
}

/*
Función genérica que recibe un elemento y una cola y que
retorna true si el elemento está en la cola y false sino
se encuentra el elemento en la cola. La cola original no
debe verse modificada.
 */
fun <T> existeElemento(col: IQueue<T>, elem: T): Boolean {
    var copia=col.copy()
    var v=false
    while(!copia.isEmpty){
        var inicio=copia.front
        if (inicio==elem){
            v=true
        }
        copia.dequeue()
    }
    return v


}

/*
Función genérica para determinar si dos colas son iguales.
Ninguna de las dos colas deben verse modificadas.
 */
fun <T> igualesColas(col1: IQueue<T>, col2: IQueue<T>): Boolean {
    var copia1=col1.copy()
    var copia2=col2.copy()
    var validacion = false

    if (tamCola(col1)== tamCola(col2)) {
        while (!col1.isEmpty) {
            var f1 = copia1.front
            var f2 = copia2.front

            if (f1 == f2) {

                validacion = true
                copia1.dequeue()
                copia2.dequeue()


            } else {
                validacion = false
            }
        }
    }else{
        validacion = false
    }
    return validacion
}

/*
Función genérica que invierte los elementos de la cola.
Debe modificar la cola. Puede usar una pila.
 */
fun <T> invertirCola(col: IQueue<T>) {
    TODO("Completar")
}
/*
Funcion generica que saque el ultimo elemento de la cola,
sin madificar la cola original
 */
fun <T>ultimo(col: IQueue<T>):T{
    var tamano = tamCola(col)
    repeat(tamano-1){
        col.dequeue()
    }
    return col.front
}

//--------------------------------------------------------------------
// Pruebas de las funciones anteriores
//--------------------------------------------------------------------
class Pruebas {
    @Test
    fun prueba1() {
        val cola: IQueue<String> = TLinkedQueue()

        cola.enqueue("hola")
        cola.enqueue("carro")
        cola.enqueue("internacionalizacion")
        cola.enqueue("relojito")
        cola.enqueue("ana")
        cola.enqueue("vericueto")
        cola.enqueue("rosales")

        assertEquals("internacionalizacion", palabraMasLarga(cola))
        println("Prueba superada ☺")
    }

    @Test
    fun prueba2() {
        val cola: IQueue<Double> = TLinkedQueue()

        cola.enqueue(4.5)
        cola.enqueue(-1.17)
        cola.enqueue(10.87)
        cola.enqueue(100.1)
        cola.enqueue(451.811)

        assertEquals(5, tamCola(cola))
        println("Prueba superada ☺")
    }

    @Test
    fun prueba3() {
        val c: IQueue<Char> = TLinkedQueue()

        c.enqueue('x')
        c.enqueue('d')
        c.enqueue('a')
        c.enqueue('f')
        c.enqueue('c')
        c.enqueue('3')
        c.enqueue('#')
        c.enqueue('=')
        c.enqueue('¿')
        c.enqueue('«')
        c.enqueue('y')

        assertTrue {
            existeElemento(c, '#')
        }

        assertFalse {
            existeElemento(c, '?')
        }

        println("Prueba superada ☺")
    }

    @Test
    fun prueba4() {
        var cola1: IQueue<Int> = TLinkedQueue()
        var cola2: IQueue<Int>

        cola1.enqueue(4)
        cola1.enqueue(71)
        cola1.enqueue(27)
        cola1.enqueue(-34171)
        cola1.enqueue(181)

        cola2 = cola1.copy()

        assertTrue(igualesColas(cola1, cola2))

        cola2.enqueue(36)
        cola2.enqueue(23)

        assertFalse(igualesColas(cola2, cola1))

        println("Prueba superada ☺")
    }

    @Test
    fun prueba5() {
        var c1: IQueue<Char> = TLinkedQueue()
        var c2: IQueue<Char> = TLinkedQueue()

        c1.enqueue('x')
        c1.enqueue('y')
        c1.enqueue('z')
        c1.enqueue('w')

        c2.enqueue('w')
        c2.enqueue('z')
        c2.enqueue('y')
        c2.enqueue('x')

        assertFalse {
            igualesColas(c1, c2)
        }

        invertirCola(c1)

        assertTrue {
            igualesColas(c1, c2)
        }

        println("Prueba superada ☺")
    }


    @Test
    fun prueba6() {
        var c1: IQueue<Char> = TLinkedQueue()

        c1.enqueue('x')
        c1.enqueue('y')
        c1.enqueue('z')
        c1.enqueue('w')

        print(ultimo(c1))

    }
}
